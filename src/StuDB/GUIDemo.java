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
        setTitle("学生信息系统");
        setSize(500,560);
        //setLocation(500,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jPanel1.setLayout(new GridLayout(3,1));
        jPanel1.add(jLabel);
        jPanel1.add(jTextField);
        jPanel1.add(jButton1);
        container.add(jPanel1,BorderLayout.NORTH);
        jPanel2.setLayout(new GridLayout(1,3));
        jPanel2.add(jButton2);
        jPanel2.add(jButton3);
        jPanel2.add(jButton4);
        container.add(jPanel2,BorderLayout.CENTER);
        try {
            submitDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }


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

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDB();
            }
        });

        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteStu();
            }
        });

        jButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeInfo();
            }
        });
        setVisible(true);
    }



    public void submitDB() throws SQLException {
        String input = jTextField.getText();
        ResultSet resultSet = dbUtil.executeQuery(input);

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
