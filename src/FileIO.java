import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

class FileIO{
    public static void store(Object o) throws IOException{
        if(o.getClass()==Academic.class){
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("data/Academic.dat"));
            out.writeObject(o);
            out.close();
        }else if(o.getClass()==Courses.class){
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("data/Courses.dat"));
            out.writeObject(o);
            out.close();
        }else if(o.getClass()==ExtraCurricular.class){
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("data/ExtraCurricular.dat"));
            out.writeObject(o);
            out.close();
        }else if(o.getClass()==Header.class){
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("data/Header.dat"));
            out.writeObject(o);
            out.close();
        }else if(o.getClass()==PoR.class){
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("data/PoR.dat"));
            out.writeObject(o);
            out.close();
        }else if(o.getClass()==Projects.class){
            ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("data/Projects.dat"));
            out.writeObject(o);
            out.close();
        }
    }
    public static Object read(String filepath) throws IOException, ClassNotFoundException{
        // simply returns the object stored in specified file - object is then type-casted to required type before using
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(filepath));
        Object res=in.readObject();
        return res;
    }
}