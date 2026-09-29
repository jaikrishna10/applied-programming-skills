import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean exploded = false;

            // Collision condition: Top of stack moves right (> 0) and current asteroid moves left (< 0)
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                if (stack.peek() < -a) {
                    // Top asteroid is smaller, pop it and continue checking collisions
                    stack.pop();
                    continue;
                } else if (stack.peek() == -a) {
                    // Both asteroids are equal size, destroy both
                    stack.pop();
                }
                // Current asteroid is destroyed or both were destroyed
                exploded = true;
                break;
            }

            // If the current asteroid survived all collisions, push it onto the stack
            if (!exploded) {
                stack.push(a);
            }
        }

        // Convert stack to result array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
