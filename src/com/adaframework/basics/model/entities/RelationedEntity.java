package com.adaframework.basics.model.entities;

import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.Table;
import com.mobandme.ada.annotations.TableField;

@Table(name = "tRelationedEntity")
public class RelationedEntity extends Entity{
	
	@TableField(name = "value", datatype = Entity.DATATYPE_TEXT)
	public String value = "";
	
	// Relación N:M
	@TableField(name = "employee", datatype = Entity.DATATYPE_ENTITY_LINK)
	public Employee employee;

}
