import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TerminosyCondiciones extends JFrame {
    private final String userName;
    private JCheckBox acceptTerms;
    private JButton continueButton, declineButton;

    public TerminosyCondiciones(String userName) {
        this.userName = userName;
        setTitle("Términos y Condiciones");
        setIconImage(Toolkit.getDefaultToolkit().getImage("path_to_your_icon.png"));
        setLayout(new FlowLayout());

        JLabel termsLabel = new JLabel("<html>Términos y condiciones...<br/></html>");
        acceptTerms = new JCheckBox("Acepto los términos y condiciones");
        continueButton = new JButton("Continuar");
        declineButton = new JButton("No aceptar");

        continueButton.setEnabled(false);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new pantallaprincipal(userName).setVisible(true);
                dispose();
            }
        });

        declineButton.addActionListener((ActionEvent e) -> {
            new bienvenida().setVisible(true);
            dispose();
        });

        acceptTerms.addActionListener((ActionEvent e) -> {
            continueButton.setEnabled(acceptTerms.isSelected());
            declineButton.setEnabled(!acceptTerms.isSelected());
        });

        add(termsLabel);
        add(acceptTerms);
        add(continueButton);
        add(declineButton);
        add(new JLabel("Usuario: " + userName));

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}

