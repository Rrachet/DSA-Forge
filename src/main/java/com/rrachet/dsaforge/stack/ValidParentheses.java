package com.rrachet.dsaforge.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/** Validates bracket nesting with a stack. Time O(n), space O(n). */
public final class ValidParentheses {
    private ValidParentheses() {}

    public static boolean check(String input) {
        Map<Character, Character> pairs = Map.of(')', '(', ']', '[', '}', '{');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            if (pairs.containsValue(c)) stack.push(c);
            else if (pairs.containsKey(c) && (stack.isEmpty() || stack.pop() != pairs.get(c))) return false;
        }
        return stack.isEmpty();
    }
}
