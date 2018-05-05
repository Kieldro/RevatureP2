package com.revature.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Batch;
import com.revature.util.HibernateUtil;

// Batch Data Access Object
public class BatchDAO implements BatchDAI {
	private static BatchDAO instance;

	private BatchDAO() {
	}

	public static BatchDAO getInstance() {
		if (instance == null) {
			instance = new BatchDAO();
		}
		return instance;
	}
	
	@Override
	public void insertBatch(Batch b) {
		Session session = HibernateUtil.getSession().openSession();
		// We use the transaction component to perform
		// actual operations on data.
		Transaction t1 = null;
		try {
			//Open of a transaction stream for our session.
			t1 = session.beginTransaction();
			//Save will persist or insert the data to the database.
			//It returns the created ID that represent this record.
			session.save(b);
			t1.commit();
			// save and persist
		} catch (HibernateException h) {
			if (t1 != null) {
				//If a transaction fails, ya gotta roll it back.
				t1.rollback();
			}
		} finally {
			// Never have open streams of anything...
			session.close();
		}

	}
	
	public Batch getBatch(String name) {
		Session session = HibernateUtil.getSession().openSession();
		Batch b = null;
		try {
			session.beginTransaction();
			b = session.get(Batch.class, name);
		} catch (HibernateException e) {
			System.err.println(e.getMessage());
			System.err.println("cause: " + e.getCause());
//			System.err.println("Stack trace: " + );
			e.printStackTrace();
		} finally {
			session.close();
		}
		return b;
	}
	
	@Override
	public List<Batch> getAllBatches() {
		Session session = HibernateUtil.getSession().openSession();
		List<Batch> batches = null;
		try {
			session.beginTransaction();
			//from Batch is not Batch table rather Batch class
			//Hibernate Query Language
			batches = session.createQuery("from com.revature.model.Batch").list();
		} catch (HibernateException h) {
			//
		} finally {
			session.close();
		}
		return batches;
	}

//
//	public void updateBatch(int id, String name) {
//		Session session = HibernateUtil.getSession().openSession();
//		Transaction t1 = null;
//		Batch emp;
//		try {
//			t1 = session.beginTransaction();
//			emp = session.get(Batch.class, id);
//			emp.setEname(name);
//			session.saveOrUpdate(emp);
//			t1.commit();
//		} catch (HibernateException h) {
//			if (t1 != null) {
//				t1.rollback();
//			}
//		} finally {
//			session.close();
//		}
//	}

//
//	public void deleteBatch(int id) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public void HQLExample(int id) {
//		Session session = HibernateUtil.getSession().openSession();
//		Query query;
//		String hql = "from com.revature.model.Batch where id =:varName";
//		try {
//			session.beginTransaction();
//			//from Batch is not Batch table rather Batch class
//			//Hibernate Query Language
//			query = session.createQuery(hql);
//			query.setParameter("varName", id);
//			System.out.println(query.getResultList());
//		} catch (HibernateException h) {
//			//
//		} finally {
//			session.close();
//		}
//	}
//
//	public void namedQueriesExample() {
//		Session session = HibernateUtil.getSession().openSession();
//		Query query;
//		try {
//			session.beginTransaction();
//			//Native SQL using Named Query
//			query = session.getNamedQuery("RetrieveAllBatchs");
//			System.out.println(query.getResultList());
//		} catch (HibernateException h) {
//			//
//		} finally {
//			session.close();
//		}
//	}
//
//	public void getVSLoad(int id) {
//		Session session1 = HibernateUtil.getSession().openSession();
//		Session session2 = HibernateUtil.getSession().openSession();
//		Batch emp1 = null;
//		Batch emp2 = null;
//		try {
//			session1.beginTransaction();
//			session2.beginTransaction();
//			System.out.println("before get : " + emp1);
//			emp1 = session1.get(Batch.class, id);
//			System.out.println("after get : " + emp1);
//			System.out.println("=================================");
//			System.out.println("before load : " + emp2);
//			emp2 = session2.load(Batch.class, id);
//			System.out.println("after load : " + emp2);
//		} catch (HibernateException h) {
//			//
//		} finally {
//			session1.close();
//			session2.close();
//		}
//	}

/*
 * The retrieval of data is designated to one of two methods:
 * -GET and LOAD
 * The key difference between these two retrieval methods is that one
 * can be considered lazy, while the other can be considered eager.
 * GET: This is our eager retrieval example. Get will hit the database
 * immediately and populate all data on the spot for you. If no data exists
 * it can provide 'null' as the data. 
 * Typically, you want to use this if you are not sure that the object exists.
 * 
 * LOAD: This is our considered lazy retrieval. It provides back to us a proxy
 * of the object.
 * -A proxy is just a simple implementation of the object structure that is 
 * 	provided for us to use. This is why we have access to the object's
 * 	getters and setters.
 * The database is only hit when you need to access the actual data within.
 * Since up to that point, hibernate assumed the object existed, and when it
 * finds out that the data isn't actually, we are greeted with an Exception.
 * Typically use this, only when you are 100% sure that the data exists.
 */
	
//	public void saveVSPersist() {
//		Session session = HibernateUtil.getSession().openSession();
//		Transaction t1 = null;
//		Batch emp1 = new Batch("Jose","SDET",new Date(),"Yuvi");
//		Batch emp2 = new Batch("Joseph","SDET",new Date(),"Yuvi");
//		try {
//			t1 = session.beginTransaction();
//			System.out.println("before save : " + emp1.getEid());
//			session.save(emp1);
//			System.out.println("after save : " + emp1.getEid());
//			
//			System.out.println("before persist : " + emp2.getEid());
//			session.persist(emp2);
//			System.out.println("after persist : " + emp2.getEid());
//			t1.commit();
//		} catch (HibernateException h) {
//			if (t1 != null) {
//				t1.rollback();
//			}
//		} finally {
//			session.close();
//		}
//	}

/*
 * The difference between SAVE and PERSIST:
 * -They are not EAGER or LAZY. But one could compare it to that.
 * -When you call save on an object. You persist it with the database.
 * -Therefore, upon calling save, you are returned a number indicating
 * 	Which record it was inserted as.
 * -With persist, however, it is not inserted into the database right
 * 	away. It is inserted at seemingly randomly points during the transaction.
 * 	This is why the persist returns void. It can't give you a number for it's
 * 	insert record because it technically MIGHT not have inserted right away.
 * 	The only guarantee with persist is that it will be inserted by flush time
 * 	for the database. (Flush time is the point where all data is 
 *  persisted with the database)
 */
	
//	@SuppressWarnings("unchecked")
//	public void criteriaExample() {
//		Session session = HibernateUtil.getSession().openSession();
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		// Create CriteriaQuery
//		CriteriaQuery<Batch> criteria = builder.createQuery(Batch.class);
//		
//		System.out.println("====GET ALL Batchs ===");
//		List<Batch> Batchs = criteria.list;
//		//As before, .list() executes
//		System.out.println(Batchs);
//		
//		System.out.println("===Criteria With Conditions===");
//		Batchs = session.createCriteria(Batch.class)
//				.add(Restrictions.ilike("bearColor", "yellow")).list();
//		//NOTE: like is case sensitive, ilike is not.
//		System.out.println(Batchs);
//		
//		/*
//		 * Note you can chain multiple criterions with the '.add'
//		 * method.
//		 * You can also apply aggragate functions to your results
//		 * using the 'Projection' object.
//		 */
//		
//		System.out.println("====BearCount====");
//		Long BatchsCount = (Long)session.createCriteria(Batch.class).setProjection(
//					Projections.count("bearId")
//				).uniqueResult();
//		System.out.println(BatchsCount);
//	}
}





