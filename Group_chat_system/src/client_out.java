import java.io.PrintWriter;
import java.util.Scanner;

public class client_out implements Runnable{
    final PrintWriter out;
    Scanner sc;
    private String msg;

    public client_out(PrintWriter out, Scanner sc) {
        this.out = out;
        this.sc = sc;
    }


    @Override
    public void run() {
        while(true){
            System.out.println("Enter your msg");
            msg = sc.nextLine();
            out.println(msg);
            if(msg.equals("exit")){
                break;
            }
        }
    }
}
