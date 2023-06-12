package com.mvidyn.std.phub.ui.repository;

import com.mvidyn.std.phub.ui.model.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
}
