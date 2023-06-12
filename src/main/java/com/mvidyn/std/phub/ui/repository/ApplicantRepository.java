package com.mvidyn.std.phub.ui.repository;

import com.mvidyn.std.phub.ui.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
