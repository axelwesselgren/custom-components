import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;

public class ScrollPane<T> extends JScrollPane {
    private DefaultListModel<T> listModel;
    private JList<T> list;
    
    public ScrollPane() {
        super();

        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        setViewportView(list);
    }

    public void addListSelectionListener(ListSelectionListener listener) {
        list.addListSelectionListener(listener);
    }

    public void addElement(T item) {
        listModel.addElement(item);
        list.setModel(listModel);
    }
    public void removeElement(String item) {
        listModel.removeElement(item);
        list.setModel(listModel);
    }

    public T getElementAt(int index) {
        return listModel.getElementAt(index);
    }
    public boolean contains(T item) {
        return listModel.contains(item);
    }

    public void setList(List<T> list) {
        listModel.clear();
        for (T item : list) {
            listModel.addElement(item);
        }
        this.list.setModel(listModel);
    }
    public void clear() {
        listModel.clear();
        list.setModel(listModel);
    }

    public void clearSelection() {
        list.clearSelection();
    }
    public int getSelectedIndex() {
        return list.getSelectedIndex();
    }
}
