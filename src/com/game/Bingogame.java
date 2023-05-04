package com.game;

import java.util.Random;
import java.util.Scanner;

public class Bingogame {
    private int min;
    private int max;

    public Bingogame(int min, int max) {
        this.min = min;
        this.max = max;
    }


    private void setMin(int min) {
        this.min = min;
    }


    private void setMax(int max) {
        this.max = max;
    }

    private static int generateRandomNumber(Bingogame game) {
        Random random = new Random();
        int randomNumber = random.nextInt(game.max - game.min) + game.min;
        System.out.println("The random Number is :" + randomNumber);
        return randomNumber;
    }

    public static void playBingoGame(Bingogame game) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = generateRandomNumber(game);
        while (true) {
            System.out.println("猜一個數字介於" + game.min + "到" + game.max);
            int input = scanner.nextInt();

            if (input == randomNumber) {
                System.out.println("Bingo");
                break;
            } else if (input < randomNumber && input >= game.min && input <= game.max) {
                game.setMin(input);
            } else if (input > randomNumber && input >= game.min && input <= game.max) {
                game.setMax(input);
            } else {
                System.out.println("請輸入一個數字介於" + game.min + "到" + game.max);
            }

        }
    }


}
