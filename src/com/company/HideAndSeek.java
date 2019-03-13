package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideAndSeek {

    private boolean[] isVisitied ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        System.out.println(bfs(N, K));
    }

    public static int bfs(int n, int k) {
        boolean[] isVisited = new boolean[100001];
        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (true) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int pN = queue.poll();
                if (pN == k) {
                    return time;
                }

                if (pN > 0 && !isVisited[pN - 1]) {
                    queue.add(pN - 1);
                    isVisited[pN - 1] = true;
                }

                if (pN < 100000 && !isVisited[pN + 1]) {
                    queue.add(pN + 1);
                    isVisited[pN + 1] = true;
                }

                if (pN * 2 <= 100000 && !isVisited[pN * 2]) {
                    queue.add(pN * 2);
                    isVisited[pN * 2] = true;
                }
            }

            time++;
        }
    }
}
