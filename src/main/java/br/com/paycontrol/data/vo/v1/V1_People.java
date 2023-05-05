package br.com.paycontrol.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class V1_People extends RepresentationModel<V1_People> implements Serializable {

    private static final long serialVersionUID = 1L;
@JsonProperty("id")
    private long key;

    private String nome;
    private String contact;
    private Date nasc;
    private String category;



}
