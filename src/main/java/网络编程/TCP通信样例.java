package 网络编程;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP通信样例 {
    public static void main(String[] args) throws InterruptedException {
        Thread client = new Thread(){
            @Override
            public void run() {
                try {
                    Socket sc = new Socket("127.0.0.1", 6666);
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(sc.getInputStream()));
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(sc.getOutputStream()));
                    bufferedWriter.write("我叫李金玉");
                    bufferedWriter.flush();
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread sever = new Thread(){
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket(6666);
                    Socket socket = serverSocket.accept();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    String val;
                    while ((val = bufferedReader.readLine()) != null) {
                        System.out.println(val);
                    }
                }catch (Exception e){

                }

            }
        };
        sever.start();
        Thread.sleep(2000);
        client.start();
    }
}
