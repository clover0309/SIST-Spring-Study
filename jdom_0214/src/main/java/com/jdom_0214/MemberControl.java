package com.jdom_0214;

import data.vo.MemberVO;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.print.Doc;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MemberControl {
    /*
    오픈API 서비스의 URL같은 경로가 멤버변수로 선언되어야 하지만
    우리는 내부에 있는 XML문서를 접근하여 마치 오픈API에서 결과를 받은 것 처럼
    가정하자.
     */
    @Autowired
    private ServletContext application;

    @RequestMapping("test")
    public ModelAndView test() throws Exception {
        ModelAndView mv = new ModelAndView();

        //준비된 문서의 절대경로를 지정하자.
        String realPath = application.getRealPath("/resources/pm/data/member.xml");

        //xml문서를 읽게하기 위해 필요한 객체 생성.
        //jdom2에 있는 객체 생성.
        SAXBuilder builder = new SAXBuilder();

        //준비된 builder를 통해 결과인 xml자원을 문서화(Document) 시킨다.
        //jdom2에 있는 Document를 사용.
        Document doc = builder.build(realPath);

        //메모리상에 존재하는 xml문서의 루트를 얻어낸다.
        //Element는 jdom2에 있는 것을 사용.
        Element root = doc.getRootElement(); //얘가 members
        System.out.println("root : " + root.getName());

        //루트의 자식들 중 태그명이 member인 자식들을 모두 가져온다.
        List<Element> list = root.getChildren("member");

        //위에서 얻은 list를 배열로 만들고자 한다.
        System.out.println("list : " + list.size());

        //각각의 Element를 MemberVO로 만들자.
        MemberVO[] ar = null;
        if (list != null && list.size() > 0) {
            ar = new MemberVO[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Element e = list.get(i); // 리스트에 저장된 Element를 하나씩 가져옴.
                String name = e.getChildText("name");
                String email = e.getChildText("email");
                String phone = e.getChildText("phone");

                //배열에 저장할 MemberVO를 생성.
                MemberVO m = new MemberVO();
                m.setName(name);
                m.setEmail(email);
                m.setPhone(phone);
                ar[i] = m;
            }
        }
        mv.addObject("ar", ar);
        mv.setViewName("member");
        return mv;
    }

    @RequestMapping(value = "search", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> search(int searchType, String searchValue) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();

        //준비된 문서의 절대경로를 지정하자.
        String realPath = application.getRealPath("/resources/pm/data/member.xml");

        //xml문서를 읽게하기 위해 필요한 객체 생성.
        //jdom2에 있는 객체 생성.
        SAXBuilder builder = new SAXBuilder();

        //준비된 builder를 통해 결과인 xml자원을 문서화(Document) 시킨다.
        //jdom2에 있는 Document를 사용.
        Document doc = builder.build(realPath);

        //메모리상에 존재하는 xml문서의 루트를 얻어낸다.
        //Element는 jdom2에 있는 것을 사용.
        Element root = doc.getRootElement();

        //루트의 자식들 중 태그명이 member인 자식들을 모두 가져온다.
        List<Element> list = root.getChildren("member");

        //각각의 Element를 MemberVO로 만들자.
        MemberVO[] ar = null;
        if (list != null && list.size() > 0) {
            ar = new MemberVO[list.size()];
            for (int i = 0; i < list.size(); i++) {
                Element e = list.get(i); // 리스트에 저장된 Element를 하나씩 가져옴.
                String name = e.getChildText("name");
                String email = e.getChildText("email");
                String phone = e.getChildText("phone");

                //배열에 저장할 MemberVO를 생성.
                MemberVO m = new MemberVO();
                m.setName(name);
                m.setEmail(email);
                m.setPhone(phone);

                boolean chk = false;

                switch (searchType) {
                    case 1:
                        if(email.contains(searchValue))
                            chk = true;
                        break;
                    case 0:
                        if(name.contains(searchValue))
                            chk = true;
                        break;
                    case 2:
                        if(phone.contains(searchValue))
                            chk = true;
                        break;
                }
                //chk가 true일 때만 배열에 저장.
                if(chk)
                    ar[i] = m;
            }
        }
        map.put("ar", ar);
        map.put("count", ar.length);
        return map;
    }
}
