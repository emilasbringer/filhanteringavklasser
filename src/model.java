import java.util.ArrayList;

public class model {
    ArrayList<String> messageList = new ArrayList<>();
    ArrayList<String> dateList = new ArrayList<>();
    int messagePos = 0;
    String author = "/EÅ";
    String date = "date";


    public void inputDataToArray(String input) {
        input = input.substring(0, input.length()-27);
        messageList.add(messagePos, input);
        dateList.add(messagePos, replaceChar(java.time.LocalDateTime.now().toString().substring(0,19), 9, ' '));
        messagePos++;
    }

    public void saveInput(String input) {
        messageList.add(messagePos, input);
        dateList.add(messagePos, replaceChar(java.time.LocalDateTime.now().toString().substring(0,19), 9, ' '));
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

    public String replaceChar(String inputString, int indexFromEnd, char character) {
        String finalString;
        char[] stringAsArray = inputString.toCharArray();
        stringAsArray[inputString.length()-indexFromEnd] = character;
        finalString = new String((stringAsArray));
        return finalString;
    }
}
