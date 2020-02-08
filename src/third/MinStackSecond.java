package third;

import java.util.Stack;

public class MinStackSecond extends Stack<Integer> {

    private Stack<Integer> minValues = new Stack<>();

    @Override
    public Integer push(Integer item) {
        if (item <= min()) {
            minValues.push(item);
        }
        return super.push(item);
    }

    @Override
    public synchronized Integer pop() {
        Integer value = super.pop();
        if (value.equals(min())) {
            minValues.pop();
        }
        return value;
    }

    public int min() {
        if (isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return minValues.peek();
    }
}
