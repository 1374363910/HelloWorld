package Task1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalendarFrame extends Frame implements ActionListener{
        Label labelDay[]=new Label[42];
        Button titleName[]=new Button[7];
        String name[]={"日","一","二","三","四","五","六"};
        Button nextMonth,previousMonth;
        int year=2011,month=10;
        CalendarBean calendar;
        Label showMessage =new Label("",Label.CENTER);
        public CalendarFrame(){
            Panel pCenter=new Panel();
            pCenter.setLayout(new GridLayout(7,7));//将 pCender 的布局设置为7行7列的GridLayout布局
            for(int i=0;i<7;i++){
                titleName[i]=new Button(name[i]);
                pCenter.add(titleName[i]);//pClender 添加组件titleName[i]
            }
            for(int i=0;i<42;i++){
                labelDay[i]=new Label("",Label.CENTER);
                pCenter.add(labelDay[i]);//pCenter 添加组件 labelDay[i]
            }
            calendar=new CalendarBean();
            calendar.setYear(year);
            calendar.setMonth(month);
            String day[]=calendar.getCalendar();
            for(int i=0;i<42;i++){
                labelDay[i].setText(day[i]);
            }
            nextMonth=new Button("下月");
            previousMonth=new Button("上月");
            nextMonth.addActionListener(this);
            previousMonth.addActionListener(this);
            Panel pNorth=new Panel(), pSouth=new Panel();
            pNorth.add(previousMonth);
            pNorth.add(nextMonth);
            pSouth.add(showMessage);
            showMessage.setText("日历："+calendar.getYear()+"年"+calendar.getMonth()+"月");
            ScrollPane scrollPane=new ScrollPane();
            scrollPane.add(pCenter);
            this.add("Center",pCenter);//窗口添加 scrollPane在中心区域
            this.add("North",pNorth);//窗口添加 pNorth在北面区域
            this.add("South",pSouth);
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==nextMonth) {//获取事件源
                month=month+1;
                if (month>12)
                    month=1;
                calendar.setMonth(month);
                String day[]=calendar.getCalendar();
                for(int i=0;i<42;i++){
                    labelDay[i].setText(day[i]);
                }
            }
            else if(e.getSource()==previousMonth){
                month=month-1;
                if (month<1)
                    month=12;
                calendar.setMonth(month);
                String day[]=calendar.getCalendar();
                for (int i = 0; i < 42; i++) {
                    labelDay[i].setText(day[i]);
                }
            }
            showMessage.setText("日历"+calendar.getYear()+"年"+calendar.getMonth()+"月");
        }
}
