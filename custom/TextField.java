import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * A customised version of JTextField that has a placeholder text
 * 
 * @author Axel Napoleon Lönnby Wesselgren
 */
public class TextField extends JTextField implements FocusListener {
    // The color of the placeholder text, default is gray
    private Color placeholderColor;
    // The text of the placeholder
    private String placeholder;

    /**
     * The constructor for TextField that sets the text to the given placeholder text.
     * It also sets the color to gray(default) and the characters to be normal instead of astrixs.
     * 
     * @param placeholder   The text that is going to be displayed when focus is lost
     */
    public TextField(String placeholder) {
        super();
        this.placeholder = placeholder;

        placeholderColor = Color.LIGHT_GRAY;

        setText(ghostText);
        setForeground(placeholderColor);
        setEchoChar('\u0000');

        addFocusListener(this);
    }

    /**
     * When the user focuses on the textfield it checks if
     * the current the text is equal to the placeholder text,
     * if so then it clears it and changes back the color to normal.
     */
    @Override
    public void focusGained(FocusEvent e) {
        if (getText().equals(placeholder)) {
            setText("");
            setForeground(getForeground());
        }
    }
    /**
     * When the user loses focus on the text field the,
     * and the text is empty it calls on the clear method
     * in order to display placeholder text. If it's not empty
     * then nothing happens, the text stays the same.
     */
    @Override
    public void focusLost(FocusEvent e) {
        if (getText().isEmpty()) clear();
    }

    /**
     * Clears the textfield by removing the current text in it,
     * and setting the text to the choosen placeholder text.
     * It also changes the characters from astrixs back to normal.
     * 
     */
    public void clear() {
        setText(placeholder);
        setForeground(getForeground());
    }
    /**
     * A method that can be called to check if the textfield is empty.
     * It does this by checking if the text in the field is empty,
     * or if it is equal to the placeholder text.
     * 
     * @return boolean  if the value is empty then it returns false else true
     */
    public boolean isEmpty() {
        if (getText().isEmpty()) return true;
        if (getText().equals(placeholder)) return true;
        return false;
    }

    // Getters and setters for placeholder's color and text

    public void setPlaceholderColor(Color placeholderColor) {
        this.placeholderColor = placeholderColor;
    }
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public Color getPlaceholderColor() {
        return placeholderColor;
    }
    public String getPlaceholder() {
        return placeholder;
    }
}