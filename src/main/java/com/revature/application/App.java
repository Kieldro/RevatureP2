package com.revature.Application;

import java.util.Date;

import com.revature.model.Batch;
import com.revature.service.BatchService;
import com.revature.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello Townies...");
		//Build trigger

		HibernateTests();
		
		System.out.println("Bye Townes.");
	}

	private static void HibernateTests() {
		Batch b = new Batch("1804aprjta", "jta", "Yuvi", "Reston", "11730 Plaza America dr", "204", new Date(),
				new Date());
		// Insert
		if (BatchService.getBatch("1804aprjta") != null)
			BatchService.insertBatch(b);

		// GetBatch
		b = BatchService.getBatch("1804aprjta");
		System.out.println("dao.getBatch(1804aprjta) " + b);
		System.out.println();

		// getAllBatches
		System.out.println(BatchService.getAllBatches());

		// update batch
		b = new Batch("1804aprjta", "jta", "Yuvi", "Reston", "11730 Plaza America dr", "214", new Date(), new Date());
		BatchService.updateBatch(b);
		b = BatchService.getBatch("1804aprjta");
		System.out.println("1804aprjta: " + b);
		System.out.println();

		// delete batch
		b = new Batch("1804aprjta", "jta", "Yuvi", "Reston", "11730 Plaza America dr", "214", new Date(), new Date());
		BatchService.deleteBatch(b);

		// b = BatchService.getBatch("1804aprjta");
		// System.out.println("1804aprjta: " + b);
		// System.out.println();
		//

		// System.out.println(HibernateUtil.getSession().getStatistics());

		// Close the SessionFactory
		HibernateUtil.getSession().close();

	}
}
