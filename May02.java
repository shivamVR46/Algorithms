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
public class May02 {

    public static void main(String[] args) {
        System.out.println(maxDiff(555));
    }

    public static int maxDiff(int num) {
        String n = "" + num;
        char x = n.charAt(0);
        char y = '9';
        boolean flag = false;
        String n1 = "";
        int a = 0;
        if (n.length() > 1) {
            flag = true;
            if (x != '9') {
                n1 = n.replace(x, y);

            } else {
                for (int i = 1; i < n.length(); i++) {
                    if (n.charAt(i) != '9') {
                        n1 = n.replace(n.charAt(i), '9');
                        break;
                    }

                }
            }
        }
        if(flag==true){
            a = Integer.parseInt(n1);
        }
        else{
            a = Integer.parseInt(n);
        }
        

        int b = 0;
        int max = 0;

        for (int j = 0; j < n.length(); j++) {
            for (int i = 0; i <= 9; i++) {

                if ((j == 0) && (i != 0)) {
                    String nn = new String(n.replace(n.charAt(j), (char) (i + '0')));
//                    nn = nn.replace(n2.toString().charAt(j),(char) i));
                    b = Integer.parseInt(nn);
                    if ((a - b) > max) {
                        max = (a - b);
                    }
                } else if ((j > 0)) {
                    String nn = new String(n.replace(n.charAt(j), (char) (i + '0')));
                    if (nn.charAt(0) != '0') {
//                    n2.append(n.replace(n.charAt(j), (char) i));
                        b = Integer.parseInt(nn);
                        if ((a - b) > max) {
                            max = (a - b);
                        }
                    }
                }
            }
        }

        return max;

    }
}
