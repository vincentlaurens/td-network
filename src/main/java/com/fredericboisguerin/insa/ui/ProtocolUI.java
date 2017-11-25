package com.fredericboisguerin.insa.ui;

import java.util.Scanner;

public class ProtocolUI {

    private static final int UDP = 1;
    private static final int TCP = 2;

    public void askProtocolOn(FinalUI finalUI) {
        int choice = createScanner().nextInt();
        switch (choice) {
        case UDP:
            finalUI.onUDP();
            break;
        case TCP:
            finalUI.onTCP();
            break;
        }
    }

    private static Scanner createScanner() {
        return new Scanner(System.in);
    }
}
