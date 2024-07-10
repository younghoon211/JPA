package jpabook.jpashop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId(); // member대신 ID return? 커맨드, 쿼리 분리! 리턴값 최소화 -> 이슈발생 최소화
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}