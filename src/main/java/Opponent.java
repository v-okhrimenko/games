import java.util.Random;

public class Opponent {

    private final String[] variants = {"Камень", "Ножницы", "Бумага"};

    public String getOpponentChoice() {
        Random r = new Random();
        int answer = r.nextInt(3);
        return variants[answer];
    }
}
