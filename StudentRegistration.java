import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends Frame implements ActionListener {

    Label nameLabel;
    Label rollLabel;
    Label courseLabel;

    TextField nameField;
    TextField rollField;
    TextField courseField;

    Button submitButton;

    StudentRegistration() {

        setTitle("Student Registration Form");

        setLayout(new FlowLayout());

        nameLabel = new Label("Name:");
        nameField = new TextField(20);

        rollLabel = new Label("Roll No:");
        rollField = new TextField(20);

        courseLabel = new Label("Course:");
        courseField = new TextField(20);

        submitButton = new Button("Submit");

        add(nameLabel);
        add(nameField);

        add(rollLabel);
        add(rollField);

        add(courseLabel);
        add(courseField);

        add(submitButton);

        submitButton.addActionListener(this);

        setSize(350, 250);
        setVisible(true);

        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {

        String name = nameField.getText();
        String rollNo = rollField.getText();
        String course = courseField.getText();

        String message =
                "Student Registered Successfully!\n\n"
                + "Name: " + name + "\n"
                + "Roll No: " + rollNo + "\n"
                + "Course: " + course;

        Dialog dialog = new Dialog(this, "Registration Successful", true);

        dialog.setLayout(new FlowLayout());

        TextArea details = new TextArea(message, 6, 35);
        Button okButton = new Button("OK");

        dialog.add(details);
        dialog.add(okButton);

        okButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        dialog.setSize(350, 200);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {

        new StudentRegistration();
    }
}
