package Task1;

import java.util.Calendar;

public class CalendarBean {
    String day[];
    int year=2010,month=0;

    public void setYear(int year) {
        this.year = year;//对成员变量year赋值
    }

    public int getYear() {
        return year;
    }

    public void setMonth(int mouth) {
        this.month = mouth;//对成员变量mouth赋值
    }

    public int getMonth() {
        return month;
    }

    public String[] getCalendar() {
        String a[] = new String[42];
        Calendar myCalendar = Calendar.getInstance();
        myCalendar.set(year,month-1,1);
        int week = myCalendar.get(Calendar.DAY_OF_WEEK)-1;
        int day = 0;
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){//月份为1、3、5、7、8、10、12
            day = 31;
        }
        if(month==4||month==6||month==9||month==11){
            day = 30;
        }
        if(month==2){//判断是否是闰年
            if(year%400==0||year%4==0&&year%100==0){
                day = 29;
            }
            else {
                day = 28;
            }
        }
        for (int i = week,n = 1; i < week+day; i++) {
            a[i] = String.valueOf(n);
            n++;
        }
        return a;
    }
}
