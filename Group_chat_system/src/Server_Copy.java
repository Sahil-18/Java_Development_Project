import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Server_Copy implements Runnable{
    private String Name;
    final BufferedReader in;
    final PrintWriter out;
    final Socket s;

    public Server_Copy(Socket s,String name, BufferedReader in, PrintWriter out) {
        this.s =s;
        this.Name = name;
        this.in = in;
        this.out = out;
    }


    @Override
    public void run() {
        String msg;
        try {
            msg = in.readLine();

            for(Server_Copy sc : Server.details){
                if(this.Name.equals(sc.Name)){
                    this.Name=msg;
                    sc.Name=msg;
                    out.println("You joined the group");
                }else{
                    sc.out.println(Name+ " connected to group");
                }
            }

            while(true){
                msg = in.readLine();

                if(msg.equals("exit")){
                    for(Server_Copy sc : Server.details){
                        if(!(this.Name.equals(sc.Name))){
                            sc.out.println(Name + " has left the chat");
                        }
                    }
                    for(Server_Copy sc : Server.details){
                        if(this.Name.equals(sc.Name)){
                            Server.details.remove(sc);
                        }
                    }
                    break;
                }
                else{
                    for(Server_Copy sc : Server.details){
                        if(!this.Name.equals(sc.Name)){
                            sc.out.println(Name + " has sent this: "+ msg);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
