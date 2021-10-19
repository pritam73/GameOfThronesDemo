package com.got.battle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.got.battle.model.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {

	Region findByRegion(String region);

}
