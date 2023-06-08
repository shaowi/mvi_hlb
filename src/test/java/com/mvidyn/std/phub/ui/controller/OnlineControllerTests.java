package com.mvidyn.std.phub.ui.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvidyn.std.phub.ui.model.Applicant;
import com.mvidyn.std.phub.ui.model.Beneficiary;
import com.mvidyn.std.phub.ui.model.form.online.data.OnlineCbftData;
import com.mvidyn.std.phub.ui.model.form.online.form.OnlineCbftForm;
import com.mvidyn.std.phub.ui.model.form.payment.ForeignPaymentForm;
import com.mvidyn.std.phub.ui.service.OnlineService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(OnlineController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
public class OnlineControllerTests {

	private static final String BASE = "/online";

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OnlineService onlineService;

	@Autowired
	private ObjectMapper objectMapper;

	private OnlineCbftForm form;

	private OnlineCbftData data;

	@BeforeEach
	public void setup() {
		Applicant applicant = Applicant.builder().id(1).idType("idType").name("name").accountNumber("accountNumber")
				.isResident(true).bankBic("bankBic").addresses(List.of("address1", "address2"))
				.accountType("accountType")
				.accountCurrency("accountCurrency").accountCifId("accountCifId").branchCode("branchCode")
				.postalCode("postalCode").countryCode("countryCode").phoneNumber("phoneNumber").build();

		Beneficiary beneficiary = Beneficiary.builder().id(2).idType("idType").name("name")
				.accountNumber("accountNumber")
				.isResident(true).bankBic("bankBic").addresses(List.of("address1", "address2"))
				.bankAddresses(List.of("bankAddress1", "bankAddress2")).build();

		ForeignPaymentForm foreignPaymentForm = ForeignPaymentForm.builder().remittanceCurrency("USD")
				.remittanceAmount(1000)
				.paymentCurrency("USD").paymentAmount(1000).localEquivalentAmount(1000).fxRefNumber("123456789")
				.exchangeRate(1.0).creditFxRate(1.0).debitFxRate(1.0).build();

		form = OnlineCbftForm.builder()
				.id(0)
				.transactionDate("2020-01-01")
				.transactionType("CBFT")
				.requestChannel("WEB")
				.valueDate("2020-01-01")
				.businessDate("2020-01-01")
				.sendersCorrespondent("sendersCorrespondent")
				.receiversCorrespondent("receiversCorrespondent")
				.channelTransactionRef("channelTransactionRef")
				.recipientRef("recipientRef")
				.purposeOfPayment("purposeOfPayment")
				.remittanceInfo("remittanceInfo")
				.senderToReceiverInfo("senderToReceiverInfo")
				.otherPaymentDetails("otherPaymentDetails")
				.requesterComments("requesterComments")
				.creditMidRate(11.11)
				.debitMidRate(12.11)
				.chargeBearer("our")
				.commissionExchange(0)
				.commissionHandle(0)
				.cableCharge(0)
				.totalFee(0)
				.netPayment(0)
				.netRemittance(0)
				.applicant(applicant)
				.beneficiary(beneficiary)
				.foreignPaymentForm(foreignPaymentForm)
				.build();

		data = OnlineCbftData.builder()
				.id(0)
				.transactionDate("2020-01-01")
				.transactionType("CBFT")
				.requestChannel("WEB")
				.valueDate("2020-01-01")
				.businessDate("2020-01-01")
				.sendersCorrespondent("sendersCorrespondent")
				.receiversCorrespondent("receiversCorrespondent")
				.channelTransactionRef("channelTransactionRef")
				.recipientRef("recipientRef")
				.purposeOfPayment("purposeOfPayment")
				.remittanceInfo("remittanceInfo")
				.senderToReceiverInfo("senderToReceiverInfo")
				.otherPaymentDetails("otherPaymentDetails")
				.requesterComments("requesterComments")
				.creditMidRate(11.11)
				.debitMidRate(12.11)
				.chargeBearer("our")
				.commissionExchange(0)
				.commissionHandle(0)
				.cableCharge(0)
				.totalFee(0)
				.netPayment(0)
				.netRemittance(0)
				.applicantId(1)
				.beneficiaryId(2)
				.foreignPaymentForm(foreignPaymentForm)
				.build();
	}

	@Test
	public void shouldCreateAttributes() {
		assertNotNull(mockMvc);
		assertNotNull(onlineService);
		assertNotNull(objectMapper);
		assertNotNull(form);
	}

	@Test
	public void createCbftTransaction_ReturnCreated() throws Exception {
		// Arrange
		String endpoint = BASE + "/cbft";
		when(onlineService.createCbftTransaction(ArgumentMatchers.any())).thenReturn(data);

		// Act
		ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post(endpoint)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(form)));

		// Assert
		response.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(data.getId())));
	}

}
