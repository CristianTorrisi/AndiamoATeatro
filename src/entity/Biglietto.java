package entity;

import lombok.Data;

@Data
public class Biglietto {
    private int id;
    private int utente;
    private int evento;
    private int posto;

}
