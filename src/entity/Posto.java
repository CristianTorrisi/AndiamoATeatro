package entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Posto {
    private int id;
    private String fila;
    private int sedia;
    private int sala;

}
