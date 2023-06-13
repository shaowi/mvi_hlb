package com.mvidyn.std.phub.ui.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.mvidyn.std.phub.ui.data.MockData;
import com.mvidyn.std.phub.ui.model.form.online.data.OnlineCbftData;
import com.mvidyn.std.phub.ui.model.form.online.form.OnlineCbftForm;
import com.mvidyn.std.phub.ui.repository.ApplicantRepository;
import com.mvidyn.std.phub.ui.repository.BeneficiaryRepository;
import com.mvidyn.std.phub.ui.repository.ForeignPaymentRepository;
import com.mvidyn.std.phub.ui.repository.OnlineCbftRepository;
import com.mvidyn.std.phub.ui.service.impl.OnlineServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
public class OnlineServiceTests {

	@Mock
	private OnlineCbftRepository onlineRepository;

	@Mock
	private ApplicantRepository applicantRepository;

	@Mock
	private BeneficiaryRepository beneficiaryRepository;

	@Mock
	private ForeignPaymentRepository foreignPaymentRepository;

	@InjectMocks
	private OnlineServiceImpl onlineService;

	private OnlineCbftForm form;

	private OnlineCbftData data;

	@Before
	public void setup() {
		form = MockData.ONLINE_CBFT_FORM;
		data = MockData.ONLINE_CBFT_DATA;
	}

	@Test
	public void createCbftTransaction_DoesNotThrowIllegalArgException() {
		// Arrange
		when(onlineRepository.save(data)).thenReturn(data);

		// Act & Assert
		assertDoesNotThrow(() -> onlineService.createCbftTransaction(form), "Form is null");
	}

	@Test
	public void createCbftTransaction_InvalidForm_ThrowIllegalArgException() {
		assertThrows(IllegalArgumentException.class, () -> onlineService.createCbftTransaction(null));
	}

	@Test
	public void createCbftTransaction_InvalidFormPayment_ThrowIllegalArgException() {
		try {
			OnlineCbftForm badForm = form.clone();
			badForm.setForeignPaymentForm(null);
			assertThrows(IllegalArgumentException.class, () -> onlineService.createCbftTransaction(badForm));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createCbftTransaction_InvalidFormApplicant_ThrowIllegalArgException() {
		try {
			OnlineCbftForm badForm = form.clone();
			badForm.setApplicant(null);
			assertThrows(IllegalArgumentException.class, () -> onlineService.createCbftTransaction(badForm));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void createCbftTransaction_InvalidFormBeneficiary_ThrowIllegalArgException() {
		try {
			OnlineCbftForm badForm = form.clone();
			badForm.setBeneficiary(null);
			assertThrows(IllegalArgumentException.class, () -> onlineService.createCbftTransaction(badForm));
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}
