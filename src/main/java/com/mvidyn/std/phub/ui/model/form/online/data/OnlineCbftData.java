package com.mvidyn.std.phub.ui.model.form.online.data;

import com.mvidyn.std.phub.ui.model.form.payment.ForeignPaymentForm;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OnlineCbftData extends OnlineData {

	// Payment details
	private ForeignPaymentForm foreignPaymentForm;

	// Charges details
	private float creditMidRate;
	private float debitMidRate;
	private String chargeBearer;
	private float commissionExchange;
	private float commissionHandle;
	private float cableCharge;
	private float totalFee;
	private float netPayment;
	private float netRemittance;

	@Builder
	public OnlineCbftData(String transactionType, String requestChannel, String transactionDate, String valueDate,
			String businessDate, int applicantId, int beneficiaryId, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionRef, String recipientRef, String purposeOfPayment,
			String remittanceInfo, String addRemittanceInfo, String senderToReceiverInfo,
			String addSenderToReceiverInfo, String otherPaymentDetails, String requesterComments,
			ForeignPaymentForm foreignPaymentForm, float creditMidRate, float debitMidRate, String chargeBearer,
			float commissionExchange, float commissionHandle, float cableCharge, float totalFee, float netPayment,
			float netRemittance) {
		super(transactionType, requestChannel, transactionDate, valueDate, businessDate, applicantId, beneficiaryId,
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