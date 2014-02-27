package com.adaframework.basics;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.adaframework.basics.model.datacontexts.ApplicationDataContext;
import com.adaframework.basics.model.entities.DependantEntityA;
import com.adaframework.basics.model.entities.DependantEntityB;
import com.adaframework.basics.model.entities.Employee;
import com.adaframework.basics.model.entities.InheritedEntity;
import com.adaframework.basics.model.entities.RelationedEntity;
import com.mobandme.ada.DataBinder;
import com.mobandme.ada.Entity;
import com.mobandme.ada.validators.ValidationResult;

public class employeeDetailActivity extends Activity {
	
	private Employee employee = new Employee();
	
	private InheritedEntity inheritedEmployee = new InheritedEntity();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.employee_detail_fragment_layout);
		
		Bundle intentExtras = this.getIntent().getExtras();
		if (intentExtras != null) {
			executeShowCommand(intentExtras.getInt("employeeID"));
		}
		
	}
	
	public void executeShowCommand(int pIndex) {
		try {
			
			this.employee = ApplicationDataContext.dataBase.employeesSet.get(pIndex);
			this.employee.setStatus(Entity.STATUS_UPDATED);
			this.employee.bind(this, DataBinder.BINDING_ENTITY_TO_UI);
			
		} catch (Exception e) {
			Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
		}
	}	
	
 	public void executeDeleteCommand(View pView) {
		try {
			
			if (this.employee.getID() != null) {
			
				this.employee.setStatus(Entity.STATUS_DELETED);
				ApplicationDataContext.dataBase.employeesSet.save();
				
				this.setResult(Activity.RESULT_OK);
				this.finish();
			}
			
		} catch (Exception e) {
			Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
		}
	}	
	
	public void executeSaveCommand(View pView) {
		try {
			
			this.employee.bind(findViewById(R.id.employeeDataForm), DataBinder.BINDING_UI_TO_ENTITY);
			this.inheritedEmployee.bind(findViewById(R.id.employeeDataForm), DataBinder.BINDING_UI_TO_ENTITY);
			if (this.employee.validate(this)) {
				
				if (this.employee.getID() == null) {
					this.employee.setEntityA(new DependantEntityA());
					DependantEntityB dependantEntityB = new DependantEntityB();
					List<DependantEntityB> listDependantEntityB = new ArrayList<DependantEntityB>();
					listDependantEntityB.add(dependantEntityB);
					this.employee.setEntityB(listDependantEntityB);
					ApplicationDataContext.dataBase.employeesSet.add(this.employee);
					ApplicationDataContext.dataBase.inheritedEntitySet.add(this.inheritedEmployee);
				}
				ApplicationDataContext.dataBase.employeesSet.save();
				ApplicationDataContext.dataBase.inheritedEntitySet.save();
				
				RelationedEntity relationedEntity = new RelationedEntity();
				relationedEntity.value = "Prueba Entidad Relacionada";
				relationedEntity.employee = ApplicationDataContext.dataBase.employeesSet.get(0);
				ApplicationDataContext.dataBase.relationedEntitySet.add(relationedEntity);
				ApplicationDataContext.dataBase.relationedEntitySet.save();
				
				this.setResult(Activity.RESULT_OK);
				this.finish();
				
			} else {
				String message = "";
				List<ValidationResult> validationResults = this.employee.getValidationResult();
				for(ValidationResult result : validationResults){
					message += "\r\n " + result.getMessage();
				}
				Toast.makeText(this, String.format("The next field is not correct: %s", message), Toast.LENGTH_SHORT).show();
			}
			
		} catch (Exception e) {
			Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
		}
	}	
	
}
