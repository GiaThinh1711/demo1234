package demo;

import entity.Student;

import java.util.HashMap;
import java.util.Scanner;

public class Ass {
    static HashMap<String,Student> data = new HashMap<>();
    public static void main(String[] args) {
        generateMenu();
    }
    public static void generateMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Student Manager: ");
            System.out.println("1.Add new student");
            System.out.println("2.Find student by Roll Number ");
            System.out.println("3.Exit");
            System.out.println("---------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    findStudentByRollNumber();
                    break;
                case 3:
                    System.out.println("Bye");
                    break;
                default:
                    System.err.println("Invalid choice");
                    break;
            }
            System.out.println("Enter to continue");
            scanner.nextLine();
            if (choice ==3){
                System.exit(1);
            }
        }
    }
    public static void addStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your Roll Number");
        String rollNumber = scanner.nextLine();
        System.out.println("Please enter your name");
        String name = scanner.nextLine();
        System.out.println("Please enter your email");
        String email = scanner.nextLine();
        int status = 1;
        Student student = new Student(rollNumber,email,name,status);
        data.put(rollNumber,student);
        System.out.println("Action success");
    }
    public static void findStudentByRollNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your roll number: ");
        String rollNumber = scanner.nextLine();
        if(!data.containsKey(rollNumber)){
            System.err.printf("Not found this roll number %s\n",rollNumber);
            return;
        }
        Student foundStudent = data.get(rollNumber);
        System.out.println("Found student with below information: ");
        System.out.println(foundStudent.toString());
    }
}
