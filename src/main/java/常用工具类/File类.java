package 常用工具类;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Field;

public class File类 {
    public static void main(String[] args) throws IOException {
//      1.File类概述
//          更准确的说 File类描述的是一个路径（文件和目录路径名的抽象表示方式）
//          相对路径：当前上下文的路径
//          绝对路径：需要指定盘符详细描述的路径
//      2.File的创建
        File file_1 = new File("C:/Users/lenovo/Desktop/投票系统维护");
//      这一种就是直接指定路径 可以用反斜杠代替转义
        File file_2 = new File("C:/Users/lenovo/Desktop/", "投票系统维护");
//      这一种需要指定 父路径 和 子路径
        File file_3 = new File(file_1, "投票系统");
//      这一种需要指定 父对象 和 子路径
//      3.文件的创建
        File file_4 = new File("test_1.txt");
        file_4.createNewFile();
//      如果有就创建 没有就不创建
        File file_5 = new File("test_2");
        file_5.mkdir();
//      如果有就创建文件夹 没有就不创建
        File file_6 = new File("tt/dd/kk");
        file_6.mkdirs();
//      创建多级文件夹
//      4.文件的重命名和删除
        File file_7 = new File("tt");
        File file_8 = new File("dd");
        file_7.renameTo(file_8);
//      路径相同直接改名 路径不同改名并剪切
        File file_9 = new File("dd");
        file_9.delete();
//      删除功能有几个注意事项
//      1.java的删除不走回收站
//      2.要删除的文件夹不能包含文件
//      5.文件的判断功能
        File file_10 = new File("cccc");
        file_10.isDirectory();
//      判断是否是文件夹
        file_10.isFile();
//      判断是否为文件
        file_10.exists();
//      判断文件是否存在
        file_10.canRead();
//      注意事项 window 系统下认为所有的文件都是可读的 一直为true setReadable方法失效
        file_10.canWrite();
//      window 可以设置不可写~
        file_10.isHidden();
//      判断文件是否是隐藏
//      6.文件的获取功能
        File file_11 = new File("kkk");
        String path_1 = file_11.getAbsolutePath();
//      获取文件的绝对路径
        String path_2 = file_11.getPath();
//      获取构造方法中传入的路径
        String name_1 = file_11.getName();
//      获取文件名字
        long length_1 = file_11.length();
//      获取文件的字节长度
        long time_1 = file_11.lastModified();
//      获取上一次修改时间的毫秒值
        String[] list_1 = file_11.list();
//      获取文件或文件夹的名称数组
        File[] files_1 = file_11.listFiles();
//      获取文件或文件夹的对象
//      7.文件过滤器
        File file_12 = new File("lll");
        file_12.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
//              dir 当前文件 name 子文件名字
                return new File(dir, name).getName().endsWith(".jpg");
            }
        });
    }
}
