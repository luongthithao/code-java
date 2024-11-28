/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication22;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author LamHoang
 */
public class Mani {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                System.out.println("\nClassroom Management System:");
                System.out.println("1. Add New Classroom");
                System.out.println("2. Add Student to Classroom");
                System.out.println("3. Delete Student from Classroom");
                System.out.println("4. Update Student in Classroom");
                System.out.println("5. Display All Students in a Classroom");
                System.out.println("6. Search Student by ID in a Classroom");
                System.out.println("7. Display Classification Statistics for a Classroom");
                System.out.println("8. Display All Classrooms");
                System.out.println("9. Exit");
                System.out.print("Choose an option: ");

                int choice = 0;
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 9.");
                    scanner.next(); // Clear invalid input
                    continue;
                }
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> {
                        // Add new class
                        System.out.print("Enter Classroom Name: ");
                        String className = scanner.nextLine();
                        if (Classroom.getClassroomByName(className) == null) {
                            Classroom classroom = new Classroom(className);
                            System.out.println("Classroom " + className + " created successfully.");
                        } else {
                            System.out.println("Classroom with name " + className + " already exists.");
                        }
                    }
                    case 2 -> {
                        // Add students to class
                        System.out.print("Enter Classroom Name: ");
                        String className = scanner.nextLine();
                        Classroom classroom = Classroom.getClassroomByName(className);
                        if (classroom == null) {
                            System.out.println("Classroom not found.");
                        } else {
                            System.out.print("Enter Student ID: ");
                            int id = 0;
                            try {
                                id = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input for Student ID. Please enter a valid integer.");
                                scanner.next(); // Clear invalid input
                                continue;
                            }
                            scanner.nextLine(); // Consume newline

                            System.out.print("Enter Student Name (letters only): ");
                            String name = scanner.nextLine();
                            if (!name.matches("[a-zA-Z\\s]+")) {
                                System.out.println("Invalid name. Please use letters only.");
                                continue;
                            }

                            System.out.print("Enter Student Score (0 to 10): ");
                            double score = 0.0;
                            try {
                                score = scanner.nextDouble();
                                if (score < 0 || score > 10) {
                                    System.out.println("Score must be between 0 and 10.");
                                    continue;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input for score. Please enter a number.");
                                scanner.next(); // Clear invalid input
                                continue;
                            }
                            scanner.nextLine(); // Consume newline

                            Student student = new Student(id, name, score);
                            classroom.addStudent(student);
                        }
                    }
                    case 3 -> {
                        // Remove student from class
                        System.out.print("Enter Classroom Name: ");
                        String className = scanner.nextLine();
                        Classroom classroom = Classroom.getClassroomByName(className);
                        if (classroom == null) {
                            System.out.println("Classroom not found.");
                        } else {
                            System.out.print("Enter Student ID to delete: ");
                            int id = 0;
                            try {
                                id = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input for Student ID. Please enter a valid integer.");
                                scanner.next(); // Clear invalid input
                                continue;
                            }
                            classroom.deleteStudent(id);
                        }
                    }
                    case 4 -> {
                        // Update student information in class
                        System.out.print("Enter Classroom Name: ");
                        String className = scanner.nextLine();
                        Classroom classroom = Classroom.getClassroomByName(className);
                        if (classroom == null) {
                            System.out.println("Classroom not found.");
                        } else {
                            System.out.print("Enter Student ID to update: ");
                            int id = 0;
                            try {
                                id = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input for Student ID. Please enter a valid integer.");
                                scanner.next(); // Clear invalid input
                                continue;
                            }
                            scanner.nextLine(); // Consume newline

                            System.out.print("Enter New Name: ");
                            String newName = scanner.nextLine();

                            System.out.print("Enter New Score: ");
                            double newScore = 0.0;
                            try {
                                newScore = scanner.nextDouble();
                                if (newScore < 0 || newScore > 10) {
                                    System.out.println("Score must be between 0 and 10.");
                                    continue;
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input for score. Please enter a number.");
                                scanner.next(); // Clear invalid input
                                continue;
                            }
                            classroom.updateStudent(id, newName, newScore);
                        }
                    }
                    case 5 -> {
                        // Show all students in the class
                        System.out.print("Enter Classroom Name: ");
                        String className = scanner.nextLine();
                        Classroom classroom = Classroom.getClassroomByName(className);
                        if (classroom == null) {
                            System.out.println("Classroom not found.");
                        } else {
                            classroom.displayAllStudents();
                        }
                    }
                    case 6 -> {
                        // Search students by ID
                        System.out.print("Enter Classroom Name: ");
                        String className = scanner.nextLine();
                        Classroom classroom = Classroom.getClassroomByName(className);
                        if (classroom == null) {
                            System.out.println("Classroom not found.");
                        } else {
                            System.out.print("Enter Student ID to search: ");
                            int id = 0;
                            try {
                                id = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input for Student ID. Please enter a valid integer.");
                                scanner.next(); // Clear invalid input
                                continue;
                            }
                            classroom.searchStudent(id);
                        }
                    }
                    case 7 -> {
                        // Displaying classification statistics in the classroom
                        System.out.print("Enter Classroom Name: ");
                        String className = scanner.nextLine();
                        Classroom classroom = Classroom.getClassroomByName(className);
                        if (classroom == null) {
                            System.out.println("Classroom not found.");
                        } else {
                            classroom.displayClassificationStats();
                        }
                    }
                    case 8 -> {
                        // Show all classes
                        Classroom.displayAllClasses();
                    }
                    case 9 -> {
                        // Thoát chương trình
                        System.out.println("Exiting...");
                        exit = true;
                    }
                    default -> System.out.println("Invalid choice. Please choose a valid option.");
                }
            }
        }
    }
}