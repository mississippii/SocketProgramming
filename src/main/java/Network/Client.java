package Network;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String host= "127.0.0.1";
    private static final int port=8060;

    public static void main(String[] args) throws IOException {
        connect();
    }
    private static void connect() throws IOException {
            Socket socket = new Socket(host, port);
            System.out.println("Client Connected");
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            System.out.printf("Client: ");
            Scanner scanner = new Scanner(System.in);
            String input =scanner.nextLine();
            outputStream.writeObject(input);
        try {
            Object messege =  inputStream.readObject();
            System.out.println("Server: " + messege);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
