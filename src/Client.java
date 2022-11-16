import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        try(Socket socket = new Socket("localhost", 1020)){
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter    out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

            String fuser,fserver;

            while ((fuser = inu.readLine())!=null) {
                out.println(fuser);

                fserver = in.readLine();
                System.out.println(fserver);
                if (fuser.equalsIgnoreCase("close")) break;

                if (fuser.equalsIgnoreCase("exit")) break;
            }

            out.close();
            in.close();
            inu.close();

            socket.close();
        }
    }
}