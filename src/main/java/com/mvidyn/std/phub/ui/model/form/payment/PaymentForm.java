package com.mvidyn.std.phub.ui.model.form.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentForm {
	private String remittanceCurrency;
	private double remittanceAmount;
	private String paymentCurrency;
	private double paymentAmount;
	private double localEquivalentAmount;
}
