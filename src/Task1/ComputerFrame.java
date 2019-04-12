package Task1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ComputerFrame extends Frame implements ActionListener{
    TextField textOne,textTwo,textResult;
    Button getProblem,giveAnswer;
    Label operatorLabel,message;
    Teacher teacher;
    ComputerFrame(String s){
        super(s);
        teacher = new Teacher();
        setLayout(new FlowLayout());
        textOne = new TextField(10);//创建textOne，其可见字符长度是10
        textTwo = new TextField(10);//创建textTwo，其可见字符长度是10
        textResult = new TextField(10);//创建textResult，其可见字符长度是10
        operatorLabel = new Label("+");
        message = new Label("你还没有回答呢");
        getProblem = new Button("获取题目");
        giveAnswer = new Button("确认答案");
        add(getProblem);
        add(textOne);
        add(operatorLabel);
        add(textTwo);
        add(new Label("="));
        add(textResult);
        add(giveAnswer);
        add(message);
        textResult.requestFocus();
        textOne.setEditable(false);
        textTwo.setEditable(false);
        //将当前窗口注册为getProblem的ActionEvent时间监视器
        getProblem.addActionListener(this);
        //将当前窗口注册为giveAnwser的ActionEvent时间监视器
        giveAnswer.addActionListener(this);
        //将当前窗口注册为textResult的ActionEvent时间监视器
        textResult.addActionListener(this);
        setBounds(100,100,450,100);
        setVisible(true);//设置可见性
        validate();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);//退出软件
            }
        }
        );
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==getProblem){//判断事件源是否是getProblem
            int number1 = teacher.giveNumberOne(100);
            int number2 = teacher.giveNumberTwo(100);
            String operator = teacher.giveOperator();
            textOne.setText(""+number1);
            textTwo.setText(""+number2);
            operatorLabel.setText(operator);
            message.setText("请回答");
            textResult.setText(null);
        }
        if (e.getSource()==giveAnswer){//判断事件源是否是giveAnwser
            String answer = textResult.getText();
            try{
                int result = Integer.parseInt(answer);
                if (teacher.getRight(result) == true){
                    message.setText("你回答正确");
                }
                else{
                    message.setText("你回答错误");
                }
            }
            catch (NumberFormatException ex){
                message.setText("请输入数字字符");
            }
        }
        textResult.requestFocus();
        validate();
    }
}
