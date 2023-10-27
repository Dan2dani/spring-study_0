package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 규칙에 따라 spring data JPA가 쿼리를 짜줌, 인터페이스 이름만으로 짜줌..!
    // select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
