package udesc.ddm.Threads;

import udesc.ddm.Crypto.Decryptor;
import udesc.ddm.Crypto.Mapper;

import java.io.BufferedReader;
import java.io.IOException;

public class ReceiveMessageThread extends Thread{

    private boolean IsRunning = true;
    private final BufferedReader in;
    private final Decryptor decryptor;

    public ReceiveMessageThread(BufferedReader in){
        this.in = in;
        decryptor = new Decryptor(new Mapper());
    }

    @Override
    public void run(){
        try{
            String messageReceived;
            while (IsRunning){
                messageReceived = decryptor.decrypt(in.readLine());
                System.out.println(messageReceived);
            }
        }catch (IOException e){
            System.out.println("deu pau");
        }
    }

    public void shutdown(){
        this.IsRunning = false;
    }
}
