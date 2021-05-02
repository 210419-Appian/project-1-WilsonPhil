package com.revature.repo;

import java.util.List;

public interface CrudRepo<L>{
	
	public List<L>findAll();
	L findById(int id);
	void insert(L newObj);
	boolean update(L updateObj);
	boolean deleteById(int id);

}
