
import java.util.ArrayList;

class Academic {

    private ArrayList<String> data;

    public Academic() {
        data = new ArrayList<>(0);
    }

    public void addEntry(String entry) {
        data.add(entry);
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
