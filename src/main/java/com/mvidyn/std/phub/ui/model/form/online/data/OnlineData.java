package com.mvidyn.std.phub.ui.model.form.online.data;

import com.mvidyn.std.phub.ui.model.form.online.OnlineBase;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OnlineData extends OnlineBase {

	private int applicantId;
	private int beneficiaryId;

	@Builder(builderMethodName = "onlineDataBuilder")
	public OnlineData(String transactionType, String requestChannel, String transactionDate, String valueDate,
			String businessDate, int applicantId, int beneficiaryId, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionRef, String recipientRef, String purposeOfPayment,
			String remittanceInfo, String addRemittanceInfo, String senderToReceiverInfo,
			String addSenderToReceiverInfo, String otherPaymentDetails, String requesterComments) {
		super(transactionType, requestChannel, transactionDate, valueDate, businessDate, sendersCorrespondent,
				receiversCorrespondent, channelTransactionRef, recipientRef, purposeOfPayment, remittanceInfo,
				addRemittanceInfo, senderToReceiverInfo, addSenderToReceiverInfo, otherPaymentDetails,
				requesterComments);
		this.applicantId = applicantId;
		this.beneficiaryId = beneficiaryId;
	}

}
