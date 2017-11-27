package com.fredericboisguerin.insa.network.core.service;

import javax.sql.DataSource;
import java.io.IOException;
import java.net.*;

public class UDPMessageReceiverService implements MessageReceiverService, Runnable {
    private byte[] dataReception;
    private DatagramSocket datagramSocket;
    private DatagramPacket datagramPacket;
    private IncomingMessageListener monIncomingMassageListenner;

    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {

        byte[] buffer = new byte[100];
        this.dataReception = new byte[100];

        this.datagramSocket = new DatagramSocket(port);
        this.datagramPacket = new DatagramPacket(buffer, 100);
        this.monIncomingMassageListenner = incomingMessageListener;

        new Thread(()-> this.run()).start();
    }

    public void messageAffichage(){

        this.dataReception = this.datagramPacket.getData();
        String chaineEnvoyee = new String(dataReception);

        monIncomingMassageListenner.onNewIncomingMessage(chaineEnvoyee);
    }
    @Override
    public void run(){
        boolean threadteceptionactive = true;
        while (threadteceptionactive){
            try{
                this.datagramSocket.receive(this.datagramPacket);
                this.messageAffichage();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
