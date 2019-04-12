package Task1;

import java.io.*;

public class FileOperation {
    public static void main(String[] args) {
        try {
            BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
            String sdir = "text";
            String sfile;
            File Fdir1 = new File(sdir);
            if (Fdir1.exists() && Fdir1.isDirectory()) {
                System.out.println("There is a Dictionary" + sdir + "exists.");
                for (int i = 0; i < Fdir1.list().length; i++)// 列出目录下的内容
                    System.out.println((Fdir1.list())[i]);
                File Fdir2 = new File("test\\temp");
                if ((Fdir2.exists()))
                    Fdir2.mkdir();// 创建原不存在的目录
                System.out.println();
                System.out.println("Now the new list after create a new dir:");
                for (int i = 0; i < Fdir1.list().length; i++)// 检查目录是否已建立
                    System.out.println((Fdir1.list()[i]));
                System.out.println();
                System.out.println("Enter a file name in the dictionary:");
                sfile = din.readLine();// 选取指定目录中的下一个文件
                File Ffile = new File(Fdir1, sfile);
                if (Ffile.isFile()) {// 显示文件有关信息
                    System.out.println("File" + Ffile.getName() + " in Path " + Ffile.getPath() + " is "
                            + Ffile.length() + " in length.");
                }
            } else
                System.out.println("the dictory doesn't exist!");
        } // try
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}