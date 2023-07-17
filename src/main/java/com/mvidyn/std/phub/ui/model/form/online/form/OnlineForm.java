package com.mvidyn.std.phub.ui.model.form.online.form;

import com.mvidyn.std.phub.ui.model.Applicant;
import com.mvidyn.std.phub.ui.model.Beneficiary;
import com.mvidyn.std.phub.ui.model.form.online.OnlineBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class OnlineForm extends OnlineBase {

	private Applicant applicant;
	private Beneficiary beneficiary;

	public OnlineForm(Applicant applicant, Beneficiary beneficiary, long id, String processingMode,
			String transactionType,
			String requestChannel, String transactionDate, String valueDate,
			String businessDate, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionReference, String recipientReference,
			String purposeOfPayment,
			String remittanceInfo, String additionalRemittanceInfo, String senderToReceiverInfo,
			String additionalSenderToReceiverInfo, String otherPaymentDetails, String reviewerComments,
			String requesterComments,
			String status) {
		super(id, processingMode, transactionType, requestChannel, transactionDate, valueDate, businessDate,
				sendersCorrespondent,
				receiversCorrespondent, channelTransactionReference, recipientReference, purposeOfPayment,
				remittanceInfo,
				additionalRemittanceInfo, senderToReceiverInfo, additionalSenderToReceiverInfo, otherPaymentDetails,
				reviewerComments,
				requesterComments, status);
		this.applicant = applicant;
		this.beneficiary = beneficiary;
	}

}
