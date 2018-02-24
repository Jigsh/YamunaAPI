package com.bios.portal.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bios.portal.daos.PackageDao;
import com.bios.portal.entities.Package;


@Service("PackageService")
@Transactional
public class PackageServiceImpl implements PackageService{

	@Autowired
	PackageDao pkgDao;
	

	
	public boolean addPackage(Package pkg) throws Exception {
		return pkgDao.insertPackage(pkg);
	}

	public boolean modifyPackage(Package pkg) throws Exception {
		return pkgDao.updatePackage(pkg);
	}

	@Override
	public List<Package> fetchPackageList(String vin) throws Exception {
		return (List < Package >)pkgDao.getPackageList(vin);
	}

}
