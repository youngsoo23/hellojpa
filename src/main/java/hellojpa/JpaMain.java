package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            // ---- 비영속성 상태 -----
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloWord");

//            Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");


            // ----- 영속 ----- (디비에 저장되지 않음)
            // sql 쓰기 저장소에 저장 (버버핑 작용 - 모았다가 한방에 넣을수있음 persistance 안에 batch value 추가)
//            em.persist(member1);
//            em.persist(member2);

            Member member1 = em.find(Member.class, 150L);
            // persist 안해줘도 됨.
            member1.setName("ZZZZZZ");

            Member findMember = em.find(Member.class, 1L);

            // ------ 준영속 상태 ---- 디텍치 상태라고도 함
            //em.detach(member1); // 데이터를 변경해도 실제 영속성 컨텍스트에서 나온다. (실제로 디비에 저장이 안됨) - 특정 엔티티만 지정
            //em.clear(); // em (영속성 컨텍스트 안에 있는 모든걸 준영속성 상태로 만든다.


            // ------ 영속 엔티티의 동일성 보장 ------
//            Member a =  em.find(Member.class, 1L);
//            Member b =  em.find(Member.class, 1L);
//            System.out.println( a == b); // true

            // ----- 영속성에서 삭제  ------
            //em.detach(member);

            // -------객체를 삭제한 상태 (삭제)
            //em.remove(member1);


            // sout <<print line 단축키
            // update
//            findMember.setName("HelloJPA");

            System.out.println("findMember :" + findMember.getId());
            System.out.println("findMember :" + findMember.getName());

            // 디비에 저장
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();

    }
}
