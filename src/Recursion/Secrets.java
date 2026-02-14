package Recursion;

import java.util.PriorityQueue;

public class Secrets {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(6,2,4));
    }

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        PriorityQueue<Person> persons = new PriorityQueue<Person>((a, b) -> (a.entryDay - b.entryDay));
        persons.offer(new Person(1));
        addPersons(persons, 1, delay, forget, n);
        while(!persons.isEmpty()) {
            if(persons.peek().entryDay + forget <= n) {
                persons.poll();
            }
            else{
                break;
            }
        }
        return persons.size() % MOD;
    }

    public static void addPersons(PriorityQueue<Person> persons, int current, int delay, int forget, int n) {
        if(current + delay > n) {
            return;
        }
        for(int i = 0; i < (forget - delay); i++) {
            int newCurrent = current + delay + i;
            if(newCurrent <= n) {
                persons.offer(new Person(newCurrent));
                addPersons(persons, newCurrent , delay, forget, n);
            }
        }
    }

}

class Person {
    int entryDay;
    public Person(int entryDay) {
        this.entryDay = entryDay;
    }
}