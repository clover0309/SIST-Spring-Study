package spring.input;

import org.springframework.web.multipart.MultipartFile;

public class ImgVO {
    //파라미터와 이름이 같은 멤버변수 선언
    //여기서 객체를 만든 이유는 파라미터를 하나하나 다 적기 불편하고 많기 때문에 객체를 만들었다.
    //파일만 받겠다면 BbsControl saveImg에서 MultipartFile upload를 파라미터로 사용했으면 되었다.
    private MultipartFile upload;

    public MultipartFile getUpload() {
        return upload;
    }

    public void setUpload(MultipartFile upload) {
        this.upload = upload;
    }
}
