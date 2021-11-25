package com.curso.domain.repository;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.curso.domain.Pais;
import com.curso.domain.Region;

@Repository
public class RegionPaisJPARepository implements RegionPaisRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Collection<Region> getAllRegiones() {
		Query q = em.createNamedQuery("Region.findAll");
		return q.getResultList();
	}

	@Override
	public Collection<Pais> getPaisesByRegion(long idRegion) {
		Query q = em.createNamedQuery("Pais.findByRegion");
		q.setParameter("idRegion", idRegion);
		return q.getResultList();
	}

	@Override
	public Region getRegion(long idRegion) {
		return em.find(Region.class,idRegion);
	}

}
