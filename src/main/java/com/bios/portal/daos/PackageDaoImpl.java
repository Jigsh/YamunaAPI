package com.bios.portal.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.entities.Maintenance;
import com.bios.portal.entities.Package;
import com.bios.portal.entities.Spare;
import com.bios.portal.entities.Vin;
import com.bios.portal.services.PackageServiceImpl;

@Repository
public class PackageDaoImpl implements PackageDao{

	private static Logger log = Logger.getLogger(PackageDaoImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	private SessionFactory sessionFactory;

	@Transactional
	public boolean insertPackage(Package pkg) throws Exception {
		entityManager.persist(pkg);
		return true;
	}

	@Transactional
	public boolean updatePackage(Package pkg) throws Exception {
		entityManager.merge(pkg);
		return true;
	}

	

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Package> getPackageList(String vin) throws Exception {
		Vin vinEntity = entityManager.find(Vin.class,new Integer(vin));
		
		//String hql = "FROM package";
		
		//entityManager.find(Package.class,vinEntity.get)
		
		List<Package>  packages = vinEntity.getPackages() ; //entityManager.createQuery("FROM package where package_id in (select package_id from vin_package where vin = 'WVWZZZ1J3W000001')").getResultList();
		return packages;
		
	}
	
	
	public List<Package> getPackagesByVIN(String vin){

		return getPackages(vin);
	}
	
private List<Package> getPackages(String vin) {
		
		Spare fourMmNut = new Spare(1, "4 mm nut");
		Spare wiper36mm = new Spare(2, "wiper 36mm");
		Spare rearViewMirror = new Spare(3, "rear view mirror");
		Spare engineCrank = new Spare(4, "engine crank");
		Spare engineValve = new Spare(5, "engine valve");
		
				
		Maintenance oilChange = new Maintenance(1, "oil change");
		Maintenance brakeLiningChange = new Maintenance(2, "brake lining change");
		Maintenance internalWashing = new Maintenance(3, "internal washing");
		Maintenance teflonCoating = new Maintenance(4, "teflon coating");
		Maintenance wheelBalancing = new Maintenance(5, "wheel balancing");
		


		
		HashMap<String, List<Package>> packagesMap = new HashMap<String, List<Package>>();

		List <Spare> basicPackageSpares = new ArrayList<Spare>();
		basicPackageSpares.add(engineValve);
		basicPackageSpares.add(engineValve);
		
		//List<Maintenance> basicPackageLabourPositions = new ArrayList<Maintenance>();
		Integer basicPackageLabourPositions = new Integer(1);
		//basicPackageLabourPositions.add(wheelBalancing);
		//basicPackageLabourPositions.add(wheelBalancing);
		
		
		Package basicPackage = new Package(1, "Basic package", 11, "Basic package description", "Y", basicPackageSpares, basicPackageLabourPositions);
		
		
		List <Spare> summerPackageSpares = new ArrayList<Spare>();
		summerPackageSpares.add(rearViewMirror);

		
		//List<Maintenance> summerPackageLabourPositions = new ArrayList<Maintenance>();
		Integer summerPackageLabourPositions = new Integer(2);
		//summerPackageLabourPositions.add(internalWashing);

		
		Package summerPackage = new Package(2, "Summer package", 22, "Summer package description", "Y", summerPackageSpares, summerPackageLabourPositions);
		
		
		
		
		List <Package> poloPackageList = new ArrayList<Package>();
		poloPackageList.add(basicPackage);
		poloPackageList.add(summerPackage);
		
		List <Package> ventoPackageList = new ArrayList<Package>();
		ventoPackageList.add(basicPackage);
		
		List <Package> beetlePackageList = new ArrayList<Package>();
		
	
		
		packagesMap.put("polo", poloPackageList);
		packagesMap.put("vento", ventoPackageList);
		packagesMap.put("beetle", beetlePackageList);
		
		String model = "";
		if (vin.endsWith("001")) model = "polo";
		if (vin.endsWith("002")) model = "vento";
		if (vin.endsWith("003")) model = "beetle";
		
		if ("polo".equals(model)) return packagesMap.get("polo");
		if ("vento".equals(model)) return packagesMap.get("vento");
		if ("beetle".equals(model)) return packagesMap.get("beetle");
		else return new ArrayList<Package>();
		

		
		
	}


	
	
}
