package hellojpa;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String username;

//    @Column(name = "team_id")
//    private Long teamId;

    //연관관계 주인 (member 과 팀)
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    //OneToOne 예제
    @OneToOne
    @JoinColumn(name ="locker_id")
    private Locker locker;

    //ManyToMany 예제
    @ManyToMany
    @JoinTable(name = "member_product")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "memeber")
    private List<MemberProduct> memberProduct;
}

