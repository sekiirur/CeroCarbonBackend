package es.custos.cerocarbon.model;


import lombok.Data;

import javax.persistence.*;
import java.io.FileWriter;
@Data
@Entity
@Table(name = "Huerto")
public class Huerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="alquilado")
    private Boolean alquilado;



    public Huerto(){


    }
}



