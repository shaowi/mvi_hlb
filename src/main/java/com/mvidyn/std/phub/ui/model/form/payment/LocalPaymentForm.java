package com.mvidyn.std.phub.ui.model.form.payment;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "local_payments")
public class LocalPaymentForm extends PaymentForm {

	@Builder
	public LocalPaymentForm(long id, String remittanceCurrency, double remittanceAmount, String paymentCurrency,
			double paymentAmount, double localEquivalentAmount, String debitAccountNumber, String creditAccountNumber,
			String debitAccountCurrency, String creditAccountCurrency, String debitAccountName,
			String creditAccountName, String debitAccountType, String creditAccountType, String debitAccountCifId,
			String creditAccountCifId, String debitBranchCode, String creditBranchCode, String debitPostalCode,
			String creditPostalCode, String debitCountryCode, String creditCountryCode, String debitPhoneNumber,
			String creditPhoneNumber) {
		super(id, remittanceCurrency, remittanceAmount, paymentCurrency, paymentAmount, localEquivalentAmount);
	}
}
