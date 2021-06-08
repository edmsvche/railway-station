package com.example.railwaystation.model;

import com.example.railwaystation.model.enums.Purchase;
import com.example.railwaystation.model.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private Double price;

    @Column(name = "purchase_method")
    @Enumerated(EnumType.STRING)
    private Purchase purchaseMethod;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @ManyToOne
    @JoinColumn(name = "schedule_id",referencedColumnName = "id")
    @JsonIgnore
    private Schedule scheduleId;
}
