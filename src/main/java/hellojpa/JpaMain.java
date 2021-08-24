package hellojpa;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {



//            Team team = new Team();
//            team.setName("team1");
//            em.persist(team);
//
//            Team team2 = new Team();
//            team2.setName("team2");
//            em.persist(team2);
//
//            Member member = new Member();
//            member.setUsername("Member1");
//            member.setTeam(team);
//            em.persist(member);
//
//            Member member2 = new Member();
//            member2.setUsername("Member2");
//            member2.setTeam(team2);

            em.flush();
            em.clear();

//           List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
//            Movie movie = new Movie();
//            movie.setActor("aaa");
//            movie.setDirector("bbb");
//            movie.setName("바람과 함께 사라질까");
//            movie.setPrice(100000);
//
//            em.persist(movie);

//            Team team = new Team();
//            team.setName("TeamA");
////            team.getMembers().add(member);
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member1");
//            member.changeTeam(team);
//            em.persist(member);

//            Team team = new Team();
//            team.setName("TeamA");
//            team.getMembers().add(member);
//            em.persist(team);



//            em.flush();
//            em.clear();

//            Member findmember = em.find(Member.class, member.getId());
//            List<Member> members = findmember.getTeam().getMembers();

//            for (Member m : members) {
//                System.out.println("m =" + m.getUsername());
//            }

//           Team team100 = em.find(Team.class, 100L);
//            member.setTeam(team100);
//            em.persist(member);

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
