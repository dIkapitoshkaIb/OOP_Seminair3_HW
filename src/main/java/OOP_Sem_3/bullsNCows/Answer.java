package src.main.java.OOP_Sem_3.bullsNCows;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Answer {
    private Integer numTry;
    private Integer cow;
    private Integer bull;

    public Answer(Integer numTry, Integer bull, Integer cow) {
        this.numTry = numTry;
        this.cow = cow;
        this.bull = bull;
    }

    @Override
    public String toString() {
        return "Количество оставшихся попыток - " + numTry +
                ", Коров - " + cow +
                ", Быков - " + bull +
                '}';
    }
}