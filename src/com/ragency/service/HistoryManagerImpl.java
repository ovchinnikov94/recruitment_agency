package com.ragency.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ragency.dao.HistoryDao;
import com.ragency.entity.History;

@Service
public class HistoryManagerImpl implements HistoryManager {

	@Autowired
	private HistoryDao historyDao;
	
	@Override
	public void addHistory(History history) {
		this.historyDao.addHistory(history);
	}

	@Override
	public void updateHistory(History history) {
		this.historyDao.deleteHistory(history);
	}

	@Override
	public void deleteHistory(History history) {
		this.historyDao.deleteHistory(history);
	}

	@Override
	public History getHistoryById(int id) {
		return this.historyDao.getHistoryById(id);
	}

	@Override
	public List<History> getAllHistory() {
		return this.historyDao.getAllHistory();
	}

	@Override
	public List<History> getHistoryByPeople(int idpeople) {
		return this.historyDao.getHistoryByPeople(idpeople);
	}

	@Override
	public List<History> getHistoryByCompany(int idcompany) {
		return this.historyDao.getHistoryByCompany(idcompany);
	}

}
