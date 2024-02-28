import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TextField extends JTextField implements FocusListener {
    private Color placeholderColor;
    private String placeholder;

    public TextField(String placeholder) {
        super();
        this.placeholder = placeholder;

        placeholderColor = Color.LIGHT_GRAY;

        setText(placeholder);
        setForeground(placeholderColor);

        addFocusListener(this);
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (getText().equals(placeholder)) {
            setText("");
            setForeground(getForeground());
        }
    }
    @Override
    public void focusLost(FocusEvent e) {
        if (getText().isEmpty()) clear();
    }

    public void clear() {
        setText(placeholder);
        setForeground(getForeground());
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