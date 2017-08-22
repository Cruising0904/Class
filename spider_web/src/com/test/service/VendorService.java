package com.test.service;

import java.util.List;

import com.test.dto.Vendor;

public interface VendorService {
	List<Vendor> selectVendorsList(String viName);
	Vendor vendorView(Vendor vd);
	List<Vendor> selectVendor(Vendor vd);
	int insertVendors(Vendor vd);
	int deleteVendor(Vendor vendor);
	int updateVendor(Vendor vendor);
}
