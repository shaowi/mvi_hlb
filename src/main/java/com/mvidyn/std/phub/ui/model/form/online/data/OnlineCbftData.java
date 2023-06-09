package com.mvidyn.std.phub.ui.model.form.online.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Table(name = "online_cbft_transaction")
@Entity
public class OnlineCbftData extends OnlineData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Payment details
	private int foreignPaymentFormId;

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
	public OnlineCbftData(int id, String transactionType, String requestChannel, String transactionDate,
			String valueDate,
			String businessDate, int applicantId, int beneficiaryId, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionRef, String recipientRef, String purposeOfPayment,
			String remittanceInfo, String addRemittanceInfo, String senderToReceiverInfo,
			String addSenderToReceiverInfo, String otherPaymentDetails, String requesterComments,
			int foreignPaymentFormId, double creditMidRate, double debitMidRate, String chargeBearer,
			double commissionExchange, double commissionHandle, double cableCharge, double totalFee, double netPayment,
			double netRemittance) {
		super(transactionType, requestChannel, transactionDate, valueDate, businessDate, applicantId, beneficiaryId,
				sendersCorrespondent, receiversCorrespondent, channelTransactionRef, recipientRef, purposeOfPayment,
				remittanceInfo, addRemittanceInfo, senderToReceiverInfo, addSenderToReceiverInfo, otherPaymentDetails,
				requesterComments);
		this.id = id;
		this.foreignPaymentFormId = foreignPaymentFormId;
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