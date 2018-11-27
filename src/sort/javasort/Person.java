package sort.javasort;

public class Person implements Comparable<Person> {

    int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}
