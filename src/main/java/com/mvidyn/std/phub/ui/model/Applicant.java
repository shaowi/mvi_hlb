package com.mvidyn.std.phub.ui.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "applicants")
public class Applicant extends Transactor {

	private String accountType;
	private String accountCurrency;
	private String accountCifId;

	private String branchCode;

	private String postalCode;
	private String phoneNumber;

	@Builder
	public Applicant(long id, String idType, String name, String accountNumber, boolean isResident, String bankBic,
			String addresses, String accountType, String accountCurrency, String accountCifId, String branchCode,
			String postalCode, String countryCode, String phoneNumber) {
		super(id, idType, name, accountNumber, isResident, bankBic, addresses, countryCode);
		this.accountType = accountType;
		this.accountCurrency = accountCurrency;
		this.accountCifId = accountCifId;
		this.branchCode = branchCode;
		this.postalCode = postalCode;
		this.phoneNumber = phoneNumber;
	}

}