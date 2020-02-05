package third;

public class ThirdChapter {

    public static void main(String[] args) {
        question_3_1();
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
}
