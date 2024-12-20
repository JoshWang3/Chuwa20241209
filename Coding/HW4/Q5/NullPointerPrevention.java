package Chuwa20241209.Coding.HW4.Q5;
import java.util.Optional;

public class NullPointerPrevention {
    public static void main(String[] args) {
        // 1: Using if-else
        String text1 = null;
        if (text1 != null) {
            System.out.println("Text1 length: " + text1.length());
        } else {
            System.out.println("Text1 is null.");
        }

        // 2: try-catch
        try {
            String text2 = null;
            System.out.println("Text2 length: " + text2.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException for text2.");
        }

        // 3: Default Values
        String text3 = null;
        String safeText3 = text3 == null ? "" : text3;
        System.out.println(safeText3.length());

        // 4: Optional
        String text4 = null;
        Optional<String> optionalText = Optional.ofNullable(text4);
        System.out.println("Text4 value: " + optionalText.orElse("Default Value from optional"));


    }
}
