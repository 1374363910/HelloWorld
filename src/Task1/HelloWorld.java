package Task1;

import java.time.LocalDate;
import java.util.Date;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println();
        //Date类（时间日期）
        Date date = new Date();
        //LocalDate类（日历）
        //当前日期
        LocalDate date1 = LocalDate.now();
        //设置日期
        LocalDate date2 = LocalDate.of(1998,7,5);
        //让birthday指向date2
        LocalDate birthday = date2;
        //将birthday变为字符串
        String s = birthday.toString();
        //给当前日期加上1000天
        LocalDate date3 = date1.plusDays(1000);
        //提取年给整数year
        int year = date1.getYear();
        int month = date1.getMonthValue();
        int day = date1.getDayOfMonth();
        for (int i = 0; i < 3; i++) {
            System.out.println(year+" "+month+" "+day);
        }
        System.out.println(s);
        System.out.println(date3);
    }
}
