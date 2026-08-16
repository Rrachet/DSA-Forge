package com.rrachet.dsaforge.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/** Evaluates integer Reverse Polish Notation expressions. Time O(n), space O(n). */
public final class EvaluateReversePolishNotation {
    private EvaluateReversePolishNotation() {}
    public static int evaluate(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.length() == 1 && "+-*/".indexOf(token.charAt(0)) >= 0) {
                int right = stack.pop(), left = stack.pop();
                stack.push(switch (token.charAt(0)) {
                    case '+' -> left + right; case '-' -> left - right; case '*' -> left * right; default -> left / right;
                });
            } else stack.push(Integer.parseInt(token));
        }
        if (stack.size() != 1) throw new IllegalArgumentException("malformed expression");
        return stack.pop();
    }
}
