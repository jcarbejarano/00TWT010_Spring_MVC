package com.curso.service;

import java.util.Collection;

import com.curso.domain.Pais;
import com.curso.domain.Region;

public interface RegionesPaisesService{

	Collection<Region>   getAllRegiones();
	Region getRegion(long idRegion);	
	Collection<Pais> getAllPaisesPorRegion(long idRegion);
}
