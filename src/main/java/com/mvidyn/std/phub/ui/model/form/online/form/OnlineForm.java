package com.mvidyn.std.phub.ui.model.form.online.form;

import com.mvidyn.std.phub.ui.model.Applicant;
import com.mvidyn.std.phub.ui.model.Beneficiary;
import com.mvidyn.std.phub.ui.model.form.online.OnlineBase;
import lombok.Getter;

@Getter
public abstract class OnlineForm extends OnlineBase {

	private Applicant applicant;
	private Beneficiary beneficiary;

	public OnlineForm(Applicant applicant, Beneficiary beneficiary, long id, String transactionType,
			String requestChannel, String transactionDate, String valueDate,
			String businessDate, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionRef, String recipientRef, String purposeOfPayment,
			String remittanceInfo, String addRemittanceInfo, String senderToReceiverInfo,
			String addSenderToReceiverInfo, String otherPaymentDetails, String requesterComments) {
		super(id, transactionType, requestChannel, transactionDate, valueDate, businessDate, sendersCorrespondent,
				receiversCorrespondent, channelTransactionRef, recipientRef, purposeOfPayment, remittanceInfo,
				addRemittanceInfo, senderToReceiverInfo, addSenderToReceiverInfo, otherPaymentDetails,
				requesterComments);
		this.applicant = applicant;
		this.beneficiary = beneficiary;
	}

}
