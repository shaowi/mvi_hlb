package com.mvidyn.std.phub.ui.model.form.online.data;

import com.mvidyn.std.phub.ui.model.Applicant;
import com.mvidyn.std.phub.ui.model.Beneficiary;
import com.mvidyn.std.phub.ui.model.form.online.form.OnlineCbftForm;
import com.mvidyn.std.phub.ui.model.form.payment.ForeignPaymentForm;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
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
	private double commissionInLieuOfExchange;
	private double commissionHandle;
	private double cableCharge;
	private double totalFee;
	private double netPayment;
	private double netRemittance;

	@Builder
	public OnlineCbftData(long id, String processingMode, String transactionType, String requestChannel,
			String transactionDate,
			String valueDate,
			String businessDate, long applicantId, long beneficiaryId, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionReference, String recipientReference,
			String purposeOfPayment,
			String remittanceInfo, String additionalRemittanceInfo, String senderToReceiverInfo,
			String additionalSenderToReceiverInfo, String otherPaymentDetails, String requesterComments, String status,
			long foreignPaymentFormId, String filename, String debitType, double creditMidRate, double debitMidRate,
			String chargeBearer,
			double commissionInLieuOfExchange, double commissionHandle, double cableCharge, double totalFee,
			double netPayment,
			double netRemittance) {
		super(applicantId, beneficiaryId, id, processingMode, transactionType, requestChannel, transactionDate,
				valueDate,
				businessDate,
				sendersCorrespondent,
				receiversCorrespondent, channelTransactionReference, recipientReference, purposeOfPayment,
				remittanceInfo,
				additionalRemittanceInfo, senderToReceiverInfo, additionalSenderToReceiverInfo, otherPaymentDetails,
				requesterComments, status);
		this.foreignPaymentFormId = foreignPaymentFormId;
		this.filename = filename;
		this.debitType = debitType;
		this.creditMidRate = creditMidRate;
		this.debitMidRate = debitMidRate;
		this.chargeBearer = chargeBearer;
		this.commissionInLieuOfExchange = commissionInLieuOfExchange;
		this.commissionHandle = commissionHandle;
		this.cableCharge = cableCharge;
		this.totalFee = totalFee;
		this.netPayment = netPayment;
		this.netRemittance = netRemittance;
	}

	public static OnlineCbftForm buildForm(Applicant applicant, Beneficiary beneficiary,
			ForeignPaymentForm foreignPaymentForm, OnlineCbftData data) {
		return OnlineCbftForm.builder()
				.processingMode(data.getProcessingMode())
				.transactionType(data.getTransactionType())
				.requestChannel(data.getRequestChannel())
				.transactionDate(data.getTransactionDate())
				.valueDate(data.getValueDate())
				.businessDate(data.getBusinessDate())
				.applicant(applicant)
				.beneficiary(beneficiary)
				.sendersCorrespondent(data.getSendersCorrespondent())
				.receiversCorrespondent(data.getReceiversCorrespondent())
				.channelTransactionReference(data.getChannelTransactionReference())
				.recipientReference(data.getRecipientReference())
				.purposeOfPayment(data.getPurposeOfPayment())
				.remittanceInfo(data.getRemittanceInfo())
				.additionalRemittanceInfo(data.getAdditionalRemittanceInfo())
				.senderToReceiverInfo(data.getSenderToReceiverInfo())
				.additionalSenderToReceiverInfo(data.getAdditionalSenderToReceiverInfo())
				.otherPaymentDetails(data.getOtherPaymentDetails())
				.requesterComments(data.getRequesterComments())
				.status(data.getStatus())
				.foreignPaymentForm(foreignPaymentForm)
				.filename(data.getFilename())
				.debitType(data.getDebitType())
				.creditMidRate(data.getCreditMidRate())
				.debitMidRate(data.getDebitMidRate())
				.chargeBearer(data.getChargeBearer())
				.commissionInLieuOfExchange(data.getCommissionInLieuOfExchange())
				.commissionHandle(data.getCommissionHandle())
				.cableCharge(data.getCableCharge())
				.totalFee(data.getTotalFee())
				.netPayment(data.getNetPayment())
				.netRemittance(data.getNetRemittance())
				.build();
	}

}