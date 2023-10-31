package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class Evento {
    private int id;
    private String nome;
    private String genere;
    private double prezzo;
    private String durata;
    private Date data;
    private int sala;
}
