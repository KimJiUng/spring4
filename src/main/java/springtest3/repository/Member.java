package springtest3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springtest3.domain.entity.MemberEntity;

public interface Member extends JpaRepository <MemberEntity,Integer> {
}
