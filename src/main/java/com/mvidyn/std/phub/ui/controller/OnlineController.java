package com.mvidyn.std.phub.ui.controller;

import com.mvidyn.std.phub.ui.model.form.online.data.OnlineCbftData;
import com.mvidyn.std.phub.ui.model.form.online.form.OnlineCbftForm;
import com.mvidyn.std.phub.ui.service.OnlineService;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/online")
public class OnlineController {

	@Autowired
	private OnlineService onlineService;

	private static final Logger LOGGER = LoggerFactory.getLogger(OnlineController.class);

	@PostMapping("/cbft/create")
	public ResponseEntity<OnlineCbftData> createCbftTransaction(@RequestBody OnlineCbftForm form, HttpSession session) {
		try {
			LOGGER.error("User " + session.getAttribute("user") + " created a new cbft transaction");
			return new ResponseEntity<>(onlineService.createCbftTransaction(form), HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			LOGGER.error(e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
