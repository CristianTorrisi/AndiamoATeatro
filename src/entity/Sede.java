package entity;

import lombok.Data;

@Data
public class Sede {

    private int id;
    private String nome;
    private String indirizzo;
    private String comune;
    private boolean al_chiuso;
}