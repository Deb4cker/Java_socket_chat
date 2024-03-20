package udesc.ddm.Socket;

import java.io.IOException;
import java.net.Socket;

public class SyncClient extends Client{
    public SyncClient(String serverIp, int serverPort){
        super(serverIp, serverPort);
    }

    @Override
    public void order() throws IOException {
        while (true) {
            this.conn = new Socket(serverIp, serverPort);
            System.out.println("service connected.");

            setIn();
            setOut();

            String received;
            String response = "";
            while (!response.equals("exit")){
                response = keyboard.nextLine();
                out.println(response);

                received = "Nicolas: " + in.readLine();
                System.out.println(received);
            }
        }
    }
}
