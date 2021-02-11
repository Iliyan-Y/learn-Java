import javax.swing.*;
import java.awt.*;

public class Box {
    public Box() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BOxzs");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    new Box();
    }
}
