package com.mvidyn.std.phub.ui.model.form.online.data;

import com.mvidyn.std.phub.ui.model.form.online.OnlineBase;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class OnlineData extends OnlineBase {

	private long applicantId;
	private long beneficiaryId;

	public OnlineData(long applicantId, long beneficiaryId, long id, String processingMode, String transactionType,
			String requestChannel,
			String transactionDate, String valueDate, String businessDate, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionRef, String recipientRef, String purposeOfPayment,
			String remittanceInfo, String addRemittanceInfo, String senderToReceiverInfo,
			String addSenderToReceiverInfo, String otherPaymentDetails, String requesterComments, String status) {
		super(id, processingMode, transactionType, requestChannel, transactionDate, valueDate, businessDate,
				sendersCorrespondent,
				receiversCorrespondent, channelTransactionRef, recipientRef, purposeOfPayment, remittanceInfo,
				addRemittanceInfo, senderToReceiverInfo, addSenderToReceiverInfo, otherPaymentDetails,
				requesterComments, status);
		this.applicantId = applicantId;
		this.beneficiaryId = beneficiaryId;
	}

}
