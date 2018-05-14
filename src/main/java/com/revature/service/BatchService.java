package com.revature.service;

import java.util.List;

import com.revature.dao.BatchDAO;
import com.revature.model.Batch;

public class BatchService {
	private static BatchDAO dao = BatchDAO.getInstance();

	private BatchService() {
	}

	public static Batch getBatch(String id) {
		return dao.getBatch(id);
	}

	public static void insertBatch(Batch b) {
		dao.insertBatch(b);
	}

	public static void updateBatch(Batch b) {
		dao.updateBatch(b);
	}

	public static void deleteBatch(Batch b) {
		dao.deleteBatch(b);
	}

	public static List<Batch> getAllBatches() {
		return dao.getAllBatches();
	}
}
