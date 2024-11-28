/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication22;

/**
 *
 * @author LamHoang
 */
public class Student {
    private int id;
    private String name;
    private double score;

    public Student(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getClassification() {
        if (score >= 0 && score < 5.0) return "Fail";
        if (score >= 5.0 && score < 6.5) return "Medium";
        if (score >= 6.5 && score < 7.5) return "Good";
        if (score >= 7.5 && score < 9.0) return "Very Good";
        if (score >= 9.0 && score <= 10.0) return "Excellent";
        return "Invalid";
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Score: " + score + ", Classification: " + getClassification();
    }
}