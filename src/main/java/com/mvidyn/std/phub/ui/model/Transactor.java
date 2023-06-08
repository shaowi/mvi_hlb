package com.mvidyn.std.phub.ui.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Transactor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String idType;
	private String name;

	private String accountNumber;

	private boolean isResident;
	private String bankBic;

	private List<String> addresses;
}
