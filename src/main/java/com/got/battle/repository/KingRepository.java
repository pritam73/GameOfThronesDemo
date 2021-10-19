package com.got.battle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.got.battle.model.King;

public interface KingRepository extends JpaRepository<King, Long> {

	@Query(value = "SELECT k FROM King k WHERE k.king = :attackKing OR k.king =:defKing")
	King findByKing(String attackKing, String defKing);

	King findByKing(String attackKing);

}
