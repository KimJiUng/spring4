package springtest3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtest3.domain.dto.MemberDto;
import springtest3.domain.entity.MemberEntity;
import springtest3.repository.Member;

import java.util.ArrayList;
import java.util.List;

@Service
public class Indexservice { // 자바 로직 실행되는 클래스


    @Autowired
    Member member;

    // 1. 생성
    public boolean create(MemberDto memberDto){

        System.out.println("저장 서비스 호출");

        // 1. Dto -> entity 변환
        MemberEntity memberEntity = memberDto.changeEntity();
        // 2. entity save
        int no = member.save(memberEntity).getNo();
        // 3. 반환
        System.out.println("저장된 엔티티 번호 : "+no);

        if(no>0){return true;}
        else{return false;}


    }
    // 2. 호출
    public List<MemberEntity> read(){
        List<MemberEntity> members = member.findAll();
        System.out.println(members);
        System.out.println("호출 서비스 호출");
        return members;
    }
    // 3. 수정
    public void update(){
        System.out.println("수정 서비스 호출");
    }
    // 4. 삭제
    public void delete(){
        System.out.println("삭제 서비스 호출");
    }
}
