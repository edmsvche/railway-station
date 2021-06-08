package com.example.railwaystation.repository;

import com.example.railwaystation.model.Locomotive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocomotiveRepository extends JpaRepository<Locomotive,Long> {
}
