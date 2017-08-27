import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Event.*;

class Window{
    // GUI components
    private JFrame parent;
    private JLabel status;
    
    private JTabbedPane menu;
    private JPanel academic;
    private JPanel courses;
    private JPanel extracurricular;
    private JPanel header; // would contain both header.java and brief.java information
    private JPanel por;
    private JPanel projects;
//    private JPanel skills;
//    private JPanel technical;
    
    // Data storage containers
    private Academic academic_data;
    private Courses courses_data;
    private Header header_data;
    private Projects projects_data;
    private ExtraCurricular extracurricular_data;
    private PoR por_data;
//    private Skills skills_data;
//    private Technical technical_data;
    
    // button click listener classes
    
    public Window(){
        // initializing data containers
        academic_data=new Academic();
        courses_data=new Courses();
        header_data=new Header();
        projects_data=new Projects();
        extracurricular_data=new ExtraCurricular();
        por_data=new PoR();
//        skills_data=new Skills();
//        technical_data=new Technical();
        
        // initializing GUI components
        parent=new JFrame("Resume Generator | By Yash Shah");
        status=new JLabel("Ready to run.");
        
        menu=new JTabbedPane();
        academic=new JPanel();
        courses=new JPanel();
        extracurricular=new JPanel();
        header=new JPanel();
        por=new JPanel();
        projects=new JPanel();
//        skills=new JPanel();
//        technical=new JPanel();
        
        // miscellaneous actions on parent frame
        parent.setLayout(new BorderLayout());
        parent.setSize(800,600);
        parent.setResizable(false);
        
        // header
        
        // academic
        
        // technical
        
        // projects
        
        // skills
        
        // courses
        
        // por
        
        // extracurricular        
        
        // creating tabs for each section
        ImageIcon icon=new ImageIcon(""); // empty icon
        menu.addTab("Header",icon,header,"Information for the resume's header");
        menu.addTab("Academic",icon,academic,"Your academic achievements");
        //menu.addTab("Technical",icon,technical,"Your technical achievements");
        menu.addTab("Projects",icon,projects,"Your list of completed projects");
        //menu.addTab("Skills",icon,skills,"Relevant skills you have");
        menu.addTab("Courses",icon,courses,"Relevant courses undertaken by you");
        menu.addTab("PoRs",icon,por,"Positions of Responsibility");
        menu.addTab("ExtraCurricular",icon,extracurricular,"Your extra-curricular achievements");
        
        
        // initializing and displaying the window
        parent.add(menu,BorderLayout.CENTER);
        parent.add(status,BorderLayout.SOUTH);
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        parent.setVisible(true);
        parent.setLocationRelativeTo(null);
        
    }
}


public class Resume{
    public static void main(String[] args){
        Window main=new Window();
    }
}