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
@Table(name = "preparation")
public class Preparation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "technical")
    private String technical;

    @Column(name = "service")
    private String service;

    @ManyToOne
    @JoinColumn(name = "locomotive_id",referencedColumnName = "id")
    @JsonIgnore
    private Locomotive locomotiveId;
}
