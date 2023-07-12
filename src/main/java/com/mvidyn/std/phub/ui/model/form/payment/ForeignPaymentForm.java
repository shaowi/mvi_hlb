package com.mvidyn.std.phub.ui.model.form.payment;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "foreign_payments")
public class ForeignPaymentForm extends PaymentForm {

	private String fxContractReferenceNo;
	private double exchangeRate;
	private double creditFxRate;
	private double debitFxRate;

	@Builder
	public ForeignPaymentForm(long id, String remittanceCurrency, double remittanceAmount, String paymentCurrency,
			double paymentAmount, double localEquivalentAmount, String fxContractReferenceNo, double exchangeRate,
			double creditFxRate, double debitFxRate) {
		super(id, remittanceCurrency, remittanceAmount, paymentCurrency, paymentAmount, localEquivalentAmount);
		this.fxContractReferenceNo = fxContractReferenceNo;
		this.exchangeRate = exchangeRate;
		this.creditFxRate = creditFxRate;
		this.debitFxRate = debitFxRate;
	}
}
