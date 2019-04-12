package Task1;

import java.io.File;
public class FileDemo1 {
    public static void main(String[] args){
        File f = new File("d:\\book");
        printAllFile(f);
        File f1 = new File("d:\\text");
        deleteAllFile(f1);
    }
    /**
     * 打印f路径下所有子文件和子文件夹
     * @param f 文件对象
     */
    public static void printAllFile(File f){
        //打印当前文件名
        System.out.println(f.getName());
        //是否是文件夹
        if (f.isDirectory()){
            //获得该文件夹下所有子文件和子文件夹
            File[] f1 = f.listFiles();
            //循环处理每个对象
            int len = f1.length;
            for (int i = 0; i < len; i++) {
                //递归调用，处理每个文件对象
                printAllFile(f1[i]);
            }
        }
    }
    /**
     * 删除对象f下所有文件和文件夹
     * @param f 文件路径
     */
    public static void deleteAllFile(File f){
        //文件
        if (f.isFile()){
            f.delete();
        }else{//文件夹
            //获得当前文件夹下所有子文件和子文件夹
            File f1[] = f.listFiles();
            //循环处理每个对象
            int len = f1.length;
            for (int i = 0; i < len; i++) {
                //递归调用，处理每个文件对象
                deleteAllFile(f1[i]);
            }
            //删除当前文件夹
            f.delete();
        }
    }
}