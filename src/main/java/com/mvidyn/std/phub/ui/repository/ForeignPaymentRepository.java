package com.mvidyn.std.phub.ui.repository;

import com.mvidyn.std.phub.ui.model.form.payment.ForeignPaymentForm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForeignPaymentRepository extends JpaRepository<ForeignPaymentForm, Long> {
}
