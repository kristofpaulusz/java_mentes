package allapotmentes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AllapotMentes {

    public static void main(String[] args) {
        Tanulo t1 = new Tanulo("Kristóf", 0.5);
        t1.ujTargy("földrajz");
        Tanulo t2 = new Tanulo("Eszter", 3.5);
        Tanulo t3 = new Tanulo("Attila", 2.5);
        System.out.println("Tanulók állapota");
            System.out.println(t1.toString());
            System.out.println(t2.toString());
            System.out.println(t3.toString());
        try {
            FileOutputStream fajlKi = new FileOutputStream("allapot.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fajlKi);
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(t3);
            
            oos.close();
            System.out.println("Gép kikapcsolva");
            t1 = null;
            t2 = null;
            t3 = null;
            System.out.println(t1);
            System.out.println(t2);
            System.out.println(t3);
        
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
//            Logger.getLogger(AllapotMentes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
           Logger.getLogger(AllapotMentes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try (ObjectInputStream fis = new ObjectInputStream(new FileInputStream("allapot.txt"))) {
            t1 = (Tanulo) fis.readObject();
            t2 = (Tanulo) fis.readObject();
            t3 = (Tanulo) fis.readObject();

            System.out.println("beolvasás után");
            t1.newId();
            t2.newId();
            t3.newId();
            
            System.out.println(t1.toString());
            System.out.println(t2.toString());
            System.out.println(t3.toString());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AllapotMentes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AllapotMentes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AllapotMentes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
