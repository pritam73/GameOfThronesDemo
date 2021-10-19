package com.got.battle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.got.battle.model.Commander;

public interface CommanderRepository extends JpaRepository<Commander, Long> {

	Commander findByCommander(String commander);

}
