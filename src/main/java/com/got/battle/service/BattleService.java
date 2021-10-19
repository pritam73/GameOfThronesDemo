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
import com.got.battle.model.Location;
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
		return battlesRepository.findByBattleNumber(number);
	}
}