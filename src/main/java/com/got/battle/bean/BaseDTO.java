package com.got.battle.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.got.battle.repository.BattleTypeRepository;
import com.got.battle.repository.BattlesRepository;
import com.got.battle.repository.CommanderRepository;
import com.got.battle.repository.KingRepository;
import com.got.battle.repository.LocationRepository;
import com.got.battle.repository.RegionRepository;
import com.got.battle.repository.YearRepository;

public abstract class BaseDTO {

	@Autowired
	protected YearRepository yearRepository;

	@Autowired
	protected BattleTypeRepository battleTypeRepository;

	@Autowired
	protected KingRepository kingRepository;

	@Autowired
	protected CommanderRepository commanderRepository;

	@Autowired
	protected LocationRepository locationRepository;

	@Autowired
	protected RegionRepository regionRepository;

	@Autowired
	protected BattlesRepository battlesRepository;
}