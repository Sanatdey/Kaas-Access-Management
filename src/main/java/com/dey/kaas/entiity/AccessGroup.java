package com.dey.kaas.entiity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="Access_groups")
public class AccessGroup {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
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
