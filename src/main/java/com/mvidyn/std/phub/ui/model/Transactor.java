package com.mvidyn.std.phub.ui.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Entity
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Transactor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String idType;
	private String name;
	private String accountNumber;
	private boolean isResident;
	private String bankBic;
	private String addresses;
}
