package springtest3.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springtest3.domain.dto.MemberDto;
import springtest3.domain.entity.MemberEntity;
import springtest3.service.Indexservice;

import java.util.List;

@Controller
public class IndexController {

    // RESTFUL 정의
        // 1. 자원(URL) 2. 행위(HTTP Method) 3. 표현
            // 행위(HTTP Method)
                //                     CRUD        차이[멱등성 = 기록 O/X]
                // 1. @PostMapping       C          X
                // 2. @GetMapping        R          O
                // 3. @PutMapping        U          O
                // 4. @DeleteMapping     D          O

                // * 여러번 호출했을때 POST는 호출할때마다 데이터 새로 생성
                // * ajax -------> spring controller
                //     ajax method : GET ----------> @GetMapping
                //     ajax method : POST ----------> @PostMapping
                //     ajax method : PUT ----------> @PutMapping
                //     ajax method : DELETE ----------> @DeleteMapping

    @GetMapping("/")
    public String index(){
        return "main";
    }

    // static Indexservice indexservice = new Indexservice();

    @Autowired  // 자동 빈 생성 = 빈 생성자  // new 사용하지 않아도 메모리 할당
    Indexservice indexservice;

    @PostMapping("/create")
    @ResponseBody
    public boolean create(@RequestParam String name,
                         @RequestParam String phone,
                         @RequestParam String memo){

//        // 1. DTO 풀생성자 사용
//        MemberDto memberDto = new MemberDto(0,name,phone, memo);
//        // 2. DTO 빈 생성자 사용
//        MemberDto memberDto2 = new MemberDto();
//            memberDto2.setNo(0);
//            memberDto2.setName(name);
//            memberDto2.setPhone(phone);
//            memberDto2.setMemo(memo);
        // 3. builder 사용
        MemberDto memberDto3 = MemberDto.builder()
            .no(0)
            .name(name)
            .phone(phone)
            .memo(memo)
            .build();
        // 생성자 vs 빌더 차이점
            // 1. 생성자 인수 순서를 무조건 지켜야한다. <---> 빌더는 순서 무관
            // 2. 생성자 인수 개수를 무조건 맞춰야 한다. <---> 빌더는 무관
        boolean result =indexservice.create(memberDto3);

        return result;
    }

    @GetMapping("/read")
    @ResponseBody
    public  List<MemberEntity> read(){
        List<MemberEntity> members = indexservice.read();
//        JSONArray jsonArray = new JSONArray();
//        for(MemberEntity member : members){
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("name",member.getName());
//            jsonObject.put("no",member.getNo());
//            jsonObject.put("phone",member.getPhone());
//            jsonObject.put("memo",member.getMemo());
//            jsonArray.put(jsonObject);
//        }
        return members;
    }

    @PutMapping("/update")
    @ResponseBody
    public String update(){
        indexservice.update();
        return "수정 성공";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(){
        indexservice.delete();
        return "삭제 성공";
    }

}
