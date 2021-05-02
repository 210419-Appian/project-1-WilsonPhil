package com.revature.repo;

import java.util.List;

public interface ReadRepo<R> {
	
	public List<R>findAll();
	
	R findById(int id);
	


}
