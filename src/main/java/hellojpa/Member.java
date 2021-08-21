package hellojpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
public class Member {
    @Id
    private Long id;
    private String name;
}

