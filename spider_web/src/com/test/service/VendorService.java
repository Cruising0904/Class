package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.common.DBConn2;
import com.test.dto.Goods;
import com.test.dto.Page;
import com.test.dto.Vendor;

public class VendorService {
	Vendor v ;
	public List<Vendor> selectVendorsList(String viName){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select vinum, viname, videsc, viaddress, viphone, vicredat from vendor_info where 1=1";
			if(viName!=null){
				sql += " and viname like ?";
			}
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			if(viName!=null){
				ps.setString(1, "%" + viName + "%");
			}
			ResultSet rs = ps.executeQuery();
			List<Vendor> vendorList = new ArrayList<Vendor>();
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
				vendor.setViCredat(rs.getString("viCredat"));
				vendorList.add(vendor);
			}
			return vendorList;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	public int insertVendors(Vendor vendor){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into vendor_info(viName, viDesc,viAddress,viPhone,vicredat,vicretim)"
					+ "values(?,?,?,?,DATE_FORMAT(NOW(), '%Y%m%d'),DATE_FORMAT(NOW(), '%H%i%s'))";
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, v.getViName());
			ps.setString(2, v.getViDesc());
			ps.setString(3, v.getViAddress());
			ps.setString(4, v.getViPhone());
			
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
	public int deleteVendor(Vendor vendor){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "delete from vendor_info where  vinum=?";
			con = DBConn2.getCon(); 
			ps = con.prepareStatement(sql);
			ps.setInt(1, v.getViNum());
			int result = ps.executeUpdate();
			con.commit();
			return result;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				DBConn2.closeCon();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

public Vendor selectVendor(Vendor vendor){
	Connection con = null;
	PreparedStatement ps = null;
	try {
		String sql = "select vinum, viname, videsc, viaddress, viphone, vicredat from vendor_info where 1=1";
		sql	+=" where vinum=?";
		con = DBConn2.getCon();
		ps = con.prepareStatement(sql);
		ps.setInt(1, v.getViNum());
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Vendor vend = new Vendor();
			vend.setViNum(rs.getInt("vinum"));
			vend.setViName(rs.getString("viname"));
			vend.setViDesc(rs.getString("videsc"));
			vend.setViAddress(rs.getString("viaddress"));
			vend.setViPhone(rs.getString("viphone"));
			vend.setViCredat(rs.getString("vicredat"));
			return vendor;
		}
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		try {
			ps.close();
			DBConn2.closeCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return null;
}	
}
//	public int updateGoods(Goods pGoods) {
//		Connection con = null;
//		PreparedStatement ps = null;
//		try {
//			String sql = "update goods_info";
//			sql += " set giname=?,";
//			sql += " gidesc=?,";
//			sql += " vinum=?";
//			sql += " where ginum=?";
//			con = DBConn2.getCon();
//			ps = con.prepareStatement(sql);
//			ps.setString(1, pGoods.getGiName());
//			ps.setString(2, pGoods.getGiDesc());
//			ps.setInt(3,  pGoods.getViNum());
//			ps.setInt(4, pGoods.getGiNum());
//			int result = ps.executeUpdate();
//			con.commit();
//			return result;
//		}catch(ClassNotFoundException e) {
//			e.printStackTrace();
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				ps.close();
//				DBConn2.closeCon();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return 0;
//	}
	