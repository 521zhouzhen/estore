package com.briup.app.estore.shoppingcart;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



import com.briup.app.estore.bean.Book;
import com.briup.app.estore.bean.Orderline;

//购物车类，可以保存用户当前挑选的书籍信息
public class ShoppingCart {
	
	
	
	// key 商品id  value 订单项（订单项中包含商品信息，数量）

	public Map<Integer, Orderline> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Orderline> map) {
		this.map = map;
	}

	private Map<Integer, Orderline> map = 
				new HashMap<Integer, Orderline>();
	
	//向购物车中添加产品
	//先判断购物车中有没有该产品的订单项目，如果有，在数量上做改变，
	//如果没有向map中添加
	public void add(Orderline orderline){
		Book book = orderline.getBook();
		if(map.containsKey(book.getId())){
			Orderline oldline = map.get(book.getId());
			oldline.setNum(oldline.getNum()+1);
		}else{
			orderline.setNum(1);
			map.put(book.getId(), orderline);
		}
	}
	
	//删除订单
	public void delete(Integer bookId){
		map.remove(bookId);
	}
	//获取总价钱
	public double getCost(){
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> iter = keySet.iterator();
		double cost = 0.0;
		while(iter.hasNext()){
			Integer key = iter.next();
			Orderline value = map.get(key);
			Integer num = value.getNum();
			double price = ((Book) value.getBook()).getPrice();
			double lineCost = num*price;
			cost += lineCost;
		}
		return cost;
	}
	
	
	//获取购物车中所有订单明细
	public Map<Integer, Orderline> getLines(){
		return map;
	}
	//清空购物车
	public void clear(){
		map.clear();
	}
	
	//修改指定line中的数量
	public void update(Integer key,Integer num){
		Orderline line = map.get(key);
		if(line!=null){
			line.setNum(num);
		}
	}

	

}
