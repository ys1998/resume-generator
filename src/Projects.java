import java.util.ArrayList;
class project{
    public String name;
    public String span;
    public String type;
    public String mentor;
    public project(){
        name=span=type=mentor="";
    }
}
class Projects{
    private ArrayList<project> data;
    public Projects(){
        data=new ArrayList<>();
    }
    public void addProject(String n,String s,String t,String m){
        project temp=new project();
        temp.name=n;
        temp.mentor=m;
        temp.span=s;
        temp.type=t;
        data.add(temp);
    }
    public int N(){
        return data.size();
    }
    public project getProject(int i){
        return data.get(i);
    }
}