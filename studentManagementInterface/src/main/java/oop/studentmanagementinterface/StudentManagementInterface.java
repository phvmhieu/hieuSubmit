/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package oop.studentmanagementinterface;

/**
 *
 * @author hieu
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentManagementInterface extends JFrame {
    private List<Student> studentList = new ArrayList<>();
    private DefaultListModel<String> studentListModel;
    private JList<String> studentListUI;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentManagementInterface frame = new StudentManagementInterface();
            frame.setTitle("Student Management Interface");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setVisible(true);
        });
    }

    public StudentManagementInterface() {
        initComponents();
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JPanel buttonPanel = new JPanel(new FlowLayout());

        JLabel fullNameLabel = new JLabel("Full Name:");
        JTextField fullNameTextField = new JTextField();

        JLabel ageLabel = new JLabel("Age:");
        JTextField ageTextField = new JTextField();

        JLabel scoreLabel = new JLabel("Score:");
        JTextField scoreTextField = new JTextField();

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullName = fullNameTextField.getText();
                int age = Integer.parseInt(ageTextField.getText());
                double score = Double.parseDouble(scoreTextField.getText());

                Student student = new Student(fullName, age, score);
                studentList.add(student);
                updateStudentList();
            }
        });

        studentListModel = new DefaultListModel<>();
        studentListUI = new JList<>(studentListModel);

        JButton showButton = new JButton("Show Student List");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateStudentList();
            }
        });

        JButton sortButton = new JButton("Sort Student List");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortStudentListByScore();
            }
        });

        inputPanel.add(fullNameLabel);
        inputPanel.add(fullNameTextField);
        inputPanel.add(ageLabel);
        inputPanel.add(ageTextField);
        inputPanel.add(scoreLabel);
        inputPanel.add(scoreTextField);
        inputPanel.add(addButton);

        buttonPanel.add(showButton);
        buttonPanel.add(sortButton);

        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(studentListUI), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
    }

    private void updateStudentList() {
        studentListModel.clear();
        for (Student student : studentList) {
            studentListModel.addElement(student.toString());
        }
    }

    private void sortStudentListByScore() {
        Collections.sort(studentList, Comparator.comparingDouble(Student::getScore));
        updateStudentList();
    }
}

