package hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DiscriminatorValue("A")
public class Album extends Item{
    private String artist;
}
