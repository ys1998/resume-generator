
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

class Education {

    public String examination;
    public String university;
    public String institute;
    public int year;
    public float cpi_or_percent;

    public Education(String e, String u, String i, int y, float cp) {
        examination = e;
        university = u;
        institute = i;
        year = y;
        cpi_or_percent = cp;
    }
}

class Header {

    private String name;
    private String dept;
    private String specialization;
    private String roll_no;
    private String degree; // Junior Undergraduate, Bachelor of Technology etc.
    private String gender;
    private String dob; // format DD/MM/YYYY
    private ArrayList<Education> edu_data;

    public void setName(String n) {
        name = n;
    }

    public void setDept(String d) {
        dept = d;
    }

    public void setSpecialization(String sp) {
        specialization = sp;
    }

    public void setRollno(String r) {
        roll_no = r;
    }

    public void setDegree(String deg) {
        degree = deg;
    }

    public void setGender(String g) {
        gender = g;
    }

    public void setDOB(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        dob = df.format(date);
    }

    public void addEducation(String e, String u, String i, int y, float cp) {
        Education entry = new Education(e, u, i, y, cp);
        edu_data.add(entry);
    }
    public ArrayList<String> getHeaderData(){
        ArrayList<String> res=new ArrayList<>();
        res.add(name);
        res.add(dept);
        res.add(specialization);
        res.add(roll_no);
        res.add(degree);
        res.add(gender);
        res.add(dob);
        return res;
    }
    public ArrayList<Education> getEducatioinData(){
        return edu_data;
    }
}
