package com.got.battle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.got.battle.model.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

	Location findByLocation(String location);

}
