package StuDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

public class GUIDemo extends JFrame {
    private JLabel jLabel = new JLabel("请输入你要查询的对象：");
    private JTextField jTextField = new JTextField("select * from StuInfo");
    private JButton jButton1 = new JButton("查询");
    private JButton jButton2 = new JButton("增加");
    private JButton jButton3 = new JButton("删除");
    private JButton jButton4 = new JButton("修改");
    private JScrollPane jScrollPane;
    private JTable jTable;
    private Container container = getContentPane();
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();



    private DBUtil dbUtil = new DBUtil();

    GUIDemo(){
        //窗口标题
        setTitle("学生信息系统");
        //窗口大小
        setSize(500,560);
        //窗口退出
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置jPanel1网格布局，三行一列
        jPanel1.setLayout(new GridLayout(3,1));
        //第一行放jLabel
        jPanel1.add(jLabel);
        jPanel1.add(jTextField);
        jPanel1.add(jButton1);
        //设置container边界布局，将jPanel放到NORTH
        container.add(jPanel1,BorderLayout.NORTH);
        //设置jPanel2网格布局，一行三列
        jPanel2.setLayout(new GridLayout(1,3));
        //将jButton2放到第一列
        jPanel2.add(jButton2);
        jPanel2.add(jButton3);
        jPanel2.add(jButton4);
        //将jPanel放到container的CENNTER处
        container.add(jPanel2,BorderLayout.CENTER);
        try {
            submitDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //给jButton1设置监听执行查询功能
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    submitDB();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //给jButton2设置监听执行增加功能
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDB();
            }
        });

        //给jButton3设置监听执行删除功能
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStu();
            }
        });

        //给jButton4设置监听执行修改功能
        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeInfo();
            }
        });
        setVisible(true);
    }



    //查询
    public void submitDB() throws SQLException {
        //用户在文本框中输入的内容（SQL语句）赋值给input
        String input = jTextField.getText();
        //根据input执行对数据库的操作
        ResultSet resultSet = dbUtil.executeQuery(input);

        //检查数据库是否为空
        boolean moreRecords = resultSet.next();
        if(!moreRecords){
            JOptionPane.showMessageDialog(null,"结果集中无记录");
            setTitle("无记录显示");
            return;
        }


        Vector columnHeads = new Vector();
        Vector rows = new Vector();
        try {
            //获取字段的名称
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); ++i) {
                columnHeads.addElement(resultSetMetaData.getColumnName(i));
            }

            //打印数据
            do {
                Vector currentRow = new Vector();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); ++i) {
                currentRow.addElement(resultSet.getString(i));
                }
                rows.addElement(currentRow);
            } while (resultSet.next());
            jTable = new JTable(rows,columnHeads);
            jScrollPane = new JScrollPane(jTable);
            container.add(jScrollPane, BorderLayout.SOUTH);
            container.validate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void inputDialog(JButton jButton,String title,String message){
        JTextField StuID = new JTextField();
        JTextField StuName = new JTextField();
        JTextField StuSex = new JTextField();
        JTextField StuAge = new JTextField();
        JTextField StuTel = new JTextField();
        JTextField JavaGrade = new JTextField();
        //给弹窗设置多个文本框
        final JComponent[] input = new JComponent[]{
                new JLabel("学号"),
                StuID,
                new JLabel("姓名:"),
                StuName,
                new JLabel("性别:"),
                StuSex,
                new JLabel("年龄:"),
                StuAge,
                new JLabel("电话:"),
                StuTel,
                new JLabel("Java成绩:"),
                JavaGrade,
        };

        int result = JOptionPane.showConfirmDialog(jButton,input,title,JOptionPane.PLAIN_MESSAGE);
        if(result == JOptionPane.OK_OPTION){
            JOptionPane.showMessageDialog(null,message);
        }
        Student student = new Student(Integer.parseInt(StuID.getText()),StuName.getText(),StuSex.getText(),
                Integer.parseInt(StuAge.getText()),StuTel.getText(),Integer.parseInt(JavaGrade.getText()));
        if(jButton == jButton2){
            dbUtil.insertDB(student);
        }else {
            dbUtil.changeDB(student);
        }

    }

    public void addDB(){
        inputDialog(jButton2,"输入相关信息","录入成功");

    }

    public void changeInfo(){
        inputDialog(jButton4,"根据学号修改信息","修改成功");

    }

    public void deleteStu(){
        JTextField jTextField = new JTextField();
        int result = Integer.parseInt(JOptionPane.showInputDialog(jButton3,"输入要删除学生的学号："));

        dbUtil.deleteDB(result);

    }

    public static void main(String[] args) {
        GUIDemo guiDemo = new GUIDemo();
    }
}
