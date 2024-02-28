import java.awt.Dimension;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

/**
 * A custom JSCrollPane class that simplifies the use of JScrollPane.
 * It contains a JList and a DefaultListModel to handle the list.
 * Instead of having to handle the list and the model separately, this class
 * handles both of them. The class is also generic, so it can be used with any
 * type of object.
 * 
 * @author Axel Napoleon Lönnby Wesselgren
 */
public class ScrollPane<T> extends JScrollPane {
    // The list model and the list with the generic type T
    private DefaultListModel<T> listModel;
    private JList<T> list;
    
    /**
     * Constructor for the ScrollPane class. It initializes the list model and
     * the list. It also sets the list as the view port of the scroll pane.
     */
    public ScrollPane() {
        super();

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        setViewportView(list);
    }

    /**
     * A method to add a ListSelectionListener to the JList
     * 
     * @param listener  A ListSelectionListener interface that listens for
     * when a user selects an item in the list.
     */
    public void addListSelectionListener(ListSelectionListener listener) {
        list.addListSelectionListener(listener);
    }

    /**
     * A method to add a T item to the list model.
     * When the item is added, the JList is also updated
     * 
     * @param item  T item to be added to the list model.
     */
    public void addElement(T item) {
        listModel.addElement(item);
        list.setModel(listModel);
    }
    /**
     * A method to remove a T item from the the list model.
     * When the item is added, the JList is also updated
     * 
     * @param item
     */
    public void removeElement(String item) {
        listModel.removeElement(item);
        list.setModel(listModel);
    }

    /**
     * A method to get the T index item in the list.
     * 
     * @param index The index of the item in the list.
     * @return  The T item at the index.
     */
    public T getElementAt(int index) {
        return listModel.getElementAt(index);
    }
    /**
     * A method to check if the list model contains T item.
     * 
     * @param item  The item to search for
     * @return  If the items exists in the list model it returns true else false.
     */
    public boolean contains(T item) {
        return listModel.contains(item);
    }

    /**
     * Sets the list model to the given list, it then updates the JList
     * 
     * @param list  A List interface with generic type T
     */
    public void setList(List<T> list) {
        listModel.clear();
        for (T item : list) {
            listModel.addElement(item);
        }
        this.list.setModel(listModel);
    }
    /**
     * Clears the list model and updates the JList
     */
    public void clear() {
        listModel.clear();
        list.setModel(listModel);
    }

    /**
     * Clears the selected item in the list
     */
    public void clearSelection() {
        list.clearSelection();
    }
    /**
     * Returns the selected index
     * 
     * @return  Selected index
     */
    public int getSelectedIndex() {
        return list.getSelectedIndex();
    }
}
