import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

class Courses{
    private Map<String,ArrayList<String> > data;
    public Courses(){
        data=new HashMap<>();
        data.clear();
    }
    public void addHeader(String header){
        data.put(header, new ArrayList<>());
    }
    public void addCourse(String header, String course){
        if(data.containsKey(header)){
            data.get(header).add(course);
        }
    }
    public void moveUp(String header,int index){
        if (index > 0) {
            String entry = data.get(header).get(index);
            data.get(header).remove(index);
            data.get(header).add(index - 1, entry);
        }
    }
    public void moveDown(String header, int index){
        if (index < data.get(header).size() - 1) {
            String entry = data.get(header).get(index);
            data.get(header).remove(index);
            data.get(header).add(index + 1, entry);
        }
    }
}