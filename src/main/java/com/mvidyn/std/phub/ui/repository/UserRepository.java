package com.mvidyn.std.phub.ui.repository;

import com.mvidyn.std.phub.ui.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
