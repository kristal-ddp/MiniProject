package project1.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PCMain {
	
	private static List<UserVO> list = new ArrayList<>();

	public static List<UserVO> getList() {
		return list;
	}
	public static void setList(List<UserVO> list) {
		PCMain.list = list;
	}

	public static void main(String[] args) throws Exception {

		UserSign us = new UserSign(list);
		UserLogin ul = new UserLogin(list);

		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print(
					"          ���ء����� ����   �� ��  \r\n" +
							"��         ��`�������� ��  ���� �� \r\n" +
							"   ��      ��|����--------���� |�� \r\n" +
							"         ����|���������� �� �� |�� \r\n" +
							"   ��       /��������������   ��  \r\n" + 
							"         ������-���������� -    ��\r\n" + 
							"          �������ܡ�������ܡ�  > \r\n" + 
							"         �� ����߲�� (_v_) ߲������\r\n" + 
							"         -- (^_^_^)-------(^_^_^)--\r\n"  +
							" ============================================ \r\n" + 
							"|                                            |\r\n" + 
							"|           _ _  ___  _    _    ___          |\r\n" + 
							"|            | || __>| |  | |  | . |         |\r\n" + 
							"|            _ || _> | |_ | |_ | | |         |\r\n" + 
							"|           _|_||___>|___||___|`___'         |\r\n" +
							"|                                            |\r\n" +
							"|            WELCOME ITWILL PC ROOM          |\r\n" + 
							"|                                            |\r\n" + 
							" ============================================ \r\n" +
							"|                    ��                      |\r\n"+ 
							"|    �� ȸ������     ��  �� ����� �α���    |\r\n"+ 
							"|                    ��                      |\r\n"+ 
							" ============================================\r\n" +
					" �޴��� ������ �ּ��� ><��> ");

//			int ch = sc.nextInt();//�����
//			switch (ch) {
			switch (sc.nextInt()) {//�����
			case 1: us.sign(); break;
			case 2: ul.login(); break;

			default: break;
			
			}
		}
	}
}
