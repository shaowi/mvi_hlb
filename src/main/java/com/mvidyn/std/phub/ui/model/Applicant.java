package com.mvidyn.std.phub.ui.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Applicant extends Transactor {

	private String accountType;
	private String accountCurrency;
	private String accountCifId;

	private String branchCode;

	private String postalCode;
	private String countryCode;
	private String phoneNumber;

	@Builder
	public Applicant(int id, String idType, String name, String accountNumber, boolean isResident, String bankBic,
			List<String> addresses, String accountType, String accountCurrency, String accountCifId, String branchCode,
			String postalCode, String countryCode, String phoneNumber) {
		super(id, idType, name, accountNumber, isResident, bankBic, addresses);
		this.accountType = accountType;
		this.accountCurrency = accountCurrency;
		this.accountCifId = accountCifId;
		this.branchCode = branchCode;
		this.postalCode = postalCode;
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
	}
}