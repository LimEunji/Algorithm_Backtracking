package com.company;

import java.util.Scanner;

public class HideAndSeek {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int targetSecond = 1;
        while (true) {

            if (hideAndSeek(N, K, 0, targetSecond)) {
                System.out.println(targetSecond);
                break;
            }

            targetSecond++;
        }
    }

    public static boolean hideAndSeek(int N, int K, int second, int targetSecond) {
        if (second >= targetSecond) {
            return false;
        }

        int nextN = 0;
        for (int i = 0; i < 3; i++) { //이동 경우의 수
           switch (i) {
               case 0:
                   nextN = walkBackward(N);
                   break;
               case 1:
                   nextN = walkForward(N);
                   break;
               case 2:
                   nextN = teleport(N);
                   break;
           }


           if (nextN == K) {
               return true;
           }

           if (hideAndSeek(nextN, K, second+1, targetSecond)) {
               return true;
           }
        }

        return false;
    }

    public static int walkBackward(int n) {
        return n-1;
    }

    public static int walkForward(int n) {
        return n+1;
    }

    public static int teleport(int n) {
        return n*2;
    }
}
