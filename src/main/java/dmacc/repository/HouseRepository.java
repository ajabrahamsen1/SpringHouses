package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> { }