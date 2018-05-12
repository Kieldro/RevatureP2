package com.revature.dao;

import java.util.List;

import com.revature.model.Batch;

// Batch Data Access Interface
public interface BatchDAI {
	public void insertBatch(Batch b);
	public List<Batch> getAllBatches();
//	public void updateBatch(int id, String name);
	public Batch getBatch(String name);
//	public void deleteBatch(int id);
//	public void HQLExample(int id);
//	public void namedQueriesExample();
//	public void getVSLoad(int id);
//	public void saveVSPersist();
//	public void criteriaExample();
}
