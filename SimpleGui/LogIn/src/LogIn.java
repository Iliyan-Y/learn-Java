import javax.swing.*;

public class LogIn {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        userLabel.setBounds(10,20,80,25);
        panel.add(userText);
        panel.add(userLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);
        panel.add(passwordLabel);

    }

}
