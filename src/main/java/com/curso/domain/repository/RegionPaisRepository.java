package com.curso.domain.repository;

import java.util.Collection;

import com.curso.domain.Pais;
import com.curso.domain.Region;

public interface RegionPaisRepository {
	
	 Collection<Region> getAllRegiones();
	 Collection<Pais> getPaisesByRegion(long idRegion);
	
	Region getRegion(long idRegion);

}
