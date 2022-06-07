package springtest3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // 스프링부트 초기 셋팅 : 1. 내장 톰캣 세팅 2. MVC 세팅 3. Restful 세팅
public class Appstart {
    public static void main(String[] args) {

        SpringApplication.run(Appstart.class);

    }
}

/*
    프로젝트폴더
        src
            main
                1.java[백엔드파일]
                    2.최상위패키지[웹페이지 명]
                        3.controller 패키지
                        3.service 패키지
                        3.domain 패키지
                        3.스프링 실행 클래스  [*]
                1.resources [프론트엔드/설정파일]
                    2. static
                        3. js
                        3. css
                        3. img
                    2. templates
                        3. html
                    2. application.properties [앱 설정파일]


 */