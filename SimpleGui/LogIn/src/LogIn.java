import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class LogIn implements ActionListener {
    private JTextField userText;
    private JPasswordField passwordText;
    private JLabel message;

    public  LogIn() {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        userLabel.setBounds(10,20,80,25);
        panel.add(userText);
        panel.add(userLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        passwordText = new JPasswordField();
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);
        panel.add(passwordLabel);

        JButton button = new JButton("Login");
        button.setBounds(50,80,80,25);
        button.addActionListener(this);
        panel.add(button);

        message = new JLabel();
        message.setBounds(10,110,300, 25);
        panel.add(message);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String acc = userText.getText();
        char[] pass = passwordText.getPassword();

        JPasswordField defaultPass = new JPasswordField("admin");
        char[] expected = defaultPass.getPassword();


        if (acc.equals("admin") && Arrays.equals(pass, expected)) {
            message.setText("Successful log in !");
        } else {
            message.setText("Please try again later");
        }
    }

    public static void main(String[] args) {
        new LogIn();
    }
}
