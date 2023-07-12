package com.mvidyn.std.phub.ui.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "beneficiaries")
public class Beneficiary extends Transactor {

	private String bankAddresses;
	private String bankCountryCode;

	@Builder
	public Beneficiary(long id, String idType, String name, String accountNumber, boolean isResident, String bankBic,
			String addresses, String countryCode, String bankAddresses, String bankCountryCode) {
		super(id, idType, name, accountNumber, isResident, bankBic, addresses, countryCode);
		this.bankAddresses = bankAddresses;
		this.bankCountryCode = bankCountryCode;
	}

}
