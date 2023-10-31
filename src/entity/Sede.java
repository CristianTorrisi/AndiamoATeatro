package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sede {

    private int id;
    private String nome;
    private String indirizzo;
    private String comune;
    private boolean al_chiuso;
}
