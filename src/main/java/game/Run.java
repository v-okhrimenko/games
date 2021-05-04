package game;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Run {

    private static boolean taDa = false;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ЗАГАДАЙТЕ ЧИСЛО ОТ 1 ДО 100...");
        Thread.sleep(1000);
        System.out.println("Я ОТГАДАЮ ЕГО МАКСИМУИ ЗА 7 ХОДОВ");
        Thread.sleep(3000);
        answer(1, 100);
    }

    private static void answer(int start, int end) {

        int[] tempArray = getVariantsArray(start, end + 1);
        //System.out.println(Arrays.toString(tempArray));
        int mayBe = tempArray[(tempArray.length - 1) / 2];
        //System.out.println("ПОПЫТКА " + ++count);
        System.out.println("ЭТО ЧИСЛО " + mayBe + "?");
        System.out.println("1 - меньше   2 - больше   3 - оно!");

        Scanner sc = new Scanner(System.in);
        int bigSmall = 0;
        try {
            bigSmall = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("ВВЕДИТЕ ЧИСЛО");
        }


        while (!taDa) {
            switch (bigSmall) {
                case 1:
                    try {
                        answer(tempArray[0], tempArray[index(tempArray, mayBe - 1)]);
                        break;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Помоему вы что то не договариваете...");
                        System.out.println("Ваше число - " + mayBe);
                        taDa = true;
                        break;
                    }
                case 2:
                    try {
                        answer(tempArray[index(tempArray, mayBe + 1)], tempArray[tempArray.length - 1]);
                        break;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Помоему вы что то не договариваете...");
                        System.out.println("Ваше число - " + mayBe);
                        taDa = true;
                        break;
                    }
                case 3:
                    System.out.println("Ваше число " + mayBe);
                    taDa = true;
                    break;
                default:
                    System.out.println("СДЕЛАЙТЕ ПРАВИЛЬНЫЙ ВЫБОР:");
                    answer(tempArray[0], tempArray[tempArray.length - 1]);
                    break;
            }
        }
    }

    public static int index(int[] arr, int element) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == element).findFirst().orElse(-1);
    }

    public static int[] getVariantsArray(int start, int end) {
        return IntStream.range(start, end).toArray();
    }
}
