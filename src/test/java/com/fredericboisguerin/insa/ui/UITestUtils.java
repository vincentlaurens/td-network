package com.fredericboisguerin.insa.ui;

import java.io.ByteArrayInputStream;

public class UITestUtils {
    public static void setUserInput(int input) {
        setUserInput(Integer.toString(input) + System.lineSeparator());
    }

    public static void setUserInput(String input) {
        byte[] inputAsBytes = input.getBytes();
        System.setIn(new ByteArrayInputStream(inputAsBytes));
    }
}
