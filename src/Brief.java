
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

class Brief {

    private boolean processed;
    private String deg; // B.Tech., M.Tech. or Other
    private String[] programme;
    private Map<String, String> data;

    public Brief() {
        processed = false;
        deg = "B.Tech";
        programme[0] = programme[1] = programme[2] = "";
        data=new HashMap<>();
        data.clear();
    }

    public void setDegree(String degree) {
        deg = degree.trim();
    }

    public void insertLink(String desc, String url) {
        data.put(desc, url);
    }

    public void removeLink(String key) {
        data.remove(key);
    }

    public ArrayList<String> getAllLinks() {
        process();
        ArrayList<String> res=new ArrayList<>();
        for(String key:data.keySet()){
            res.add(key+" : "+data.get(key));
        }
        return res;
    }

    public void addProgramme(char t, String core) {
        switch (t) {
            case 'c':
                programme[0] = core.trim();
                break; // department
            case 'm':
                programme[2] = core.trim();
                break; // minor
            case 'h':
                programme[1] = core.trim();
                break; // honor
        }
    }

    public void process() {
        if (!processed) {
            processed = true;
            for (String key : data.keySet()) {
                String val = data.get(key);
                data.remove(key);
                data.put(key.substring(0, 1).toUpperCase() + key.substring(1), val);
            }
        }
    }

    public String getProgramme() {
        if (!programme[0].equals("")) {
            if (programme[1].equals("") && programme[2].equals("")) {
                return deg + " in " + programme[0];
            } else if (programme[1].equals("")) {
                return deg + " in " + programme[0] + " with Minor in " + programme[2];
            } else if (programme[2].equals("")) {
                return deg + " with Honors in " + programme[0];
            } else {
                return deg + " with Honors in " + programme[0] + " and Minor in " + programme[2];
            }
        } else {
            return "";
        }
    }
}
