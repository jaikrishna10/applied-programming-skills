import java.util.Stack;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Set<Integer> indexesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        // First pass: identify invalid parentheses indices
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i); // Unmatched closing parenthesis
                } else {
                    stack.pop(); // Matched pair
                }
            }
        }

        // Add any remaining unmatched opening parentheses indices
        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        // Second pass: build the resulting string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}