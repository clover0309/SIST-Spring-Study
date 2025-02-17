package Control;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import spring.input.ImgVO;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BbsControl {
    @Autowired
    private BbsDAO bbsDAO;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ServletContext application;

    @Autowired
    private HttpSession session;

    int numPerPage = 7; // 한 페이지에 보여질 게시물 수
    int pagePerBlock = 5; // 한 블럭에 보여질 페이지 수

    private String upload_Path = "/resources/upload/";

    @RequestMapping("/list")
    //처음에는 bname과 cPage는 아무것도 주어지지 않았기 때문에 null이 존재함.
    public ModelAndView list(String bname, String cPage) {
        //여기서 bname을 검증하여서 null이면 bname을 BBS로 지정한다.
        if(bname==null || bname.equals(""))
            bname="BBS";


        Paging page = new Paging(numPerPage, pagePerBlock);
        int totalCount = bbsDAO.getTotalCount(bname);
        page.setTotalRecord(totalCount);
        if(cPage == null)
            cPage="1";
        page.setNowPage(Integer.parseInt(cPage));

        ModelAndView mv = new ModelAndView();

        //뷰페이지(jsp)에서 표현할 자원.
        BbsVO[] ar = bbsDAO.getList("BBS", 1, 10);
        mv.addObject("ar", ar);
        mv.addObject("page", page);
        mv.setViewName("list");
        return mv;
    }



    @RequestMapping("/write")
    public String write() { //해당방식은 GET방식 요청시 수행하는 곳.
        return "write";
    }

    @RequestMapping(value = "write", method = RequestMethod.POST)
    @Transactional
    public ModelAndView write(BbsVO vo) {
       ModelAndView mv = new ModelAndView();

       //폼에 encType이 multipart로 시작하는지 확인하고 싶다면
        String c_type = request.getContentType();
        if(c_type.startsWith("multipart")) {
            //파일이 첨부되는 폼에서 호출 된 경우.
            MultipartFile f = vo.getFile();
            String fname = null;
            if(f != null && f.getSize() > 0) {
                //파일이 첨부된 경우 - 파일이 저장될 위치를 절대경로화 시킨다.
                String realPath = application.getRealPath(upload_Path);
                fname = f.getOriginalFilename();

                try{
                    //파일 업로드(upload폴더에 저장)
                    f.transferTo(new File(realPath, fname));
                    vo.setFile_name(fname);

                } catch(Exception e){
                    e.printStackTrace();
                }
            }
            vo.setIp(request.getRemoteAddr()); // ip저장

            //vo를 DAO에게 전달하여 DB에 저장하도록 한다.
            bbsDAO.add(vo);
        }
        //list화면으로 이동하기 위해 다시 list라는 RequestMapping을 호출해야한다.
        // redirect로 호출해야 함.
        mv.setViewName("redirect:/list?bname="+vo.getBname());
       return mv;
    }

    @RequestMapping(value = "saveImg", method = RequestMethod.POST)
    @ResponseBody // MAP구조를 JSON형태로 바꿔서 보내줌.
    //여기서는 write.jsp에서 "upload", File로 보내고 있어서 upload를 파라미터로 사용함.
    //근데 강사님은 여기서 객체로 구현해서 던진다함.
    public Map<String, Object> saveImg(ImgVO ivo) { //이미지파일을 주고 json형식으로 반응을 해야한다.
        //여기서는 Spring환경에서 json으로 반환하는것을 알려준다. (쌉중요)

        //반환객체인 Map구조를 생성해야한다.
        Map<String, Object> map = new HashMap<String, Object>();

        // 전달되어 오는 이미지는 ivo에 저장되어 있다.
        // 파일을 첨부하지 않아도 MultipartFile에는 값이 들어있다. (0으로 추정됨)
        MultipartFile f = ivo.getUpload();
        if(f.getSize() > 0){
            //파일이 있는 경우
            //파일을 저장할 위치를 절대경로로 만들자.
            //이미 apllication으로 절대경로가 지정되어 있기 때문에 application으로 사용하면됨.
            String realPath = application.getRealPath("/resources/upload_img");

            //저장될 위치를 알아냈으니 파일을 저장하자.
            try{
                //파일올리기 (파일 객체를 하나 만들고, realPath를 파라미터를 준 다음에, getOriginalFilename)
                f.transferTo(new File(realPath, f.getOriginalFilename()));
                map.put("fname", f.getOriginalFilename());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //현재 파일이 저장된 서버경로(url)를 문자열로 만들자.
            // 예) localhost:8080/resources/upload_img
            String c_path = request.getContextPath(); //localhost:8080
            map.put("url", c_path+"/resources/upload_img");
        }

        return map; //요청한 곳으로 보내진다. 이때
        // JSON으로 보내기 위해 현재 메서드 위에 @ResponseBody를 지정했음.
        // {"fname" : "test.gif", "url":"localhost:8080/resources/upload_img"}

    }
    @RequestMapping("view")
    public ModelAndView view(String b_idx, String bname, String cPage) {
        ModelAndView mv = new ModelAndView();

        List<BbsVO> list = null;
        //세션으로부터 이름이 r_list라는 이름으로 저장된 객체를 얻어낸다.
        Object obj = session.getAttribute("r_list");
        if(obj != null) {
            list = (List<BbsVO>) obj;
        } else {
            list = new ArrayList<BbsVO>();
            session.setAttribute("r_list", list);
        }
        //이제 list에서 인자로 받은 b_idx값과 같은 값을 가진 BbsVO를
        // list에서 검색해야한다.
        boolean chk = false;

        for(BbsVO bvo : list) {
            if(bvo.getB_idx().equals(b_idx)) {
                chk = true;
                break;
            }
        }//for의 끝
        if(!chk) { // chk가 false를 유지하고 있을때, (한번도 글을 읽지 않았을 때 hit 수 증가)
            bbsDAO.hitUp(b_idx);
        }
        BbsVO vo = bbsDAO.getBbs(b_idx);

        if(vo != null) {
            if(!chk)
                list.add(vo);
            mv.addObject("vo", vo); // JSP에서 글내용을 출력하기 위해서 저장.
        }
        mv.setViewName("view");
        return mv;
    }
}
