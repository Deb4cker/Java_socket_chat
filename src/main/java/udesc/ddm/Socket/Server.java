package udesc.ddm.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public abstract class Server {

    protected final ServerSocket server;
    protected Socket connection;
    protected BufferedReader in;
    protected PrintWriter out;

    protected final Scanner keyboard = new Scanner(System.in);

    public Server(ServerSocket server){
        this.server = server;
    }

    public abstract void serve() throws IOException;

    protected void setIn() throws IOException{
        in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    }

    protected void setOut() throws IOException{
        out = new PrintWriter(connection.getOutputStream(), true);
    }
}

