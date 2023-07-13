package com.mvidyn.std.phub.ui.model.form.online.form;

import com.mvidyn.std.phub.ui.model.Applicant;
import com.mvidyn.std.phub.ui.model.Beneficiary;
import com.mvidyn.std.phub.ui.model.form.online.data.OnlineCbftData;
import com.mvidyn.std.phub.ui.model.form.payment.ForeignPaymentForm;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OnlineCbftForm extends OnlineForm implements Cloneable {

	private String filename;
	private String debitType;

	// Payment details
	private ForeignPaymentForm foreignPaymentForm;

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
	public OnlineCbftForm(long id, String processingMode, String transactionType, String requestChannel,
			String transactionDate,
			String valueDate,
			String businessDate, Applicant applicant, Beneficiary beneficiary, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionReference, String recipientReference,
			String purposeOfPayment,
			String remittanceInfo, String additionalRemittanceInfo, String senderToReceiverInfo,
			String additionalSenderToReceiverInfo, String otherPaymentDetails, String requesterComments, String status,
			ForeignPaymentForm foreignPaymentForm, String filename, String debitType, double creditMidRate,
			double debitMidRate, String chargeBearer,
			double commissionInLieuOfExchange, double commissionHandle, double cableCharge, double totalFee,
			double netPayment,
			double netRemittance) {
		super(applicant, beneficiary, id, processingMode, transactionType, requestChannel, transactionDate, valueDate,
				businessDate,
				sendersCorrespondent, receiversCorrespondent, channelTransactionReference, recipientReference,
				purposeOfPayment,
				remittanceInfo, additionalRemittanceInfo, senderToReceiverInfo, additionalSenderToReceiverInfo,
				otherPaymentDetails,
				requesterComments, status);
		this.foreignPaymentForm = foreignPaymentForm;
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

	public static OnlineCbftData buildData(OnlineCbftForm form) {
		return OnlineCbftData.builder()
				.id(form.getId())
				.processingMode(form.getProcessingMode())
				.transactionType(form.getTransactionType())
				.requestChannel(form.getRequestChannel())
				.transactionDate(form.getTransactionDate())
				.valueDate(form.getValueDate())
				.businessDate(form.getBusinessDate())
				.applicantId(form.getApplicant().getId())
				.beneficiaryId(form.getBeneficiary().getId())
				.sendersCorrespondent(form.getSendersCorrespondent())
				.receiversCorrespondent(form.getReceiversCorrespondent())
				.channelTransactionReference(form.getChannelTransactionReference())
				.recipientReference(form.getRecipientReference())
				.purposeOfPayment(form.getPurposeOfPayment())
				.remittanceInfo(form.getRemittanceInfo())
				.additionalRemittanceInfo(form.getAdditionalRemittanceInfo())
				.senderToReceiverInfo(form.getSenderToReceiverInfo())
				.additionalSenderToReceiverInfo(form.getAdditionalSenderToReceiverInfo())
				.otherPaymentDetails(form.getOtherPaymentDetails())
				.requesterComments(form.getRequesterComments())
				.status(form.getStatus())
				.foreignPaymentFormId(form.getForeignPaymentForm().getId())
				.filename(form.getFilename())
				.debitType(form.getDebitType())
				.creditMidRate(form.getCreditMidRate())
				.debitMidRate(form.getDebitMidRate())
				.chargeBearer(form.getChargeBearer())
				.commissionInLieuOfExchange(form.getCommissionInLieuOfExchange())
				.commissionHandle(form.getCommissionHandle())
				.cableCharge(form.getCableCharge())
				.totalFee(form.getTotalFee())
				.netPayment(form.getNetPayment())
				.netRemittance(form.getNetRemittance())
				.build();
	}

	@Override
	public OnlineCbftForm clone() throws CloneNotSupportedException {
		return (OnlineCbftForm) super.clone();
	}

}
