package hellojpa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Period {
    //Period
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public String printStartDate(){
        return "start date:" + startDate;
    }
}
