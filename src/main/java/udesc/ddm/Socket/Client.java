package udesc.ddm.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public abstract class Client {

    protected BufferedReader in;
    protected Socket conn ;
    protected PrintWriter out;
    protected final String serverIp;
    protected final int serverPort;
    protected final Scanner keyboard = new Scanner(System.in);

    public Client(String serverIp, int serverPort){
        this.serverIp = serverIp;
        this.serverPort = serverPort;
    }

    public abstract void order() throws IOException;

    protected void setIn() throws IOException{
        this.in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    }

    protected void setOut() throws IOException{
        this.out= new PrintWriter(conn.getOutputStream(), true);
    }
}
