package com.adaframework.basics.validators;

import java.lang.reflect.Field;

import com.mobandme.ada.Entity;
import com.mobandme.ada.validators.Validator;

public class EmailValidator extends Validator {
	
	@Override
	public Boolean Validate(Entity pEntity, Field pField, Object pAnnotation,
			Object pValue) {
		Boolean returnedValue = true;
		
		if(pValue != null){
			if(pValue instanceof String){
				String value = (String)pValue;
				
				if(!value.trim().equals("")){
					if(!value.contains("@")){
						returnedValue = false;
					}
				}
				
			}
		}
		return returnedValue;
	}

}
