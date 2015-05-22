package com.ragency.service;

import java.util.Collection;

import com.ragency.entity.Company;
import com.ragency.entity.History;
import com.ragency.entity.People;

public interface HistoryManager {
	public void addHistory(History history);
	public void updateHistory(History history);
	public void deleteHistory(History history);
	public History getHistoryById(int id);
	public Collection<History> getAllHistory();
	public Collection<History> getHistoryByPeople(People people);
	public Collection<History> getHistoryByCompany(Company company);

}
