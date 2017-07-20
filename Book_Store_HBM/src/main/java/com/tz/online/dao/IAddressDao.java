package com.tz.online.dao;

import java.util.List;

import com.tz.online.entity.Address;

public interface IAddressDao {
	
	void save(Address a);
	
	List<Address> findByUserId(Long userId);
	
	void delete(Address a);
	
	Address findById(Long id);
	
	void update(Address a);

}
