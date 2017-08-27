import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class PoR{
    private ArrayList<String> post;
    private ArrayList<String> organization;
    private ArrayList<Integer> start;
    private ArrayList<Integer> end;
    private ArrayList<ArrayList<String>> points;
    public PoR(){
        post=new ArrayList<>();
        organization=new ArrayList<>();
        start=new ArrayList<>();
        end=new ArrayList<>();
        points=new ArrayList<>();
    }
    public void addPoR(String p, String o, int s, int e, String data){
        // data is the points separated by ';'
        post.add(p);
        organization.add(o);
        start.add(s);
        end.add(e);
        ArrayList<String> temp = new ArrayList<>(Arrays.asList(data.split(";")));
        points.add(temp);
    }
    public int N(){
        return post.size();
    }
    public Map<String,String> getPoR(int i){
        Map<String,String> res=new HashMap<>();
        res.put("post", post.get(i));
        res.put("org", organization.get(i));
        res.put("st", Integer.toString(start.get(i)));
        res.put("en", Integer.toString(end.get(i)));
        String temp="";
        for(int j=0;j<points.size();++j){
            temp=temp+points.get(j)+";";
        }
        res.put("points",temp);
        return res;
    }
}