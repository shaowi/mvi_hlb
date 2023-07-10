package com.mvidyn.std.phub.ui.repository;

import java.util.List;

import com.mvidyn.std.phub.ui.model.form.online.data.OnlineCbftData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnlineCbftRepository extends JpaRepository<OnlineCbftData, Long> {

	List<OnlineCbftData> findByFilename(String filename);
}
