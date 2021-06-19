package com.emmanuelagboola.daofab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.emmanuelagboola.daofab.exceptions.DaofabException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Concrete class that wraps functionalities related to handling serializing json to object
 */
@Service
public class JsonToObjectSerializerImpl implements JsonToObjectSerializer {
	
	/*
	 * @var ObjectMapper objectMapper mapper to map entities to json
	 */
	private ObjectMapper objectMapper;
	
	@Autowired
	public JsonToObjectSerializerImpl(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}
	
	/*
	 * Serializes a given list of transactions json to corresponding list of object instances
	 * @param Class<T> classType the class type to cast json format to
	 * @param Resource resource the resource serving as source for the json files
	 * @return <T> the class type which depends on the <classType> param
	 * @throws DaofabException
	 */
	@Override
	public <T> T serializeTo(Class<T> classType, Resource resource) throws DaofabException {
		try {
			return objectMapper.readValue(resource.getFile(), classType);
		} catch (Exception e) {
			throw new DaofabException("An Error occured while parsing file, ensure file is well validated");
		}
       
	}

}
