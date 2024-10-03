import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pantallaprincipal extends JFrame {
    private final String userName;
    private JTextField lastNameField, resultField;
    private JComboBox<String> departmentComboBox, seniorityComboBox;

    public pantallaprincipal(String userName) {
         setLayout(null);
        setBackground(Color.magenta);
        this.userName = userName;
        setTitle("Pantalla Principal");
        setIconImage(Toolkit.getDefaultToolkit().getImage("path_to_your_icon.png"));
        setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Nombre: " + userName);
        lastNameField = new JTextField(15);
        resultField = new JTextField(15);
        resultField.setEditable(false);

        String[] departments = {"Atención al Cliente", "Logística", "Gerente"};
        departmentComboBox = new JComboBox<>(departments);

        String[] seniorities = {"1 año", "2-6 años", "7 años o más"};
        seniorityComboBox = new JComboBox<>(seniorities);

        JButton calculateButton = new JButton("Calcular Vacaciones");
        JButton clearButton = new JButton("Limpiar");
        JButton backButton = new JButton("Regresar");

        calculateButton.addActionListener((ActionEvent e) -> {
            calculateVacations();
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lastNameField.setText("");
                resultField.setText("");
                departmentComboBox.setSelectedIndex(0);
                seniorityComboBox.setSelectedIndex(0);
            }
        });

        backButton.addActionListener((ActionEvent e) -> {
            new bienvenida().setVisible(true);
            dispose();
        });

        add(nameLabel);
        add(new JLabel("Apellidos:"));
        add(lastNameField);
        add(new JLabel("Departamento:"));
        add(departmentComboBox);
        add(new JLabel("Antigüedad:"));
        add(seniorityComboBox);
        add(calculateButton);
        add(clearButton);
        add(backButton);
        add(new JLabel("Días de Vacaciones:"));
        add(resultField);
        add(new JLabel("Nova Cases | Estudiante: Lester Josué Orellana Argueta | Curso: Programacion II | Sección: B"));

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void calculateVacations() {
        String department = (String) departmentComboBox.getSelectedItem();
        String seniority = (String) seniorityComboBox.getSelectedItem();
        int vacationDays = 0;

        switch (department) {
            case "Atención al Cliente":
        switch (seniority) {
            case "1 año":
                vacationDays = 6;
                break;
            case "2-6 años":
                vacationDays = 14;
                break;
            case "7 años o más":
                vacationDays = 20;
                break;
            default:
                break;
        }
                break;
            case "Logística":
        switch (seniority) {
            case "1 año":
                vacationDays = 7;
                break;
            case "2-6 años":
                vacationDays = 15;
                break;
            case "7 años o más":
                vacationDays = 22;
                break;
            default:
                break;
        }
                break;
            case "Gerente":
        switch (seniority) {
            case "1 año":
                vacationDays = 10;
                break;
            case "2-6 años":
                vacationDays = 20;
                break;
            case "7 años o más":
                vacationDays = 30;
                break;
            default:
                break;
        }
                break;
        }

        resultField.setText(String.valueOf(vacationDays));
    }
}
