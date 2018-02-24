package com.bios.portal.daos;

import java.util.List;

import com.bios.portal.entities.Package;

public interface PackageDao {
	

	
	boolean insertPackage(Package pkg) throws Exception;
	boolean updatePackage(Package pkg) throws Exception;
	List< Package > getPackageList(String vin) throws Exception;

	
}
