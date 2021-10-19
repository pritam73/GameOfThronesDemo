package com.got.battle.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.got.battle.bean.BaseDTO;
import com.got.battle.model.BattleType;
import com.got.battle.model.Battles;
import com.got.battle.model.Commander;
import com.got.battle.model.King;
import com.got.battle.model.Location;
import com.got.battle.model.Region;
import com.got.battle.model.Year;

@Component
public class CSVDataHandler extends BaseDTO {

	public static String TYPE = "text/csv";

	public static boolean hasCSVFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public Object csvToBattles(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			List<Battles> battleList = new ArrayList<Battles>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) {
				Long yearId = null;
				Year existYear = yearRepository.findByYear(csvRecord.get("year"));
				if (existYear != null) {
					yearId = existYear.getId();
				} else {
					Year year = new Year();
					year.setYear(csvRecord.get("year"));
					yearRepository.save(year);
					yearId = year.getId();
				}
				Long batTypeId = null;
				BattleType existBatType = battleTypeRepository.findByBattleType(csvRecord.get("battle_type"));
				if (existBatType != null) {
					batTypeId = existBatType.getId();
				} else {
					BattleType batType = new BattleType();
					batType.setBattleType(csvRecord.get("battle_type"));
					battleTypeRepository.save(batType);
					batTypeId = batType.getId();
				}
				Long attackKingId = null;
				Long defKingId = null;
				King existAttackKing = kingRepository.findByKing(csvRecord.get("attacker_king"));
				if (existAttackKing != null) {
					attackKingId = existAttackKing.getId();
				} else {
					King attackKing = new King();
					attackKing.setKing(csvRecord.get("attacker_king"));
					kingRepository.save(attackKing);
					attackKingId = attackKing.getId();
				}
				King existDefKing = kingRepository.findByKing(csvRecord.get("defender_king"));
				if (existDefKing != null) {
					defKingId = existDefKing.getId();
				} else {
					King defKing = new King();
					defKing.setKing(csvRecord.get("defender_king"));
					kingRepository.save(defKing);
					defKingId = defKing.getId();
				}
				Long attackCmdId = null;
				Commander existAttCmd = commanderRepository.findByCommander(csvRecord.get("attacker_commander"));
				if (existAttCmd != null) {
					attackCmdId = existAttCmd.getId();
				} else {
					Commander attackCmd = new Commander();
					attackCmd.setCommander(csvRecord.get("attacker_commander"));
					commanderRepository.save(attackCmd);
					attackCmdId = attackCmd.getId();
				}
				Commander existDefCmd = commanderRepository.findByCommander(csvRecord.get("attacker_commander"));
				Long defCmdId = null;
				if (existDefCmd != null) {
					defCmdId = existDefCmd.getId();
				} else {
					Commander defCmd = new Commander();
					defCmd.setCommander(csvRecord.get("defender_commander"));
					commanderRepository.save(defCmd);
					defCmdId = defCmd.getId();
				}
				Region existRegion = regionRepository.findByRegion(csvRecord.get("region"));
				Region regionId = null;
				if (existRegion != null) {
					regionId = existRegion;
				} else {
					Region region = new Region();
					region.setRegion(csvRecord.get("region"));
					regionRepository.save(region);
					regionId = region;
				}

				String locationData = csvRecord.get("location");
				String[] data = locationData.split(",");
				Set<Location> locationList = new HashSet<>();
				for (String d : data) {
					Location existLocation = locationRepository.findByLocation(d);
					if (existLocation != null) {
						locationList.add(existLocation);
					} else {
						Location location = new Location();
						location.setLocation(d.trim());
						location.setRegionId(regionId);
						locationRepository.save(location);
						locationList.add(location);
					}
				}

				Battles battle = new Battles(csvRecord.get("name"), csvRecord.get("battle_number"),
						csvRecord.get("attacker_outcome"), csvRecord.get("major_death"), csvRecord.get("major_capture"),
						csvRecord.get("attacker_size"), csvRecord.get("defender_size"), csvRecord.get("summer"),
						csvRecord.get("note"), attackKingId, defKingId, attackCmdId, defCmdId, locationList,
						regionId.getId(), batTypeId, yearId);
				battleList.add(battle);
			}
			battlesRepository.saveAll(battleList);
		} catch (IOException e) {
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
		return null;
	}
}
