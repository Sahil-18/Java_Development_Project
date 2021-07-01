import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket s = new Socket("localhost",8081);
        System.out.println("Ypu are now connected to group and server");
        String msg;
        Scanner sc = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        System.out.println("Enter your name");
        msg = sc.nextLine();
        out.println(msg);
        client_in new_in = new client_in(in);
        client_out new_out = new client_out(out,sc);
        Thread Input = new Thread(new_in);
        Thread Output = new Thread(new_out);
        Input.setDaemon(true);
        Input.start();
        Output.start();
        Output.join();
        Input.interrupt();
    }
}
