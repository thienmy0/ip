package bob;

/**
 * Represents a parser that deals with making sense of the user command.
 */
public class Parser {

    public Parser() {

    }

    /**
     * Checks if the input statement is a command to mark a Task.
     *
     * @param input the user input.
     * @return boolean true if input is mark.
     */
    public boolean isMark(String input) {
        char[] charArray = input.toCharArray();
        if (input.startsWith("mark") && Character.isWhitespace(charArray[4]) && Character.isDigit(charArray[5])) {
            return true;
        }
        return false;
    }

    /**
     * Returns the digit of the index of the Task that should be marked.
     *
     * @param input the user input.
     * @return int the index of marked task.
     */
    public int getMarkDigit(String input) {
        assert isMark(input);
        char[] charArray = input.toCharArray();
        return Character.getNumericValue(charArray[5]);
    }

    /**
     * Checks if input statement is a command to delete a Task.
     *
     * @param input the user input.
     * @return boolean true if statement is a delete command.
     */
    public boolean isDelete(String input) {
        char[] charArray = input.toCharArray();
        if (input.startsWith("delete") && Character.isWhitespace(charArray[6]) && Character.isDigit(charArray[7])) {
            return true;
        }
        return false;
    }

    /**
     * Returns the digit of the index of the Task that should be deleted.
     *
     * @param input the user input.
     * @return int the number of the task to be deleted.
     */
    public int getDeleteDigit(String input) {
        assert isDelete(input);
        char[] charArray = input.toCharArray();
        return Character.getNumericValue(charArray[7]);
    }

    /**
     * Checks if input statement is a command to find a keyword.
     *
     * @param input the user input.
     * @return boolean true if input is find command.
     */
    public boolean isFind(String input) {
        char[] charArray = input.toCharArray();
        if (input.startsWith("find") && Character.isWhitespace(charArray[4]) && Character.isDigit(charArray[5])) {
            return true;
        }
        return false;
    }

    /**
     * Returns the keyword to be used to search for tasks.
     *
     * @param input the user input.
     * @return String the keyword to find.
     */
    public String findKeyword(String input) {
        assert isFind(input);
        char[] charArray = input.toCharArray();
        String str = "";

        for (int i = 5; i < charArray.length; i++) {
            str += charArray[i];
        }

        return str;
    }

    /**
     * Checks if input statement is a command to reschedule task.
     *
     * @param input the user input.
     * @return boolean true if statement is a delete command.
     */
    public boolean isReschedule(String input) {
        char[] charArray = input.toCharArray();
        if (input.startsWith("reschedule") && Character.isWhitespace(charArray[10])
                && Character.isDigit(charArray[11])) {
            return true;
        }
        return false;
    }

    /**
     * Returns the digit of the index of the Task that should be rescheduled.
     *
     * @param input the user input.
     * @return the index of the task to be rescheduled.
     */
    public int getRescheduleDigit(String input) {
        assert isReschedule(input);
        char[] charArray = input.toCharArray();
        return Character.getNumericValue(charArray[11]);
    }

    /**
     * Returns the new due date of a Deadline.
     *
     * @param input the user input.
     * @return the string representation of the new due date.
     */
    public static String getNewDueDate(String input) {
        String[] str = input.split("/by ", -1);
        return str[1];
    }

    /**
     * Returns the new start date of an Event.
     *
     * @param input the user input.
     * @return the string representation of the new start date.
     */
    public String getNewStartDate(String input) {
        String[] str = input.split(" ", -1);
        return str[3];
    }

    /**
     * Returns the new end date of an Event.
     *
     * @param input the user input.
     * @return the string representation of the new end date.
     */
    public String getNewEndDate(String input) {
        String[] str = input.split(" ", -1);
        return str[5];
    }
}
