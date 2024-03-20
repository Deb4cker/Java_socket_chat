package udesc.ddm.Socket;

import java.io.IOException;
import java.net.ServerSocket;

public class SyncServer extends Server{
    public SyncServer(ServerSocket server){
        super(server);
    }

    @Override
    public void serve() throws IOException{
        server.setReuseAddress(true);
        while (true) {
            System.out.println("Waiting connection...");
            connection = server.accept();
            System.out.println("Someone connected");

            setIn();
            setOut();

            String received;
            String response = "";
            while (!response.equals("exit")) {
                received = "Ana Fábia:" + in.readLine();
                System.out.println(received);

                response = keyboard.nextLine();
                out.println(response);
            }
        }
    }
}
