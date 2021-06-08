package com.example.railwaystation.repository;

import com.example.railwaystation.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
