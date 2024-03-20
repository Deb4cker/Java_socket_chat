package udesc.ddm;

import udesc.ddm.Singleton.NameGetter;
import udesc.ddm.Singleton.SaltGetter;
import udesc.ddm.Socket.AsyncClient;
import udesc.ddm.Socket.AsyncServer;
import udesc.ddm.Socket.Client;
import udesc.ddm.Socket.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Main {
    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        run();
    }

    public static void run() throws IOException{
        System.out.println("Você vai ser cliente [C] ou servidor [S]? ");
        String type = s.nextLine();
        while (true){
            if(type.equalsIgnoreCase("S")) {
                runServer();
                break;
            }
            else if(type.equalsIgnoreCase("C")){
                runClient();
                break;
            }
            else System.out.println("Input invalido");
        }
    }

    public static void runClient() throws IOException{
        System.out.print("Endereço de ip do servidor: ");
        String ip = s.nextLine();
        System.out.println("Frase chave: ");
        String key = s.nextLine();
        System.out.print("Porta do server: ");
        int port = s.nextInt();
        System.out.print("Seu nome: ");
        String name = s.next();

        SaltGetter.setSalt(key);
        NameGetter.setName(name);
        Client client = new AsyncClient(ip, port);
        client.order();
    }

    public static void runServer() throws IOException{
        System.out.println("Frase chave: ");
        String key = s.nextLine();
        System.out.print("Porta que vai ouvir: ");
        int port = s.nextInt();
        System.out.print("Seu nome: ");
        String name = s.next();

        SaltGetter.setSalt(key);
        NameGetter.setName(name);
        Server server = new AsyncServer(new ServerSocket(port));
        server.serve();
    }
}
