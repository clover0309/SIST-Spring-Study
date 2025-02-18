package com.openapi_0218;

import com.data.vo.DataVO;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Locale;

@Controller
public class IndexControl {
    @RequestMapping("/")
  public String index(Model model) {
      //공공데이터의 자원을 받기 위해 URL을 생성.
      StringBuffer sb = new StringBuffer("http://apis.data.go.kr/B551011/KorService1/searchFestival1?");
      sb.append("serviceKey=5XYZl%2BZ2MFf%2FCx%2FlB8nPgIAyMoDXBds7R33IKl%2FJTfQ7alQ4ncCvpt6o8Likf3y08HLII%2BBV4d5hkPTXvEq1WA%3D%3D");
      sb.append("&numOfRows=10");
      sb.append("&pageNo=1");
      sb.append("&MobileOS=ETC");
      sb.append("&MobileApp=AppTest");
      sb.append("&arrange=A");
      sb.append("&listYN=Y");
      sb.append("&eventStartDate=20170901");
      sb.append("&areaCode=1");

      try {
        //자바에서는 외부의 서버호출 시 URL객체를 생성해야함.
        URL url = new URL(sb.toString());

        //위에서 만든 웹상의 URL을 호출하기 위한 연결 객체
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        //응답 받을 데이터의 형식을 지정
        conn.setRequestProperty("Content-Type", "application/xml");

        //요청-(연결)
        conn.connect();

        //JDOM 라이브러리를 통해 xml문자열을 DOM객체로 변환하자.
        SAXBuilder builder = new SAXBuilder();

        //응답된 내용을 하나의 XML의 문서(Document)로 변환해야한다.
        Document doc = builder.build(conn.getInputStream());

        //루트얻기
        Element root = doc.getRootElement(); // response
        //System.out.println("root : " + root.getName());

        //루트의 자식요소들 중 이름이 body인 요소
        Element body = root.getChild("body");

        //body안에 자식요소들 중 이름이 items인 요소
        Element items = body.getChild("items");

        //items 요소 안에 자식요소들 중 이름이 item인 요소들 모두 받기
        List<Element> item_list = items.getChildren("item");

        DataVO[] ar = new DataVO[item_list.size()];

        if(item_list != null && item_list.size() > 0) {
          ar = new DataVO[item_list.size()];

          int i = 0;
          for (Element item : item_list) {
            //하나의 item객체에서 제목, 이벤트 날짜, 이미지등 얻어냄.
            String title = item.getChildText("title");
            String eventstartdate = item.getChildText("eventstartdate");
            String eventenddate = item.getChildText("eventenddate");
            String firstimage = item.getChildText("firstimage");
            String firstimage2 = item.getChildText("firstimage2");
            String mapx = item.getChildText("mapx");
            String mapy = item.getChildText("mapy");
            String addr1 = item.getChildText("addr1");
            String addr2 = item.getChildText("addr2");
            String tel = item.getChildText("tel");

            //앞서 받은 데이터들을 DataVO객체로 생성
            DataVO vo = new DataVO(title, mapx, mapy, addr1, addr2, firstimage,
              firstimage2, tel, eventstartdate, eventenddate);

            //생성된 vo를 배열에 저장.
            ar[i++] = vo;
          }
        }
        //배열을 jsp에서 표현 할 수 있도록 Model에 추가
        model.addAttribute("ar", ar);
      } catch (Exception e) {
        e.printStackTrace();
      }
      return "index";
    }
}
