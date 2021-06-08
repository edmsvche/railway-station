package com.example.railwaystation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departure_day")
    private String departureDay;

    @Column(name = "arrival_day")
    private String arrivalDay;

    @Column(name = "departure_date")
    private Date departureDate;

    @Column(name = "arrival_date")
    private Date arrivalDate;

    @OneToOne
    @JoinColumn(name = "route_id",referencedColumnName = "id")
    @JsonIgnore
    private Route routeId;

    @OneToOne
    @JoinColumn(name = "locomotive_id",referencedColumnName = "id")
    @JsonIgnore
    private Locomotive locomotiveId;
}
