package Server1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server1 {
    public static void main(String[] args) throws IOException{
        String  clientSentence;
        String capitalizedSentence;

        ServerSocket welcomeSocket;
        welcomeSocket = new ServerSocket(6789);
        System.out.println("Server Start..\n");
        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            System.out.println("From Client : "+clientSentence);
            capitalizedSentence = clientSentence.toUpperCase()+'\n';
            outToClient.writeBytes(capitalizedSentence);
        }
    }
}
