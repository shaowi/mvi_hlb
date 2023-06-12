package com.mvidyn.std.phub.ui.model.form.online;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Entity
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class OnlineBase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

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
