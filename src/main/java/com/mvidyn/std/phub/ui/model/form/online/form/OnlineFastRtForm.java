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
	private double transactionFee;
	private double totalFee;
	private double netPayment;
	private double netRemittance;

	@Builder
	public OnlineFastRtForm(int id, String transactionType, String requestChannel, String transactionDate,
			String valueDate,
			String businessDate, Applicant applicant, Beneficiary beneficiary, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionRef, String recipientRef, String purposeOfPayment,
			String remittanceInfo, String addRemittanceInfo, String senderToReceiverInfo,
			String addSenderToReceiverInfo, String otherPaymentDetails, String requesterComments,
			LocalPaymentForm localPaymentForm, double transactionFee, double totalFee, double netPayment,
			double netRemittance) {
		super(id, transactionType, requestChannel, transactionDate, valueDate, businessDate, applicant, beneficiary,
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
