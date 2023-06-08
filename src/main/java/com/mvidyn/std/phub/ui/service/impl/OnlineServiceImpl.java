package com.mvidyn.std.phub.ui.service.impl;

import java.util.Arrays;

import com.mvidyn.std.phub.ui.model.Applicant;
import com.mvidyn.std.phub.ui.model.Beneficiary;
import com.mvidyn.std.phub.ui.model.Transactor;
import com.mvidyn.std.phub.ui.model.form.online.data.OnlineCbftData;
import com.mvidyn.std.phub.ui.model.form.online.form.OnlineCbftForm;
import com.mvidyn.std.phub.ui.repository.OnlineCbftRepository;
import com.mvidyn.std.phub.ui.repository.ApplicantRepository;
import com.mvidyn.std.phub.ui.repository.BeneficiaryRepository;
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

	@Override
	public OnlineCbftData createCbftTransaction(OnlineCbftForm form) {
		if (isInvalidForm(form)) {
			throw new IllegalArgumentException("Invalid form");
		}
		saveTransactorsIfNotExists(form.getApplicant(), form.getBeneficiary());
		return onlineCbftRepository.save(OnlineCbftForm.buildData(form));
	}

	private void saveTransactorsIfNotExists(Transactor... transactors) {
		if (transactors == null || transactors.length == 0
				|| Arrays.asList(transactors).stream().anyMatch(t -> t == null || t.getId() == -1)) {
			throw new IllegalArgumentException("Invalid transactors");
		}
		for (Transactor t : transactors) {
			if (t instanceof Applicant) {
				if (applicantRepository.findById(t.getId()) == null) {
					applicantRepository.save((Applicant) t);
				}
			} else if (t instanceof Beneficiary) {
				if (beneficiaryRepository.findById(t.getId()) == null) {
					beneficiaryRepository.save((Beneficiary) t);
				}
			}
		}
	}

	private boolean isInvalidForm(OnlineCbftForm form) {
		return form == null;
	}

}
