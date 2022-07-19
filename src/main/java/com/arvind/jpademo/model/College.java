package com.arvind.jpademo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "colleges")
@AllArgsConstructor
@NoArgsConstructor
public class College {

	@Id
	@Column(name = "`c_id`")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long c_id;
	private String c_name;
//	@OneToMany(mappedBy="college")
//    private List<Student> student;
//	@OneToMany(mappedBy = "college", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	private Set<Student> student;
	// @OneToMany(mappedBy = "college")..fix use in case of bi-directional;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_c_id", referencedColumnName = "c_id")
	private List<Student> students;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_c_id", referencedColumnName = "c_id")
	private List<Employee> employees;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_c_id", referencedColumnName = "c_id")
	private List<Faculty> faculties;
	//address_add_id - default fk column name
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "fk_add_id")//for bi-directional relationship

}
