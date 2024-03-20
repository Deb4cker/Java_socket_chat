package udesc.ddm.Socket;

import udesc.ddm.Threads.ReceiveMessageThread;
import udesc.ddm.Threads.SendMessageThread;

import java.io.IOException;
import java.net.ServerSocket;

import static udesc.ddm.Commons.Colors.YELLOW;
import static udesc.ddm.Commons.Colors.GREEN;

public class AsyncServer extends Server{

    public AsyncServer(ServerSocket server) {
        super(server);
    }

    @Override
    public void serve() throws IOException {
        server.setReuseAddress(true);
        while (true) {
            System.out.println(YELLOW + "Waiting connection...");
            connection = server.accept();
            System.out.println(GREEN + "Someone connected");

            setIn();
            setOut();

            ReceiveMessageThread messageReceiver = new ReceiveMessageThread(in);
            SendMessageThread messageSender = new SendMessageThread(out);

                messageReceiver.start();
                messageSender.run();
        }
    }
}
