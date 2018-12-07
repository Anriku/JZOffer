import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -(o1 - o2);
            }
        }){{
           add(1);
           add(10);
           add(2);
           add(3);
           add(8);
           add(5);
        }};

        treeSet.pollFirst();
        System.out.println(treeSet.size());
        System.out.println(treeSet.first());
    }
}