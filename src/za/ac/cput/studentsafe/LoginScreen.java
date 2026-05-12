package za.ac.cput.studentsafe;

/**
 * Application:  StudentSafe Accommodation Finder
 * Screen:       Login Screen
 * Description:  Allows students to log in using their university email
 *               and password, or via Student ID verification.
 *
 * Author:       Matthew Smit
 * Student No:   222648767
 * Date:         May 2026
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen extends JFrame {

    private final Color BACKGROUND = Color.WHITE;
    private final Color LIGHT_GREY = new Color(245, 245, 245);
    private final Color BORDER_GREY = new Color(220, 220, 220);
    private final Color BUTTON_GREY = new Color(145, 145, 140);
    private final Color TEXT_DARK = new Color(30, 30, 30);
    private final Color TEXT_LIGHT = new Color(120, 120, 120);

    private final Font TITLE_FONT = new Font("SansSerif", Font.BOLD, 28);
    private final Font SUB_FONT = new Font("SansSerif", Font.PLAIN, 13);
    private final Font LABEL_FONT = new Font("SansSerif", Font.PLAIN, 12);
    private final Font BUTTON_FONT = new Font("SansSerif", Font.BOLD, 14);

    public LoginScreen() {

        setTitle("StudentSafe - Login");
        setSize(390, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(BACKGROUND);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(40, 40, 40, 40));

        
        JPanel logoPanel = new JPanel();
        logoPanel.setPreferredSize(new Dimension(80, 80));
        logoPanel.setMaximumSize(new Dimension(80, 80));
        logoPanel.setBackground(LIGHT_GREY);
        logoPanel.setBorder(new LineBorder(BORDER_GREY, 1, true));
        logoPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel logoText = new JLabel("Logo");
        logoText.setForeground(TEXT_LIGHT);
        logoPanel.add(logoText);

        JLabel title = new JLabel("StudentSafe");
        title.setFont(TITLE_FONT);
        title.setForeground(TEXT_DARK);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Find verified student accommodation");
        subtitle.setFont(SUB_FONT);
        subtitle.setForeground(TEXT_LIGHT);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel emailLabel = new JLabel("Student Email");
        emailLabel.setFont(LABEL_FONT);
        emailLabel.setForeground(TEXT_LIGHT);
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField emailField = new JTextField();
        emailField.setMaximumSize(new Dimension(260, 45));
        emailField.setPreferredSize(new Dimension(260, 45));
        emailField.setBackground(LIGHT_GREY);
        emailField.setBorder(new CompoundBorder(
                new LineBorder(BORDER_GREY, 1, true),
                new EmptyBorder(0, 12, 0, 12)
        ));
        emailField.setFont(new Font("SansSerif", Font.PLAIN, 13));
        emailField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(LABEL_FONT);
        passwordLabel.setForeground(TEXT_LIGHT);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setMaximumSize(new Dimension(260, 45));
        passwordField.setPreferredSize(new Dimension(260, 45));
        passwordField.setBackground(LIGHT_GREY);
        passwordField.setBorder(new CompoundBorder(
                new LineBorder(BORDER_GREY, 1, true),
                new EmptyBorder(0, 12, 0, 12)
        ));
        passwordField.setFont(new Font("SansSerif", Font.PLAIN, 13));
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel forgotPassword = new JLabel("Forgot password?");
        forgotPassword.setFont(new Font("SansSerif", Font.PLAIN, 11));
        forgotPassword.setForeground(TEXT_LIGHT);
        forgotPassword.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loginButton = new JButton("Log In");
        stylePrimaryButton(loginButton);

        JPanel dividerPanel = new JPanel();
        dividerPanel.setBackground(BACKGROUND);
        dividerPanel.setMaximumSize(new Dimension(260, 20));
        dividerPanel.setLayout(new BoxLayout(dividerPanel, BoxLayout.X_AXIS));

        JSeparator left = new JSeparator();
        JSeparator right = new JSeparator();

        JLabel orLabel = new JLabel("OR");
        orLabel.setForeground(TEXT_LIGHT);
        orLabel.setFont(new Font("SansSerif", Font.PLAIN, 11));

        dividerPanel.add(left);
        dividerPanel.add(Box.createHorizontalStrut(10));
        dividerPanel.add(orLabel);
        dividerPanel.add(Box.createHorizontalStrut(10));
        dividerPanel.add(right);

        JButton studentButton = new JButton("Sign in with Student ID");
        styleSecondaryButton(studentButton);

        JPanel signupPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        signupPanel.setBackground(BACKGROUND);

        JLabel noAccount = new JLabel("Don't have an account?");
        noAccount.setForeground(TEXT_LIGHT);
        noAccount.setFont(new Font("SansSerif", Font.PLAIN, 11));

        JLabel signup = new JLabel("Sign Up");
        signup.setForeground(TEXT_DARK);
        signup.setFont(new Font("SansSerif", Font.BOLD, 11));

        signupPanel.add(noAccount);
        signupPanel.add(signup);

        mainPanel.add(logoPanel);
        mainPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(title);
        mainPanel.add(Box.createVerticalStrut(8));

        mainPanel.add(subtitle);
        mainPanel.add(Box.createVerticalStrut(40));

        mainPanel.add(emailLabel);
        mainPanel.add(Box.createVerticalStrut(5));

        mainPanel.add(emailField);
        mainPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(passwordLabel);
        mainPanel.add(Box.createVerticalStrut(5));

        mainPanel.add(passwordField);
        mainPanel.add(Box.createVerticalStrut(10));

        mainPanel.add(forgotPassword);
        mainPanel.add(Box.createVerticalStrut(25));

        mainPanel.add(loginButton);
        mainPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(dividerPanel);
        mainPanel.add(Box.createVerticalStrut(20));

        mainPanel.add(studentButton);
        mainPanel.add(Box.createVerticalStrut(25));

        mainPanel.add(signupPanel);

        loginButton.addActionListener(e -> {

            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            if(email.isEmpty() || password.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill in all fields.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!"
                );

                new DashboardScreen().setVisible(true);

                dispose();

            }

        });

        studentButton.addActionListener(e -> {

            JOptionPane.showMessageDialog(
                    this,
                    "Student ID login coming soon."
            );

        });

        signup.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                JOptionPane.showMessageDialog(
                        LoginScreen.this,
                        "Sign Up screen coming soon."
                );

            }

        });

       

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
);

        add(scrollPane);

        add(scrollPane);

        setVisible(true);
    }

    private void stylePrimaryButton(JButton button) {

        button.setMaximumSize(new Dimension(260, 50));
        button.setPreferredSize(new Dimension(260, 50));

        button.setBackground(BUTTON_GREY);
        button.setForeground(Color.WHITE);

        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.setFont(BUTTON_FONT);

        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void styleSecondaryButton(JButton button) {

        button.setMaximumSize(new Dimension(260, 50));
        button.setPreferredSize(new Dimension(260, 50));

        button.setBackground(Color.WHITE);
        button.setForeground(TEXT_DARK);

        button.setFocusPainted(false);

        button.setBorder(new LineBorder(BORDER_GREY, 1, true));

        button.setFont(BUTTON_FONT);

        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new LoginScreen();

        });

    }

}