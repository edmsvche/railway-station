package com.example.railwaystation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brigade")
public class Brigade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    @JsonIgnore
    private Department departmentId;

    @ManyToOne
    @JoinColumn(name = "locomotive_id",referencedColumnName = "id")
    @JsonIgnore
    private Locomotive locomotiveId;

}
