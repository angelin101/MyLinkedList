import java.util.*;

/**
 * Created by Ангелин on 13.08.2015.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new MyLinkedList<>();
        Add:
        {
            list.add(5);
            list.add(6);
            list.add(9);
            list.add(25);
            list.add(28);
            list.add(0, 3);
            list.add(3, 2);
        }

        PrintList:
        {
            int numEl = 1;
            System.out.println(numEl + " element - " + list.get(numEl));
            System.out.println("size - " + list.size());
            System.out.println(list);
            System.out.println();
        }

        /*RemoveObject:
        {
            System.out.println("RemoveObject");
            System.out.println("Remove is - "+list.remove(new Integer(6)));
            System.out.println("Remove is - " +list.remove(new Integer(25)));
            System.out.println("size - " + list.size());
            System.out.println(list);
            System.out.println();
        }*/

        /*RemoveWithIndex:
        {
            System.out.println("RemoveWithIndex");
            int remIndex = 5;
            Integer res = list.remove(remIndex);
            System.out.println("Remove " + remIndex + " element - " + res);
            System.out.println("size - " + list.size());
            System.out.println(list);
        }*/

        /*ClearAndIsEmpty:{
            System.out.println("ClearAndIsEmpty");
            System.out.println("before:");
            System.out.println(list);
            System.out.println(list.size());
            System.out.println(list.isEmpty());
            list.clear();
            System.out.println();
            System.out.println("under:");
            System.out.println(list);
            System.out.println(list.size());
            System.out.println(list.isEmpty());
        }*/

        /*Contains:{
            System.out.println(list.contains(9));
        }*/

       /* Set:{
            System.out.println("SET");
            System.out.println("Return - "+list.set(5, 36));
            System.out.println("size - " + list.size());
            System.out.println(list);
        }*/
    }
}
