import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculadoraGUI extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton btnSuma, btnResta, btnMultiplicacion, btnDivision, btnRaiz, btnSeno, btnCoseno, btnTangente, btnRedondear, btnClear, btnIgual, btnPunto;
    private JButton[] btnNumeros;

    private String operador;
    private double valorActual;

    public CalculadoraGUI() {
        super("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 24)); 
        add(inputField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 3));

        btnNumeros = new JButton[10];
        for (int i = 0; i < 10; i++) {
            btnNumeros[i] = new JButton(String.valueOf(i));
            buttonPanel.add(btnNumeros[i]);
            btnNumeros[i].addActionListener(this);
        }

        btnSuma = new JButton("+");
        buttonPanel.add(btnSuma);

        btnResta = new JButton("-");
        buttonPanel.add(btnResta);

        btnMultiplicacion = new JButton("*");
        buttonPanel.add(btnMultiplicacion);

        btnDivision = new JButton("/");
        buttonPanel.add(btnDivision);

        btnRaiz = new JButton("√");
        buttonPanel.add(btnRaiz);

        btnSeno = new JButton("sin");
        buttonPanel.add(btnSeno);

        btnCoseno = new JButton("cos");
        buttonPanel.add(btnCoseno);

        btnTangente = new JButton("tan");
        buttonPanel.add(btnTangente);

        btnRedondear = new JButton("Redondear");
        buttonPanel.add(btnRedondear);

        btnClear = new JButton("Clear");
        btnClear.setForeground(Color.RED);
        buttonPanel.add(btnClear);

        btnIgual = new JButton("=");
        btnIgual.setForeground(Color.BLUE);
        buttonPanel.add(btnIgual);

        btnPunto = new JButton(".");
        buttonPanel.add(btnPunto);

        add(buttonPanel, BorderLayout.CENTER);

        btnSuma.addActionListener(this);
        btnResta.addActionListener(this);
        btnMultiplicacion.addActionListener(this);
        btnDivision.addActionListener(this);
        btnRaiz.addActionListener(this);
        btnSeno.addActionListener(this);
        btnCoseno.addActionListener(this);
        btnTangente.addActionListener(this);
        btnRedondear.addActionListener(this);
        btnClear.addActionListener(this);
        btnIgual.addActionListener(this);
        btnPunto.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("Clear")) {
            inputField.setText("");
        } else if (comando.equals("=")) {
            double resultado = realizarOperacion();
            inputField.setText(String.valueOf(resultado));
            valorActual = resultado;
        } else if (comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/")) {
            operador = comando;
            valorActual = Double.parseDouble(inputField.getText());
            inputField.setText("");
        } else if (comando.equals("√")) {
            double valorIngresado = Double.parseDouble(inputField.getText());
            double resultado = Math.sqrt(valorIngresado);
            inputField.setText(String.valueOf(resultado));
        } else if (comando.equals("sin")) {
            double valorIngresado = Double.parseDouble(inputField.getText());
            double resultado = Math.sin(Math.toRadians(valorIngresado));
            inputField.setText(String.valueOf(resultado));
        } else if (comando.equals("cos")) {
            double valorIngresado = Double.parseDouble(inputField.getText());
            double resultado = Math.cos(Math.toRadians(valorIngresado));
            inputField.setText(String.valueOf(resultado));
        } else if (comando.equals("tan")) {
            double valorIngresado = Double.parseDouble(inputField.getText());
            double resultado = Math.tan(Math.toRadians(valorIngresado));
            inputField.setText(String.valueOf(resultado));
        } else if (comando.equals("Redondear")) {
            double valorIngresado = Double.parseDouble(inputField.getText());
            double resultado = Math.round(valorIngresado);
            inputField.setText(String.valueOf(resultado));
        } else {
            inputField.setText(inputField.getText() + comando);
        }
    }

    private double realizarOperacion() {
        double resultado = 0;
        double valorIngresado = Double.parseDouble(inputField.getText());

        switch (operador) {
            case "+":
                resultado = valorActual + valorIngresado;
                break;
            case "-":
                resultado = valorActual - valorIngresado;
                break;
            case "*":
                resultado = valorActual * valorIngresado;
                break;
            case "/":
                resultado = valorActual / valorIngresado;
                break;
        }

        return resultado;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraGUI calculadora = new CalculadoraGUI();
            calculadora.setSize(300, 400); 
            calculadora.setVisible(true);
        });
    }
}
