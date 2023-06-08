package com.mvidyn.std.phub.ui.model.form.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentForm {
	private String remittanceCurrency;
	private float remittanceAmount;
	private String paymentCurrency;
	private float paymentAmount;
	private float localEquivalentAmount;
}
