package com.mvidyn.std.phub.ui.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(unique = true)
	private String name;
	private String password;
	private Access access;
	private Role role;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private String token;

	@Override
	public String toString() {
		return String.format(
				"User[id=%ld, name='%s', password='%s']",
				id, name, password);
	}
}
