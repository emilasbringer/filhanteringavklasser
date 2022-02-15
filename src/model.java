import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDateTime;

public class model {
    ArrayList<String> messageList = new ArrayList<>();
    ArrayList<String> dateList = new ArrayList<>();
    int messagePos = 0;
    String author = "/EÅ";
    String date = "date";


    public void inputData(String input) {
        input = input.substring(0, input.length()-27);
        messageList.add(messagePos, input);
        dateList.add(messagePos, java.time.LocalDateTime.now().toString().substring(0,19));
        messagePos++;
    }

    public void saveInput(String input) {
        messageList.add(messagePos, input);
        dateList.add(messagePos, java.time.LocalDateTime.now().toString().substring(0,19));
        messagePos++;
        for (int i = 0; i < messageList.toArray().length; i++) {
            System.out.println(messageList.get(i));
        }
    }

    public String getMessageListAsString() {
        String output = "";

        for (int i = 0; i < messageList.toArray().length; i++) {
            date = dateList.get(i);
            output += messageList.get(i) + "    " + author + " " + date + "\n";
        }

        return output;
    }

    public void clearLogg() {
        messageList.clear();
        messagePos = 0;
    }
}
