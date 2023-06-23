package ua.lviv.iot.algo.part1.lab5;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class LastLetterUppercaser {
    private String text;
    public static final Pattern LAST_lETTER_UPPERCASE_PATTERN = Pattern.compile("(\\w)(\\W|$)");
    // //^//w+//s+//b//w+//s+//b|$
    public static final Pattern LIST_OF_STUDENTS_PATTERN = Pattern.compile("(^//w+//s//w+//s//w+)");

    public LastLetterUppercaser replaceLastCharacterWithUpperCase() {
        Matcher matcher = LAST_lETTER_UPPERCASE_PATTERN.matcher(this.text);
        StringBuilder stringBuilder = new StringBuilder();
        int lastMatchEnd = 0;
        while (matcher.find()) {
            stringBuilder.append(this.text.substring(lastMatchEnd, matcher.start()));
            String matchedGroup = matcher.group(1);
            stringBuilder.append(matchedGroup.substring(0, matchedGroup.length() - 1));
            stringBuilder.append(Character.toUpperCase(matchedGroup.charAt(matchedGroup.length() - 1)));
            stringBuilder.append(matcher.group(2));
            lastMatchEnd = matcher.end();
        }
        stringBuilder.append(this.text.substring(lastMatchEnd));
        this.text = stringBuilder.toString();
        return new LastLetterUppercaser(this.text);
    }

    public LastLetterUppercaser createAndModifyFromConsoleInput(String text) {
        LastLetterUppercaser inputText = new LastLetterUppercaser(text);
        LastLetterUppercaser resultText = inputText.replaceLastCharacterWithUpperCase();
        System.out.println("\n" + "Result text: " + resultText.getText());
        return resultText;
    }

    public static void main(String[] args) {
        LastLetterUppercaser textForLab = new LastLetterUppercaser();
        textForLab.createAndModifyFromConsoleInput(Arrays.toString(args));
    }

    public LastLetterUppercaser(String text) {
        this.text = text;
    }

    public LastLetterUppercaser() {
    }

    public String getText() {
        return text;
    }
}
