package com.adaframework.basics.model.entities;

import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;

@Table(name="tInheritedEntity")
public class InheritedEntity extends Employee{
	
	// Herencia
	@TableField(name = "inheritedValue", datatype = Entity.DATATYPE_INTEGER)
	public int inheritedValue = 4;

}
