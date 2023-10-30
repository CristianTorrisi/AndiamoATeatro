package entity;

import lombok.Data;

import java.util.Date;

@Data
public class Evento {
    private int id;
    private String nome;
    private String genere;
    private double prezzo;
    private String durata;
    private Date data;
    private int sala;
}
