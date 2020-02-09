package third;

public class ThirdChapter {

    public static void main(String[] args) {
//        question_3_1();
//        question_3_2();
//        question_3_2_1();
//        question_3_3();
        question_3_4();
    }

    private static void question_3_1() {
        FixedMultiStack multiStack = new FixedMultiStack(20);
        try {
            multiStack.push(0, 1);
            multiStack.push(1, 2);
            multiStack.push(2, 3);
            System.out.println(multiStack.pop(1));
        } catch (FullStackException | EmptyStackException e) {
            e.printStackTrace();
        }
    }

    private static void question_3_2() {
        MinStack minStack = new MinStack();
        minStack.push(4);
        minStack.push(1);
        minStack.push(2);
        minStack.push(0);
        minStack.push(6);

        System.out.println(minStack.min());

        minStack.pop();
        minStack.pop();
        minStack.pop();
        minStack.pop();

        System.out.println(minStack.min());
    }

    private static void question_3_2_1() {
        MinStackSecond stack = new MinStackSecond();
        stack.push(4);
        stack.push(1);
        stack.push(2);
        stack.push(0);
        stack.push(6);

        System.out.println(stack.min());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack.min());
    }

    private static void question_3_3() {
        SetOfStackWithoutShifting setOfStackStack = new SetOfStackWithoutShifting();
        setOfStackStack.push(1);
        setOfStackStack.push(2);
        setOfStackStack.push(3);
        setOfStackStack.push(4);
        setOfStackStack.push(5);
        setOfStackStack.push(6);
        setOfStackStack.push(7);
        setOfStackStack.push(8);
        setOfStackStack.push(9);
        setOfStackStack.push(10);

        try {
            System.out.println(setOfStackStack.popAt(2));
            System.out.println(setOfStackStack.popAt(2));
            System.out.println(setOfStackStack.popAt(2));
            System.out.println(setOfStackStack.popAt(2));
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }

        System.out.println(setOfStackStack);
    }

    private static void question_3_4() {
        StackQueue stackQueue = new StackQueue();
        stackQueue.add(1);
        stackQueue.add(2);
        stackQueue.add(3);
        stackQueue.add(4);
        System.out.println(stackQueue.peek());
        stackQueue.add(5);
        System.out.println(stackQueue.peek());
    }

}
