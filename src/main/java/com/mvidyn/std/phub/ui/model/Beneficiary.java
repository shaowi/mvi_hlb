package com.mvidyn.std.phub.ui.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "beneficiaries")
public class Beneficiary extends Transactor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bankAddresses;

	@Builder
	public Beneficiary(int id, String idType, String name, String accountNumber, boolean isResident, String bankBic,
			String addresses, String bankAddresses) {
		super(idType, name, accountNumber, isResident, bankBic, addresses);
		this.id = id;
		this.bankAddresses = bankAddresses;
	}

}
