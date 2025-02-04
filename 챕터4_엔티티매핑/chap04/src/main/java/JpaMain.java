import entity.Board;
import entity.Board2;
import entity.Board3;
import entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class JpaMain {

    public static void main(String[] args) {

        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성

        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {

            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직
            tx.commit();//트랜잭션 커밋

        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager em) {

            //2021-06-22 sor
            Board board = new Board();
            em.persist(board);
            System.out.println("board.id = " + board.getId());

            Board2 board2 = new Board2();
            em.persist(board2);
            System.out.println("board.id = " + board2.getId());

        //seq
            Board3 board3 = new Board3();
            em.persist(board3);
            System.out.println("board.id = " + board3.getId());


//        String id = "id1";
//        Member member = new Member();
//        member.setId(id);
//        member.setUsername("지한");
//        member.setAge(2);
//
//        //등록
//        em.persist(member);
//
//        //수정
//        member.setAge(20);
//
//        //한 건 조회
//        Member findMember = em.find(Member.class, id);
//        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());
//
//        //목록 조회
//        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
//        System.out.println("members.size=" + members.size());
//
//        //삭제
//        em.remove(member);

    }
}
