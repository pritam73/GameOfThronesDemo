package com.got.battle.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.got.battle.bean.BaseDTO;
import com.got.battle.model.Battles;
import com.got.battle.model.Commander;
import com.got.battle.model.King;
import com.got.battle.model.Location;
import com.got.battle.model.Year;
import com.got.battle.utils.CSVDataHandler;

@Service
public class BattleService extends BaseDTO {

	@Autowired
	private CSVDataHandler csvData;

	public Object importCsvData(MultipartFile file) throws IOException {
		csvData.csvToBattles(file.getInputStream());
		return null;
	}

	public Object placesList() {
		List<Location> locationList = locationRepository.findAll();
		List<Object> dataList = new ArrayList<>();
		for (Location location : locationList) {
			HashMap<String, Object> hashMap = new HashMap<>();
			hashMap.put("location", location.getLocation());
			hashMap.put("region", location.getRegionId().getRegion());
			dataList.add(hashMap);
		}
		return dataList;
	}

	public Object getBattlesCount() {
		return battlesRepository.count();
	}

	public Object getBattlesList() {
		List<Battles> battles = battlesRepository.findAll();
		List<Object> dataList = new ArrayList<>();
		for (Battles battle : battles) {
			HashMap<String, Object> hashMap = new HashMap<>();
			hashMap.put("id", battle.getId());
			hashMap.put("name", battle.getName());
			hashMap.put("battleNumber", battle.getBattleNumber());
			dataList.add(hashMap);
		}
		return dataList;
	}

	public Object getBattleByNumber(String number) {
		Battles battle = battlesRepository.findByBattleNumber(number);
		HashMap<String, Object> hashMap = new HashMap<>();
		if (battle != null) {
			King attckerKing = kingRepository.findById(battle.getAttackerKingId()).get();
			King defnderKing = kingRepository.findById(battle.getDefenderKingId()).get();
			Commander attackerCommander = commanderRepository.findById(battle.getAttackerCommanderId()).get();
			Commander defenderCommander = commanderRepository.findById(battle.getAttackerCommanderId()).get();
			Year year = yearRepository.findById(battle.getYearId()).get();
			hashMap.put("id", battle.getId());
			hashMap.put("name", battle.getName());
			hashMap.put("battleNumber", battle.getBattleNumber());
			hashMap.put("attackerOutcome", battle.getAttackerOutcome());
			hashMap.put("majorDeath", battle.getMajorDeath());
			hashMap.put("majorCapture", battle.getMajorCapture());
			hashMap.put("attackerSize", battle.getAttackerSize());
			hashMap.put("defenderSize", battle.getDefenderSize());
			hashMap.put("summer", battle.getSummer());
			hashMap.put("note", battle.getNote());
			hashMap.put("attackerKing", attckerKing.getKing());
			hashMap.put("defenderKing", defnderKing.getKing());
			hashMap.put("attackerCommander", attackerCommander.getCommander());
			hashMap.put("defenderCommander", defenderCommander.getCommander());
			hashMap.put("year", year.getYear());
			hashMap.put("location", battle.getLocation());
		}
		return hashMap;
	}

	public Object userDetails() {
		return kingRepository.findAll();
	}
}