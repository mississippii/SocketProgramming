package Network;


import java.io.*;
import java.net.Socket;

public class Client {
    private static final String host= "127.0.0.1";
    private static final int port=8060;

    public static void main(String[] args) throws IOException {
        connect();
    }
    private static void connect() throws IOException {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Client Connected");
            ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
            int i=0;
            while(i<5) {
                writer.writeObject("Hello Server I'm from client1");
                i++;
            }
            System.out.println("Message transferred");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
