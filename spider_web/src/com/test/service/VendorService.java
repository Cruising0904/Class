package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn2;
import com.test.dto.Vendor;

public class VendorService {
	public Vendor vendorView(Vendor vd){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn2.getCon();
			String sql = "select * from vendor_info";
			sql += " where vinum = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, vd.getViNum());
			ResultSet rs = ps.executeQuery();
			Vendor vendor = new Vendor();
			while(rs.next()){
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
			}
			return vendor;
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
	
	public List<Vendor> selectVendor(Vendor vd){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn2.getCon();
			String sql = "select * from vendor_info";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<Vendor> vendorList = new ArrayList<Vendor>();
			while(rs.next()){
				Vendor vendor = new Vendor();
				vendor.setViNum(rs.getInt("vinum"));
				vendor.setViName(rs.getString("viname"));
				vendor.setViDesc(rs.getString("videsc"));
				vendor.setViAddress(rs.getString("viaddress"));
				vendor.setViPhone(rs.getString("viphone"));
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
	
	
	public int insertVendors(Vendor vd){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into vendor_info(viName, viDesc,viAddress,viPhone,vicredat,vicretim)"
					+ "values(?,?,?,?,DATE_FORMAT(NOW(), '%Y%m%d'),DATE_FORMAT(NOW(), '%H%i%s'))";
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vd.getViName());
			ps.setString(2, vd.getViDesc());
			ps.setString(3, vd.getViAddress());
			ps.setString(4, vd.getViPhone());
			
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
			ps.setInt(1, vendor.getViNum());
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
	