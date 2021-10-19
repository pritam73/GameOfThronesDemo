package com.got.battle.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Battles {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String battleNumber;
	private String attackerOutcome;
	private String majorDeath;
	private String majorCapture;
	private String attackerSize;
	private String defenderSize;
	private String summer;
	@Column(columnDefinition = "TEXT")
	private String note;
	private Long attackerKingId;
	private Long defenderKingId;
	private Long attackerCommanderId;
	private Long defenderCommanderId;
	private Long regionId;
	private Long battleTypeId;
	private Long yearId;

	@ManyToMany
	@JoinTable(name = "battle_location", joinColumns = @JoinColumn(name = "battle_id"), inverseJoinColumns = @JoinColumn(name = "location_id"))
	private Set<Location> location = new HashSet<>();

	public Battles() {
	}

	public Battles(String name, String battleNumber, String attackerOutcome, String majorDeath, String majorCapture,
			String attackerSize, String defenderSize, String summer, String note, Long attackerKingId,
			Long defenderKingId, Long attackerCommanderId, Long defenderCommanderId, Set<Location> location,
			Long regionId, Long battleTypeId, Long yearId) {
		super();
		this.name = name;
		this.battleNumber = battleNumber;
		this.attackerOutcome = attackerOutcome;
		this.majorDeath = majorDeath;
		this.majorCapture = majorCapture;
		this.attackerSize = attackerSize;
		this.defenderSize = defenderSize;
		this.summer = summer;
		this.note = note;
		this.attackerKingId = attackerKingId;
		this.defenderKingId = defenderKingId;
		this.attackerCommanderId = attackerCommanderId;
		this.defenderCommanderId = defenderCommanderId;
		this.location = location;
		this.regionId = regionId;
		this.battleTypeId = battleTypeId;
		this.yearId = yearId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBattleNumber() {
		return battleNumber;
	}

	public void setBattleNumber(String battleNumber) {
		this.battleNumber = battleNumber;
	}

	public String getAttackerOutcome() {
		return attackerOutcome;
	}

	public void setAttackerOutcome(String attackerOutcome) {
		this.attackerOutcome = attackerOutcome;
	}

	public String getMajorDeath() {
		return majorDeath;
	}

	public void setMajorDeath(String majorDeath) {
		this.majorDeath = majorDeath;
	}

	public String getMajorCapture() {
		return majorCapture;
	}

	public void setMajorCapture(String majorCapture) {
		this.majorCapture = majorCapture;
	}

	public String getAttackerSize() {
		return attackerSize;
	}

	public void setAttackerSize(String attackerSize) {
		this.attackerSize = attackerSize;
	}

	public String getDefenderSize() {
		return defenderSize;
	}

	public void setDefenderSize(String defenderSize) {
		this.defenderSize = defenderSize;
	}

	public String getSummer() {
		return summer;
	}

	public void setSummer(String summer) {
		this.summer = summer;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getAttackerKingId() {
		return attackerKingId;
	}

	public void setAttackerKingId(Long attackerKingId) {
		this.attackerKingId = attackerKingId;
	}

	public Long getDefenderKingId() {
		return defenderKingId;
	}

	public void setDefenderKingId(Long defenderKingId) {
		this.defenderKingId = defenderKingId;
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

	public Set<Location> getLocation() {
		return location;
	}

	public void setLocation(Set<Location> location) {
		this.location = location;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public Long getBattleTypeId() {
		return battleTypeId;
	}

	public void setBattleTypeId(Long battleTypeId) {
		this.battleTypeId = battleTypeId;
	}

	public Long getYearId() {
		return yearId;
	}

	public void setYearId(Long yearId) {
		this.yearId = yearId;
	}
}