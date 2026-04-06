public class ex5 {
    public static void main(String[] args) {
        String text = "I love my home country";
        int index = text.length();
        System.out.println(index);

        String text_new = text.substring(7, 22);
        System.out.println(text_new);


        String text1 = "Hi Students!";
        String text2 = "Students";
        String text3 = "Hi Students!";
        
         System.out.println("\"i\" is at index: " + text1.indexOf('i'));
        System.out.println("\"u\" is at index: " + text1.indexOf('u'));
        System.out.println("\"e\" is at index: " + text1.indexOf('e'));

        System.out.println("Text1 is equal to Text2: " + text1.equals(text2));
        System.out.println("Text1 is equal to Text3: " + text1.equals(text3));

        System.out.println();

        String text4 = "Hi Students!";
        String text5 = "Students";
        String text6 = "Teacher";
        System.out.println("Text1 contains Text2: " + text4.contains(text5));
        System.out.println("Text1 contains Text3: " + text4.contains(text6));
    }
}
