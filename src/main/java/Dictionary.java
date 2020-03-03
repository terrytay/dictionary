import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        try {
            String keyword;
            System.out.println("Enter END into console to end the program.");
            while (true) {
                Search search = new Search();
                System.out.println("Please enter a search term:");
                Scanner input = new Scanner(System.in);
                keyword = input.nextLine();
                if (keyword.equals("END")) {
                    break;
                }
                search.findWord(keyword);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
