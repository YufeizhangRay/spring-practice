package cn.zyf.spring.tx.xml.service.impl;

import cn.zyf.spring.tx.xml.BookShopDao;
import cn.zyf.spring.tx.xml.service.BookShopService;

public class BookShopServiceImpl implements BookShopService{

	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
	@Override
	public void purchase(String username, String isbn) {
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {}
		
		//1.获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		//2.更新书的库存
		bookShopDao.updateBookStock(isbn);
		
		//3.更新用户余额
		bookShopDao.updateUserAccount(username, price);
		
	}

}
