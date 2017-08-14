package com.test.dto;

public class Page {

	private int totalCnt = 0; // ��ü ������ �ο� ����
	private int rowCnt = 10; // ���������� ���̴� �ο� ����
	private int nowPage = 1; // ���� ������
	private int blockCnt = 10; // ���������� ���̴� ��� ����
	private int totalPageCnt = 0; // ��ü ������ ����
	private int startBlock;
	private int startRow;
	private int endBlock;

	public Page(){
		calPage();
	}
	public void setStartBlock(int startBlock) {
		this.startBlock = startBlock;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public void setEndBlock(int endBlock) {
		this.endBlock = endBlock;
	}

	private void calPage() {
		totalPageCnt = (totalCnt / rowCnt) + 1;
		startRow = (nowPage - 1) * rowCnt;
		startBlock = ((nowPage - 1) / blockCnt) * blockCnt + 1;
		endBlock = startBlock + blockCnt - 1;
		if (endBlock > totalPageCnt) {
			endBlock = totalPageCnt;
		}
	}

	public int getStartBlock() {
		return this.startBlock;
	}

	public int getStartRow() {
		return this.startRow;
	}

	public int getEndBlock() {
		return endBlock;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
		calPage();
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

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	@Override
	public String toString() {
		return "Page [totalCnt=" + totalCnt + ", rowCnt=" + rowCnt + ", nowPage=" + nowPage + ", blockCnt=" + blockCnt
				+ ", totalPageCnt=" + totalPageCnt + ", startBlock=" + startBlock + ", startRow=" + startRow
				+ ", endBlock=" + endBlock + "]";
	}

}
