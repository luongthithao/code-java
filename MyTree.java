/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication22;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LamHoang
 */
public class MyTree {
    private Node root;

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node node, Student student) {
        if (node == null) {
            return new Node(student);
        }
        if (student.getId() < node.getStudent().getId()) {
            node.setLeft(insertRec(node.getLeft(), student));
        } else if (student.getId() > node.getStudent().getId()) {
            node.setRight(insertRec(node.getRight(), student));
        }
        return node;
    }

    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.getLeft());
            System.out.println(node.getStudent());
            inorderRec(node.getRight());
        }
    }

    public Node search(int id) {
        return searchRec(root, id);
    }

    private Node searchRec(Node node, int id) {
        if (node == null || node.getStudent().getId() == id) {
            return node;
        }
        if (id < node.getStudent().getId()) {
            return searchRec(node.getLeft(), id);
        }
        return searchRec(node.getRight(), id);
    }

    public void updateStudent(int id, String newName, double newScore) {
        Node node = search(id);
        if (node != null) {
            node.getStudent().setName(newName);
            node.getStudent().setScore(newScore);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void deleteStudent(int id) {
        root = deleteRec(root, id);
    }

    private Node deleteRec(Node node, int id) {
        if (node == null) return null;

        if (id < node.getStudent().getId()) {
            node.setLeft(deleteRec(node.getLeft(), id));
        } else if (id > node.getStudent().getId()) {
            node.setRight(deleteRec(node.getRight(), id));
        } else {
            if (node.getLeft() == null) return node.getRight();
            if (node.getRight() == null) return node.getLeft();

            Node minNode = findMin(node.getRight());
            node.getStudent().setName(minNode.getStudent().getName());
            node.getStudent().setScore(minNode.getStudent().getScore());
            node.setRight(deleteRec(node.getRight(), minNode.getStudent().getId()));
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public void bubbleSortByScore() {
        List<Student> students = new ArrayList<>();
        collectStudents(root, students);

        students.sort((s1, s2) -> Double.compare(s1.getScore(), s2.getScore()));

        System.out.println("\nStudents sorted by score:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void collectStudents(Node node, List<Student> students) {
        if (node != null) {
            collectStudents(node.getLeft(), students);
            students.add(node.getStudent());
            collectStudents(node.getRight(), students);
        }
    }

    public void printClassificationStats() {
        int[] counts = new int[5]; 
        countClassifications(root, counts);
        System.out.println("\nClassification Statistics:");
        System.out.println("Fail: " + counts[0]);
        System.out.println("Medium: " + counts[1]);
        System.out.println("Good: " + counts[2]);
        System.out.println("Very Good: " + counts[3]);
        System.out.println("Excellent: " + counts[4]);
    }

    private void countClassifications(Node node, int[] counts) {
        if (node == null) return;

        double score = node.getStudent().getScore();
        if (score >= 0 && score < 5.0) counts[0]++;
        else if (score >= 5.0 && score < 6.5) counts[1]++;
        else if (score >= 6.5 && score < 7.5) counts[2]++;
        else if (score >= 7.5 && score < 9.0) counts[3]++;
        else if (score >= 9.0 && score <= 10.0) counts[4]++;

        countClassifications(node.getLeft(), counts);
        countClassifications(node.getRight(), counts);
    }
}