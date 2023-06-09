package com.mvidyn.std.phub.ui.model.form.online.data;

import com.mvidyn.std.phub.ui.model.form.payment.ForeignPaymentForm;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "online_cbft_transaction")
public class OnlineCbftData extends OnlineData {

	// Payment details
	private ForeignPaymentForm foreignPaymentForm;

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
			ForeignPaymentForm foreignPaymentForm, double creditMidRate, double debitMidRate, String chargeBearer,
			double commissionExchange, double commissionHandle, double cableCharge, double totalFee, double netPayment,
			double netRemittance) {
		super(id, transactionType, requestChannel, transactionDate, valueDate, businessDate, applicantId, beneficiaryId,
				sendersCorrespondent, receiversCorrespondent, channelTransactionRef, recipientRef, purposeOfPayment,
				remittanceInfo, addRemittanceInfo, senderToReceiverInfo, addSenderToReceiverInfo, otherPaymentDetails,
				requesterComments);
		this.foreignPaymentForm = foreignPaymentForm;
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