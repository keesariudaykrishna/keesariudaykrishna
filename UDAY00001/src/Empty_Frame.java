import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Empty_Frame extends JFrame {

    private JLabel lettersLabel, symbolsLabel, numbersLabel, resultLabel,Welcome;
    private JTextField lettersField, symbolsField, numbersField, resultField;
    private JButton generateButton;
    char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	char[] symbols = {'!', '#', '$', '%', '&', '(', ')', '*', '+'};
	char[] numbers= {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};


    public Empty_Frame() {
        setTitle("Password Generator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        Welcome = new JLabel("Welcome TO Java Password Generator");
        Welcome.setBounds(20, 20, 300, 25);
        add(Welcome);

        lettersLabel = new JLabel("Letters:");
        lettersLabel.setBounds(20, 60, 80, 25);
        add(lettersLabel);

        lettersField = new JTextField();
        lettersField.setBounds(120, 60, 50, 25);
        add(lettersField);

        symbolsLabel = new JLabel("Symbols:");
        symbolsLabel.setBounds(20, 100, 80, 25);
        add(symbolsLabel);

        symbolsField = new JTextField();
        symbolsField.setBounds(120, 100, 50, 25);
        add(symbolsField);

        numbersLabel = new JLabel("Numbers:");
        numbersLabel.setBounds(20,140, 80, 25);
        add(numbersLabel);

        numbersField = new JTextField();
        numbersField.setBounds(120, 140, 50, 25);
        add(numbersField);

        generateButton = new JButton("Generate Password");
        generateButton.setBounds(20, 180, 200, 25);
        add(generateButton);

        resultLabel = new JLabel("Password:");
        resultLabel.setBounds(20,220, 80, 25);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(120, 220, 220, 25);
        resultField.setEditable(false);
        add(resultField);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePassword();
            }
        });
    }

    private void generatePassword() {
        int nrLetters = Integer.parseInt(lettersField.getText());
        int nrSymbols = Integer.parseInt(symbolsField.getText());
        int nrNumbers = Integer.parseInt(numbersField.getText());

        List<Character> passwordList = new ArrayList<>();

        for (int i = 0; i < nrLetters; i++) {
            passwordList.add(getRandomElement(letters));
        }

        for (int i = 0; i < nrSymbols; i++) {
            passwordList.add(getRandomElement(symbols));
        }

        for (int i = 0; i < nrNumbers; i++) {
            passwordList.add(getRandomElement(numbers));
        }

        Collections.shuffle(passwordList);

        StringBuilder password = new StringBuilder();
        for (char character : passwordList) {
            password.append(character);
        }

        resultField.setText(password.toString());
    }

    private static char getRandomElement(char[] array) {
        int randomIndex = (int) (Math.random() * array.length);
        return array[randomIndex];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Empty_Frame().setVisible(true);
            }
        });
    }
}

