package CalcuratorServer;
import java.net.*;
public class CalcServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(5180);
        System.out.println("Server Start\n");
        while(true){
            Socket users = serverSocket.accept();
            Thread t = new Thread(new Calculator(users));
            t.start();
        }
    }
}
