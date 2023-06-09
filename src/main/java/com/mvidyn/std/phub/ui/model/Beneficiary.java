package com.mvidyn.std.phub.ui.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "beneficiaries")
public class Beneficiary extends Transactor {

	private List<String> bankAddresses;

	@Builder
	public Beneficiary(int id, String idType, String name, String accountNumber, boolean isResident, String bankBic,
			List<String> addresses, List<String> bankAddresses) {
		super(id, idType, name, accountNumber, isResident, bankBic, addresses);
		this.bankAddresses = bankAddresses;
	}

}
