/**
   Copyright Mob&Me 2013 (@MobAndMe)

   Licensed under the GPL General Public License, Version 3.0 (the "License"),  
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.gnu.org/licenses/gpl.html

   Unless required by applicable law or agreed to in writing, software 
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   
   Website: http://adaframework.com
   Contact: Txus Ballesteros <txus.ballesteros@mobandme.com>
*/

package com.adaframework.basics.model.datacontexts;

import android.content.Context;

import com.adaframework.basics.model.entities.Employee;
import com.adaframework.basics.model.entities.InheritedEntity;
import com.adaframework.basics.model.entities.RelationedEntity;
import com.mobandme.ada.ObjectContext;
import com.mobandme.ada.ObjectSet;

public class DataContext extends ObjectContext {

	public ObjectSet<Employee> employeesSet;
	
	public ObjectSet<InheritedEntity> inheritedEntitySet;
	
	public ObjectSet<RelationedEntity> relationedEntitySet;
	
	public DataContext(Context pContext) { 
		super(pContext); 
		
		initialize();
	}

	private void initialize() {
		try {
			
			this.employeesSet = new ObjectSet<Employee>(Employee.class, this);
			this.inheritedEntitySet = new ObjectSet<InheritedEntity>(InheritedEntity.class, this);
			this.relationedEntitySet = new ObjectSet<RelationedEntity>(RelationedEntity.class, this);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
