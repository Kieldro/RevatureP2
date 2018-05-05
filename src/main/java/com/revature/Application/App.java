package com.revature.Application;


import com.revature.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		System.out.println("Hello Townies...");
		

		
//		Batch e1 = new Batch("Jean", "SDET", new Date(), "Yuvi");
//		EmployeeDaoImpl ed1 = new EmployeeDaoImpl();
//		ed1.insertEmployee(e1);
		//ed1.updateEmployee(602, "Clayton");
//		System.out.println(ed1.findEmployeeById(603));
//		System.out.println(ed1.getAllEmployees());
//		ed1.HQLExample(3);
		//ed1.namedQueriesExample();
		//ed1.getVSLoad(1);
		//ed1.getVSLoad(20);
		//ed1.criteriaExample();
//		ed1.saveVSPersist();
		
		// Close the SessionFactory
		HibernateUtil.getSession().close();

		System.out.println("Bye Townes.");
	}

}
