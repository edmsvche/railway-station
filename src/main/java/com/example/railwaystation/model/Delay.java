package com.example.railwaystation.model;

import com.example.railwaystation.model.enums.Cause;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "delay")
public class Delay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cause")
    @Enumerated(EnumType.STRING)
    private Cause cause;

    @Column(name = "hours_spent")
    private Double hoursSpent;

    @ManyToOne
    @JoinColumn(name = "schedule_id",referencedColumnName = "id")
    @JsonIgnore
    private Schedule scheduleId;
}
