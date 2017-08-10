package com.test.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.common.DBConn2;
import com.test.dto.Goods;
import com.test.dto.Page;

public class GoodsService {
	
	public List<Goods> selectGoodsList(Goods pGoods){
		Connection con = null;
		PreparedStatement ps = null;
		try {
			String sql = "select gi.ginum, gi.giname, gi.gidesc, vi.vinum, vi.name"
					+ "from goods_info as gi, vendor_info as vi"
					+ " where gi.vinum = vi.vinum"
					+ " order by gi.gnum"
					+ " limit ?,?";
			Page page = pGoods.getPage();
			con = DBConn2.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1,  page.getStartRow());
			System.out.println(page.getStartRow());
			ps.setInt(2,  page.getRowCnt());
			System.out.println(page.getBlockCnt());
			ResultSet rs = ps.executeQuery();
			List<Goods> goodsList = new ArrayList<Goods>();
			while(rs.next()){
				Goods goods = new Goods();
				goods.setGiNum(rs.getInt("giNum"));
				goods.setGiName(rs.getString("giName"));
				goods.setGiDesc(rs.getString("giDesc"));
				goods.setViNum(rs.getInt("viNum"));
				goods.setViName(rs.getString("viName"));
				goodsList.add(goods);
			}
			return goodsList;
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
