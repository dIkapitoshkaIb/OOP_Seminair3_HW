package src.main.java.OOP_Sem_3.bullsNCows;

public interface Game {
    void start();
    void restart();
    Answer inputValue(String value);
    GameStatus getGameStatus();
    void setSizeWord(Integer number);
    void setMaxTry(Integer number);
    void getLogs();
    void getStatistic();
}