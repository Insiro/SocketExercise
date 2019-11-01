package CalcuratorServer;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Calculator implements Runnable{
    private String inputLine;
    private Socket socket;
    private String result;

    Calculator(Socket socket)throws IOException {
        this.socket = socket;
        BufferedReader readBuff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        inputLine = readBuff.readLine();
    }
    private String calc(){
        // TODO : divide With Operators
        // 1+2*3/(3-4)%4
        int []position = new int[inputLine.length()];// ( 스택
        for(int i=0;i<inputLine.length();i++){

        }


        return "0";
    }
    private String SubCalc(String substr){

    }
    private void sendData()throws  IOException{
        DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
        outStream.writeBytes(result+'\n');
        socket.close();
    }
    @Override
    public void run() {
        //The four basic arithmetic operations shoud be supported
        // - addition, subtraction, multiplication and division
        result = String.valueOf(calc());
        try{
            sendData();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

