package udesc.ddm.Threads;

import udesc.ddm.Crypto.Encryptor;
import udesc.ddm.Crypto.Mapper;
import udesc.ddm.Singleton.NameGetter;

import java.io.PrintWriter;
import java.util.Scanner;

import static udesc.ddm.Commons.Colors.CYAN;
import static udesc.ddm.Commons.Colors.YELLOW;

public class SendMessageThread extends Thread{
    private boolean IsRunning = true;
    private final PrintWriter out;
    private final Scanner keyboard = new Scanner(System.in);
    private final Encryptor encryptor;
    public SendMessageThread(PrintWriter out){
        this.out = out;
        encryptor = new Encryptor(new Mapper());
    }

    @Override
    public void run(){
        String message;
        while (IsRunning) {
            message = keyboard.nextLine();

            if (message.equals("exit")){
                shutdown();
                break;
            }
            String encryptedMessage = encryptor.encrypt(YELLOW + NameGetter.getName() + ": " + message);
            System.out.println(CYAN + "Você: " + message);
            out.println(encryptedMessage);
        }
    }

    public void shutdown(){
        this.IsRunning = false;
    }
}
