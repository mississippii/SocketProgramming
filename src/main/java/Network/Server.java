package Network;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.*;

public class Server {
    private static final int port = 8060;
    public static  void main(String[] args) throws IOException {
        run();
    }
    private static void run() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server running on port 8060");
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String message = input.readLine();
                    System.out.println("Received: " + message);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
