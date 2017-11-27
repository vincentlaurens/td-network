package com.fredericboisguerin.insa.network.core.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMessageReceiverService implements MessageReceiverService, Runnable {
    private ServerSocket serverSocket;
    private BufferedReader reader;
    private InputStreamReader stream;
    private IncomingMessageListener monIncomingMessageListener;

    @Override
    public void listenOnPort(int port, IncomingMessageListener incomingMessageListener) throws Exception {
        this.serverSocket = new ServerSocket(port);
        this.monIncomingMessageListener = incomingMessageListener;
        Socket chatSocket = serverSocket.accept();


        this.stream = new InputStreamReader(chatSocket.getInputStream());
        this.reader  =new BufferedReader(this.stream);
        new Thread(()-> this.run()).start();
    }
    public void run(){
        try{
            boolean threadteceptionactive = true;
            while (threadteceptionactive){
                String message = this.reader.readLine();
                this.monIncomingMessageListener.onNewIncomingMessage(message);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
