package br.com.paycontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "people")
public class People implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@Column(name = "nome", nullable = false)
    private String nome;
@Column(name = "contact", nullable = false)
    private String contact;
@Column(name = "nasc", nullable = false)
    private Date nasc;
@Column(name = "category")
    private String category;

}
