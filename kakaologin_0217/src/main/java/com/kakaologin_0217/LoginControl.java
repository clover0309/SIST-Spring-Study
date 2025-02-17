package com.kakaologin_0217;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vo.MemberVO;

import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
public class LoginControl {
    @Autowired
    //세션을 확보하기 위한 HttpSession 지정.
    private HttpSession session;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //이곳으로 카카오서버가 호출이됨.
    @RequestMapping("/login/kakao")
    public ModelAndView loginKakao(@RequestParam("code") String code) {
        ModelAndView mv = new ModelAndView();

        //카카오서버가 인자로 전달해준 "인증코드"가 code라는 변수로 넣어준다.
        //System.out.println("code: " + code);

        //받은 인증코드를 가지고 2번째 카카오서버와 통신을 하기 위해
        // 토큰을 요청하여 받아야함.

        //토큰 제도에서는 access 토큰과 refresh 토큰이 존재한다.
        String access_Token = "";
        String refresh_Token = "";

        //두번째 요청을 위한 준비과정.
        String req_url = "https://kauth.kakao.com/oauth/token";


        // 경로가 잘못되었다는 가정하에 진행하는 것이기에 try catch 사용
        try {
            //자바에서는 a태그나 form 태그를 사용 할 수 없기에 이럴때는 url 객체를 만들어서 사용하면된다.
            //웹상의 경로를 객체화 시킨다
            URL url = new URL(req_url);

            //웹상의 경로와 연결하는 객체.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //카카오서버쪽에서 POST방식의 요청을 원하므로 RequestMethod를 POST로 지정.
            conn.setRequestMethod("POST");
            //데이터 방출을 허용.
            conn.setDoOutput(true);

            //연결된 카카오서버로 파라미터들을 전달하기 위해 스트림을 생성.
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(conn.getOutputStream()));

            //카카오 API문서에 있는 4개에의 파라미터들을 정의하기 위해
            //문자열 편집이 필요함.
            //예) grant_type=authorization_de&client_id=....
            StringBuffer sb = new StringBuffer();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=e3075c63df4a3c2135413cd116f067c5");
            sb.append("&redirect_uri=http://localhost:8080/login/kakao");
            sb.append("&code=").append(code);

            bw.write(sb.toString());//준비된 파라미터들을 카카오서버에 보낸다.
            bw.flush();

            //카카오서버에 요청을 보낸 후 응답결과가 성곡적인 경우(200)에만
            //토큰들을 받아내야함.
            int res_code = conn.getResponseCode();
            //System.out.println("rescode : " + res_code);

            if (res_code == 200) {
                //요청을 통해 얻은 JSON타입의 결과 메시지를 읽어온다.
                // 그 결과를 받기 위해 스트림 준비.
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream())
                );
                StringBuffer result = new StringBuffer();
                String line = null;

                //한줄 단위로 읽어서 result라는 StringBuffer에 적재한다.
                //이때 json으로 넘어옴.
                while( (line = br.readLine()) != null) {
                    result.append(line);
                } //while문의 끝.
                //System.out.println("result : " + result.toString());

                //JSON파싱 처리 : "access_token"과 "refresh_token"을 찾아내어 값을 얻어내야 한다.
                //현재 안에 있는것들은 JSON형태이긴 하지만, JSON이 아니다. (한 덩어리로 된 String 상태)
                // 이때 Json-Simple을 사용해서 json형태로 바꿔줌.

                //JSONParser는 json-simple 라이브러리가 가지고 있으며
                //문자열이지만 JSON표현식으로 된 것을 JSON객체화 시키는 객체다.
                JSONParser parser = new JSONParser();

                //parse의 형태가 Object로 사용해야 함으로 Object obj 선언.
                //Object obj = parser.parse(result.toString());

                JSONObject json = (JSONObject) parser.parse(result.toString());

                access_Token = (String) json.get("access_token");
                refresh_Token = (String) json.get("refresh_token");

                //System.out.println("access_token = " + access_Token);
                //System.out.println("refresh_token = " + refresh_Token);

                //이제 받은 토큰을 가지고, 마지막 3번째 호출인
                // 사용자 정보를 요청을 하자!
                String apiURL = "https://kapi.kakao.com/v2/user/me";
                String header = "Bearer "+access_Token;

                //자바에서 특정 웹상의 경로(URL)를 호출하기 위해서는
                //먼저 URL객체를 생성해야한다.
                URL url2 = new URL(apiURL);
                HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
                conn2.setRequestMethod("POST");
                conn2.setDoOutput(true);

                //카카오API의 문서상에 조건이 access토큰을 header에 담아 보내라고 적혀있음.
                //명시가 되어있으니깐 헤더설정을 하자.
                conn2.addRequestProperty("Authorization", header);

                res_code = conn2.getResponseCode();
                System.out.println("res_code = " + res_code);
                //HTTP_OK는 상수다.
                System.out.println("res_code = " + HttpURLConnection.HTTP_OK);

                if (res_code == HttpURLConnection.HTTP_OK) {
                    //요청에 성공했다면...
                    BufferedReader brdm = new BufferedReader(
                            new InputStreamReader(conn2.getInputStream())
                    );

                    StringBuffer res = new StringBuffer();
                    String line2 = null;
                    while((line2 = brdm.readLine()) != null) {
                        res.append(line2);
                    }

                    //System.out.println("res = " + res.toString());

                    //받은 JSON표현의 문자열을 JSON객체로 변환 후
                    //원하는 정보(nickname, profile_image)를 얻어낸다.
                    //앞서 이미 파서객체(JSONParser)가 생성된 상태이다.
                    json = (JSONObject) parser.parse(res.toString());

                    //원하는 정보 nickname과 profile_image가 있는 "properties"라는
                    // 키의 값을 얻어낸다.

                    // ----- 사용자 정보 -----
                        JSONObject props = (JSONObject) json.get("properties");
                        String nickname = (String) props.get("nickname");
                        String p_img = (String) props.get("profile_image");
                    // ---------------------

                    MemberVO mvo = new MemberVO();
                    mvo.setNickname(nickname);
                    mvo.setP_img(p_img);

                    //이렇게 카카오에서 받은 정보를 mvo에 저장한 후
                    //ModelAndView에다가 저장하여 추가 정보를 받을 수 있는
                    //registry.jsp에서 표현 할 수 있도록 한다.
                    mv.addObject("mvo", mvo);
                    mv.setViewName("registry");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return mv;
    }
}
