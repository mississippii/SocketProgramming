package Network;



import java.io.*;
import java.net.*;

public class Server {
    private static final int port = 8060;

    public static void main(String[] args) throws IOException {
        run();
    }

    private static void run() throws IOException  {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server running on port 8060");
        while (true) {
            Socket socket = serverSocket.accept();
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            try {
                Object obj = objectInputStream.readObject();
                String str = (String) obj;
                System.out.println("Received: " + str);
                objectOutputStream.writeObject(str.toUpperCase());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

