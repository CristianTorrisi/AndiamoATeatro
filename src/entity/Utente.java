package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Utente {

    private int id;
    private String nome;
    private String cognome;
    private String indirizzo;
    private String telefono;
    private String email;
    private int eta;


}
