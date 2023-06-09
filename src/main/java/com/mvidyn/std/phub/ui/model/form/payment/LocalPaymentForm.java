package com.mvidyn.std.phub.ui.model.form.payment;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Table(name = "local_payments")
public class LocalPaymentForm extends PaymentForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Builder
	public LocalPaymentForm(String remittanceCurrency, double remittanceAmount, String paymentCurrency,
			double paymentAmount, double localEquivalentAmount, String debitAccountNumber, String creditAccountNumber,
			String debitAccountCurrency, String creditAccountCurrency, String debitAccountName,
			String creditAccountName, String debitAccountType, String creditAccountType, String debitAccountCifId,
			String creditAccountCifId, String debitBranchCode, String creditBranchCode, String debitPostalCode,
			String creditPostalCode, String debitCountryCode, String creditCountryCode, String debitPhoneNumber,
			String creditPhoneNumber) {
		super(remittanceCurrency, remittanceAmount, paymentCurrency, paymentAmount, localEquivalentAmount);
	}
}
