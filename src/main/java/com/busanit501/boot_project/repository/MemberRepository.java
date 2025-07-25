package com.busanit501.boot_project.repository;

import com.busanit501.boot_project.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    // <Member>... Member내 변수로 CRUD전부 가능
    // 부모테이블 : Member , 자식테이블:Member Role ==> 1:N 관계
        //DB서버에 요청을 각각 매번하게됨
        // 서버입장에선 한번에 모아서 요청을 했으면 한다. 왔다갔다 안하게
        // 질문 query도 조금 모아서 요청해줬으면 함.
        // 2개의 테이블을 조인해서.. 한번만 호출하면 조인되어서 결과를 받을수 있음.
            // Member테이블을 조회할때 MemberRole Set 테이블도 같이 조회되게
    @EntityGraph(attributePaths = "roleSet")
    @Query("select m from Member m where m.mid = :mid and m.social= false")
    Optional<Member> getWithRoles(String mid);


}
