package ua.lviv.iot.algo.part1.lab5;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class TextForLab {
    private String text;

    public TextForLab replaceLastCharacterWithUpperCase() {
        Pattern pattern = Pattern.compile("(\\w)(\\W|$)");
        Matcher matcher = pattern.matcher(this.text);
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
        return new TextForLab(this.text);
    }

    public TextForLab createAndModifyFromConsoleInput(String text) {
        TextForLab inputText = new TextForLab(text);
        TextForLab resultText = inputText.replaceLastCharacterWithUpperCase();
        System.out.println("\n" + "Result text: " + resultText.getText());
        return resultText;
    }

    public static void main(String[] args) {
        TextForLab textForLab = new TextForLab();
        textForLab.createAndModifyFromConsoleInput(Arrays.toString(args));
    }

    public TextForLab(String text) {
        this.text = text;
    }

    public TextForLab() {
    }

    public String getText() {
        return text;
    }
}
