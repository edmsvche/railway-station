package com.example.railwaystation.model;

import com.example.railwaystation.model.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private Double age;

    @Column(name = "skills")
    private String skills;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "town")
    private String town;

    @Column(name = "children_number")
    private Long childrenNumber;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonIgnore
    private Category categoryId;

    @ManyToOne
    @JoinColumn(name = "brigade_id", referencedColumnName = "id")
    @JsonIgnore
    private Brigade brigadeId;
}
