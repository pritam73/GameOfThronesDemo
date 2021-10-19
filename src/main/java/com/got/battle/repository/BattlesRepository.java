package com.got.battle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.got.battle.model.Battles;

public interface BattlesRepository extends JpaRepository<Battles, Long> {

	Battles findByBattleNumber(String number);

}
