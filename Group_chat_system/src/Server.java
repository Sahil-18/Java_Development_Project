import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    static Vector<Server_Copy> details = new Vector<>();
    static int i=1;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8081);
        System.out.println("Server online");
        Socket client ;
        while(true){
            client=server.accept();
            System.out.println("New client connected to server");
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);
            Server_Copy New_Client = new Server_Copy(client,"Client"+i,in,out);
            i++;
            Thread t = new Thread(New_Client);
            details.add(New_Client);
            t.start();
        }
    }
}
