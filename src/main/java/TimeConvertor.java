import java.util.regex.Pattern;

/**
 * Created by randallcrame on 2/15/17.
 */
public class TimeConvertor {

    //Code reference for number to words => http://javahungry.blogspot.com/2014/05/
    //convert-math-number-to-equivalent-readable-word-in-java-code-with-example.html

    private static final String[] tensPlace = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",

    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    protected static boolean isTimeFormat(String input) {
        return Pattern.matches("((1[^3-9\\D]):[^6-9\\D]\\d\\s[pPaA][mM])|[1-9]:[^6-9\\D]\\d\\s[pPaA][mM]", input);
    }

    protected static String[] parseTime(String input) {
        return input.split("[:\\s]+");
    }

    protected static String convertHour(String input) {
        return numNames[Integer.parseInt(input)];
    }

    protected static String convertMinutes(String input) {
        int number = Integer.parseInt(input);
        if (number % 100 < 20) {
            input = numNames[number % 100];
        } else {
            input = numNames[number % 10];
            number /= 10;
            input = tensPlace[number % 10] + input;
        }

        return input;
    }

    protected static String convertAMPM(String input) {
        return (input.equalsIgnoreCase("am")) ? " ante meridiem." : " post meridiem.";
    }

    public static String tellTime(String input) {
        String[] time = parseTime(input);
        if (isTimeFormat(input)) {
            input = "The time is" +
                    convertHour(time[0]) +
                    convertMinutes(time[1]) +
                    convertAMPM(time[2]);
            return input;
        }
        else return "Not a properly formatted time";
    }
}
