package Task3;

public class ListNode {
    //设置结点
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
        this.next = null;
    }
    //增加结点
    void add(ListNode a){
        ListNode p = this;
        //如果p的下个结点为空，则跳到下一结点，直至为空
        //for (;p.next!=null;p=p.next);
        while (p.next!=null){
            p=p.next;
        }
        //给空的p.next赋值
        p.next = a;
    }
    //将链表转成字符串
    public String toString(){
        String str = new String();
        ListNode p = this;
        //将所有结点连起来转成字符串
        while (p!=null){
            str+=Integer.toString(p.val)+" ";
            p = p.next;
        }
        return str;
    }
    //反转链表
    public ListNode reverseList() {
        ListNode p = this;
        ListNode next = null;
        ListNode pre = null;

        while (p != null) {
            //将p.next赋值给next变量，也就是说next指向了节点2，先将节点2保存起来。
            next = p.next;
            //将pre变量赋值给了p.next，即节点1指向了null。
            p.next = pre;
            //将p赋值给了pre，即pre指向节点1，将节点1设为“上一个节点”。
            pre = p;
            //将next赋值给p，即p指向了节点2。将节点2设置为“头结点”。
            p = next;
        }
        return pre;
    }
}

