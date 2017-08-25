import java.util.Map;
import java.util.ArrayList;

class ExtraCurricular{
    private Map<String,ArrayList<String>> data;
    public ExtraCurricular(){
        data.clear();
    }
    public void addHeader(String header){
        data.put(header, new ArrayList<>());
    }
    public void addPoint(String header,String point){
        if(data.containsKey(header)){
            data.get(header).add(point);
        }
    }
    public void moveUp(String header,int index){
        if (index > 0) {
            String entry = data.get(header).get(index);
            data.get(header).remove(index);
            data.get(header).add(index - 1, entry);
        }
    }
    public void moveDown(String header,int index){
        if (index < data.get(header).size() - 1) {
            String entry = data.get(header).get(index);
            data.get(header).remove(index);
            data.get(header).add(index + 1, entry);
        }
    }
}