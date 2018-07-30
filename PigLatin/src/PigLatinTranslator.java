import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* This program will take text entered in English and translate it into Pig Latin.
 * This program will use a Swing GUI.
 * If a word starts with punctuation, the translation is skipped and the nontranslated version is shown.
 * If a word starts with a number, the number is treated as a consonant.
 *
 * Ball = allbay, button = uttonbay
 * one = oneway, all = allway, on = onway
 *
 * There should be two separate textboxes for the input and output.
 * A JButton with an event to perform the translation should be used.
 *
 */

@SuppressWarnings("serial")
public class PigLatinTranslator extends JFrame implements ActionListener {

    // Determine size of window:
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 560;
    public static final int NUM_OF_CHARS = 100;

    // Declare text areas:
    @SuppressWarnings("unused")
    private JTextArea englishText;
    @SuppressWarnings("unused")
    private JTextArea pigLatinText;


// Create the main method:
    public static void main(String[] args) {

        PigLatinTranslator gui = new PigLatinTranslator();
        gui.setVisible(true);
    }

// Create the window:
    public PigLatinTranslator() {

        super("English to Pig Latin Translator");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        JPanel englishPanel = new JPanel();
            englishPanel.setLayout(new BorderLayout());
            englishPanel.setBackground(Color.LIGHT_GRAY);

        JPanel pigPanel = new JPanel();
        pigPanel.setLayout(new BorderLayout());
        pigPanel.setBackground(Color.LIGHT_GRAY);

        Border border = BorderFactory.createEtchedBorder(Color.LIGHT_GRAY, Color.LIGHT_GRAY);
        int style = Font.BOLD;
        Border englishBorder = BorderFactory.createTitledBorder(border, "Enter the English text here:", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Verdana", style, 13), Color.blue);
        Border pigBorder = BorderFactory.createTitledBorder(border, "Pig Latin Translation:", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Verdana", style, 13), Color.red);

        // Create the text areas and buttons:
        englishText = new JTextArea();
                    englishText.setRows(30);
                    englishText.setColumns(20);
                    englishText.setBackground(Color.WHITE);
                    englishText.setBorder(englishBorder);

                JButton translateText = new JButton("Translate to Pig Latin");
                    translateText.addActionListener(this);

                JButton clearText = new JButton("Clear");
                    clearText.addActionListener(this);

                pigLatinText = new JTextArea();
                    pigLatinText.setRows(30);
                    pigLatinText.setColumns(20);
                    pigLatinText.setBackground(Color.WHITE);
                    pigLatinText.setBorder(pigBorder);

// Add everything to the appropriate panels:
            englishPanel.add(englishText, BorderLayout.NORTH);
            pigPanel.add(pigLatinText, BorderLayout.NORTH);
            englishPanel.add(translateText, BorderLayout.PAGE_END);
            pigPanel.add(clearText, BorderLayout.PAGE_END);

// Add the panels:
        add(englishPanel);
        add(pigPanel);

    }

// Create the actions the buttons perform:
    public void actionPerformed(ActionEvent e) {

        // Declare variables:
        String actionCommand = e.getActionCommand();
        String translatedWord = "";
        String translatedText = "";
        String strPattern1 = "^[a-zA-Z0-9]*$";
        String englishPhrase = englishText.getText().toLowerCase();

        // Determine which button was pressed and perform actions:
        if (actionCommand.equals("Clear")) {
            pigLatinText.setText("");
            englishText.setText("");
       }

        // Determine what the first character is, then translate using rules of Pig Latin:
        else if (actionCommand.equals("Translate to Pig Latin")) {
            for (String pigVal : englishPhrase.split(" ")) {

                // Vowels:
                if (pigVal.charAt(0) == 'a' || pigVal.charAt(0) == 'e' || pigVal.charAt(0) == 'i' || pigVal.charAt(0) == 'o' || pigVal.charAt(0) == 'u') {
                    translatedWord = pigVal + "way";

                    // Non alphanumeric:
                } else if (!(pigVal.matches(strPattern1))) {
                    translatedWord = pigVal;

                    // Normal:
                } else {
                    translatedWord = pigVal.substring(1, pigVal.length()) + pigVal.charAt(0) + "ay".toLowerCase();
                }

                // Append to translated string:
                translatedText = new StringBuilder().append(translatedText).append(" " + translatedWord).toString();
            }

            // Send to text area:
            pigLatinText.setText(translatedText);

            // Check for errors:
        } else {
            pigLatinText.setText("Error!");

        }

    }

}
