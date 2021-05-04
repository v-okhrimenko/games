import java.util.InputMismatchException;
import java.util.Scanner;

public class GameRun {

    private static final String[] variants = {"Камень", "Ножницы", "Бумага"};
    private static boolean letsPlay = false;
    private static int roundsCounter;
    private static GameLogic gl;


    public static void main(String[] args) {

        System.out.println("---- КАМЕНЬ ---- НОЖНИЦЫ ---- БУМАГА ----\n");

        startGame(roundSelect());

    }

    private static int roundSelect() {
        do {
            System.out.print("Сколько партий хотите сыграть?: ");
            Scanner roundScanner = new Scanner(System.in);
            try {
                int rounds = roundScanner.nextInt();
                if (rounds < 1) {
                    throw new InputMismatchException();
                } else {
                    letsPlay = true;
                    return rounds;
                }
            } catch (InputMismatchException e) {
                System.out.println("Введите количество раундов!");
            }
        }
        while (!letsPlay);
        return 0;
    }

    private static void startGame(int rounds) {
        do {
            System.out.println("\n__________ " + "Партия " + ++roundsCounter + " ___________");
            System.out.println("1 Камень   2 Ножницы   3 Бумага");
            System.out.print("Ваш выбор?: ");
            Scanner sc = new Scanner(System.in);
            try {
                int selected = sc.nextInt();
                if (selected < 1 || selected > 3) {
                    throw new InputMismatchException();
                }
                startNewRound(selected - 1);

            } catch (InputMismatchException e) {
                --roundsCounter;
                System.out.println("Введите число!");
            }
        }
        while (roundsCounter != rounds);
        System.out.println(" ______________________________");
        System.out.println("|             Счет             |");
        System.out.println("|______________________________|");
        System.out.println("|     ВЫ     |     КОМПЬЮТЕР   |");
        System.out.println("|______________________________|");
        System.out.println("|     " + gl.getHumanCount() + "               " + gl.getComputerCount() + "        |");
        System.out.println("|______________________________|");
        System.out.println("        " + gl.winner());
    }

    private static void startNewRound(int selected) {
        gl = new GameLogic(new Opponent().getOpponentChoice(), variants[selected]);

        try {
            System.out.println("В этом рауне " + gl.result());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1330);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
