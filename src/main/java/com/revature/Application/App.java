package com.revature.Application;

import java.util.Date;

import com.revature.model.Batch;
import com.revature.service.BatchService;
import com.revature.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello Townies...");

		Batch b = new Batch("2804aprjta", "jta", "Yuvi", "Reston", "11730 Plaza America dr", "204", new Date(),
				new Date());
//		BatchService.insertBatch(b);
		
		b = BatchService.getBatch("1804aprjta");
		System.out.println("dao.getBatch(1804aprjta) " + b);
//		 System.out.println(dao.getAllBatches());
		// dao.updateBatch("1804aprjta");

		// Close the SessionFactory
		HibernateUtil.getSession().close();

		System.out.println("Bye Townes.");
	}
}
