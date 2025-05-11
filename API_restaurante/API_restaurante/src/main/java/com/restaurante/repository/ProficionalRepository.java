package com.restaurante.repository;

import com.restaurante.model.Proficional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProficionalRepository extends JpaRepository<Proficional, Long> {


}
