package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "parched_invoice_line_item")
public class ParchedInvoiceLineItem  implements Serializable {
    @Id
    private int  parchedItemId;
    @OneToOne
    @JoinColumn
    private Product product;
    private  int parchedItemQuantity;
    private  double totalItemLinePrice;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                    CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn
    private ParchedInvoice invoice ;

}
