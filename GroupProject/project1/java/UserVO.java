package project1.java;	

import java.io.Serializable;

public class UserVO implements Serializable{
	
	private String userID;
	private String userPW;
	private String userPhoneNum;
	private int userNum;
	private int seatNum;
	private int rdNum;
	private int hour;
	private int hourPrice;
	private int menuNum;//메뉴 주문수량
	private int menuPrice;//메뉴 금액
	private int sumPrice;//메뉴 금액 합계
	private int bonusPoint;//포인트
	private int bonusNum;//포인트 적립or사용 선택
	private int selectHourPrice;
	
	public int getSelectHourPrice() {
		return selectHourPrice;
	}

	public void setSelectHourPrice(int selectHourPrice) {
		this.selectHourPrice = selectHourPrice;
	}

	public int getHourPrice() {
		return hourPrice;
	}

	public void setHourPrice(int hourPrice) {
		this.hourPrice = hourPrice;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	public String getUserPW() {
		return userPW;
	}

	public void setUserPW(String userPW) {
		this.userPW = userPW;
	}

	public String getUserPhoneNum() {
		return userPhoneNum;
	}

	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public int getRdNum() {
		return rdNum;
	}

	public void setRdNum(int rdNum) {
		this.rdNum = rdNum;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMenuNum() {
		return menuNum;
	}

	public void setMenuNum(int menuNum) {
		this.menuNum = menuNum;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public int getBonusNum() {
		return bonusNum;
	}

	public void setBonusNum(int bonusNum) {
		this.bonusNum = bonusNum;
	}

}
