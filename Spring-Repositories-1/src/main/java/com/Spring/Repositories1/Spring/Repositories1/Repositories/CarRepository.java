package com.Spring.Repositories1.Spring.Repositories1.Repositories;

import com.Spring.Repositories1.Spring.Repositories1.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
