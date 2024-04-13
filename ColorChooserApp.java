import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserApp extends JFrame {
    private Color currentColor = Color.WHITE; // Default color is clear/white

    public ColorChooserApp() {
        super("Color Chooser App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        // Circle Panel
        JPanel circlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(currentColor);
                g.fillOval(10, 10, 100, 100); // Draw the circle
            }
        };
        circlePanel.setPreferredSize(new Dimension(120, 120));

        // Dropdown for color selection
        String[] colors = {"Red", "Blue", "Green"};
        JComboBox<String> colorDropdown = new JComboBox<>(colors);

        // Text output field
        JTextField colorTextOutput = new JTextField();
        colorTextOutput.setEditable(false);

        // Add ActionListener to JComboBox
        colorDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorDropdown.getSelectedItem();
                switch (selectedColor) {
                    case "Red":
                        currentColor = Color.RED;
                        break;
                    case "Blue":
                        currentColor = Color.BLUE;
                        break;
                    case "Green":
                        currentColor = Color.GREEN;
                        break;
                    default:
                        currentColor = Color.WHITE; // Default case
                }
                colorTextOutput.setText(selectedColor);
                circlePanel.repaint(); // Repaint the circle with the new color
            }
        });

        // Adding components to the frame
        add(circlePanel, BorderLayout.WEST);
        add(colorDropdown, BorderLayout.CENTER);
        add(colorTextOutput, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ColorChooserApp().setVisible(true);
            }
        });
    }
}
