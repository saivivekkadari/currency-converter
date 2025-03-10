import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Currency_Converter extends JFrame {
    private JLabel amountLabel, fromLabel, toLabel, resultLabel;
    private JTextField amountField;
    private JComboBox<String> fromComboBox, toComboBox;
    private JButton convertButton;
    private DecimalFormat decimalFormat = new DecimalFormat("#,##0.000");

    private final String[] currencies = {
        "USD", "EUR", "JPY", "GBP", "CAD", "AUD", "CHF", "CNY", "INR", "SGD",
        "HKD", "NZD", "SEK", "KRW", "NOK", "MXN", "RUB", "ZAR", "BRL", "IDR",
        "MYR", "PHP", "THB", "PLN", "TRY", "AED", "SAR", "DKK", "HUF", "CZK"
    };

    private final double[] exchangeRates = {
        1.00, 0.91, 144.77, 0.79, 1.36, 1.52, 0.91, 7.25, 83.35, 1.36,
        7.82, 1.65, 10.65, 1322.50, 10.93, 17.08, 92.50, 18.45, 5.14, 15200.00,
        4.67, 56.35, 36.10, 4.00, 29.50, 3.67, 3.75, 6.85, 332.50, 22.50
    };

    public Currency_Converter() {
        setTitle("Currency Converter");
        setLayout(new GridLayout(5, 2, 10, 10));

        amountLabel = new JLabel("Amount:");
        add(amountLabel);
        amountField = new JTextField();
        add(amountField);

        fromLabel = new JLabel("From:");
        add(fromLabel);
        fromComboBox = new JComboBox<>(currencies);
        add(fromComboBox);

        toLabel = new JLabel("To:");
        add(toLabel);
        toComboBox = new JComboBox<>(currencies);
        add(toComboBox);

        convertButton = new JButton("Convert");
        add(convertButton);

        resultLabel = new JLabel("Converted Amount: ");
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String fromCurrency = (String) fromComboBox.getSelectedItem();
                    String toCurrency = (String) toComboBox.getSelectedItem();

                    double exchangeRate = exchangeRates[getIndex(toCurrency)] / exchangeRates[getIndex(fromCurrency)];
                    double result = amount * exchangeRate;
                    resultLabel.setText("Converted Amount: " + decimalFormat.format(result) + " " + toCurrency);
                } catch (Exception ex) {
                    resultLabel.setText("Invalid input");
                }
            }
        });

        setSize(450, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private int getIndex(String currency) {
        for (int i = 0; i < currencies.length; i++) {
            if (currency.equals(currencies[i])) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new Currency_Converter();
    }
}
