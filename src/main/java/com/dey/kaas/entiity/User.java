package com.dey.kaas.entiity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="company_id", nullable = false)
	private Company company;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany
	private List<AccessGroup> accessgroups;
	
	@ManyToMany
	private List<Access> accesses;
	
	@Column(updatable = false,nullable = false,name="created_at")
	private LocalDateTime created_at;
	
	@Column(name="updated_at")
	private LocalDateTime updated_at;
	
	@PrePersist
	protected void onCreate() {
		LocalDateTime now = LocalDateTime.now();
		this.created_at = now;
		this.updated_at = now;
	}
	
	@PreUpdate
	protected void onUpdate() {
		LocalDateTime now = LocalDateTime.now();
		this.updated_at= now;
	}
}
