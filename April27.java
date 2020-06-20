/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author Shivam Patel
 */
class April27 {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        
        if(matrix==null || matrix.length==0) return 0;
        int size=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++)
            {
               if(matrix[i][j]=='1')
                {
                    while(isSquare(matrix,i,j,size))
                    {
                        size++;
                    }
                }
            }
        }
        return size*size;
    }
    
    public static boolean isSquare(char[][] matrix, int curRow,int curCol, int size)
    {
        int row=curRow+size;
        int col=curCol+ size;
        if(row>=matrix.length || col>=matrix[0].length)
            return false;
         for (int i=curRow;i<=row;i++){
            for (int j=curCol;j<=col;j++)
            {
                if(matrix[i][j]!='1') return false;
            }
         }
        return true;
    }
    

}
