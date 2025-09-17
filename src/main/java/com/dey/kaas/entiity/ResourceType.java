package com.dey.kaas.entiity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name="Resources_types")
public class ResourceType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	
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
