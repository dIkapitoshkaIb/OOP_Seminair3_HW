package src.main.java.OOP_Sem_3.bullsNCows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnAlphGame extends AbstractGame {
    @Override
    protected List<String> generateCharList() {
        return new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i",
                "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
    }
}