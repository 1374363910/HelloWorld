package Task2;

public class PolyTest {
    public static void main(String[] args) {

        PolyList p1 = new PolyList();
        p1.insert(new PolyNode(2, 2));
        p1.insert(new PolyNode(100, 4));
        p1.insert(new PolyNode(45, 5));
        p1.insert(new PolyNode(3, 20));
        System.out.println("p1=" + p1.toString());


        PolyList p2 = new PolyList();
        p2.insert(new PolyNode(8, 2));
        p2.insert(new PolyNode(7, 3));
        p2.insert(new PolyNode(4, 4));
        p2.insert(new PolyNode(6, 18));
        p2.insert(new PolyNode(7, 20));
        System.out.println("p2=" + p2.toString());


        PolyList resultList1 = PolyList.addPoly(p1, p2);
        System.out.println("p1+p2=" + resultList1.toString());

        System.out.println();

    }
}