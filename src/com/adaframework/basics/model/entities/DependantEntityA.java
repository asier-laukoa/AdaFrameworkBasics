package com.adaframework.basics.model.entities;

import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.TableField;


public class DependantEntityA extends Entity{
	
	@TableField(name = "valueA", datatype = Entity.DATATYPE_INTEGER)
	public int value = 2;

}
