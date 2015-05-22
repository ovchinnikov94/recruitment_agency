package com.ragency.dao;

import java.util.List;

import com.ragency.entity.History;

public interface HistoryDao {
	public void addHistory(History history);
	public void updateHistory(History history);
	public void deleteHistory(History history);
	public History getHistoryById(int id);
	public List<History> getAllHistory();
	public List<History> getHistoryByPeople(int idpeople);
	public List<History> getHistoryByCompany(int idcompany);
}
