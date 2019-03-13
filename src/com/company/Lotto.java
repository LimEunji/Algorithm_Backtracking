package com.company;

import java.io.File;
import java.util.Scanner;

public class Lotto {

    public static void main(String[] args) throws Exception{

        File file = new File("lotto_input.txt");
        Scanner scanner = new Scanner(file);

        int setCount = scanner.nextInt();
        while(setCount != 0) {
            int[] number = new int[setCount];
            for (int i = 0; i < setCount; i++) {
                number[i] = scanner.nextInt();
            }

            backtracking(number, 0, new int[6], 0);

            System.out.println();
            setCount = scanner.nextInt();
        }
    }

    private static void backtracking(int[] set, int count, int[] lotto, int index) {
        if (count == 6) {
            for(int i = 0; i < 6; i++) {
                System.out.print(lotto[i] + " ");
            }

            System.out.println();
            return;
        }

        while (index < set.length) {
            lotto[count] = set[index];
            backtracking(set, count+1, lotto, index+1);
            lotto[count] = 0;
            index++;
        }
    }
}
