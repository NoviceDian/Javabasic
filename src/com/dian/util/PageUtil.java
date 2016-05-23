package com.dian.util;

public class PageUtil {

	public static Page createPage(int onePageCount, int totalCount, int currentPage) {
		onePageCount = getonePageCount(onePageCount);
		currentPage = getCurrentPage(currentPage);
		int totalPage = getTotalPage(onePageCount, totalCount);
		int beginIndex = getBeginIndex(onePageCount, currentPage);
		boolean hasPrePage = getHasPrePage(currentPage);
		boolean hasNextPage = getHasNextPage(totalPage, currentPage);
		return new Page(onePageCount, totalCount, totalPage, currentPage, beginIndex, hasPrePage, hasNextPage);
	}

	public static boolean getHasNextPage(int totalPage, int currentPage) {
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}

	public static boolean getHasPrePage(int currentPage) {
		return currentPage == 1 ? false : true;
	}

	public static int getonePageCount(int onePageCount) {
		return onePageCount == 0 ? 10 : onePageCount;
	}

	public static int getCurrentPage(int currentPage) {
		return currentPage == 0 ? 1 : currentPage;
	}

	public static int getTotalPage(int onePageCount, int totalCount) {
		int totalPage = 0;
		if (totalCount != 0 && totalCount % onePageCount == 0) {
			totalPage = totalCount / onePageCount;
		} else {
			totalPage = totalCount / onePageCount + 1;
		}
		return totalPage;
	}

	public static int getBeginIndex(int onePageCount, int currentPage) {
		return (currentPage - 1) * onePageCount;
	}

}
