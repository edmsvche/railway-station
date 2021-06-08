package com.example.railwaystation.model;

import com.example.railwaystation.model.enums.Race;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "race")
    @Enumerated(EnumType.STRING)
    private Race race;

    @Column(name = "initial_destination")
    private String initialDestination;

    @Column(name = "final_destination")
    private String finalDestination;

    @Column(name = "main_stations")
    private String mainStations;
}
