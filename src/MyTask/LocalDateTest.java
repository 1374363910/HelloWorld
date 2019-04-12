package MyTask;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class LocalDateTest {
    LocalDate date = LocalDate.now();

//    public int getMonth() {
//        int month = date.getMonthValue();
//        return month;
//    }
//
//    public int getToday() {
//        int today = date.getDayOfMonth();
//        return today;
//    }

    int month = date.getMonthValue();
    int today = date.getDayOfMonth();

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getWeekday() {
        //当前日期减去today-1天，即调到月首
        //minusDays(x)：减去x天 minusXXX类似
        date = date.minusDays(today-1);
        //得到date的星期数
        DayOfWeek weekday = date.getDayOfWeek();
        //将星期数转为int型
        int value = weekday.getValue();
        return value;
    }

    public void printDate(int a){
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < a; i++) {
            System.out.print("   ");
        }
        while (date.getMonthValue() == month){
            System.out.printf("%3d",date.getDayOfMonth());
            if (date.getDayOfMonth()==today){
                System.out.print("*");
            }
            else
                System.out.print(" ");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue()==1){
                System.out.println();
            }
        }
//        if (date.getDayOfWeek().getValue()!=1){
//            System.out.println();
//        }
    }

    public static void main(String[] args) {
        LocalDateTest test = new LocalDateTest();
        //test.setDate(LocalDate.now());
        test.printDate(test.getWeekday());
        //System.out.println(test.getWeekday());
    }
}
