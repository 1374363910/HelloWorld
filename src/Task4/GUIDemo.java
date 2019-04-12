//package Task4;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.util.Vector;
//
//public class GUIDemo extends JFrame {
//
//    private JdbcOdbcConnection jdbcOdbcConnection = new JdbcOdbcConnection();
//
//    private JTable table;
//    private JTextField input;
//    private JButton submit;
//    private JButton add;
////    private JButton delete;
////    private JButton change;
//
//    public GUIDemo(){
//        String test = "select * from StuInfo";
//        input = new JTextField(test);
//        submit = new JButton("查询");
//
//        //Button事件
//        submit.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        getTable();
//                    }
//                }
//        );
//
//
//        JPanel topPanel = new JPanel();
//        topPanel.setLayout(new BorderLayout());
//        //将“输入查询”编辑框布置到“CENTER”
//        topPanel.add(new JScrollPane(input), BorderLayout.CENTER);
//        //将“提交查询”按钮布置到“SOUTH”
//        topPanel.add(submit, BorderLayout.SOUTH);
//        table = new JTable();
//        Container c = getContentPane();
//        c.setLayout(new BorderLayout());
//        //将“topPanel”编辑框布置到“NORTH”
//        c.add(topPanel, BorderLayout.NORTH);
//        //将“table”编辑框布置到“CENTER”
//        c.add(table, BorderLayout.CENTER);
//        getTable();
//        setSize(500,300);
//        //显示Form
//        setVisible(true);
//
//    }
//
//
//
//    private void getTable() {
//        try {
//            //执行SQL语句
//            String query = input.getText();
//            displayResultSet(jdbcOdbcConnection.executeQuery(query));
////            if (jdbcOdbcConnection.executeQuery(query) == null) {
////                JOptionPane.showMessageDialog(this,"查询失败，请检查SQL语句");
////                setTitle("查询失败");
////            }
//        }catch (SQLException sqlex){
//            sqlex.printStackTrace();
//        }
//    }
//
//    private void displayResultSet(ResultSet resultSet) throws SQLException{
//        //定位到达第一条记录
//        boolean moreRecords = resultSet.next();
//        //如果没有记录，则提示一条消息
//        if(!moreRecords){
//            JOptionPane.showMessageDialog(this,"结果集中无记录");
//            setTitle("无记录显示");
//            return;
//        }
//
//        Vector columnHeads = new Vector();
//        Vector rows = new Vector();
//        try {
//            //获取字段的名称
//            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//            for (int i = 1; i <= resultSetMetaData.getColumnCount(); ++i) {
//                columnHeads.addElement(resultSetMetaData.getColumnName(i));
//            }
//            do{
//                rows.addElement(getNextRow(resultSet,resultSetMetaData));
//            }while (resultSet.next());
//            //在表格中显示查询结果
//            table = new JTable(rows, columnHeads);
//            JScrollPane scroller = new JScrollPane(table);
//            Container c = getContentPane();
//            c.remove(1);
//            c.add(scroller, BorderLayout.CENTER);
//            c.validate();
//        }catch (SQLException sqlex){
//            sqlex.printStackTrace();
//        }
//    }
//
//    private Vector getNextRow(ResultSet resultSet, ResultSetMetaData resultSetMetaData) throws SQLException{
//        Vector currentRow = new Vector();
//        for (int i = 1; i <= resultSetMetaData.getColumnCount(); ++i) {
//            currentRow.addElement(resultSet.getString(i));
//            //返回一条记录
//        }
//        return currentRow;
//    }
//
//    public static void main(String[] args) {
//        final GUIDemo app = new GUIDemo();
//        JdbcOdbcConnection jdbcOdbcConnection = new JdbcOdbcConnection();
//        app.addWindowListener(
//                new WindowAdapter() {
//                    @Override
//                    public void windowClosing(WindowEvent e) {
//                        jdbcOdbcConnection.close();
//                        System.exit(0);
//                    }
//                }
//        );
//    }
//}
