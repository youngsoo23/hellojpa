package hellojpa;

import javax.persistence.*;

@Entity
public class Locker {
    @Id @GeneratedValue
    @Column(name = "locker_id")
    private Long id;

    private String name;

    //oneToone 양방향성 -- 읽기 전용
    @OneToOne(mappedBy = "locker")
    private Member member;
}
