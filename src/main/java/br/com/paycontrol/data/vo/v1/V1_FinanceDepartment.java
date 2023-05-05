package br.com.paycontrol.data.vo.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class V1_FinanceDepartment extends RepresentationModel<V1_FinanceDepartment> implements Serializable {

    private static final long serialVersionUID = 1L;

    private long registered;

    private Double paymentReceived;

    private Date datePayment;

    private long receivedBy;


}
