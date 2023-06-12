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
	public OnlineCbftForm(long id, String transactionType, String requestChannel, String transactionDate,
			String valueDate,
			String businessDate, Applicant applicant, Beneficiary beneficiary, String sendersCorrespondent,
			String receiversCorrespondent, String channelTransactionRef, String recipientRef, String purposeOfPayment,
			String remittanceInfo, String addRemittanceInfo, String senderToReceiverInfo,
			String addSenderToReceiverInfo, String otherPaymentDetails, String requesterComments,
			ForeignPaymentForm foreignPaymentForm, double creditMidRate, double debitMidRate, String chargeBearer,
			double commissionExchange, double commissionHandle, double cableCharge, double totalFee, double netPayment,
			double netRemittance) {
		super(applicant, beneficiary, id, transactionType, requestChannel, transactionDate, valueDate, businessDate,
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

	public static OnlineCbftData buildData(OnlineCbftForm form) {
		return OnlineCbftData.builder()
				.transactionType(form.getTransactionType())
				.requestChannel(form.getRequestChannel())
				.transactionDate(form.getTransactionDate())
				.valueDate(form.getValueDate())
				.businessDate(form.getBusinessDate())
				.applicantId(form.getApplicant().getId())
				.beneficiaryId(form.getBeneficiary().getId())
				.sendersCorrespondent(form.getSendersCorrespondent())
				.receiversCorrespondent(form.getReceiversCorrespondent())
				.channelTransactionRef(form.getChannelTransactionRef())
				.recipientRef(form.getRecipientRef())
				.purposeOfPayment(form.getPurposeOfPayment())
				.remittanceInfo(form.getRemittanceInfo())
				.addRemittanceInfo(form.getAddRemittanceInfo())
				.senderToReceiverInfo(form.getSenderToReceiverInfo())
				.addSenderToReceiverInfo(form.getAddSenderToReceiverInfo())
				.otherPaymentDetails(form.getOtherPaymentDetails())
				.requesterComments(form.getRequesterComments())
				.foreignPaymentFormId(form.getForeignPaymentForm().getId())
				.creditMidRate(form.getCreditMidRate())
				.debitMidRate(form.getDebitMidRate())
				.chargeBearer(form.getChargeBearer())
				.commissionExchange(form.getCommissionExchange())
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
