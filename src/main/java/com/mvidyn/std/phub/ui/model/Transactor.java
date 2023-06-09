package com.mvidyn.std.phub.ui.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Transactor {
	private String idType;
	private String name;
	private String accountNumber;
	private boolean isResident;
	private String bankBic;
	private String addresses;
}
