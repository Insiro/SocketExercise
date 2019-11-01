package CalcuratorServer;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Calculator implements Runnable {
    private String inputLine;
    private Socket socket;
    private String result;

    Calculator(Socket socket) throws IOException {
        this.socket = socket;
        BufferedReader readBuff = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        inputLine = readBuff.readLine();
    }

    private String simpleCalc() {
        int i, a, b;
        boolean checkOperator = false;

        for (i = 0; i < inputLine.length(); i++) {
            if (inputLine.charAt(i) < '0' || inputLine.charAt(i) > '9') {
                System.out.println(i+" "+inputLine.charAt(i));
                checkOperator = true;
                break;
            }
        }
        if (checkOperator==false) {
            return "There's no Operators";
        }
        a = Integer.parseInt(inputLine.substring(0, i));
        b = Integer.parseInt(inputLine.substring(i+1));
        switch (inputLine.charAt(i)) {
            case 'x':
                return "result : "+String.valueOf(a * b);
            case '/':
                if (b == 0)
                    return "Error : Divide with 0";
                return "result : "+String.valueOf((double) a / b);
            case '+':
                return "result : "+String.valueOf(a + b);
            case '-':
                return "result : "+ Integer.toString(a - b);
                default: return "Error : No Supported Operator";
        }
    }

    private String calc() {

        // TODO : divide With Operators
        // 1+2*3/(3-4)%4

        int[] position = new int[inputLine.length()];// ( 스택
        for (int i = 0; i < inputLine.length(); i++) {

        }


        return "0";
    }

    private void sendData() throws IOException {
        DataOutputStream outStream = new DataOutputStream(socket.getOutputStream());
        outStream.writeBytes(result + '\n');
        socket.close();
    }

    @Override
    public void run() {
        //The four basic arithmetic operations shoud be supported
        // - addition, subtraction, multiplication and division
        result = simpleCalc();
        try {
            sendData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

