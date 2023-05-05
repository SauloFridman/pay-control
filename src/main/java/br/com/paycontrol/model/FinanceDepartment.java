package br.com.paycontrol.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "financedepartment")
public class FinanceDepartment implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long registered;

@Column(name = "payment_received",nullable = false)
    private Double paymentReceived;

@Column(name = "date_payment", nullable = false)
    private Date datePayment;


@Column(name = "received_by", nullable = false)
    private long receivedBy;


}
