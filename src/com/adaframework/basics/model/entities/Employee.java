package com.adaframework.basics.model.entities;

import java.util.List;

import com.adaframework.basics.R;
import com.adaframework.basics.validators.EmailValidator;
import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.CustomValidation;
import com.mobandme.ada.annotations.Databinding;
import com.mobandme.ada.annotations.RangeValidation;
import com.mobandme.ada.annotations.RegularExpressionValidation;
import com.mobandme.ada.annotations.RequiredFieldValidation;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;

@Table(name = "tEmployees")
public class Employee extends Entity{
	
	@TableField(name = "employeeName", datatype = Entity.DATATYPE_TEXT, required = true, maxLength = 100)
	@Databinding(ViewId = R.id.employeeName)
	@RequiredFieldValidation(messageResourceId = R.string.messageEmployeeNameRequired)
	@RegularExpressionValidation(expression = "[a-z]*", messageResourceId = R.string.messageEmployeeNameFormat)
	private String name = "";
	
	@TableField(name = "employeeSurName", datatype = Entity.DATATYPE_TEXT, maxLength = 100)
	@Databinding(ViewId = R.id.employeeSurname)
	@RequiredFieldValidation(messageResourceId = R.string.messageEmployeeSurnameRequired)
	private String surname = "";

	@TableField(name = "employeeAge", datatype = Entity.DATATYPE_INTEGER, required = true)
	@Databinding(ViewId = R.id.employeeAge)
	@RangeValidation(minValue = 1, maxValue = 99, messageResourceId = R.string.messageEmployeeAgeRange)
	private Integer age = 0;
	
	@TableField(name = "active", datatype = DATATYPE_BOOLEAN)
	@Databinding(ViewId = R.id.employeeActive)
	public Boolean active = false;	
	
	@TableField(name = "employeeEmail", datatype = Entity.DATATYPE_TEXT)
	@Databinding(ViewId = R.id.employeeEmail)
	@CustomValidation(validator = EmailValidator.class, messageResourceId = R.string.messageEmployeeEmailFormat)
	private String email = "";
	
	@TableField(name = "employeeUsername", datatype = Entity.DATATYPE_TEXT)
	@Databinding(ViewId = R.id.employeeUserName)
	private String username = "";
	
	@TableField(name = "employeePassword", datatype = Entity.DATATYPE_TEXT, encripted = true)
	@Databinding(ViewId = R.id.employeePassword)
	private String password = "";
	
	// Dependencia -- Relación 1:1
	@TableField(name = "entityA", datatype = Entity.DATATYPE_ENTITY)
	private DependantEntityA entityA = null;
	
	// Dependencia -- Relación 1:N
	@TableField(name = "entityB", datatype = Entity.DATATYPE_ENTITY)
	private List<DependantEntityB> entityB = null;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String surname, Integer age, Boolean active,
			String email, String username, String password,
			DependantEntityA entityA, List<DependantEntityB> entityB) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.active = active;
		this.email = email;
		this.username = username;
		this.password = password;
		this.entityA = entityA;
		this.entityB = entityB;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	

	public DependantEntityA getEntityA() {
		return entityA;
	}

	public void setEntityA(DependantEntityA entityA) {
		this.entityA = entityA;
	}

	public List<DependantEntityB> getEntityB() {
		return entityB;
	}

	public void setEntityB(List<DependantEntityB> entityB) {
		this.entityB = entityB;
	}

	@Override
	public String toString() {
		return String.format("%s, %s", this.name, this.surname);
	}
	
}
