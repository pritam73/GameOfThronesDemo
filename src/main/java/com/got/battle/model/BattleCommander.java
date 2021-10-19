package com.got.battle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BattleCommander {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long battleId;
	private Long attackerCommanderId;
	private Long defenderCommanderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBattleId() {
		return battleId;
	}

	public void setBattleId(Long battleId) {
		this.battleId = battleId;
	}

	public Long getAttackerCommanderId() {
		return attackerCommanderId;
	}

	public void setAttackerCommanderId(Long attackerCommanderId) {
		this.attackerCommanderId = attackerCommanderId;
	}

	public Long getDefenderCommanderId() {
		return defenderCommanderId;
	}

	public void setDefenderCommanderId(Long defenderCommanderId) {
		this.defenderCommanderId = defenderCommanderId;
	}

}
