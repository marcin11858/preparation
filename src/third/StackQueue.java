package third;

import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stackNewest, stackOldest;

    public StackQueue() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public void add(Integer value) {
        stackNewest.push(value);
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public int peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public int pop() {
        shiftStacks();
        return stackOldest.pop();
    }
}
