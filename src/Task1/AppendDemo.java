package Task1;

import java.io.*;

public class AppendDemo {
    public static void main(String[] args) throws IOException {
        File file1 = new File("t1.txt");
        File file2 = new File("t2.txt");
        file1.createNewFile();
        file2.createNewFile();
        FileWriter writer1 = new FileWriter(file1);
        writer1.write("你好！");
        FileWriter writer2 = new FileWriter(file2);
        writer1.write("Java！");
        writer1.flush();
        writer1.close();
        writer2.flush();
        writer2.close();
        FileReader in = new FileReader("t1.txt");//创建文件输入流
        BufferedReader bin = new BufferedReader(in);//创建缓冲流
        FileWriter out = new FileWriter("t2.txt",true);
        String s1;
        while ((s1=bin.readLine())!=null){
            System.out.println(s1);//将s1输出到显示器
            out.write(s1+"\n");//将s1写入out对象中
        }
        in.close();//关闭输入流
        out.close();//关闭输出流
    }
}
