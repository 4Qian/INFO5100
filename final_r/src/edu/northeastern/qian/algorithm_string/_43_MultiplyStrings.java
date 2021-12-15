package edu.northeastern.qian.algorithm_string;

public class _43_MultiplyStrings {
    // https://leetcode.com/problems/multiply-strings/
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        String res = "0";
        for (int i = n - 1; i >= 0; i--) {//从num2的尾巴开始
            //每一次num2[i]与num1[j]num[j--]相乘的结果形成sb
            StringBuilder cur = new StringBuilder();
            int carry = 0;
            for (int j = n - 1; j > i; j--) {
                cur.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {//从num1的尾巴开始
                int x = num1.charAt(j) - '0';
                int product = x * y + carry;
                cur.append(product % 10);
                carry = product / 10;
            }
            if (carry != 0) {
                cur.append(carry % 10);
            }
            res = addStrings(res, cur.reverse().toString());
        }
        return res;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() -1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        res.reverse();
        return res.toString();
    }
}
