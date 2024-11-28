/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication22;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author LamHoang
 */
public class Classroom {
    private String className;
    private BinarySearchTree studentTree; // Lưu trữ sinh viên theo cây nhị phân
    private static Map<String, Classroom> allClasses = new HashMap<>(); // Lưu tất cả các lớp học

    // Constructor
    public Classroom(String className) {
        this.className = className;
        this.studentTree = new BinarySearchTree();
        Classroom put = allClasses.put(className, this); // Đảm bảo lớp được thêm vào danh sách tất cả các lớp học
    }

    // Add students to class
    public void addStudent(Student student) {
        studentTree.insert(student);
        System.out.println("Student added to class " + className + ": " + student);
    }

    // Remove student from class
    public void deleteStudent(int id) {
        studentTree.deleteStudent(id);
        System.out.println("Student deleted from class " + className + " if existed.");
    }

    // Update student information in class
    public void updateStudent(int id, String newName, double newScore) {
        studentTree.updateStudent(id, newName, newScore);
    }

    // Show all students in class
    public void displayAllStudents() {
        System.out.println("Students in class " + className + ":");
        studentTree.inorder();
    }

    // Display classification statistics in class
    public void displayClassificationStats() {
        System.out.println("Classification Statistics for class " + className + ":");
        studentTree.printClassificationStats();
    }

    // Search students by ID
    public void searchStudent(int id) {
        Node result = studentTree.search(id);  // Tìm kiếm sinh viên theo ID trong cây nhị phân
        if (result != null) {
            System.out.println("Student found in class " + className + ": " + result.getStudent());
        } else {
            System.out.println("Student with ID " + id + " not found in class " + className);
        }
    }

    // Get a list of all classes
    public static void displayAllClasses() {
        if (allClasses.isEmpty()) {
            System.out.println("No classes available.");
            return;
        }
        System.out.println("Available classes:");
        for (String className : allClasses.keySet()) {
            System.out.println("- " + className);
        }
    }

    // Access classes by name
    public static Classroom getClassroomByName(String className) {
        return allClasses.get(className);
    }

    public String getClassName() {
        return className;
    }
}