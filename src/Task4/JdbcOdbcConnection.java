//package Task4;
//
//import java.sql.*;
//import java.util.Scanner;
//
//public class JdbcOdbcConnection {
//    private String sDBDriver = null;
//    private String sConnStr = null;
//    private String user = null;
//    private String pass = null;
//    private Connection conn = null;
//    private Statement stmt = null;
//
//    public JdbcOdbcConnection(){
//        sDBDriver = "com.hxtt.sql.access.AccessDriver";
//        sConnStr = "jdbc:Access:///C:/Users/a/IdeaProjects/HelloWorld/StuInfo.accdb/";
//        user = "";
//        pass = "";
//        try{
//            Class.forName(sDBDriver);
//        }catch (ClassNotFoundException classnotfoundexception){
//            System.err.println("加载驱动程序失败：" + classnotfoundexception.getMessage());
//        }
//    }
//
//    /*
//    *获取数据库连接操作
//     */
//    public void getConnection(){
//        try{
//            conn = DriverManager.getConnection(sConnStr,user,pass);
//            //conn.setAutoCommit(false);
//            stmt = conn.createStatement();
//        } catch (SQLException sqlexception) {
//            System.err.println("获取数据库连接失败："+sqlexception.getMessage());
//        }
//    }
//    /*
//    *数据库查询操作
//    * 参数sql为要查询的SQL语句
//    * 成功返回查询结果集，否则返回null
//    * @return ResultSet
//     */
//    public ResultSet executeQuery(String s){
//        try {
//            if (conn == null) {
//                getConnection();
//            }
//            if (stmt == null) {
//                stmt = conn.createStatement();
//            }
//            ResultSet rs = stmt.executeQuery(s);
//            return rs;
//        }catch (SQLException sqlexception){
//            System.err.println("查询失败："+sqlexception.getMessage());
//            return null;
//        }
//    }
//    /*
//    *数据库更新操作
//    * 参数sql为要更新的SQL语句
//    * 更新成功返回true，否则返回false
//    * @return boolean
//     */
//    public boolean executeUpdate(String s){
//        try {
//            if (conn == null) {
//                getConnection();
//            }
//            if (stmt == null) {
//                stmt = conn.createStatement();
//            }
//            stmt.executeUpdate(s);
//            return true;
//        }catch (SQLException sqlexception){
//            System.err.println("更新操作失败："+sqlexception.getMessage());
//            return false;
//        }
//    }
//    /*
//    *数据库更新的批处理操作
//    * 参数sql为数组变量，存储要更新的SQL语句
//    * 更新成功返回true，否则返回false
//    * @return boolean
//     */
//    public boolean updateBatch(String[] sql){
//        try {
//            if (conn == null) {
//                getConnection();
//            }
//            if (stmt == null) {
//                stmt = conn.createStatement();
//            }
//            for (int i = 0; i < sql.length; i++) {
//                if (sql[i] != null) {
//                    stmt.addBatch(sql[i]);
//                }
//            }
//            stmt.executeBatch();
//            return true;
//        }catch (Exception e){
//            System.err.println("更新操作失败："+e.toString());
//            return false;
//        }
//    }
//    /*
//    *提交事务对象
//     */
//    public void commit(){
//        try {
//            conn.commit();
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }
//    }
//    /*
//    *回滚事务对象
//     */
//    public void rollback(){
//        try {
//            conn.rollback();
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }
//    }
//    /*
//    *关闭数据库连接
//     */
//    public void close(){
//        try {
//            if (stmt != null) {
//                stmt.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }
//    }
//
//
//    public static void main(String[] args) {
//        JdbcOdbcConnection Conn = new JdbcOdbcConnection();
//        try {
//            Scanner scanner = new Scanner(System.in);
//            String keyword = scanner.next();
//            String keywords = "select * from StuInfo where StuSex like \'" + keyword + "\'";
//            ResultSet rs = Conn.executeQuery(keywords);
//            System.out.println("学号     姓名   性别 年龄 电话      分数");
//            while (rs.next()){
//                System.out.print(rs.getString(1)+"  ");
//                System.out.print(rs.getString(2)+"  ");
//                System.out.print(rs.getString(3)+"  ");
//                System.out.print(rs.getString(4)+"  ");
//                System.out.print(rs.getString(5)+"  ");
//                System.out.println(rs.getString(6));
//            }
//        }catch (SQLException e){
//            System.out.println(e.toString());
//        }
//    }
//}
