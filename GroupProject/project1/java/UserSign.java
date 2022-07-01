package project1.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserSign {

	private List<UserVO> list;

	Scanner sc = new Scanner(System.in);

	String pNum,pNumb;
	int ch,temp=1,userNum;
	boolean panjung = false;

	public UserSign(List<UserVO> list) throws Exception {

		this.list = list;

		File f = new File("c:\\doc\\pcroom.txt");

		if (f.exists()) {
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fos);
			list = (List<UserVO>) ois.readObject();
		}
	}

	public void sign() throws Exception {//회원등록

		Iterator<UserVO> it = list.iterator();

		UserVO vo = new UserVO();
		UserData ud = new UserData(list);//for 비회원

		System.out.println("\r\n" +
				"  ♥ ^ ^ \r\n" + 
				"   （' v') \r\n" + 
				" ┏--U━U━━━━━━━━━━┓\r\n" + 
				"\r\n" +
				" ♡  [1] 회원    [2] 비회원  ♡\r\n" +
				"\r\n" +
				" ┗━━━━━━━━━━━━━┛");
		System.out.print("메뉴를 선택하세요 ▶ ");	
		ch = sc.nextInt();
		
		if(ch==1) {//회원

			//ID
			System.out.print("아이디 ▶ ");//ID에서 반복◀
			String ID = sc.next();

			while(it.hasNext()) {
				UserVO uv = it.next();

				if(uv.getUserID().equals(ID)) {
					System.out.print("이미 사용중인 아이디 입니다.");
					return;
				}
			}
			vo.setUserID(ID);

			//PW
			System.out.print("비밀번호 ▶ ");
			String pw1 = sc.next();

			do {
				System.out.print("비밀번호 확인 > ");
				String pw2 = sc.next();

				if(pw1.equals(pw2)) {
					pw2 = pw1;
					vo.setUserPW(pw1);
					panjung = true;
				}else {
					System.out.println("비밀번호가 다릅니다.");
					panjung = false;
				}
			}while(panjung == false);

			//전화번호
			do {
			System.out.print("전화번호(010-****-****) ▶ ");//전화번호 조건, 전화번호에서 반복◀
			pNum = sc.next();

			while(it.hasNext()) {
				UserVO uv = it.next();

				if(uv.getUserPhoneNum().equals(pNum)) {
					System.out.print("이미 사용중인 전화번호입니다.");
					panjung = false;
//					return;
				}
			}
			vo.setUserPhoneNum(pNum);
			}while(panjung == false);

			//회원번호
			userNum += temp;//userNum 누적◀
			
			System.out.println();
			System.out.println("================< 회원정보 확인 >===============\r\n");
			System.out.println("    회원정보           ID              연락처");
			System.out.printf("%9d %15s %22s\n",userNum,ID,pNum);
			System.out.println();
			System.out.println("================================================\r\n");
			
			vo.setUserNum(userNum);
			list.add(vo);

//			userNum++;
			temp++;

			return;
		}

		else if(ch==2) {//비회원

			System.out.print("연락처 > ");		
			pNumb = sc.next();

			while(it.hasNext()) {
				UserVO uv = it.next();

				if(uv.getUserPhoneNum().equals(pNumb)) {//전화번호 조건, 전화번호에서 반복◀
					System.out.println("이미 이용중인 번호 입니다.");
					return;
				}
			}
			vo.setUserPhoneNum(pNumb);
			list.add(vo);

			while(true) {

				System.out.println("\r\n" +
						"  ♥ ^ ^ \r\n" + 
						"   （' v') \r\n" + 	
						"=====U==U===============================\r\n");
				System.out.println( "  ① 좌석선택 ② 시간선택\n" +
						"  ③ 메뉴주문 ④ 결제 ⑤ 종료\r\n");
				System.out.println("=========================================");
				System.out.print("메뉴를 선택하세요 : ");
				ch = sc.nextInt();

				switch(ch) {
				case 1: ud.selectSeat();break;//좌석선택
				case 2: ud.time();break;//시간선택
				case 3: ud.order();break;//메뉴주문
				case 4: ud.Bpay();break;//비회원결제
				default:
					System.out.println( "               /\\             /\\\r\n" + 
							"              |`\\\\_,--=\"=--,_//`|  \r\n" + 
							"              \\ .\"  :'. .':  \". /\r\n" + 
							"             ==)  _ :  '  : _  (==\r\n" + 
							"               |>/O\\   _   /O\\<|\r\n" + 
							"               | \\-\"~` _ `~\"-/ |\r\n" + 
							"              >|`===. \\_/ .===`|<\r\n" + 
							"        .-\"-.   \\==='  |  '===/   .-\"-.\r\n" + 
							"  -----{'. '`}---\\,  .-'-.  ,/---{.'. '}-----\r\n" + 
							"       `\"---\"`     `~-===-~`     `\"---\"`" +
							"              BYE~ 시스템을 종료합니다.");
					ud.save();
					System.exit(0);
				}
				System.out.println(); 

			}
		}
	}
}
