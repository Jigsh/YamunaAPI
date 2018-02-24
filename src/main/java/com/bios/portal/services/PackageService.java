package com.bios.portal.services;

import java.util.List;

import com.bios.portal.entities.Package;


public interface PackageService {
	boolean addPackage(Package pkg) throws Exception;
	boolean modifyPackage(Package pkg) throws Exception;
	List< Package > fetchPackageList(String vin) throws Exception;

}
