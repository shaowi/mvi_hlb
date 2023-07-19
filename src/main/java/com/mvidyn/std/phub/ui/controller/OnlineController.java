package com.mvidyn.std.phub.ui.controller;

import java.util.List;

import com.mvidyn.std.phub.ui.exception.Message;
import com.mvidyn.std.phub.ui.model.form.online.data.OnlineCbftData;
import com.mvidyn.std.phub.ui.model.form.online.form.OnlineCbftForm;
import com.mvidyn.std.phub.ui.service.OnlineService;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/online")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OnlineController {

	@Autowired
	private OnlineService onlineService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OnlineController.class);

	@PostMapping("/cbft/create")
	public ResponseEntity<OnlineCbftData> createCbftTransaction(@RequestBody OnlineCbftForm form, HttpSession session) {
		try {
			LOGGER.error("User " + session.getAttribute("user") + " created a new cbft transaction");
			return new ResponseEntity<>(onlineService.saveCbftTransaction(form), HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/cbft/update")
	public ResponseEntity<OnlineCbftData> updateCbftTransaction(@RequestBody OnlineCbftForm form, HttpSession session) {
		try {
			LOGGER.error(
					"User " + session.getAttribute("user") + " updating a cbft transaction of id: " + form.getId());
			return new ResponseEntity<>(onlineService.saveCbftTransaction(form), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/cbft/all")
	public ResponseEntity<List<OnlineCbftForm>> getCbftTransactions(
			HttpSession session) {
		try {
			LOGGER.info("User " + session.getAttribute("user") + " retrieved all cbft transactions");
			return new ResponseEntity<>(onlineService.getCbftTransactions(),
					HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/cbft")
	public ResponseEntity<List<OnlineCbftForm>> getCbftTransactions(@RequestParam String filename,
			HttpSession session) {
		try {
			LOGGER.info("User " + session.getAttribute("user") + " retrieved cbft transactions");
			if (filename.isEmpty()) {
				throw new IllegalArgumentException(Message.INVALID_FILENAME);
			}
			return new ResponseEntity<>(onlineService.getCbftTransactionsByFilename(filename), HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
}
