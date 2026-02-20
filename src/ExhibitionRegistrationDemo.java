import javax.swing.*;
import java.awt.*;

public class ExhibitionRegistrationDemo extends JFrame {
    private JTextField txtRegId;
    private JTextField txtName;
    private JTextField txtFaculty;
    private JTextField txtProjectTitle;
    private JTextField txtContact;
    private JTextField txtEmail;

    public ExhibitionRegistrationDemo() {
        setTitle("VUE Exhibition Registration");
        setSize(520, 360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel form = new JPanel(new GridLayout(7, 2, 8, 8));

        form.add(new JLabel("Registration ID:"));
        txtRegId = new JTextField();
        form.add(txtRegId);

        form.add(new JLabel("Student Name:"));
        txtName = new JTextField();
        form.add(txtName);

        form.add(new JLabel("Faculty:"));
        txtFaculty = new JTextField();
        form.add(txtFaculty);

        form.add(new JLabel("Project Title:"));
        txtProjectTitle = new JTextField();
        form.add(txtProjectTitle);

        form.add(new JLabel("Contact Number:"));
        txtContact = new JTextField();
        form.add(txtContact);

        form.add(new JLabel("Email Address:"));
        txtEmail = new JTextField();
        form.add(txtEmail);

        JButton btnRegister = new JButton("Register");
        JButton btnClear = new JButton("Clear");
        JButton btnExit = new JButton("Exit");

        form.add(btnRegister);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        buttonPanel.add(btnClear);
        buttonPanel.add(btnExit);
        form.add(buttonPanel);

        add(form, BorderLayout.CENTER);

        // Pre-fill sample data for screenshot
        txtRegId.setText("REG001");
        txtName.setText("priscilla akello");
        txtFaculty.setText("Science and Technology");
        txtProjectTitle.setText("AI-Powered Student Management System");
        txtContact.setText("+256700123456");
        txtEmail.setText("apriscilla@vu.sc.ug");

        btnRegister.addActionListener(e -> registerParticipant());

        btnClear.addActionListener(e -> {
            txtRegId.setText("");
            txtName.setText("");
            txtFaculty.setText("");
            txtProjectTitle.setText("");
            txtContact.setText("");
            txtEmail.setText("");
        });

        btnExit.addActionListener(e -> System.exit(0));
    }

    private void registerParticipant() {
        if (txtRegId.getText().trim().isEmpty() ||
                txtName.getText().trim().isEmpty() ||
                txtFaculty.getText().trim().isEmpty() ||
                txtProjectTitle.getText().trim().isEmpty() ||
                txtContact.getText().trim().isEmpty() ||
                txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
            return;
        }

        // Demo mode - simulates successful registration without database
        String message = "Participant registered successfully!\n\n" +
                "Registration ID: " + txtRegId.getText() + "\n" +
                "Student Name: " + txtName.getText() + "\n" +
                "Faculty: " + txtFaculty.getText() + "\n" +
                "Project Title: " + txtProjectTitle.getText() + "\n" +
                "Contact: " + txtContact.getText() + "\n" +
                "Email: " + txtEmail.getText();
        
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExhibitionRegistrationDemo().setVisible(true));
    }
}
