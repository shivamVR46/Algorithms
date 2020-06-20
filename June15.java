/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Shivam Patel
 */
public class June15 {

    static ArrayList<String> visited = new ArrayList();

    public static void main(String[] args) {
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {1, 3, 100}, {2, 4, 100}, {3, 4, 0}};
        int ans = findCheapestPrice(3, flights, 0, 4, 2);
        System.out.println(ans);
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        ArrayList<Integer> price = new ArrayList();
        boolean status = false;
        for (int i = 0; i < flights.length; i++) {
            if (flights[i][1] == dst) {
                status = true;
            }
        }
        if (status == false) {
            return -1;
        }

        Arrays.sort(flights, (a, b) -> Integer.compare(a[1], b[1]));
        int index = -1, max = 0;
        for (int i = 1; i < flights.length; i++) {
            if (flights[i][0] == src && flights[i][1] == dst) {
//                max = Math.max(max, flights[i][2]);
                if (flights[i][2] > max) {
                    max = flights[i][2];
                    index = i;
                }
            }
        }
//        System.out.println("Index  :" + index);
        int temp0 = 0;
        int temp1 = 0;
        int cost = 0;
        int[][] flightsnew = new int[flights.length + 1][3];
        for (int i = 0; i < flights.length; i++) {

            if (flights[i][0] == src && i == index) {
                temp0 = flights[i][0];
                temp1 = flights[i][1];
                cost = flights[i][2];
                flights[i][0] = 0;
                flights[i][1] = 0;
                flights[i][2] = Integer.MAX_VALUE;

            } else {
                flightsnew[i][0] = flights[i][0];
                flightsnew[i][1] = flights[i][1];
                flightsnew[i][2] = flights[i][2];
            }

            if (i == flights.length - 1) {
                flightsnew[i + 1][0] = temp0;
                flightsnew[i + 1][1] = temp1;
                flightsnew[i + 1][2] = cost;
            }
        }

        for (int i = 0; i < flightsnew.length; i++) {
            System.out.println(flightsnew[i][0] + " " + flightsnew[i][1] + " " + flightsnew[i][2]);
        }

        return getPrice(n, flightsnew, src, dst, K, 0, 0, price, 0, 0);
    }

    private static int getPrice(int n, int[][] flights, int src, int dst, int K, int i, int j, ArrayList<Integer> price, int count, int cost) {
        if (i >= 0 && i < flights.length) {
            String str = flights[i][0] + "_" + flights[i][1];

            if (!visited.contains(str) && i < flights.length) {
                visited.add(str);
                if (count <= K) {
                    cost += flights[i][2];

                    if (flights[i][1] != dst) {
                        return getPrice(n, flights, src, dst, K, i + 1, j, price, count + 1, cost);
                    } else {
                        price.add(cost);
                        count = 0;
                        cost = 0;
                        i = findSource(visited, flights, src);

                        return getPrice(n, flights, src, dst, K, i, j, price, count, cost);
                    }
                } else {
                    count = 0;
                    cost = 0;
                    return getPrice(n, flights, src, dst, K, i, j, price, count, cost);
                }
            } else if (visited.contains(str) && i < flights.length) {
                return getPrice(n, flights, src, dst, K, i + 1, j, price, count, cost);
            }
        }
        Collections.sort(price);
        return price.get(0);

    }

    private static int findSource(ArrayList<String> visited, int[][] flights, int src) {

        for (int i = 0; i < flights.length; i++) {
            String str = flights[i][0] + "_" + flights[i][1];
            if (!visited.contains(str) && flights[i][0] == src) {
                return i;
            }
        }
        return -1;
    }

}
