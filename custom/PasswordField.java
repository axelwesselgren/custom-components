import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class PasswordField extends JPasswordField implements FocusListener {
    private Color placeholderColor;
    private String placeholder;

    public PasswordField(String placeholder) {
        super();
        this.placeholder = placeholder;

        placeholderColor = Color.LIGHT_GRAY;

        setText(placeholder);
        setForeground(placeholderColor);
        setEchoChar('\u0000');

        addFocusListener(this);
    }

    @Override
    public String getText() {
        return String.valueOf(getPassword());
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (getText().equals(placeholder)) {
            setText("");
            setForeground(getForeground());
            setEchoChar('*');
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if (getText().isEmpty()) clear();
    }

    public void clear() {
        setText(placeholder);
        setForeground(getForeground());
        setEchoChar('\u0000');
    }
    public boolean isEmpty() {
        if (getText().isEmpty()) return true;
        if (getText().equals(placeholder)) return true;
        return false;
    }

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