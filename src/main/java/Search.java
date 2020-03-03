import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Search {
    private final static String SPACE_SYMBOL = " ";
    private final static String EMPTY_SYMBOL = "";
    private final static String DOT_SYMBOL = ".";
    private final static String SECOND_POINT = "2.";
    private final static String DEFINITION_WORD = "definition";
    private final static String COLON_SYMBOL = ":";
    private final static String WORD_NOT_FOUND = "The most popular dictionary and thesaurus. Meanings & definitions of words in English with examples, synonyms, pronunciations and translations.";
    public void findWord(String word) {
        try {
            Document doc = Jsoup.connect("https://dictionary.cambridge.org/dictionary/english/" + word).get();
            String output = doc.select("meta[name=description]").first().attr("content");

            if (!output.contains(WORD_NOT_FOUND)) {
                String[] buffer = output.split(SPACE_SYMBOL);

                boolean readytoPrint = false;

                for (int i = 0; i < buffer.length; ++i) {
                    if (buffer[i].contains(SECOND_POINT)) {
                        break;
                    } else if (buffer[i].contains(DOT_SYMBOL)) {
                        continue;
                    } else {
                        if (buffer[i].contains(DEFINITION_WORD)) {
                            readytoPrint = true;
                            continue;
                        }
                    }
                    if (readytoPrint) {
                        if (buffer[i].contains(COLON_SYMBOL)) {
                            String temp = buffer[i].replaceAll(COLON_SYMBOL, EMPTY_SYMBOL);
                            System.out.print(temp + SPACE_SYMBOL);
                        } else {
                            System.out.print(buffer[i] + SPACE_SYMBOL);
                        }
                    }
                }
                System.out.println("\n");
            } else {
                System.out.println("Sorry, the word is not found.\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
