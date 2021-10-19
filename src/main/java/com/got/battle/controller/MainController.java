package com.got.battle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.got.battle.bean.ResultDTO;
import com.got.battle.service.BattleService;
import com.got.battle.utils.CSVDataHandler;

@RestController
@RequestMapping("/api/v1")
public class MainController {

	@Autowired
	private BattleService battleService;

	@RequestMapping(value = "/importCsvData", headers = "content-type=multipart/*", method = RequestMethod.POST)
	public ResponseEntity<?> importCsvData(@RequestParam("file") MultipartFile file) {
		System.err.println("::: MainController.importCsvData :::");
		ResultDTO<?> responsePacket = null;
		String message = "";
		try {
			if (CSVDataHandler.hasCSVFormat(file)) {
				message = "CSV uploaded successfully: " + file.getOriginalFilename();
				responsePacket = new ResultDTO<>(battleService.importCsvData(file), message, true);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				message = "Please upload a csv file!";
				responsePacket = new ResultDTO<>(null, message, false);
				return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			responsePacket = new ResultDTO<>(null, message, false);
			return new ResponseEntity<>(responsePacket, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/placesList")
	public ResponseEntity<?> placesList() {
		System.err.println("::: MainController.placesList :::");
		ResultDTO<?> responsePacket = null;
		String message = "";
		try {
			message = "Record Fetched Successfully !!!";
			responsePacket = new ResultDTO<>(battleService.placesList(), message, true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responsePacket = new ResultDTO<>(null, message, false);
			return new ResponseEntity<>(responsePacket, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/getBattlesCount")
	public ResponseEntity<?> getBattlesCount() {
		System.err.println("::: MainController.getBattlesCount :::");
		ResultDTO<?> responsePacket = null;
		String message = "";
		try {
			message = "Record Fetched Successfully !!!";
			responsePacket = new ResultDTO<>(battleService.getBattlesCount(), message, true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responsePacket = new ResultDTO<>(null, message, false);
			return new ResponseEntity<>(responsePacket, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/getBattlesList")
	public ResponseEntity<?> getBattlesList() {
		System.err.println("::: MainController.getBattlesList :::");
		ResultDTO<?> responsePacket = null;
		String message = "";
		try {
			message = "Record Fetched Successfully !!!";
			responsePacket = new ResultDTO<>(battleService.getBattlesList(), message, true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responsePacket = new ResultDTO<>(null, message, false);
			return new ResponseEntity<>(responsePacket, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/getBattleByNumber/{number}")
	public ResponseEntity<?> getBattleByNumber(@PathVariable("number") String number) {
		System.err.println("::: MainController.getBattleByNumber :::");
		ResultDTO<?> responsePacket = null;
		String message = "";
		try {
			message = "Record Fetched Successfully !!!";
			responsePacket = new ResultDTO<>(battleService.getBattleByNumber(number), message, true);
			return new ResponseEntity<>(responsePacket, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responsePacket = new ResultDTO<>(null, message, false);
			return new ResponseEntity<>(responsePacket, HttpStatus.EXPECTATION_FAILED);
		}
	}
}