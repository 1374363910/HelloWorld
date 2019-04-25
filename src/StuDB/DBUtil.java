package StuDB;

import java.sql.*;

public class DBUtil {
    private static final String sDBDriver = "com.hxtt.sql.access.AccessDriver";
    private static final String sConnStr = "jdbc:Access:///C:/Users/a/IdeaProjects/HelloWorld/StuInfo.accdb/";
    private static final String user = "";
    private static final String pass = "";

    private static Connection connection = null;
    private static Statement statement = null;
    private static PreparedStatement preparedStatement = null;



    //加载驱动，获取数据库连接
    static {
        try {
            Class.forName(sDBDriver);
            connection = DriverManager.getConnection(sConnStr, user, pass);
        } catch (ClassNotFoundException e) {
            System.err.println("加载驱动程序失败：" + e.getMessage());
        } catch (SQLException e){
            System.err.println("获取数据库连接失败：" + e.getMessage());
        }
    }

    //连接数据库
    public static Connection getConnection(){
        return connection;
    }

    //获取查询结果
    public ResultSet executeQuery(String s){
        try {
            getConnection();
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(s);
            return resultSet;
        }catch (SQLException e){
            System.err.println("查询失败："+e.getMessage());
            return null;
        }
    }

    //插入数据
    public void insertDB(Student student){
        getConnection();
        //SQL语句插入values到StuInfo
        String sql = "insert into StuInfo(StuID,StuName,StuSex,StuAge,StuTel,JavaGrade) values (?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            //将student里的StuID放入第一个问号
            preparedStatement.setInt(1,student.getStuID());
            preparedStatement.setString(2,student.getStuName());
            preparedStatement.setString(3,student.getStuSex());
            preparedStatement.setInt(4,student.getStuAge());
            preparedStatement.setString(5,student.getStuTel());
            preparedStatement.setInt(6,student.getJavaGrade());

            //更新数据库
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //根据学生ID修改学生信息
    public void changeDB(Student student){
        getConnection();
        //根据StuID修改学生信息
        String sql = "update StuInfo set StuName=?,StuSex=?,StuAge=?,StuTel=?,JavaGrade=? where StuID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            //将student的StuID放到SQL语句的第六个问号的位置
            preparedStatement.setInt(6,student.getStuID());
            preparedStatement.setString(1,student.getStuName());
            preparedStatement.setString(2,student.getStuSex());
            preparedStatement.setInt(3,student.getStuAge());
            preparedStatement.setString(4,student.getStuTel());
            preparedStatement.setInt(5,student.getJavaGrade());

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据学生ID删除学生信息
    public void deleteDB(int StuID){
        try {
            getConnection();
            //SQL语句在StuInfo删除StuID为某某的数据
            String sql = "delete from StuInfo where StuID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,StuID);

            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //测试
    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
        Student student = new Student(170003,"重负","男",12,"12345432",12);
        dbUtil.changeDB(student);
        try {
            String input = "select * from StuInfo";
            ResultSet resultSet = dbUtil.executeQuery(input);
            System.out.println("学号     姓名   性别 年龄 电话      分数");
            while (resultSet.next()) {
                System.out.print(resultSet.getString(1) + "  ");
                System.out.print(resultSet.getString(2) + "  ");
                System.out.print(resultSet.getString(3) + "  ");
                System.out.print(resultSet.getString(4) + "  ");
                System.out.print(resultSet.getString(5) + "  ");
                System.out.println(resultSet.getString(6));

            }
        }catch (SQLException e){
            System.err.println(e.toString());
        }



    }
}
