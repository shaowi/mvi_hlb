package com.mvidyn.std.phub.ui.service.impl;

import java.util.Arrays;
import java.util.List;

import com.mvidyn.std.phub.ui.exception.Message;
import com.mvidyn.std.phub.ui.model.Applicant;
import com.mvidyn.std.phub.ui.model.Beneficiary;
import com.mvidyn.std.phub.ui.model.Transactor;
import com.mvidyn.std.phub.ui.model.form.online.data.OnlineCbftData;
import com.mvidyn.std.phub.ui.model.form.online.form.OnlineCbftForm;
import com.mvidyn.std.phub.ui.model.form.payment.ForeignPaymentForm;
import com.mvidyn.std.phub.ui.model.form.payment.PaymentForm;
import com.mvidyn.std.phub.ui.repository.ApplicantRepository;
import com.mvidyn.std.phub.ui.repository.BeneficiaryRepository;
import com.mvidyn.std.phub.ui.repository.ForeignPaymentRepository;
import com.mvidyn.std.phub.ui.repository.OnlineCbftRepository;
import com.mvidyn.std.phub.ui.service.OnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OnlineServiceImpl implements OnlineService {

	@Autowired
	private OnlineCbftRepository onlineCbftRepository;

	@Autowired
	private ApplicantRepository applicantRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private ForeignPaymentRepository foreignPaymentRepository;

	@Override
	public OnlineCbftData createCbftTransaction(OnlineCbftForm form) {
		checkFormValidity(form);
		saveTransactorsIfNotExists(form.getApplicant(), form.getBeneficiary());
		savePayment(form.getForeignPaymentForm());
		return onlineCbftRepository.save(OnlineCbftForm.buildData(form));
	}

	@Override
	public List<OnlineCbftData> getCbftTransactions(String filename) {
		return onlineCbftRepository.findByFilename(filename);
	}

	private void savePayment(PaymentForm paymentForm) {
		if (paymentForm == null) {
			throw new IllegalArgumentException(Message.INVALID_FORM_PAYMENT);
		}
		if (paymentForm instanceof ForeignPaymentForm) {
			ForeignPaymentForm foreignPaymentForm = (ForeignPaymentForm) paymentForm;
			foreignPaymentRepository.save(foreignPaymentForm);
		}
	}

	private void saveTransactorsIfNotExists(Transactor... transactors) {
		if (hasInvalidTransactors(transactors)) {
			throw new IllegalArgumentException(Message.INVALID_FORM_TRANSACTOR);
		}
		for (Transactor t : transactors) {
			if (t instanceof Applicant) {
				Applicant applicant = (Applicant) t;
				boolean hasApplicant = applicantRepository.existsById(applicant.getId());
				if (!hasApplicant) {
					applicantRepository.save(applicant);
				}
			} else if (t instanceof Beneficiary) {
				Beneficiary beneficiary = (Beneficiary) t;
				boolean hasBeneficiary = beneficiaryRepository.existsById(beneficiary.getId());
				if (!hasBeneficiary) {
					beneficiaryRepository.save(beneficiary);
				}
			}
		}
	}

	private void checkFormValidity(OnlineCbftForm form) {
		if (form == null) {
			throw new IllegalArgumentException(Message.INVALID_FORM);
		}
		if (form.getForeignPaymentForm() == null) {
			throw new IllegalArgumentException(Message.INVALID_FORM_PAYMENT);
		}
		Transactor[] transactors = new Transactor[] { form.getApplicant(), form.getBeneficiary() };
		if (hasInvalidTransactors(transactors)) {
			throw new IllegalArgumentException(Message.INVALID_FORM_TRANSACTOR);
		}
	}

	private boolean hasInvalidTransactors(Transactor... transactors) {
		return (transactors == null || transactors.length == 0
				|| Arrays.asList(transactors).stream().anyMatch(t -> t == null));
	}

}
