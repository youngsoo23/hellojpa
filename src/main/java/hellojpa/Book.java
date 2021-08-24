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
@DiscriminatorValue("B") // DType 을 바꿀수 있다.
public class Book extends Item{
    private String author;
    private String isbn;
}
