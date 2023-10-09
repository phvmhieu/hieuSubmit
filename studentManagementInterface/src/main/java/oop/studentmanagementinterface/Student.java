/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop.studentmanagementinterface;

/**
 *
 * @author hieu
 */
class Student {
    private String fullName;
    private int age;
    private double score;

    public Student(String fullName, int age, double score) {
        this.fullName = fullName;
        this.age = age;
        this.score = score;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Name: " + fullName + ", Age: " + age + ", Score: " + score;
    }
}