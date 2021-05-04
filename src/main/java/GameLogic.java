public class GameLogic {
    private final String computer;
    private final String human;
    private static int humanCount;
    private static int computerCount;

    public GameLogic(String computer, String human) {
        this.computer = computer;
        this.human = human;
    }

    public int getHumanCount() {
        return humanCount;
    }

    public int getComputerCount() {
        return computerCount;
    }

    public String winner() {
        if (this.getHumanCount() > this.getComputerCount()) return "Вы победили!!!";
        if (this.getHumanCount() == this.getComputerCount()) return "Ничья!!!";
        else return "Компьютер победил!!!";

    }

    public String result() throws InterruptedException {
        System.out.println("Ваш выбор - " + this.human);
        String winner = "";
        int x = 0;
        while (x < 31) {
            System.out.print("-");
            Thread.sleep(100);
            x++;
        }
        System.out.println("\nВыбор компьютера - " + this.computer);
        System.out.println("-------------------------------");

        if (this.human.equals(this.computer)) {
            winner = "Ничья";
        }

        if (this.computer.equals("Камень")) {
            if (this.human.equals("Ножницы")) winner = "Компьютер победил!";
            if (this.human.equals("Бумага")) winner = "Вы победили!";
        }
        if (this.computer.equals("Ножницы")) {
            if (this.human.equals("Бумага")) winner = "Компьютер победил!";
            if (this.human.equals("Камень")) winner = "Вы победили!";
        }
        if (this.computer.equals("Бумага")) {
            if (this.human.equals("Ножницы")) winner = "Вы победили!";
            if (this.human.equals("Камень")) winner = "Компьютер победил!";
        }
        if (winner.equals("Компьютер победил!")) computerCount++;
        if (winner.equals("Вы победили!")) humanCount++;

        return winner;
    }
}
