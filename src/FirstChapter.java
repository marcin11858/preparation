import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstChapter {
    public static void main(String[] args) {
        question_1_1();
        question_1_1_1();
        question_1_1_1_1();
        question_1_2();
        question_1_2_1();
        question_1_3();
        question_1_4();
        question_1_4_1();
        question_1_5();
        question_1_5_1();
        question_1_6();
        question_1_6_1();
        question_1_7();
        question_1_8();
        question_1_9();

    }

    private static void question_1_1() {
        String s = "abcdefg";
        Map<Character, Character> letters = new HashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (letters.containsKey(c)) {
                System.out.println("Not unique letters");
                return;
            }
            letters.put(c, c);
        }
        System.out.println("Unique letters");
    }

    private static void question_1_1_1() {
        String s = "test";

        if (s.length() > 128) {
            System.out.println("Not unique letters");
            return;
        }

        boolean [] charSet = new boolean[128];
        for (int i = 0; i < s.length(); i++){
            int c = s.charAt(i);
            if (charSet[c]) {
                System.out.println("Not unique letters");
                return;
            }
            charSet[c] = true;
        }
        System.out.println("Unique letters");
    }

    private static void question_1_1_1_1() {
        String s = "abcsd";

        int checker = 0;
        for (int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            if ((checker & (1 << c)) > 0) {
                System.out.println("Not unique letters");
                return;
            }
            checker |= (1 << c);
        }
        System.out.println("Unique letters");
    }

    private static void question_1_2() {
        String s1 = "abcsd";
        String s2 = "csdab";

        if (s1.length() != s2.length()) {
            System.out.println("No permutation");
            return;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            if (!map.containsKey(c)) {
                System.out.println("No permutation");
                return;
            } else {
                int value = map.get(c);
                if (value == 1) {
                    map.remove(c);
                } else {
                    map.put(c, value - 1);
                }
            }
        }
        if (map.isEmpty()) {
            System.out.println("Permutation");
        } else {
            System.out.println("No permutation");
        }

    }

    private static void question_1_2_1() {
        String s1 = "abcsd";
        String s2 = "csdab";

        if (s1.length() != s2.length()) {
            System.out.println("No permutation");
            return;
        }

        int[] letters = new int[128];
        for (int i = 0; i < s1.length(); i++){
            int c = s1.charAt(i);
            letters[c]++;
        }

        for (int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            letters[c]--;
            if(letters[c] < 0) {
                System.out.println("No permutation");
                return;
            }
        }
        System.out.println("Permutation");
    }

    private static void question_1_2_2() {
        String s1 = "abcsd";
        String s2 = "csdab";

        if (s1.length() != s2.length()) {
            System.out.println("No permutation");
            return;
        }

        int[] letters = new int[128];
        for (int i = 0; i < s1.length(); i++){
            int c = s1.charAt(i);
            letters[c]++;
        }

        for (int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            letters[c]--;
            if(letters[c] < 0) {
                System.out.println("No permutation");
                return;
            }
        }
        System.out.println("Permutation");
    }

    private static void question_1_3() {
        char [] str = "Mr John Smith     ".toCharArray();
        int length = 13;

        int spaceCount = 0;
        for(int i = 0; i < length; ++i) {
            if (str[i] == ' ') {
                ++spaceCount;
            }
        }

        int index = length + 2*spaceCount;
        if (length < str.length) str[length] = '\0';
        for (int i = length - 1; i >= 0; --i) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index -3;
            } else {
                str[index - 1] = str[i];
                --index;
            }
        }
        System.out.println(str);
    }

    private static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (val >= a && val <= z) {
            return val - a;
        }
        return -1;
    }

    private static void question_1_4() {
        String word = "kajakdd";

        int [] letters = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for(int i = 0; i < word.length(); ++i) {
            int val = getCharNumber(word.charAt(i));
            if (val != -1) {
                letters[val]++;
            }
        }

        int oddCount = 0;
        for (int i = 0; i < letters.length; ++i) {
            if (letters[i] % 2 == 1) {
                ++oddCount;
            }
        }
        if (oddCount > 1) {
            System.out.println("It is not a palindrome");
        } else {
            System.out.println("It is palindrome");
        }
    }

    private static void question_1_4_1() {
        String word = "testest";
        int bitVector = createBitVector(word);
        if (bitVector == 0 || ( bitVector & (bitVector - 1)) == 0) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not palindrome");
        }
    }

    private static int createBitVector(String word) {
        int bitVector = 0;
        for (char c : word.toCharArray()) {
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }

    private static int toggle(int bitVector, int x) {
        if (x == -1) {
            return bitVector;
        }
        int mask = 1 << x;
        if ((mask & bitVector) > 0) {
            bitVector &= ~mask;
        } else {
            bitVector |= mask;
        }
        return bitVector;
    }

    private static void question_1_5() {
        String s1 = "pale";
        String s2 = "pal";
        if (s1.length() == s2.length()) {
            boolean diference = false;
            for (int i = 0; i < s1.length(); ++i) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (diference) {
                        System.out.println(false);
                        return;
                    }
                    diference = true;
                }
            }
        } else {
            String bigger = s1.length() > s2.length() ? s1 : s2;
            String smaller = s1.length() < s2.length() ? s1 : s2;
            if (bigger.length() - smaller.length() > 1) {
                System.out.println(false);
                return;
            }
            int offset = 0;
            for (int i = 0; i < bigger.length(); ++i) {
                if (offset == 0 && i == smaller.length()) {
                    continue;
                } else if (bigger.charAt(i) != smaller.charAt(i - offset)) {
                    ++offset;
                    if (offset > 1) {
                        System.out.println(false);
                        return;
                    }
                }
            }
        }
        System.out.println(true);
    }

    boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                ++index1;
                ++index2;
            }
        }
        return true;
    }

    static void question_1_5_1() {
        String first = "pale";
        String second = "pal";
        if (Math.abs(first.length() - second.length()) > 1) {
            System.out.println(false);
            return;
        }

        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDiff = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDiff) {
                    System.out.println(false);
                    return;
                }
                foundDiff = true;

                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        System.out.println(true);
    }

    static void question_1_6() {
        String text = "aabcccccaa";
        StringBuilder sb = new StringBuilder();
        char letter = '\0';
        int count = 0;
        for (int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) != letter) {
                if (count > 0) {
                    sb.append(letter).append(count);
                }
                count = 1;
                letter = text.charAt(i);
            } else {
                count++;
            }
        }
        if (count > 0) {
            sb.append(letter).append(count);
        }
        String result = sb.toString();
        System.out.println(result.length() < text.length() ? result : text);
    }

    static int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); ++i) {
            countConsecutive++;

            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }

    static void question_1_6_1() {
        String text = "abcd";
        int compressedLength = countCompression(text);
        if (text.length() < compressedLength) {
            System.out.println(text);
            return;
        }

        StringBuilder sb = new StringBuilder(compressedLength);
        int countConsecutive = 0;
        for (int i = 0; i < text.length(); ++i) {
            countConsecutive++;

            if (i + 1 >= text.length() || text.charAt(i) != text.charAt(i + 1)) {
                sb.append(text.charAt(i)).append(countConsecutive);
                countConsecutive = 0;
            }
        }
        System.out.println(sb.toString());
    }

    static void question_1_7() {
        int [][] matrix = {{1, 2, 3}, {4,5,6}, {7,8,9}};
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            System.out.println(false);
            return;
        }
        int n = matrix.length;
        for (int layer = 0; layer < n /2; ++ layer) {
            int last = n - 1 - layer;
            for (int i = layer; i < last; ++i) {
                int offset = i - layer;
                int top = matrix[layer][i];

                matrix[layer][i] = matrix[last-offset][layer];

                matrix[last-offset][layer] = matrix[last][last-offset];

                matrix[last][last - offset] = matrix[i][last];

                matrix[i][last] = top;
            }
        }
        System.out.println(matrix);
    }

    static void question_1_8() {
        int [][] matrix = {{1, 2, 3}, {4,0,6}, {7,8,9}};
        Set<Integer> columns = new HashSet<>();
        Set<Integer> rows = new HashSet<>();
        for(int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if(matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        for (Integer i : rows) {
            nullifyRow(matrix, i);
        }

        for (Integer j : columns) {
            nullifyColumn(matrix, j);
        }
        System.out.println(matrix);
    }

    static void nullifyRow(int [][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    static void nullifyColumn(int [][] matrix, int col) {
        for (int i = 0; i < matrix.length; ++i) {
            matrix[i][col] = 0;
        }
    }

    private static void question_1_9() {
        String s1 = "waterbottel";
        String s2 = "bottegwater";
        if (s1.length() != s2.length()) {
            System.out.println(false);
            return;
        }

        String s1s1 = s1 + s1;
        System.out.println(s1s1.contains(s2));
    }

}
