package 网络编程;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDP通信样例 {
    public static void main(String[] args) throws Exception{

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                try (DatagramSocket datagramSocket = new DatagramSocket(6666);){
                    DatagramPacket datagramPacket = new DatagramPacket(new byte[1024], 100);
                    datagramSocket.receive(datagramPacket);
                    byte[] data = datagramPacket.getData();
                    int len = datagramPacket.getLength();  //获取有效的字节个数
                    String val = new String(data);
                    System.out.println(val);
                    System.out.println(new String(data, 0, len));
                }catch (Exception e){
                    System.out.println("出错了");
                }
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                String data = "wojiaolijinyu";
                byte[] bytes = data.getBytes();
                try (DatagramSocket datagramSocket = new DatagramSocket();){
                    DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(),6666);
                    datagramSocket.send(datagramPacket);
                }catch (Exception e){
                    System.out.println("发送失败");
                }
            }
        };

        thread1.start();
        Thread.sleep(2000);
        thread2.start();

    }
}
