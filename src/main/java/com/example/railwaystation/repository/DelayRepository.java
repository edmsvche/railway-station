package com.example.railwaystation.repository;

import com.example.railwaystation.model.Delay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DelayRepository extends JpaRepository<Delay,Long> {
}
