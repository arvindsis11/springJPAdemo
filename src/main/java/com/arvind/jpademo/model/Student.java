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
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	@Id
	@Column(name = "`s_id`")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long s_id;
	private String s_name;

	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)//(optional = false,cascade = CascadeType.ALL)
//	@JoinColumn(name = "c_id",nullable = true)
//	private College college;
//.........................................
//  @OneToOne(cascade = CascadeType.ALL) test
//	@ManyToOne(cascade = CascadeType.ALL)...fix
//	@JoinColumn(name = "c_id",nullable = true)..fix use in case of bi-directional
	@ManyToOne
	@JoinColumn(name = "fk_c_id")
	private College college;
	 // for bidirectional one to one mapping
    //@OneToOne(mappedBy = "address")
    //private Employee employee;
}
