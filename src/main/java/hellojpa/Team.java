package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Team {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>(); //양뱡향 연관관계

    //member에 changeTeam 을 넣었으면 안해줘도 된다.(한쪽에만 있는걸 선호)
//    public void addMember(Member member) {
//        member.setTeam(this);
//        members.add(member);
//    }
}
