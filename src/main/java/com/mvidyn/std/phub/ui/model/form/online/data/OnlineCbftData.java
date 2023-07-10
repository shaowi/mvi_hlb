package com.mvidyn.std.phub.ui.model.form.online.data;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "online_cbft_transaction")
public class OnlineCbftData extends OnlineData {

	private String filename;
	private String debitType;

	// Payment details
	private long foreignPaymentFormId;

	// Charges details
	private double creditMidRate;
	private double debitMidRate;
	private String chargeBearer;
	private double commissionExchange;
	private double commissionHandle;
	private double cableCharge;
	private double totalFee;
	private double netPayment;
	private double netRemittance;

	@Builder
	public OnlineCbftData(long id, String transactionType, String requestChannel,
			String transactionDate,
			String valueDate,
			String businessDate, long applicantId, long beneficiaryId, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionRef, String recipientRef, String purposeOfPayment,
			String remittanceInfo, String addRemittanceInfo, String senderToReceiverInfo,
			String addSenderToReceiverInfo, String otherPaymentDetails, String requesterComments,
			long foreignPaymentFormId, String filename, String debitType, double creditMidRate, double debitMidRate,
			String chargeBearer,
			double commissionExchange, double commissionHandle, double cableCharge, double totalFee, double netPayment,
			double netRemittance) {
		super(applicantId, beneficiaryId, id, transactionType, requestChannel, transactionDate, valueDate,
				businessDate,
				sendersCorrespondent,
				receiversCorrespondent, channelTransactionRef, recipientRef, purposeOfPayment, remittanceInfo,
				addRemittanceInfo, senderToReceiverInfo, addSenderToReceiverInfo, otherPaymentDetails,
				requesterComments);
		this.foreignPaymentFormId = foreignPaymentFormId;
		this.filename = filename;
		this.debitType = debitType;
		this.creditMidRate = creditMidRate;
		this.debitMidRate = debitMidRate;
		this.chargeBearer = chargeBearer;
		this.commissionExchange = commissionExchange;
		this.commissionHandle = commissionHandle;
		this.cableCharge = cableCharge;
		this.totalFee = totalFee;
		this.netPayment = netPayment;
		this.netRemittance = netRemittance;
	}

}