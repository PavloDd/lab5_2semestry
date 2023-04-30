package ua.lviv.iot.algo.part1.lab5;
;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class testTextForLab {

    @Test
    public void testCreateAndModifyFromConsoleInput (){
            String input = "This is a sample input.";
            String expected = "ThiS iS A samplE inpuT.";
            InputStream inputStream = new ByteArrayInputStream(input.getBytes());
            System.setIn(inputStream);
            TextForLab textForLab = new TextForLab();
            TextForLab result = textForLab.createAndModifyFromConsoleInput();
            assertEquals(expected, result.getText());

    }
}
