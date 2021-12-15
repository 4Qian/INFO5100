package edu.northeastern.qian.algorithm_string;

import java.util.Stack;

public class _394_DecodeString {
    // https://leetcode.com/problems/decode-string/
    public String decodeString(String s) {
        Stack<Integer> cntStack = new Stack<>();// 装数字
        Stack<StringBuilder> strStack = new Stack<>();// currentString
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if (c == '[') {
                cntStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();// reset currentString and k
                k = 0;
            } else if (c == ']') {
                StringBuilder decoded = strStack.pop();
                // decode currentK[currentString] by appending currentString k times
                for (int i = cntStack.pop(); i > 0; i--) {
                    decoded.append(cur);
                }
                cur = decoded;
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
