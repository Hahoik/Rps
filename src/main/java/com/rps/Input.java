package com.rps;

import java.util.Scanner;

import static com.rps.Function.*;
import static com.rps.Program.*;

class Input {

    /**
     * @param inputNum number of selection user can make: [1, inputNum]
     * @return the selected number
     */
    private static int checkInput(int inputNum) {
        Scanner sc = new Scanner(System.in);
        int inputInt = 0;
        boolean yes = false;
        System.out.print("> ");
        String inputString = sc.nextLine();

        while (true) {
            while (inputString.isEmpty() || yes) {
                String returnString = "Enter ";
                System.out.println();
                for (int i = 1; i <= inputNum; i++) {
                    returnString += "[" + i + "]";
                    if (i < inputNum) {
                        returnString += " or ";
                    }
                }
                System.out.println(returnString);
                System.out.print("> ");
                inputString = sc.nextLine();
                yes = false;
            }

            try {
                inputInt = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                yes = true;
            }

            if (inputInt < 1 || inputInt > inputNum) {
                yes = true;
            }

            if (!yes) {
                break;
            }
        }
        return inputInt;
    }

    static void menuInput() {
        if (checkInput(2) == 1) {
            playMenu();
        }
    }

    static void playInput() {
        int userHandType = checkInput(3);
        int computerHandType = (int) (Math.random() * 3) + 1;
        int result = userHandType - computerHandType;

        System.out.println("You: " + getStringHandType(userHandType));
        System.out.println("Computer: " + getStringHandType(computerHandType));

        if (result == -1 || result == 2) {
            System.out.println("You Win!!");
            winCount++;
        } else if (result == 0) {
            System.out.println("Draw;;");
            drawCount++;
        } else {
            System.out.println("You Lose..");
            loseCount++;
        }
        stopMenu();
    }

    static void stopInput() {
        switch (checkInput(3)) {
            case 1:
                playMenu();
                break;
            case 2:
                break;
            case 3:
                statistics();
                stopMenu();
        }
    }
}