package project1.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserLogin {

	private List<UserVO> list;
	Scanner sc = new Scanner(System.in);

	UserData ud;
	
	String user;
	int userNum;

	public UserLogin(List<UserVO> list) throws Exception {

		this.list = list;
		
		ud = new UserData(list);

		File f = new File("c:\\doc\\pcroom.txt");
		
		if(f.exists()) {	
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fos);
			list = (List<UserVO>) ois.readObject();
		}
	}

	public void login() throws Exception {//로그인

		Iterator<UserVO> it = list.iterator();

		System.out.print("아이디 ▶ ");
		String id = sc.next();

		System.out.print("비밀번호 ▶ ");
		String pw = sc.next();

		while(it.hasNext()) {

			UserVO vo = it.next();

			if(!(id.equals(vo.getUserID()) && pw.equals(vo.getUserPW()))) {
				System.out.println("[오류] 존재하지 않는 ID 혹은 PW 오류");
				return;
			}
		}

		System.out.println(
				"      ♡    。      ♡     。   ♡  \r\n" +
				"   ♡。　＼　       ｜　       ／  ♡ \r\n"+
				"       。　♡ 。　　♡。　　 ♡    \r\n" + 
				"       ♡。　＼　　｜　　 ／。　♡\r\n" + 
				"   。   　  ! 로그인 성공 !     。   \r\n" + 
				"       ♡。　／　　｜　　＼。　♡\r\n" + 
				"       。　♡。 　 ♡。　　♡。\r\n" + 
				"  。   　／　      ｜　  。   ＼   ♡ \r\n" +
				"      ♡    。      ♡ 。       ♡\r\n" +
				"");
		System.out.println();
		System.out.println();

		while(true) {

			System.out.println("\r\n" +
								"  ♥ ^ ^ \r\n" + 
								"   （' v') \r\n" + 	
								"=====U==U====================================\r\n");
			System.out.println("    ① 회원출력 ② 좌석선택 ③ 시간선택 \r\n" +
								"    ④ 메뉴주문 ⑤ 포인트 및 결제 ⑥ 종료\r\n");
			System.out.println("=============================================");
			System.out.print("메뉴를 선택하세요 ▶ ");
			int ch1 = sc.nextInt();

			switch(ch1) {

			case 1:	ud.print();break;//회원출력
			case 2: ud.selectSeat();break;//좌석선택
			case 3: ud.time();break;//시간선택
			case 4: ud.order();break;//메뉴주문
			case 5: ud.pay();break;//포인트 및 결제
			default:
				System.out.print(
						"          　へ　　　 　　   ／ ＼  \r\n" +
						"　         ｜`＼　　　 　  ／／ ｜ \r\n" +
						"   　      ｜|＼〉--------〈／ |｜ \r\n" +
						"         　｜|／　　　　 　 ＼ |｜ \r\n" +
						"   　       /　　　　　　　   ＼  \r\n" + 
						"         　／　-　　　　　 -    ＼\r\n" + 
						"          〈　　●　　ο　　●　  > \r\n" + 
						"         　 ⊂⊃三　 (_v_) 三⊂⊃／\r\n" + 
						" ===========(^_^_^)=======(^_^_^)============ \r\n" + 
						"|                 .-.   .-.                  |\r\n" +  
						"|                /   \\ /   \\                 |\r\n" + 
						"|            .-. |    |    | .-.             |\r\n" + 
						"|          /   \\ \\  / \\  / /  \\              |\r\n" + 
						"|          |   |  '`.-.`'    |   |           |\r\n" + 
						"|           \\_.' .-`   `-. '._/              |\r\n" + 
						"|             .-'         '-.                |\r\n" + 
						"|            /               \\               |\r\n" + 
						"|            |   SEE YOU  ♡  |              |\r\n" + 
						"|             \\             /                |\r\n" + 
						"|              '.___...___.''                |\r\n" +
						" ============================================ \r\n" 
					 	);
				ud.save();
				System.exit(0);
			}

			System.out.println(); 

		}
	}

}
