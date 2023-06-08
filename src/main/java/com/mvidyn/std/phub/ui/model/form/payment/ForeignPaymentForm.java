package com.mvidyn.std.phub.ui.model.form.payment;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ForeignPaymentForm extends PaymentForm {

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
