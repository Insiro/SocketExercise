package CalcuratorClient;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CalcClient {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Socket connectToServer;
        DataOutputStream outline;
        BufferedReader readFromServer;
        String calcRequestLine,result;
        while (true) {

            calcRequestLine= sc.nextLine() + "\n";
            if(calcRequestLine=="-1\n")break;
            connectToServer = new Socket("localhost", 5180);
            outline = new DataOutputStream(connectToServer.getOutputStream());
            outline.writeBytes(calcRequestLine);
            readFromServer = new BufferedReader(new InputStreamReader(connectToServer.getInputStream()));
            result = readFromServer.readLine();
            connectToServer.close();
            System.out.println(result);
            System.out.println("Do you want more Calc?");
            System.out.println("for exit input -1 or next line");
        }
    }
}
