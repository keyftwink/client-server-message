import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("InfiniteLoopStatement")
public class Server {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(1020)) {
            while (true) {
                Socket socket = serverSocket.accept();
                serverClient(socket);
            }
        }
    }

    private static void serverClient(Socket socket) throws IOException {
        System.out.println("Serving client" + socket.getInetAddress());

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter    out = new PrintWriter(socket.getOutputStream(),true);

        while (true) {
            String request = in.readLine();
            System.out.println("Request:" + request);
            out.println(request);
        }
    }
}