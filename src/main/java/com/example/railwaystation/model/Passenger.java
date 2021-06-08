package com.example.railwaystation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "luggage_compartment")
    private String luggageCompartment;

    @Column(name = "weight_goods")
    private Long weightGoods;

    @OneToOne
    @JoinColumn(name = "ticket_id",referencedColumnName = "id")
    @JsonIgnore
    private Ticket ticketId;
}
