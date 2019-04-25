package MyStack;

public class MyStack {

    //存数据的数组
    int[] data;

    //栈的最大长度
    private int size;
    //栈顶的位置
    private int top;

    public MyStack(int size) {
        //给栈赋值长度
        this.size = size;
        //数组长度
        data = new int[size];
        //栈顶位置
        top = -1;
    }

    //返回栈顶最大长度
    public int getSize() {
        return size;
    }

    //返回栈顶位置
    public int getTop() {
        return top;
    }


    //判断是否为空栈
    public boolean isEmpty()     {
        return top == -1;
    }


    //判断是否为满栈
    public boolean isFull() {
        return (top+1) == size;
    }


    //入栈操作
    public boolean push(int data) {
        if(isFull()) {
            System.out.println("栈已满!");
            return false;
        } else {
            //栈顶位置+1
            top++;
            //给栈顶放入data
            this.data[top] = data;
            return true;
        }
    }


    //出栈且返回栈顶值
    public int pop() throws Exception{
        if(isEmpty()) {
            //如果为空，抛出异常
            throw new Exception("栈为空!");
        }
        else {
            //返回data[top]值，top-1
            return this.data[top--];
        }
    }


    //返回栈顶值，不出栈
    public int peek() throws Exception{
        if(isEmpty()) {
            //如果为空，抛出异常
            throw new Exception("栈为空!");
        } else {
            //返回栈顶值
            return this.data[getTop()];
        }
    }

    public static void main(String[] args)  {
        //new一个长度为3的栈
        MyStack myStack = new MyStack(3);
        //尝试返回栈顶值，结果为异常
        try {
            System.out.println("现在栈顶值为：" + myStack.peek());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //尝试弹出栈顶值，结果为异常
        try {
            System.out.println("现在栈顶值为：" + myStack.pop());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //入栈
        myStack.push(0);
        myStack.push(1);
        myStack.push(2);
        //超过栈的大小，返回：栈已满
        myStack.push(3);
        //尝试返回栈顶值，结果为：现在的栈顶值为2
        try {
            System.out.println("现在栈顶值为：" + myStack.peek());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //while循环将栈里的值弹出
        while(! myStack.isEmpty()) {
            try {
                System.out.println(myStack.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
