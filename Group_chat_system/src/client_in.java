import java.io.BufferedReader;
import java.io.IOException;

public class client_in implements Runnable{
    final BufferedReader in;
    private String msg;
    public client_in(BufferedReader in){
        this.in = in;
    }

    @Override
    public void run() {
        try {
            while(true){
                msg = in.readLine();
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

