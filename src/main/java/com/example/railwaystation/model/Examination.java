package com.example.railwaystation.model;

import com.example.railwaystation.model.enums.Estimation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "examination")
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estimation")
    @Enumerated(EnumType.STRING)
    private Estimation estimation;

    @Column(name = "date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    @JsonIgnore
    private Employee employeeId;
}
