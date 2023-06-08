package com.mvidyn.std.phub.ui.model.form.online.form;

import com.mvidyn.std.phub.ui.model.Applicant;
import com.mvidyn.std.phub.ui.model.Beneficiary;
import com.mvidyn.std.phub.ui.model.form.payment.LocalPaymentForm;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OnlineFastRtForm extends OnlineForm {

	// Payment details
	private LocalPaymentForm localPaymentForm;

	// Charges details
	private float transactionFee;
	private float totalFee;
	private float netPayment;
	private float netRemittance;

	@Builder
	public OnlineFastRtForm(String transactionType, String requestChannel, String transactionDate, String valueDate,
			String businessDate, Applicant applicant, Beneficiary beneficiary, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionRef, String recipientRef, String purposeOfPayment,
			String remittanceInfo, String addRemittanceInfo, String senderToReceiverInfo,
			String addSenderToReceiverInfo, String otherPaymentDetails, String requesterComments,
			LocalPaymentForm localPaymentForm, float transactionFee, float totalFee, float netPayment,
			float netRemittance) {
		super(transactionType, requestChannel, transactionDate, valueDate, businessDate, applicant, beneficiary,
				sendersCorrespondent, receiversCorrespondent, channelTransactionRef, recipientRef, purposeOfPayment,
				remittanceInfo, addRemittanceInfo, senderToReceiverInfo, addSenderToReceiverInfo, otherPaymentDetails,
				requesterComments);
		this.localPaymentForm = localPaymentForm;
		this.transactionFee = transactionFee;
		this.totalFee = totalFee;
		this.netPayment = netPayment;
		this.netRemittance = netRemittance;
	}

}
