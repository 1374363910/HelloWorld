package Task1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StreamDemo {
    public static void main(String[] args) {
        String s;
        InputStreamReader ir;
        BufferedReader in;
        ir = new InputStreamReader(System.in);//创建标准输入流
        //建立与系统标准输入之间的输入流联系
        in = new BufferedReader(ir);
        try{
            do{
                s = in.readLine();
                if(s!=null){
                    System.out.println("Read:"+s);
                }
            }while(s!=null);
        }catch (Exception e){};
    }
}
