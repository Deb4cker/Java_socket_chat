package udesc.ddm.Socket;

import udesc.ddm.Threads.ReceiveMessageThread;
import udesc.ddm.Threads.SendMessageThread;

import java.io.IOException;
import java.net.Socket;

import static udesc.ddm.Commons.Colors.GREEN;

public class AsyncClient extends Client{

    public AsyncClient(String serverIp, int serverPort) {
        super(serverIp, serverPort);
    }

    @Override
    public void order() throws IOException {
        while (true) {
            this.conn = new Socket(serverIp, serverPort);
            System.out.println(GREEN + "service connected.");

            setIn();
            setOut();

            ReceiveMessageThread messageReceiver = new ReceiveMessageThread(in);
            SendMessageThread messageSender = new SendMessageThread(out);


                messageReceiver.start();
                messageSender.run();

        }
    }
}
