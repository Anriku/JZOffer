package basicalgorithm.sort.javasort;

import java.util.*;

/**
 * Java自带排序使用
 */
public class JavaSort {

    public static void main(String[] args) {
        listSort();
    }

    private static void listSort() {
        List<Person> list = new ArrayList<Person>() {{
            add(new Person(1));
            add(new Person(10));
            add(new Person(8));
            add(new Person(20));
            add(new Person(32));
        }};

//        // 使用Comparable
//        Collections.basicalgorithm.sort(list);
        // 使用Comparator
        Collections.sort(list, (o1, o2) -> o2.age - o1.age);
        for (Person person :
                list) {
            System.out.println(person);
        }
    }

}
