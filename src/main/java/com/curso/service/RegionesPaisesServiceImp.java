package com.curso.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.domain.Pais;
import com.curso.domain.Region;
import com.curso.domain.repository.RegionPaisRepository;

@Service
public class RegionesPaisesServiceImp implements RegionesPaisesService{
	
	@Autowired
	private RegionPaisRepository repositorio;

	@Override
	public Collection<Region> getAllRegiones() {	
		return repositorio.getAllRegiones();
	}

	@Override
	public Collection<Pais> getAllPaisesPorRegion(long idRegion) {
		
		return repositorio.getPaisesByRegion(idRegion);
	}

	@Override
	public Region getRegion(long idRegion) {
		return repositorio.getRegion(idRegion);
	}


}
