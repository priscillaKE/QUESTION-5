import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExhibitionRegistrationApp extends JFrame {
    private JTextField txtRegId;
    private JTextField txtName;
    private JTextField txtFaculty;
    private JTextField txtProjectTitle;
    private JTextField txtContact;
    private JTextField txtEmail;

    private static final String DB_URL = "jdbc:ucanaccess://C:/VUE_Exhibition/VUE_Exhibition.accdb";

    public ExhibitionRegistrationApp() {
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

        String sql = "INSERT INTO Participants (RegistrationID, StudentName, Faculty, ProjectTitle, ContactNumber, EmailAddress) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, txtRegId.getText().trim());
            statement.setString(2, txtName.getText().trim());
            statement.setString(3, txtFaculty.getText().trim());
            statement.setString(4, txtProjectTitle.getText().trim());
            statement.setString(5, txtContact.getText().trim());
            statement.setString(6, txtEmail.getText().trim());

            int rows = statement.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Participant registered successfully.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExhibitionRegistrationApp().setVisible(true));
    }
}
