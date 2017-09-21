
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.util.Vector;
import javax.swing.border.EtchedBorder;

class Academic {
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
    
    public Academic() {
        data = new ArrayList<>(0);
        year=new ArrayList<>(0);
        
        //Initialization of GUI components
        root=new JPanel();
        yr=new JTextField(5);
        point=new JTextArea(2,40);
        add=new JButton("Add");
        remove=new JButton("Remove");
        edit=new JButton("Edit");
        moveDown=new JButton("Move up");
        moveUp=new JButton("Move down");
        list=new JList<>();
        view=new JScrollPane();
        
        root.setSize(800,550);
        root.setLayout(new BorderLayout());
        
        // adding data-list
        root.add(view,BorderLayout.WEST);
        
        // adding East panel of buttons
        JPanel east=new JPanel(new GridLayout(0, 1));
        east.setSize(60,80);
        east.add(remove);
        east.add(edit);
        east.add(moveUp);
        east.add(moveDown);
        
        // adding South panel for new data
        JPanel south=new JPanel(new FlowLayout());
        south.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
        south.add(new JLabel("Description"));
        south.add(point);
        south.add(new JLabel("Academic year"));
        south.add(yr);
        south.add(add);     
        root.add(east, BorderLayout.EAST);
        root.add(south,BorderLayout.SOUTH);
        
    }
    
    public JPanel panel(){
        return root;
    }

    public void addEntry(String entry,String y) {
        data.add(entry);
        year.add(y);
    }

    public void removeEntry(String entry) {
        data.remove(entry);
    }

    public String getEntry(int i) {
        return data.get(i);
    }

    // ordering functions
    public void moveUp(int index) {
        if (index > 0) {
            String entry = data.get(index);
            data.remove(index);
            data.add(index - 1, entry);
        }
    }

    public void moveDown(int index) {
        if (index < data.size() - 1) {
            String entry = data.get(index);
            data.remove(index);
            data.add(index + 1, entry);
        }
    }

    // processing function
    public void process() {
        // removes extra spaces and formats each entry
        for (int i = 0; i < data.size(); ++i) {
            data.set(i, data.get(i).trim().replaceAll("\\s+", " "));
        }
    }
}
