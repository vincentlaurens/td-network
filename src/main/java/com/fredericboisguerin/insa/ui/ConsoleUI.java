package com.fredericboisguerin.insa.ui;

import java.util.Scanner;

public class ConsoleUI {

    private static final int RECEIVE = 1;
    private static final int SEND = 2;
    private final ProtocolUI protocolUI;

    private final FinalUI receiveUI;
    private final FinalUI sendUI;

    public ConsoleUI(ProtocolUI protocolUI, ReceiveUI receiveUI, SendUI sendUI) {
        this.protocolUI = protocolUI;
        this.receiveUI = receiveUI;
        this.sendUI = sendUI;
    }

    public void askForAction() {
        int choice = createScanner().nextInt();
        switch (choice) {
        case RECEIVE:
            protocolUI.askProtocolOn(receiveUI);
            break;
        case SEND:
            protocolUI.askProtocolOn(sendUI);
            break;
        }
    }

    private static Scanner createScanner() {
        return new Scanner(System.in);
    }
}
