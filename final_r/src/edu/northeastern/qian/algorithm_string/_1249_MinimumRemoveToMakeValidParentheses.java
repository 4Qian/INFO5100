package edu.northeastern.qian.algorithm_string;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class _1249_MinimumRemoveToMakeValidParentheses {
    // https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
    public String minRemoveToMakeValid(String s) {
        Set<Integer> toRemove = new HashSet<>();// 要移除的index, 不是char 是为了好决定删掉谁
        Deque<Integer> stack = new LinkedList<>();// 放前括号index
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(i);
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    toRemove.add(i);
                }else{
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            toRemove.add(stack.pop());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!toRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
