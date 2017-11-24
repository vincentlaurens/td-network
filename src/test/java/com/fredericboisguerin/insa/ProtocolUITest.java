package com.fredericboisguerin.insa;

import static com.fredericboisguerin.insa.UITestUtils.setUserInput;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class ProtocolUITest {

    private static final int UDP_CODE = 1;
    private static final int TCP_CODE = 2;

    private ProtocolUI protocolUI;
    private FinalUI finalUI = mock(FinalUI.class);

    @Before
    public void setUp() throws Exception {
        protocolUI = new ProtocolUI();
    }

    @Test
    public void should_inform_UDP_to_receiving_ui_when_user_chose_option_1() throws Exception {
        setUserInput(UDP_CODE);

        protocolUI.askProtocolOn(finalUI);

        verify(finalUI).onUDP();
    }

    @Test
    public void should_inform_UDP_to_receiving_ui_when_user_chose_option_2() throws Exception {
        setUserInput(TCP_CODE);

        protocolUI.askProtocolOn(finalUI);

        verify(finalUI).onTCP();
    }
}