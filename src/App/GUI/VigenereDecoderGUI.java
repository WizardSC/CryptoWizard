import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VigenereDecoderGUI extends JFrame {
    private JTextField keyField;
    private JTextArea inputTextArea;
    private JButton decodeButton;
    private JTextArea outputTextArea;

    public VigenereDecoderGUI() {
        setTitle("Vigenere Decoder");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        keyField = new JTextField(20);
        inputTextArea = new JTextArea(10, 40);
        decodeButton = new JButton("Decode");
        outputTextArea = new JTextArea(10, 40);
        outputTextArea.setEditable(false);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Enter the decryption key:"), BorderLayout.NORTH);
        inputPanel.add(keyField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(decodeButton);

        JPanel textAreaPanel = new JPanel(new GridLayout(1, 2));
        textAreaPanel.add(new JScrollPane(inputTextArea));
        textAreaPanel.add(new JScrollPane(outputTextArea));

        add(inputPanel, BorderLayout.NORTH);
        add(textAreaPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        decodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = keyField.getText();
                String inputText = inputTextArea.getText();
                String decodedText = decodeVigenere(inputText, key);
                outputTextArea.setText(decodedText);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VigenereDecoderGUI decoder = new VigenereDecoderGUI();
                decoder.setVisible(true);
            }
        });
    }

    public static String decodeVigenere(String input, String key) {
        StringBuilder decodedText = new StringBuilder();
        int keyLength = key.length();
        int inputLength = input.length();

        for (int i = 0; i < inputLength; i++) {
            char inputChar = input.charAt(i);
            char keyChar = key.charAt(i % keyLength);

            if (Character.isLetter(inputChar)) {
                char base = Character.isUpperCase(inputChar) ? 'A' : 'a';
                int decodedChar = (inputChar - keyChar + 26) % 26 + base;
                decodedText.append((char) decodedChar);
            } else {
                decodedText.append(inputChar);
            }
        }

        return decodedText.toString();
    }
}