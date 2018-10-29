package com.snkit.springbootdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceGeneratorRepository extends JpaRepository<SequenceGeneratorEntity, Long> {

	
	public SequenceGeneratorEntity findByType(String type);
}
