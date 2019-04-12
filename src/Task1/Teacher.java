package Task1;

public class Teacher {
    int numberOne,numberTwo;
    String operator="";
    boolean right;
    public int giveNumberOne(int n){
        numberOne=(int)(Math.random()*n);//生成n以内的整数
        return numberOne;
    }
    public int giveNumberTwo(int n){
        numberTwo=(int)(Math.random()*n);//生成n以内的整数
        return numberTwo;
    }

    public String giveOperator() {
        double d=Math.random();//生成随机数
        if(d>0.5)
            operator="+";
        else
            operator="-";
        return operator;
    }

    public boolean getRight(int answer) {
        if(operator=="+"){//判断operator是否是“+”号
            if(answer==numberOne+numberTwo)
                right=true;
            else
                right=false;
        }
        else if (operator=="-"){//判断operator是否是“-”号
            if(answer==numberOne-numberTwo)
                right=true;
            else
                right=false;
        }
        return right;
    }
}
