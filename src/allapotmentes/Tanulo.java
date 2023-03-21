
package allapotmentes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Tanulo implements Serializable {
    private String nev;
    private double atlag;
    private transient UUID id;
    private ArrayList<String> tantargyak;
    public Tanulo(String nev, double atlag) {
        this(nev, atlag, new ArrayList<>());
    }

    public Tanulo(String nev, double atlag, ArrayList<String> tantargyak) {
        this.nev = nev;
        this.atlag = atlag;
        this.tantargyak = tantargyak;
        newId();
    }
    public void ujTargy(String targy) {
        this.tantargyak.add(targy);
    }
    public void newId() {
        this.id = UUID.randomUUID();;
    }

    @Override
    public String toString() {
        return "Tanulo{" + "nev=" + nev + ", atlag=" + atlag + ", id=" + id + ", tantargyak=" + tantargyak + '}';
    }

    

    
}
