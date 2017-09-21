
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import javax.swing.border.EtchedBorder;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectOutputStream;

class Academic implements Serializable{

    // data elements
    private ArrayList<String> data;
    private ArrayList<String> year;

    //GUI components
    private JPanel root;
    private JTextField yr;
    private JTextArea point;
    private JButton add;
    private JButton remove;
    private JButton edit;
    private JButton moveUp;
    private JButton moveDown;
    private JList<String> list;
    private JScrollPane view;

    class ButtonClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            int index;
            if (null != command) {
                switch (command) {
                    case "add":
                        if (!yr.getText().equals("") && !point.getText().equals("")) {
                            year.add(yr.getText());
                            data.add(point.getText());
                            yr.setText("");
                            point.setText("");
                            add.setText("Add");
                        }
                        break;
                    case "remove":
                        index = list.getSelectedIndex();
                        if (index != -1) {
                            data.remove(index);
                            year.remove(index);
                        }
                        break;
                    case "edit":
                        index = list.getSelectedIndex();
                        if (index != -1) {
                            yr.setText(year.get(index));
                            point.setText(data.get(index));
                            add.setText("Save");
                            data.remove(index);
                            year.remove(index);
                        }
                        break;
                    case "up":
                        index = list.getSelectedIndex();
                        if (index != -1 && index > 0) {
                            String entry = data.get(index);
                            data.remove(index);
                            data.add(index - 1, entry);
                            entry = year.get(index);
                            year.remove(index);
                            year.add(index - 1, entry);
                        }
                        break;
                    case "down":
                        index = list.getSelectedIndex();
                        if (index != -1 && index < data.size() - 1) {
                            String entry = data.get(index);
                            data.remove(index);
                            data.add(index + 1, entry);
                            entry = year.get(index);
                            year.remove(index);
                            year.add(index + 1, entry);
                        }
                        break;
                    default:
                        break;
                }
            }
            // update JList
            root.remove(view);
            ArrayList<String> merge = new ArrayList<>();
            for (int i = 0; i < data.size(); ++i) {
                merge.add(data.get(i) + " [" + year.get(i) + "]");
            }
            list = new JList(merge.toArray());
            view = new JScrollPane(list);
            root.add(view,BorderLayout.CENTER);
            root.setVisible(false); root.setVisible(true);
        }
    }

    public Academic() {
        data = new ArrayList<>(0);
        year = new ArrayList<>(0);

        //Initialization of GUI components
        root = new JPanel();
        yr = new JTextField(5);
        point = new JTextArea(3, 45);
        point.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        add = new JButton("Add");
        add.setActionCommand("add");
        add.addActionListener(new ButtonClickListener());
        remove = new JButton("Remove");
        remove.setActionCommand("remove");
        remove.addActionListener(new ButtonClickListener());
        edit = new JButton("Edit");
        edit.setActionCommand("edit");
        edit.addActionListener(new ButtonClickListener());
        moveUp = new JButton("Move up");
        moveUp.setActionCommand("up");
        moveUp.addActionListener(new ButtonClickListener());
        moveDown = new JButton("Move down");
        moveDown.setActionCommand("down");
        moveDown.addActionListener(new ButtonClickListener());
        ArrayList<String> merge = new ArrayList<>();
        for (int i = 0; i < data.size(); ++i) {
            merge.add(data.get(i) + " [" + year.get(i) + "]");
        }
        list = new JList(merge.toArray());
        view = new JScrollPane(list);

        root.setSize(800, 550);
        root.setLayout(new BorderLayout());

        // adding data-list
        root.add(view, BorderLayout.CENTER);

        // adding East panel of buttons
        JPanel east = new JPanel(new GridLayout(9, 1));
        east.setSize(60, 80);
        east.add(moveUp);
        east.add(moveDown);
        for (int i = 0; i < 4; ++i) {
            east.add(new JPanel());
        }
        east.add(remove);
        east.add(edit);
        east.add(add);

        // adding South panel for new data
        JPanel south = new JPanel(new FlowLayout());
        south.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        south.add(new JLabel("Description"));
        south.add(point);
        south.add(new JLabel("Academic year"));
        south.add(yr);
        root.add(east, BorderLayout.EAST);
        root.add(south, BorderLayout.SOUTH);

    }

    public JPanel panel() {
        return root;
    }
    
    public void save() throws IOException{
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("../data/Academic.ser"))) {
            out.writeObject(this);
        }
    }
    
    public void load(){
      
    }
    
    // processing function
    public void process() {
        // removes extra spaces and formats each entry
        for (int i = 0; i < data.size(); ++i) {
            data.set(i, data.get(i).trim().replaceAll("\\s+", " "));
        }
    }
}
