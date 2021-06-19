package com.emmanuelagboola.daofab.services;

import org.springframework.core.io.Resource;

import com.emmanuelagboola.daofab.exceptions.DaofabException;

/*
 * Interface that wraps functionalities related to handling serializing json to object
 */
public interface JsonToObjectSerializer {

	public <T> T serializeTo(Class<T> classType, Resource resource) throws DaofabException  ;
	
}
