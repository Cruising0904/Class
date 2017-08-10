package com.test.dto;

public class Page {

	private int totalCnt = 0;			// 전체 데이터 로우 갯수
	private int rowCnt = 10;			// 한페이지에 보이는 로우 갯수
	private int nowPage = 1; 			// 현재 페이지
	private int blockCnt = 10;			// 한페이지에 보이는 블락 갯수
	private int totalPageCnt = 0;		// 전체 페이지 갯수
	private int totalBlockCnt = 0;	// 전체 블락 갯수

	public int getStartBlock(){
		return getStartRow()/blockCnt;
	}
	
	public int getStartRow(){
		return ( nowPage-1) * rowCnt;
	}
	
	public int getEndBlock(){
		int endBlock = getStartBlock()+blockCnt;
		if(endBlock < totalBlockCnt){
			endBlock = totalBlockCnt;
		}
		return endBlock;
	}
	
	
	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getRowCnt() {
		return rowCnt;
	}

	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}

	public int getBlockCnt() {
		return blockCnt;
	}

	public void setBlockCnt(int blockCnt) {
		this.blockCnt = blockCnt;
	}

	public int getTotalPageCnt() {
		return totalPageCnt;
	}

	public void setTotalPageCnt(int totalPageCnt) {
		this.totalPageCnt = totalPageCnt;
	}

	public int getTotalBlockCnt() {
		return totalBlockCnt;
	}

	public void setTotalBlockCnt(int totalBlockCnt) {
		this.totalBlockCnt = totalBlockCnt;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
}
