package com.adaframework.basics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.adaframework.basics.model.datacontexts.ApplicationDataContext;
import com.adaframework.basics.model.datacontexts.DataContext;
import com.adaframework.basics.model.entities.Employee;
import com.mobandme.ada.exceptions.AdaFrameworkException;

public class employeeListActivity extends Activity {

	private ListView employeesListView;
	
	private ArrayAdapter<Employee> entitiesListAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		try {
			
			setContentView(R.layout.employee_list_fragment_layout);
			ApplicationDataContext.dataBase = new DataContext(this);
			this.employeesListView = (ListView) findViewById(R.id.EmployeesListView);
			
			if(this.employeesListView != null){
				this.employeesListView.setOnItemClickListener(new OnItemClickListener() {
			    	
					public void onItemClick(AdapterView<?> pParent, View pView, int pPosition, long id) {
						try {
				        	
							Intent deatailIntent = new Intent(pParent.getContext(), employeeDetailActivity.class);
							deatailIntent.putExtra("employeeID", pPosition);
							startActivityForResult(deatailIntent, 1);
				        	
				        } catch (Exception e) {
							Toast.makeText(pParent.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
						}
					}
			    });
				this.entitiesListAdapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1);
				
				ApplicationDataContext.dataBase.employeesSet.fill();
				// Set the ListView adapter to the ObjectSet.
				ApplicationDataContext.dataBase.employeesSet.setAdapter(this.entitiesListAdapter);
				
				this.employeesListView.setAdapter(this.entitiesListAdapter);
			}
			
		} catch (AdaFrameworkException e) {
			Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
		}
		
	}
	
    public void executeAddNewCommand(View pView) {
    	try {
    		Intent deatailIntent = new Intent(this, employeeDetailActivity.class);
    		startActivityForResult(deatailIntent, 1);
    		
    	} catch (Exception e) {
 			Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
 		}
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
