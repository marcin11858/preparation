package third;

import java.util.Stack;

public class MinStack extends Stack<MinStack.MinStackEntry> {


    public void push(int value) {
        int min = Math.min(value, min());
        super.push(new MinStackEntry(value, min));
    }

    public int popInt() {
        MinStackEntry entry = super.pop();
        return entry.min;
    }

    public int min() {
        if (isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }

    class MinStackEntry {
        int value;
        int min;

        MinStackEntry(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
