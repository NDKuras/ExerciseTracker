package a9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * The {@code LoginFrame} class provides a dialog window for user authentication.
 * It includes fields for entering a username and password, and provides
 * options to log in or cancel.
 * <p>
 * The class is implemented as a singleton via the {@link #V(JFrame)} method.
 */
class LoginFrame extends JDialog {
    private static final long serialVersionUID = 1L; // Add this line
    private static LoginFrame v;

    /**
     * Returns the singleton instance of the {@code LoginFrame}, creating it if necessary.
     *
     * @param parent The parent frame to associate the dialog with.
     * @return The singleton instance of the {@code LoginFrame}.
     */
    public static LoginFrame V(JFrame parent) {
        if (v == null)
            v = new LoginFrame(parent);
        return v;
    }

    // Labels for username and password fields
    private final JLabel lblUsername = new JLabel("Username");
    private final JLabel lblPassword = new JLabel("Password");

    // Input fields for username and password
    private final JTextField txtUsername = new JTextField(15);
    private final JPasswordField txtPassword = new JPasswordField();

    // Buttons for login and cancel actions
    private final JButton btnLogin = new JButton("Login");
    private final JButton btnCancel = new JButton("Cancel");

    /**
     * Default constructor for {@code LoginFrame}, initializing the dialog without a parent.
     */
    private LoginFrame() {
        this(null);
    }

    /**
     * Constructs the {@code LoginFrame} and initializes the dialog components.
     *
     * @param parent The parent frame to associate the dialog with.
     */
    private LoginFrame(final JFrame parent) {
        super(parent, "Login Window", true);
        setLayout(new BorderLayout());

        // Center panel containing username and password fields
        JPanel centerPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        centerPanel.add(lblUsername);
        centerPanel.add(txtUsername);
        centerPanel.add(lblPassword);
        centerPanel.add(txtPassword);

        // Button panel containing login and cancel buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLogin);
        buttonPanel.add(btnCancel);

        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        // Event handler for the login button
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strPassword = String.valueOf(txtPassword.getPassword());
                String strUsername = txtUsername.getText().trim();

                if (verifyLogin(strUsername, strPassword)) {
                    parent.setVisible(true);
                    ((ExerciseTrackerGUI) parent).enableAllFields();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect username/password", "Login",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

            /**
             * Verifies the entered username and password.
             *
             * @param strUsername The entered username.
             * @param strPassword The entered password.
             * @return {@code true} if the login credentials are correct; {@code false} otherwise.
             */
            private boolean verifyLogin(String strUsername, String strPassword) {
                return strUsername.equals("ndkuras") && strPassword.equals("password123");
            }
        });

        // Event handler for the cancel button
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtPassword.setText("");
                txtUsername.setText("");
                setVisible(false);
            }
        });
    }
}
