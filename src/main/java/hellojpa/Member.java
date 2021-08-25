package hellojpa;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "name")
    private String username;


//    @Column(name = "team_id")
//    private Long teamId;

    //연관관계 주인 (member 과 팀)
    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩
    @JoinColumn(name = "team_id")
    private Team team;

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

    //OneToOne 예제
    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;

    //ManyToMany 예제
    @ManyToMany
    @JoinTable(name = "member_product")
    private List<Product> products = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProduct;

    //Period
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;

    @Embedded
    private Period workPeriod;

    //Address
//    private String city;
//    private String street;
//    private String zipcode;
    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city",
                    column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name = "street",
                    column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name = "zipcode",
                    column = @Column(name = "WORK_ZIPCODE"))
    })
    private Address workAddress;


    //값 타입 컬렉션
    @ElementCollection
    @CollectionTable(name = "favorite_food", joinColumns = @JoinColumn(name="member_id"))
    @Column(name="food_name")
    private Set<String> favoriteFoods;

    @ElementCollection
    @CollectionTable(name="address", joinColumns = @JoinColumn(name="member_id"))
    private List<Address> addressHistory = new ArrayList<>();
}

