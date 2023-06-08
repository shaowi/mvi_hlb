package com.mvidyn.std.phub.ui.model.form.payment;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ForeignPaymentForm extends PaymentForm {

	private String fxRefNumber;
	private float exchangeRate;
	private float creditFxRate;
	private float debitFxRate;

	@Builder
	public ForeignPaymentForm(String remittanceCurrency, float remittanceAmount, String paymentCurrency,
			float paymentAmount, float localEquivalentAmount, String fxRefNumber, float exchangeRate,
			float creditFxRate, float debitFxRate) {
		super(remittanceCurrency, remittanceAmount, paymentCurrency, paymentAmount, localEquivalentAmount);
		this.fxRefNumber = fxRefNumber;
		this.exchangeRate = exchangeRate;
		this.creditFxRate = creditFxRate;
		this.debitFxRate = debitFxRate;
	}
}
