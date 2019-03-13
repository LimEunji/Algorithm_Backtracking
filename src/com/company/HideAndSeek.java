package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {

    private static boolean isSuccess = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        long startTime = System.nanoTime();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        hideAndSeek(K, 0, queue);
        long endTime = System.nanoTime();
        System.out.println("elapsed time: " + (endTime - startTime));
    }

    public static void hideAndSeek(int K, int second, Queue<Integer> queue) {
        for (int i = 0; i < Math.pow(3, second); i++) {
            int n = queue.poll();
            if (move(queue, n, K)) {
                System.out.println(second+1);
                return;
            }
        }

        hideAndSeek(K, second + 1, queue);
    }

    public static boolean move(Queue<Integer> queue, int N, int K) {
        int nextN = 0;
        for (int i = 0; i < 3; i++) {
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

            queue.add(nextN);
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
