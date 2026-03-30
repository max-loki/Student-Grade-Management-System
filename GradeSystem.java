import java.util.Scanner;

class Student {
    String name;
    int[] marks;
    double average;
    char grade;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        calculateResult();
    }

    private void calculateResult() {
        int sum = 0;
        for (int m : marks) sum += m;
        this.average = sum / (double) marks.length;

        if (average >= 90) grade = 'A';
        else if (average >= 75) grade = 'B';
        else if (average >= 50) grade = 'C';
        else grade = 'F';
    }

    public void display() {
        System.out.println("\n--- Student Report ---");
        System.out.println("Name: " + name);
        System.out.println("Average: " + String.format("%.2f", average));
        System.out.println("Final Grade: " + grade);
    }
}

public class GradeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        Student s = new Student(name, marks);
        s.display();
        
        sc.close();
    }
}