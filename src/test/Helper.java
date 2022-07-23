package test;

import linkList.MyList;
import linkList.Node;

/**
 * 测试
 * @author Jay Zhou
 * @version 1.0
 */
public class Helper {
    public static void helper() throws IndexOutOfBoundsException{
        try {
            Node<String> n1 = new Node<String>("艾欧尼亚");
            Node<String> n2 = new Node<String>("祖安");
            Node<String> n3 = new Node<String>("弗雷尔卓德");
            Node<String> n4 = new Node<String>("皮尔特沃夫");
            Node<String> n5 = new Node<String>("水晶之痕");

            //设置各个节点之间的关系
            n1.setPre(null);
            n1.setNext(n2);

            n2.setPre(n1);
            n2.setNext(n3);

            n3.setPre(n2);
            n3.setNext(n4);

            n4.setPre(n3);
            n4.setNext(n5);

            n5.setPre(n4);
            n5.setNext(null);

            MyList<String> myList = new MyList<String>(n1, n5);

            //检查traversal()方法
            myList.traversal();
            System.out.println();

            //检查size()方法
            int j = myList.size();
            System.out.println(j);

            //检查search()方法
            int i = myList.search("祖安");
            System.out.println(i);

            //检查get()方法
            System.out.println(myList.get(3).getData());



            //检查delete()方法
            myList.delete(3);
            myList.delete(1);
            myList.traversal();

            //检查insert()方法
            System.out.println();
            myList.insert("巨神峰",3);
            myList.traversal();

            //检查reversal()方法
            System.out.println();
            myList.reversal();



        }catch (IndexOutOfBoundsException e){
            throw e;
        }

    }
}
