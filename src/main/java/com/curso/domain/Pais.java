package com.curso.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table( schema="HR", name="COUNTRIES")
@NamedQueries({
	@NamedQuery(name="Pais.findAll", 
				query="SELECT p FROM Pais p"),
	@NamedQuery(name="Pais.findByRegion", 
				query="SELECT p FROM Pais p "
						+ "WHERE p.idRegion= :idRegion")
})
public class Pais implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COUNTRY_ID")
	private String countryId;

	@Column(name="COUNTRY_NAME")
	private String countryName;


	@Column(name="REGION_ID")
	private long idRegion;
	
	
	@ManyToOne
	@JoinColumn(name="REGION_ID", 
					insertable = false,
					updatable = false)
	private Region region;
	
	public Pais() {
	}

	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public long getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(long idRegion) {
		this.idRegion = idRegion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(countryId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(countryId, other.countryId);
	}

	@Override
	public String toString() {
		return "Pais [countryId=" + countryId + ", countryName=" + countryName + ", idRegion=" + idRegion + "]";
	}

	

}