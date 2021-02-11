import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Box implements ActionListener {
    private  int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public Box() {
        frame = new JFrame();
        panel = new JPanel();
        JButton button = new JButton("Click me");
        button.addActionListener(this);
        label = new JLabel("Number of clicks: 0");

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,80,120));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BOxzs");
        frame.pack();


        frame.setVisible(true);
    }

    public static void main(String[] args) {
    new Box();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Number of clicks: " + count);
    }
}
