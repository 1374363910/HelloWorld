package Task2;

public class PolyList {
    PolyNode head;
    PolyNode current;

    public PolyList(){//初始化
        head = new PolyNode();
        current = head;
        head.next = null;
    }

    public boolean isEmpty() {//判断是否为空
        return head.next == null;
    }

    public void insert(PolyNode node) {//插入结点数值
        current.next = node;
        current = node;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();//构建一个字符串构建器
        PolyNode node = head.next;
        while (node != null) {//构建多项式
            sb.append(node.getCoef() + "x^"+node.getExpn());
            sb.append(" + ");
            node = node.next;
        }
        return sb.substring(0, sb.length() - 2);//返回多项式
    }


    public static PolyList addPoly(PolyList p, PolyList q) {
        PolyNode pnext = p.head.next;//定义p结点
        PolyNode qnext = q.head.next;//定义q结点
        PolyList result = new PolyList();

        while (pnext != null && qnext != null) {
            int pexpn = pnext.getExpn();
            int qexpn = qnext.getExpn();
            double pcoef = pnext.getCoef();
            double qcoef = qnext.getCoef();
            if (pexpn == qexpn) {//判断指数是否相同
                if (pcoef+qcoef != 0) {//判断系数之和是不是为0
                    PolyNode node = new PolyNode(pcoef + qcoef, pexpn);//形成新的项
                    result.insert(node);//插入到结果
                }
                pnext = pnext.next;//下一跳
                qnext = qnext.next;//下一跳
            }else if(pexpn < qexpn){//如果p指数小于q指数
                PolyNode node = new PolyNode(pnext.getCoef(), pnext.getExpn());
                result.insert(node);
                pnext = pnext.next;//插入p结点
            }else{//如果p指数大于q指数
                PolyNode node = new PolyNode(qnext.getCoef(), qnext.getExpn());
                result.insert(node);
                qnext = qnext.next;//插入q结点
            }
        }

        while (pnext != null) {//多余的p结点
            PolyNode node = new PolyNode(pnext.getCoef(), pnext.getExpn());
            result.insert(node);
            pnext = pnext.next;
        }

        while (qnext != null) {//多余的q结点
            PolyNode node = new PolyNode(qnext.getCoef(), qnext.getExpn());
            result.insert(node);
            qnext = qnext.next;
        }
        return result;
    }
}
