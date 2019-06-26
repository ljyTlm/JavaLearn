package 输入输出流;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class 随机访问流样例 {
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("tt.txt");
        Random random = new Random();
        for(int i = 0; i < 999999; i ++){
            outputStream.write(random.nextInt(25)+'a');
        }
        outputStream.flush();
        outputStream.close();
        RandomAccessFile randomAccessFile = new RandomAccessFile("tt.txt", "rw");
//      此类用于对于文件的读取和写入 虽然在io包下但是跟InputSteam OutputSteam并没有什么关系
//      这个类可以设置在指定的地方对文件进行读取和写入
        randomAccessFile.seek(100);
        randomAccessFile.read();
        randomAccessFile.write(98);
//      那么有什么应用呢？
//      可以开取多线程对文件进行下载 并列执行
        Thread [] threads = new Thread[10];
        for (int i = 0; i < 10; i ++) {
            threads[i] = new DownLoad(i*100, i*100+99);
            threads[i].start();
        }
    }
}
class DownLoad extends Thread{

    int start;

    int end;

    RandomAccessFile randomAccessFile;

    private DownLoad(){}

    DownLoad(int start, int end){
        this.start = start;
        this.end = end;
        try {
            randomAccessFile = new RandomAccessFile("tt.txt", "rw");
            randomAccessFile.seek(start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String val = this.getName()+"\r\n";
        while (start ++ < end){
            try {
                int read = randomAccessFile.read();
                val += (char)read;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(val+"\r\n\r\n");
    }
}