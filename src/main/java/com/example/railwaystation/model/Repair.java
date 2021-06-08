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
@Table(name = "repair")
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kind")
    private String kind;

    @OneToOne
    @JoinColumn(name = "locomotive_id",referencedColumnName = "id")
    @JsonIgnore
    private Locomotive locomotiveId;
}
