package src.Week8;

import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */


class Priorities {
    public List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pq = new PriorityQueue<>(
                Comparator.comparingDouble(Student::getCgpa).reversed()
                        .thenComparing(Student::getName)
                        .thenComparingInt(Student::getId)
        );

        for (String event : events) {
            String[] arrEvent = event.split(" ", -1);
            if (arrEvent[0].equals("ENTER")) {
                pq.offer(new Student(Integer.parseInt(arrEvent[3]),
                        arrEvent[1],
                        Double.parseDouble(arrEvent[2])));
            } else if (arrEvent[0].equals("SERVED")) {
                pq.poll();
            }
        }

        List<Student> result = new ArrayList<>(pq);
        result.sort(Comparator.comparingDouble(Student::getCgpa).reversed()
                .thenComparing(Student::getName)
                .thenComparingInt(Student::getId));

        return result;
    }
}

class Student {
    int id;
    String name;
    double cgpa;
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }


}


public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}