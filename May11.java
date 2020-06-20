/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;

/**
 *
 * @author Shivam Patel
 */
public class May11 {

    public static void main(String[] args) {
//        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] image = {{1, 1}, {1, 1}};
        int[][] ans = floodFill(image, 1, 1, 2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(" " + ans[i][j]);
            }
            System.out.println("");
        }
//        System.out.println(ans);
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        ArrayList<String> visited = new ArrayList();
        int[][] ans = fillImage(image, sr, sc, newColor, image[sr][sc], visited);
        return ans;
    }

    public static int[][] fillImage(int[][] image, int sr, int sc, int newColor, int oldColor, ArrayList<String> visited) {

        if ((sr < image.length) && (sr >= 0)) {

            if ((sc < image[sr].length) && (sc >= 0)) {
                if (image[sr][sc] == oldColor) {
                    if (!visited.contains("" + (sr + "_" + sc))) {
                        image[sr][sc] = newColor;
                        visited.add("" + (sr + "_" + sc));
                        fillImage(image, sr + 1, sc, newColor, oldColor, visited);
                        fillImage(image, sr - 1, sc, newColor, oldColor, visited);
                        fillImage(image, sr, sc + 1, newColor, oldColor, visited);
                        fillImage(image, sr, sc - 1, newColor, oldColor, visited);
                        return image;
                    }
                }

            }
        }
        return image;
    }
}
