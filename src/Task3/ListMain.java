package Task3;

public class ListMain {
    public static void main(String[] args) {
        //设置头结点
        ListNode head = new ListNode(1);
        ListNode l = null;
        //用for循环添加结点
        for (int i = 2; i < 12; i++) {
            l = new ListNode(i);
            head.add(l);
        }
        System.out.println("输入的链表："+head.toString());
        System.out.println("反转的链表："+head.reverseList().toString());
    }
}
