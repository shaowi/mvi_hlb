package com.mvidyn.std.phub.ui.data;

import com.mvidyn.std.phub.ui.model.Applicant;
import com.mvidyn.std.phub.ui.model.Beneficiary;
import com.mvidyn.std.phub.ui.model.form.online.data.OnlineCbftData;
import com.mvidyn.std.phub.ui.model.form.online.form.OnlineCbftForm;
import com.mvidyn.std.phub.ui.model.form.payment.ForeignPaymentForm;

public class MockData {

	public static final Applicant APPLICANT = Applicant.builder().id(1).idType("idType").name("name")
			.accountNumber("accountNumber")
			.isResident(true).bankBic("bankBic").addresses("address1,address2")
			.accountType("accountType")
			.accountCurrency("accountCurrency").accountCifId("accountCifId").branchCode("branchCode")
			.postalCode("postalCode").countryCode("countryCode").phoneNumber("phoneNumber").build();

	public static final Beneficiary BENEFICIARY = Beneficiary.builder().id(2).idType("idType").name("name")
			.accountNumber("accountNumber")
			.isResident(true).bankBic("bankBic").addresses("address1,address2")
			.bankAddresses("bankAddress1,bankAddress2").build();

	public static final ForeignPaymentForm FOREIGN_PAYMENT_FORM = ForeignPaymentForm.builder().remittanceCurrency("USD")
			.remittanceAmount(1000)
			.paymentCurrency("USD").paymentAmount(1000).localEquivalentAmount(1000).fxRefNumber("123456789")
			.exchangeRate(1.0).creditFxRate(1.0).debitFxRate(1.0).build();

	public static final OnlineCbftForm ONLINE_CBFT_FORM = OnlineCbftForm.builder()
			.id(0)
			.transactionDate("2020-01-01")
			.transactionType("CBFT")
			.requestChannel("WEB")
			.valueDate("2020-01-01")
			.businessDate("2020-01-01")
			.sendersCorrespondent("sendersCorrespondent")
			.receiversCorrespondent("receiversCorrespondent")
			.channelTransactionRef("channelTransactionRef")
			.recipientRef("recipientRef")
			.purposeOfPayment("purposeOfPayment")
			.remittanceInfo("remittanceInfo")
			.senderToReceiverInfo("senderToReceiverInfo")
			.otherPaymentDetails("otherPaymentDetails")
			.requesterComments("requesterComments")
			.creditMidRate(11.11)
			.debitMidRate(12.11)
			.chargeBearer("our")
			.commissionExchange(0)
			.commissionHandle(0)
			.cableCharge(0)
			.totalFee(0)
			.netPayment(0)
			.netRemittance(0)
			.applicant(APPLICANT)
			.beneficiary(BENEFICIARY)
			.foreignPaymentForm(FOREIGN_PAYMENT_FORM)
			.build();

	public static final OnlineCbftData ONLINE_CBFT_DATA = OnlineCbftData.builder()
			.id(0)
			.transactionDate("2020-01-01")
			.transactionType("CBFT")
			.requestChannel("WEB")
			.valueDate("2020-01-01")
			.businessDate("2020-01-01")
			.sendersCorrespondent("sendersCorrespondent")
			.receiversCorrespondent("receiversCorrespondent")
			.channelTransactionRef("channelTransactionRef")
			.recipientRef("recipientRef")
			.purposeOfPayment("purposeOfPayment")
			.remittanceInfo("remittanceInfo")
			.senderToReceiverInfo("senderToReceiverInfo")
			.otherPaymentDetails("otherPaymentDetails")
			.requesterComments("requesterComments")
			.creditMidRate(11.11)
			.debitMidRate(12.11)
			.chargeBearer("our")
			.commissionExchange(0)
			.commissionHandle(0)
			.cableCharge(0)
			.totalFee(0)
			.netPayment(0)
			.netRemittance(0)
			.applicantId(1)
			.beneficiaryId(2)
			.foreignPaymentFormId(FOREIGN_PAYMENT_FORM.getId())
			.build();
}
