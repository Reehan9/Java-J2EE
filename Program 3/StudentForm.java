import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentForm extends JFrame {
    private JTextField nameField;
    private JTextField usnField;
    private JTextField ageField;
    private JTextField addressField;
    private JTextField[] sgpaFields;
    private JTextField categoryField;
    private JButton computeButton;
    private JButton doneButton;
    private JButton displayButton;
    private JTextArea studentListTextArea;

    private ArrayList<Student> students;

    public StudentForm() {
        students = new ArrayList<>();
        initComponents();
    }

    private void initComponents() {
        setTitle("Student Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(10, 2));

        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField(20);
        formPanel.add(nameField);

        formPanel.add(new JLabel("USN:"));
        usnField = new JTextField(20);
        formPanel.add(usnField);

        formPanel.add(new JLabel("Age:"));
        ageField = new JTextField(20);
        formPanel.add(ageField);

        formPanel.add(new JLabel("Address:"));
        addressField = new JTextField(20);
        formPanel.add(addressField);

        sgpaFields = new JTextField[8];
        for (int i = 0; i < 8; i++) {
            formPanel.add(new JLabel("Semester " + (i + 1) + " SGPA:"));
            sgpaFields[i] = new JTextField(20);
            formPanel.add(sgpaFields[i]);
        }

        formPanel.add(new JLabel("Category:"));
        categoryField = new JTextField(20);
        formPanel.add(categoryField);

        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        computeButton = new JButton("Compute");
        buttonPanel.add(computeButton);
        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double sum = 0;
                int count = 0;
                for (JTextField sgpaField : sgpaFields) {
                    double sgpa = Double.parseDouble(sgpaField.getText());
                    if (StudentValidator.isValidSgpa(sgpa)) {
                        sum += sgpa;
                        count++;
                    }
                }
                double cgpa = sum / count;
                JOptionPane                .showMessageDialog(StudentForm.this, "CGPA: " + cgpa);
               }
           });
   
           doneButton = new JButton("Done");
           buttonPanel.add(doneButton);
           doneButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   String name = nameField.getText();
                   String usn = usnField.getText();
                   int age = Integer.parseInt(ageField.getText());
                   String address = addressField.getText();
                   String category = categoryField.getText();
                   double[] sgpa = new double[8];
                   for (int i = 0; i < 8; i++) {
                       sgpa[i] = Double.parseDouble(sgpaFields[i].getText());
                   }
   
                   if (StudentValidator.isValidAge(age)) {
                       Student student = new Student(name, usn, age, address, sgpa, category);
                       students.add(student);
                   } else {
                       JOptionPane.showMessageDialog(StudentForm.this, "Invalid age. Please enter a valid age.");
                   }
               }
           });
   
           displayButton = new JButton("Display");
           buttonPanel.add(displayButton);
           displayButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   StringBuilder sb = new StringBuilder();
                   for (Student student : students) {
                       sb.append(student.toString()).append("\n");
                   }
                   studentListTextArea.setText(sb.toString());
               }
           });
   
           add(buttonPanel, BorderLayout.SOUTH);
   
           studentListTextArea = new JTextArea(10, 50);
           JScrollPane scrollPane = new JScrollPane(studentListTextArea);
           add(scrollPane, BorderLayout.EAST);
       }
   }
   
