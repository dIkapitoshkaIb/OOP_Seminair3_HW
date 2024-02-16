package src.main.java.OOP_Sem_3.bullsNCows;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scan2ner = new Scanner(System.in);
        String programStatus = "ACTIVE";
        Game newGame = null;
        Integer sc;
        while (programStatus == "ACTIVE") {
            System.out.println("Добро пожаловать в игру быки и коровы!\n" +
                    "Что вы хотите угадывать?\n" +
                    "1 - числа\n" +
                    "2 - русские буквы\n" +
                    "3 - английские буквы");
            switch (scanner.nextInt()) {
                case (1):
                    newGame = new NumberGame();
                    break;
                case (2):
                    newGame = new RuAlphGame();
                    break;
                case (3):
                    newGame = new EnAlphGame();
                    break;
                default:
                    System.out.println("Такого выбора не предлагалось!");
            }
            System.out.println("Введите количество символов, которые будете угадывать");
            newGame.setSizeWord(scanner.nextInt());
            System.out.println("Введите количество попыток на игру");
            newGame.setMaxTry(scanner.nextInt());
            newGame.start();
            while (newGame.getGameStatus().equals(GameStatus.ACTIVE)) {
                Answer answer = newGame.inputValue(scanner.nextLine());
                System.out.println(answer);
            }
            if (newGame.getGameStatus().equals(GameStatus.WIN)) {
                System.out.println("Победа!!");
            } else {
                System.out.println("Проигрыш!");
            }
            do {
                System.out.println("Хотите сыграть еще раз?\n" +
                        "1 - Новая игра\n" +
                        "2 - Выход\n" +
                        "3 - Посмотреть статистику\n" +
                        "4 - Посмотреть запись последней игры");
                sc = scanner.nextInt();
                switch (sc) {
                    case (1):
                        newGame.start();
                        break;
                    case (2):
                        programStatus = "DISABLE";
                        break;
                    case (3):
                        newGame.getStatistic();
                        break;
                    case (4):
                        newGame.getLogs();
                        break;
                    default:
                        System.out.println("Такого выбора не предлагалось!");
                }
            } while (sc > 2);
        }
    }
}