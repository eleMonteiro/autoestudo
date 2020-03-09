package quixada.npi.springproject.model;

import java.util.Map;
import java.util.TreeMap;

public enum Turno {

    MANHA("Manhâ"), TARDE("Tarde"), NOITE("Noite");

    private String name;
    private static Map<Turno, String> map;

    Turno(String name) {
        this.name = name;
    }

    public static Map<Turno, String> toMap() {
        if (map == null) {
            map = new TreeMap<Turno, String>(); // Usar TreeMap para ficar ordenado
            for (Turno c : Turno.values()) {
                map.put(c, c.name);
            }
        }
        return map;
    }

}
