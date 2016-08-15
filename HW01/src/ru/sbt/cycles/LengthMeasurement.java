package ru.sbt.cycles;


import java.util.Scanner;

public class LengthMeasurement {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // длина в сантиметрах
        int lengthInCm = scanner.nextInt();

        // в одном дюйме 3 сантиметра
        int oneInch = 3;
        // в одном футе 12 дюймов
        int oneFt = oneInch * 12;

        int countOfFts = lengthInCm / oneFt;
        int mod = lengthInCm % oneFt;
        int countOfInch = mod / oneInch;
        if (mod % oneInch > 0) {
            countOfInch += mod % oneInch == 1 ? 0 : 1;
        }

        System.out.println(countOfFts + " " + countOfInch);
    }
}
