import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bienvenida extends JFrame {
    private JTextField nameField;
    private JButton continueButton;

    public bienvenida() {
        setLayout(null);
        setBackground(Color.magenta);
        
        setTitle("Bienvenida a Nova Cases");
        
        setLayout(new FlowLayout());

        JLabel welcomeLabel = new JLabel("Ingrese su nombre:");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 36));
        nameField = new JTextField(15);
        continueButton = new JButton("Continuar");

        continueButton.addActionListener((ActionEvent e) -> {
            if (!nameField.getText().isEmpty()) {
                new TerminosyCondiciones(nameField.getText()).setVisible(true);
                dispose();
            }
        });

        nameField.addActionListener((ActionEvent e) -> {
            continueButton.doClick();
        });

        add(welcomeLabel);
        add(nameField);
        add(continueButton);
        add(new JLabel("Nova Cases | Estudiante: Lester Josué Orellana Argueta | Curso: Programacion II | Sección: B"));

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new bienvenida().setVisible(true));
    }
}
