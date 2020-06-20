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
public class June20 {

    public static void main(String[] args) {
        char[][] citations = {{'X', 'O', 'X', 'O', 'X', 'O'},
        {'O', 'X', 'O', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'O', 'X', 'O'},
        {'O', 'X', 'O', 'X', 'O', 'X'}};

//        char[][] citations = {{'x', 'o', 'x', 'o', 'x', 'o'}, {'o', 'x', 'x', 'x', 'o', 'x'}, {'x', 'x', 'x', 'o', 'x', 'o'}, {'o', 'x', 'o', 'x', 'o', 'x'}};
        solve(citations);

    }

    public static void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
//        boolean[][] visited;
//        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {   // Run dfs on left and right borders and change '0's to '#'
            dfs(board, i, 0);
            dfs(board, i, board[0].length - 1);
        }

        for (int j = 1; j < board[0].length - 1; j++) { // Run dfs on top and bottom borders and change '0's to '#'
            dfs(board, 0, j);
            dfs(board, board.length - 1, j);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println("");
        }

        System.out.println("");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') // Change surrounded '0' to 'X'
                {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') // Change '#' (not surrounded) back to '0'
                {
                    board[i][j] = 'O';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(" " + board[i][j]);
            }
            System.out.println("");
        }

    }

    public static void dfs(char[][] board, int i, int j) {
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == 'O') {
//            visited[i][j] = true;
            board[i][j] = '#';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }
}
