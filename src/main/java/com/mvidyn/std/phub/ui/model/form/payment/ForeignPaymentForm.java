package com.mvidyn.std.phub.ui.model.form.payment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "foreign_payments")
public class ForeignPaymentForm extends PaymentForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fxRefNumber;
	private double exchangeRate;
	private double creditFxRate;
	private double debitFxRate;

	@Builder
	public ForeignPaymentForm(String remittanceCurrency, double remittanceAmount, String paymentCurrency,
			double paymentAmount, double localEquivalentAmount, String fxRefNumber, double exchangeRate,
			double creditFxRate, double debitFxRate) {
		super(remittanceCurrency, remittanceAmount, paymentCurrency, paymentAmount, localEquivalentAmount);
		this.fxRefNumber = fxRefNumber;
		this.exchangeRate = exchangeRate;
		this.creditFxRate = creditFxRate;
		this.debitFxRate = debitFxRate;
	}
}
