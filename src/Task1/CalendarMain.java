package Task1;
public class CalendarMain{
    public static void main(String[] args) {
        CalendarFrame frame=new CalendarFrame();
        frame.setBounds(100,100,360,300);
        frame.setVisible(true);
        frame.validate();
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
/**
 * 此代码段由学生独立完成
 * 功能：利用匿名类实现frame窗口事件的监听
 * 当用户单机【关闭】按钮时退出程序
 */
    }
}
