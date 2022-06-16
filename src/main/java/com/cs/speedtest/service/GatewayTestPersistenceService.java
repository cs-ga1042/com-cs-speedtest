/*
 * Created on 2022-06-09 ( Date ISO 2022-06-09 - Time 21:05:06 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.3.0
 */
package com.cs.speedtest.service;

import java.util.List;
import java.util.Optional;

import com.cs.speedtest.entities.GatewayTest;
import com.cs.speedtest.repository.GatewayTestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Spring persistence service for "GatewayTest" <br>
 * @author Telosys (http://www.telosys.org/) version 3.3.0
 */
@Service

public class GatewayTestPersistenceService {

	@Autowired
	private GatewayTestRepository gatewayTestRepository;
	//@Autowired
	//private GatewayTestMapper gatewayTestMapper;


	
	public GatewayTest findById(String guid) {

		Optional<GatewayTest> optionalEntity = gatewayTestRepository.findById(guid);
		if ( optionalEntity.isPresent() ) {
			return optionalEntity.get();
		}
		return null ;

	}

	
	public List<GatewayTest> findAll() {
		//return mapper.mapEntityToRecord(gatewayTestRepository.findAll());

		List<GatewayTest> entities = gatewayTestRepository.findAll() ;
		List<GatewayTest> records = new java.util.LinkedList<GatewayTest>();
		for ( GatewayTest entity : entities ) {
			records.add( entity) ;
		}
		return records ;

	}

	
	public long countAll() {
		return gatewayTestRepository.count();
	}

	
	public GatewayTest save(GatewayTest record) {
//		return mapper.map(gatewayTestRepository.save(mapper.map(record)));
		return gatewayTestRepository.save(record );

	}

	
	public boolean update(GatewayTest record) {

		if ( exists(record) ) {
			gatewayTestRepository.save(record);
			return true;
		}
		return false;
	}

	
	public GatewayTest create(GatewayTest record) {
		return gatewayTestRepository.save(record );

	}

	
	public boolean deleteById(String guid) {
		final Optional<GatewayTest> optinalEntity = gatewayTestRepository.findById(guid);
		if( ! optinalEntity.isPresent() ) {
			return false;
		}

		else {
			gatewayTestRepository.delete(optinalEntity.get());
			return true;
		}
	}

	
	public boolean delete(GatewayTest record) {
		if(record == null) {
			return false;
		}
		return deleteById( record.getGuid() );

	}

	
	public boolean exists(String guid) {
		return gatewayTestRepository.findById(guid).isPresent();
	}

	
	public boolean exists(GatewayTest record) {
		return record == null ? false : gatewayTestRepository.findById(record.getGuid()).isPresent();
	}

}