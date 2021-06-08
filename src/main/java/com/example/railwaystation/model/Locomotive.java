package com.example.railwaystation.model;

import com.example.railwaystation.model.enums.Condition;
import com.example.railwaystation.model.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "locomotive")
public class Locomotive {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_wagons")
    private Long numberWagons;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "condition")
    @Enumerated(EnumType.STRING)
    private Condition condition;

}
