package com.dian.util;

public class Page {

	// ÿҳ��ʾ�ļ�¼��
	private int onepageCount;
	// �ܼ�¼��
	private int totalCount;
	// ��ҳ��
	private int totalPage;
	// ��ǰҳ
	private int currentPage;
	// ��ѯ��ʼ��
	private int beginIdex;
	// �Ƿ�����һҳ
	private boolean hasPrePage;
	// �Ƿ�����һҳ
	private boolean hasNextPage;

	public Page(int onepageCount, int totalCount, int totalPage, int currentPage, int beginIdex, boolean hasPrePage,
			boolean hasNextPage) {
		this.onepageCount = onepageCount;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.beginIdex = beginIdex;
		this.hasNextPage = hasNextPage;
		this.hasPrePage = hasPrePage;
	}

	public int getOnepageCount() {
		return onepageCount;
	}

	public void setOnepageCount(int onepageCount) {
		this.onepageCount = onepageCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBeginIdex() {
		return beginIdex;
	}

	public void setBeginIdex(int beginIdex) {
		this.beginIdex = beginIdex;
	}

	public boolean isHasPrePage() {
		return hasPrePage;
	}

	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	
	
	
	

}
