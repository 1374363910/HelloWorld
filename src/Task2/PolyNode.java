package Task2;

public class PolyNode{
    private double coef;//系数
    private int expn;//指数
    public PolyNode next;

    public PolyNode() {//初始值
        this(0, 0);
    }

    public PolyNode(double coef, int expn) {//给结点赋值
        this.coef = coef;
        this.expn = expn;
    }

    public double getCoef() {//返回系数
        return coef;
    }

    public void setCoef(double coef) {//设置系数
        this.coef = coef;
    }

    public int getExpn() {//返回指数
        return expn;
    }

    public void setExpn(int expn) {//设置指数
        this.expn = expn;
    }
}
