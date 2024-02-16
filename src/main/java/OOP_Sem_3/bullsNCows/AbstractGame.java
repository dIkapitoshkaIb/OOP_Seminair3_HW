package src.main.java.OOP_Sem_3.bullsNCows;

import java.util.*;

public abstract class AbstractGame implements Game {
    private Integer sizeWord;
    private Integer maxTry;
    private GameStatus status;
    private String word;
    private List logs = new ArrayList();
    static Map<String, Integer> stat = new HashMap<String, Integer>(){{
        put("Количество  побед", 0);
        put("Количество поражений", 0);
    }};


    @Override
    public void start() {
        status = GameStatus.ACTIVE;
        word = generateWord(sizeWord);
        System.out.println(word);
        logs.add("Программа загадала следующие символы - " + word);

    }

    @Override
    public void restart() {
        System.out.println("restart");
    }

    private String generateWord(Integer sizeWord) {
        List<String> alf = generateCharList();
        String resultWord = "";
        for (int i = 0; i < sizeWord; i++) {
            Integer ind = new Random().nextInt(alf.size());
            resultWord += alf.get(ind);
            alf.remove(ind);
        }
        return resultWord;
    }

    protected abstract List<String> generateCharList();

    @Override
    public Answer inputValue(String value) {
        Integer countBull = 0;
        Integer countCow = 0;
        for (int i = 0; i < value.length(); i++) {
            if (word.contains(((Character) (value.charAt(i))).toString())) {
                countCow++;
                if (value.charAt(i) == word.charAt(i)) {
                    countBull++;
                }
            }
            maxTry--;
        }
        if (countBull.equals(word.length())) {
            status = GameStatus.WIN;
            stat.put("Количество  побед", stat.get("Количество  побед")+1);
            logs.add("Вы выйграли");
            return new Answer(maxTry, countBull, countCow);
        }
        if (maxTry == 0) {
            status = GameStatus.LOSE;
            stat.put("Количество поражений", stat.get("Количество поражений")+1);
            logs.add("Вы проиграли");
            return new Answer(maxTry, countBull, countCow);
        }
        logs.add("Ваш ответ - " + value);
        logs.add(new Answer(maxTry, countBull, countCow));
        return new Answer(maxTry, countBull, countCow);
    }

    @Override
    public GameStatus getGameStatus() {
        return status;
    }

    public void setSizeWord(Integer sizeWord) {
        this.sizeWord = sizeWord;
    }

    public void setMaxTry(Integer maxTry) {
        this.maxTry = maxTry;
    }

    @Override
    public void getLogs() {
        System.out.println(logs);
    }

    @Override
    public void getStatistic() {
        System.out.println(stat);
    }
}