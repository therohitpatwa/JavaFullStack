package com.example.CheckTrain.repo;

import com.example.CheckTrain.enitity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StationRepository extends JpaRepository<Station,Long> {
}
