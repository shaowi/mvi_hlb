package com.mvidyn.std.phub.ui.model.form.online;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OnlineBase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String transactionType;
	private String requestChannel;
	private String transactionDate;
	private String valueDate;
	private String businessDate;

	// Correspondent Bank Details
	private String sendersCorrespondent;
	private String receiversCorrespondent;

	// Transaction Details
	private String channelTransactionRef;
	private String recipientRef;
	private String purposeOfPayment;
	private String remittanceInfo;
	private String addRemittanceInfo;
	private String senderToReceiverInfo;
	private String addSenderToReceiverInfo;
	private String otherPaymentDetails;

	private String requesterComments;
}
