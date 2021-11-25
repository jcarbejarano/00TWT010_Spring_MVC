package com.curso.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table( schema="HR", name="REGIONS")
@NamedQuery(name="Region.findAll", 
            query="SELECT r FROM Region r")
public class Region implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REGION_ID")
	private long regionId;

	@Column(name="REGION_NAME")
	private String regionName;


	public Region() {
	}

	public long getRegionId() {
		return this.regionId;
	}

	public void setRegionId(long regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(regionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Region other = (Region) obj;
		return regionId == other.regionId;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName + "]";
	}

	

}