package com.arvind.jpademo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@Column(name = "`emp_id`")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long emp_id;
	private String emp_name;

	@JsonIgnore
//	@ManyToOne(optional = false,cascade = CascadeType.ALL)
//	@JoinColumn(name = "c_id")
//	private College college;
//	@ManyToOne --fix1
//	private College college;--fix2
	@ManyToOne
	@JoinColumn(name = "fk_c_id")
	private College college;

}
