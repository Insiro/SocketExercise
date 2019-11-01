package CalcuratorClient;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CalcClient {
    public static void main(String[] args) throws  Exception{
        Scanner sc = new Scanner(System.in);
        String calcRequestLine = sc.nextLine()+"\n";
        sc.close();
        Socket connectToServer = new Socket("localhost",5180);
        DataOutputStream outline = new DataOutputStream(connectToServer.getOutputStream());
        outline.writeBytes(calcRequestLine);
        BufferedReader readFromServer = new BufferedReader(new InputStreamReader(connectToServer.getInputStream()));
        String result = readFromServer.readLine();
        System.out.println(result);
        connectToServer.close();
    }
}
