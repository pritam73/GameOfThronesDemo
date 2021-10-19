package com.got.battle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.got.battle.model.BattleType;

public interface BattleTypeRepository extends JpaRepository<BattleType, Long> {

	BattleType findByBattleType(String batType);

}
