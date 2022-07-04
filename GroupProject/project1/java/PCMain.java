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
					"          　へ　　　 　　   ／ ＼  \r\n" +
							"　         ｜`＼　　　 　  ／／ ｜ \r\n" +
							"   　      ｜|＼〉--------〈／ |｜ \r\n" +
							"         　｜|／　　　　 　 ＼ |｜ \r\n" +
							"   　       /　　　　　　　   ＼  \r\n" + 
							"         　／　-　　　　　 -    ＼\r\n" + 
							"          〈　　●　　ο　　●　  > \r\n" + 
							"         　 ⊂⊃三　 (_v_) 三⊂⊃／\r\n" + 
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
							"|                    ｜                      |\r\n"+ 
							"|    ① 회원가입     ｜  ② 사용자 로그인    |\r\n"+ 
							"|                    ｜                      |\r\n"+ 
							" ============================================\r\n" +
					" 메뉴를 선택해 주세요 ><≡> ");

//			int ch = sc.nextInt();//방법①
//			switch (ch) {
			switch (sc.nextInt()) {//방법②
			case 1: us.sign(); break;
			case 2: ul.login(); break;

			default: break;
			
			}
		}
	}
}
