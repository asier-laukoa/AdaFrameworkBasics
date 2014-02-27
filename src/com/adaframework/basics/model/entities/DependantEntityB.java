package com.adaframework.basics.model.entities;

import com.mobandme.ada.Entity;
import com.mobandme.ada.annotations.TableField;

public class DependantEntityB extends Entity{
	
	@TableField(name = "valueB", datatype = Entity.DATATYPE_INTEGER)
	public int value = 3;

}
