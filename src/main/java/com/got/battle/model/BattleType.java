package com.got.battle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BattleType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String battleType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBattleType() {
		return battleType;
	}

	public void setBattleType(String battleType) {
		this.battleType = battleType;
	}

}
