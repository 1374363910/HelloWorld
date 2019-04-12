//package StuDB;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class StuDB {
//    public List query(){
//        List stuList = new ArrayList();
//
//        //获取数据库连接
//        Connection connection = null;
//        ResultSet resultSet = null;
//        PreparedStatement preparedStatement = null;
//
//        try {
//            connection = DBUtil.getConnection();
//
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("select StuID,StuName,StuSex,StuAge,StuTel,JavaGrade from StuInfo");
//
//            //通过数据库的连接操作数据库，实现增删改查
//            preparedStatement = connection.prepareStatement(stringBuilder.toString());
//
//            resultSet = preparedStatement.executeQuery();
//            StuInfo stuInfo = null;
//            while (resultSet.next()){
//                stuInfo = new StuInfo();
//                stuInfo.setStuID(resultSet.getInt("StuID"));
//                stuInfo.setStuName(resultSet.getString("StuName"));
//                stuInfo.setStuSex(resultSet.getString("StuSex"));
//                stuInfo.setStuAge(resultSet.getInt("StuAge"));
//                stuInfo.setStuTel(resultSet.getString("StuTel"));
//                stuInfo.setJavaGrade(resultSet.getInt("JavaGarde"));
//
//                stuList.add(stuInfo);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }finally {
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//            }catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
//        return stuList;
//    }
//
//
//}
