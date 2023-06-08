package com.mvidyn.std.phub.ui.model.form.online.form;

import com.mvidyn.std.phub.ui.model.Applicant;
import com.mvidyn.std.phub.ui.model.Beneficiary;
import com.mvidyn.std.phub.ui.model.form.payment.ForeignPaymentForm;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OnlineIntraBankForm extends OnlineForm {

	// Payment details
	private ForeignPaymentForm foreignPaymentForm;

	@Builder
	public OnlineIntraBankForm(int id, String transactionType, String requestChannel, String transactionDate,
			String valueDate,
			String businessDate, Applicant applicant, Beneficiary beneficiary, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionRef, String recipientRef, String purposeOfPayment,
			String remittanceInfo, String addRemittanceInfo, String senderToReceiverInfo,
			String addSenderToReceiverInfo, String otherPaymentDetails, String requesterComments,
			ForeignPaymentForm foreignPaymentForm) {
		super(id, transactionType, requestChannel, transactionDate, valueDate, businessDate, applicant, beneficiary,
				sendersCorrespondent, receiversCorrespondent, channelTransactionRef, recipientRef, purposeOfPayment,
				remittanceInfo, addRemittanceInfo, senderToReceiverInfo, addSenderToReceiverInfo, otherPaymentDetails,
				requesterComments);
		this.foreignPaymentForm = foreignPaymentForm;
	}

}
