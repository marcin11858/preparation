package third;

public class ThirdChapter {

    public static void main(String[] args) {
//        question_3_1();
        question_3_2();
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

}
