package project1.java;//soo

import java.util.Scanner;

public class PCMain {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		UserData ud = new UserData();
		
		int ch;
		
		while(true) {
			
			do {
				System.out.println("================================================");
				System.out.println("1.회원등록 2.로그인 3.회원출력 4.좌석선택\n"
						+ "5.시간선택 6.메뉴주문 7.포인트 및 결제 8.종료");
				System.out.println("================================================");
				System.out.print("메뉴를 선택하세요 : ");
				ch = sc.nextInt();
			}while(ch<1);
			
			switch(ch) {
				case 1: ud.sign();break;//회원등록
				case 2:	ud.login();break;//로그인
				case 3:	ud.print();break;//회원출력
				case 4: ud.selectSeat();break;//좌석선택
				case 5: ud.time();break;//시간선택
				case 6: ud.order();break;//메뉴주문
				case 7: ud.pay();break;//포인트 및 결제
				default:
					System.out.println("시스템을 종료합니다.");
					ud.save();
					System.exit(0);
			}
			
			System.out.println();
			
		}

	}

}
