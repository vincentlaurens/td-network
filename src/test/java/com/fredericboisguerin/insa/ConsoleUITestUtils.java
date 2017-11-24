package com.fredericboisguerin.insa;

import static com.fredericboisguerin.insa.UITestUtils.setUserInput;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class ConsoleUITestUtils {

    private static final int RECEIVER_ACTION_CODE = 1;
    private static final int SENDER_ACTION_CODE = 2;

    private ConsoleUI consoleUI;
    private ProtocolUI protocolUI = mock(ProtocolUI.class);

    private ReceiveUI receiveUI = mock(ReceiveUI.class);
    private SendUI sendUI = mock(SendUI.class);

    @Before
    public void setUp() throws Exception {
        consoleUI = new ConsoleUI(protocolUI, receiveUI, sendUI);
    }

    @Test
    public void should_ask_protocol_to_receiver_ui_when_user_choose_to_listen_to_incoming_messages() throws Exception {
        setUserInput(RECEIVER_ACTION_CODE);

        consoleUI.askForAction();

        verify(protocolUI).askProtocolOn(receiveUI);
    }

    @Test
    public void should_ask_protocol_to_sender_ui_when_user_choose_to_send_messages() throws Exception {
        setUserInput(SENDER_ACTION_CODE);

        consoleUI.askForAction();

        verify(protocolUI).askProtocolOn(sendUI);
    }
}