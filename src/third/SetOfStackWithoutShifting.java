package third;

import java.util.ArrayList;
import java.util.Stack;

public class SetOfStackWithoutShifting {
    ArrayList<Stack<Integer>> stacks = new ArrayList<>();
    private static final int MAX_STACKS_SIZE = 3;

    void push(int value) {
        Stack<Integer> stack;
        if (stacks.isEmpty() || stacks.get(stacks.size() -1).size() >= MAX_STACKS_SIZE) {
            stack = new Stack<>();
            stacks.add(stack);
        } else {
            stack = stacks.get(stacks.size() -1);
        }
        stack.push(value);
    }

    int pop() throws EmptyStackException {
        if (stacks.isEmpty()) {
            throw new EmptyStackException();
        }
        Stack<Integer> stack = stacks.get(stacks.size() -1);
        int value = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(stacks.size() -1);
        }
        return value;
    }

    int popAt(int i) throws EmptyStackException {
        if (i >= stacks.size()) {
            throw new EmptyStackException();
        }
        Stack<Integer> stack = stacks.get(i);
        int value = stack.pop();
        if (stack.isEmpty()) {
            stacks.remove(i);
        }
        return value;
    }

    @Override
    public String toString() {
        return "SetOfStackWithoutShifting{" +
                "stacks=" + stacks +
                '}';
    }
}
