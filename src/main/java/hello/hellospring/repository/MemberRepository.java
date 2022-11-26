package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); // 저장소에 회원 정보를 저장
    Optional<Member> findById(Long id); // Optional은 findById나 findByName으로 값을 가져올때 널값을 처리하는 방법
    Optional<Member> findByName(String name); // findById, findByName은 저장소에서 값을 가져옴
    List<Member> findAll();


}
