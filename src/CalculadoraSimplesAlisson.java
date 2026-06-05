import javax.swing.*;
import java.awt.*;

public class CalculadoraSimplesAlisson extends JFrame {

    private JTextField campo1;
    private JTextField campo2;
    private JLabel resultado;

    public CalculadoraSimplesAlisson() {

        setTitle("Calculadora Simples");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(6, 1));

        // campos de entrada
        campo1 = new JTextField();
        campo2 = new JTextField();

        resultado = new JLabel("Resultado: ");

        // botões das operações
        JButton btnSomar = new JButton("Somar");
        JButton btnSubtrair = new JButton("Subtrair");
        JButton btnMultiplicar = new JButton("Multiplicar");
        JButton btnDividir = new JButton("Dividir");

        add(new JLabel("Digite o número 1:"));
        add(campo1);

        add(new JLabel("Digite o número 2:"));
        add(campo2);

        JPanel painelBotoes = new JPanel();

        painelBotoes.add(btnSomar);
        painelBotoes.add(btnSubtrair);
        painelBotoes.add(btnMultiplicar);
        painelBotoes.add(btnDividir);

        add(painelBotoes);
        add(resultado);

        // eventos dos botões (estilo mais “manual de aluno”)
        btnSomar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                calcular("+");
            }
        });

        btnSubtrair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                calcular("-");
            }
        });

        btnMultiplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                calcular("*");
            }
        });

        btnDividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                calcular("/");
            }
        });

        setVisible(true);
    }

    private void calcular(String operacao) {

        try {

            // pegando valores digitados
            double num1 = Double.parseDouble(campo1.getText());
            double num2 = Double.parseDouble(campo2.getText());

            double res = 0;

            switch (operacao) {

                case "+":
                    res = num1 + num2;
                    break;

                case "-":
                    res = num1 - num2;
                    break;

                case "*":
                    res = num1 * num2;
                    break;

                case "/":
                    // proteção contra divisão por zero
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "Não pode dividir por zero!");
                        return;
                    }
                    res = num1 / num2;
                    break;
            }

            resultado.setText("Resultado: " + res);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                this,
                "Digite apenas números válidos!",
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        new CalculadoraSimplesAlisson();
    }
}