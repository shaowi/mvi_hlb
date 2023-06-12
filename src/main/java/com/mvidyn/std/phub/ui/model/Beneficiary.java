package com.mvidyn.std.phub.ui.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "beneficiaries")
public class Beneficiary extends Transactor {

	private String bankAddresses;

	@Builder
	public Beneficiary(long id, String idType, String name, String accountNumber, boolean isResident, String bankBic,
			String addresses, String bankAddresses) {
		super(id, idType, name, accountNumber, isResident, bankBic, addresses);
		this.bankAddresses = bankAddresses;
	}

}
