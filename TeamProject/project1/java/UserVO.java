package project1.java;//member1

import java.io.Serializable;

public class UserVO implements Serializable{
	
	private String userID;
	private String userPW;
	private String userPhoneNum;
	private int userNum;
	private int seatNum;
	private int rdNum;
	private int hour;
	
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

	
	public String toString() {
		
		System.out.println("회원번호 ID");
		String str = String.format("%d %s",userNum,userID);
		return str;
		
	}

}
