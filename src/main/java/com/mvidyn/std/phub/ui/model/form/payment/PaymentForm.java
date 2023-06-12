package com.mvidyn.std.phub.ui.model.form.payment;

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
public abstract class PaymentForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String remittanceCurrency;
	private double remittanceAmount;
	private String paymentCurrency;
	private double paymentAmount;
	private double localEquivalentAmount;
}
