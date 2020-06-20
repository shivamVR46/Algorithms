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
public class June16 {

    public static void main(String[] args) {
        String IP = "256.256.256.256";
        String ans = validIPAddress(IP);
        System.out.println(ans);
    }

    public static String validIPAddress(String IP) {

        int d = -1; //0 for IPV4 , 1 for IPV6;
        for (int i = 0; i < IP.length(); i++) {
            if (IP.charAt(i) == '.') {
                d = 0;
                break;
            }
            if (IP.charAt(i) == ':') {
                d = 1;
                break;
            }
        }

        if (d == 0) {
            String[] str = IP.split("\\.");
            return checkIPV4(str);
        } else {
            String[] str = IP.split("\\:");
            return checkIPV6(str);
        }

    }

    public static String checkIPV4(String[] IP) {
        System.out.println(IP.length);

        for (int i = 0; i < IP.length; i++) {
            int x = Integer.parseInt(IP[i]);
            System.out.println(x);
            if (x < 0 || x > 255) {
                return "Neither";
            }

            if (IP[i].charAt(0) == '0') {
                return "Neither";
            }

        }
        return "IPv4";

    }

    public static String checkIPV6(String[] IP) {

        for (int i = 0; i < IP.length; i++) {
            String str = IP[i];
            if (str.length() > 4) {
                return "Neither";
            }
            if (str.length() > 4) {
                if (str.charAt(0) == '0' && str.charAt(1) != '0') {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }

}
