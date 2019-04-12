package Task1;

import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandom {
    public static void main(String[] args) {
        try {
            RandomAccessFile rf = new RandomAccessFile("rtest.dat","rw");
            for (int i = 0; i < 10; i++)
                rf.writeDouble(i*1.414);
            rf.close();
            rf = new RandomAccessFile("rtest.dat","rw");
            rf.seek(5*8);
            rf.writeDouble(47.0001);
            rf.close();
            rf = new RandomAccessFile("rtest.dat","r");
            for (int i = 0; i < 10; i++)
                System.out.println("value"+i+":"+rf.readDouble());
            rf.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
