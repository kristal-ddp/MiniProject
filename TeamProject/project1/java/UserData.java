package project1.java;//soo

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserData {
	
	private List<UserVO> lists;
	
	int userNum=1,i=1;
	int seat[] = new int[6];
	
	String userID,menu="";
	int selectNum,selectHour=0,selectHourPrice;
	int menuNum,menuPrice=0;
	int totPrice,bonusPoint,payNum;
	
	Scanner sc = new Scanner(System.in);
	String phonenum,user;
	
	public UserData() throws Exception {
		
		File f = new File("c:\\doc\\pcroom.txt");
		
		if (!f.exists()) {
			lists = new ArrayList<>();
		}else {
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fos);
			lists = (List<UserVO>) ois.readObject();
		}
	}
	
	public void sign() {//회원등록
		
		Iterator<UserVO> it = lists.iterator();
		UserVO vo = new UserVO();
		
		System.out.println("================================================");
		System.out.println("         [1] 회원            [2] 비회원 ");
		System.out.println("================================================");
		System.out.print("메뉴를 선택하세요 : ");	
		
		int num = sc.nextInt();
		if(num==1) {
			
			//ID
			System.out.print("아이디 > ");
			String ID = sc.next();
			
			while(it.hasNext()) {
				UserVO uv = it.next();
				
				if(uv.getUserID().equals(ID)) {
					System.out.print("이미 사용중인 아이디 입니다.");
					return;
				}
			}
			vo.setUserID(ID);
			user = vo.getUserID();
			
			//PW
			System.out.print("비밀번호 > ");
			String pw1 = sc.next();
	
			System.out.print("비밀번호 확인 > ");
			String pw2 = sc.next();
			
			if(!pw1.equals(pw2)) {
				System.out.println("비밀번호가 다릅니다.");
				return;
			}
			vo.setUserPW(pw1);
			
			//전화번호
			System.out.print("연락처(010-****-****) > ");
			String pNum = sc.next();
			
			while(it.hasNext()) {
				UserVO uv = it.next();
				
				if(uv.getUserPhoneNum().equals(pNum)) {
					System.out.print("이미 사용중인 전화번호입니다.");
					return;
				}
			}
			vo.setUserPhoneNum(pNum);
			
			//회원번호
			System.out.println("================< 회원정보 확인 >===============");
			System.out.println("    회원정보           ID              연락처");
			System.out.printf("%9d %15s %22s\n",userNum,ID,pNum);
			System.out.println("================================================");
			vo.setUserNum(userNum);

			lists.add(vo);
			
			userNum++;
			
			return;
		}
		
		else if(num==2) {
			
			System.out.print("연락처 > ");		
			String pNumb = sc.next();
			
			while(it.hasNext()) {
				UserVO uv = it.next();
				
				if(uv.getUserPhoneNum().equals(pNumb)) {
					System.out.println("이미 이용중인 번호 입니다.");
					return;
				}
			}
		}
	}
	
	public void login() {//로그인
		
		Iterator<UserVO> it = lists.iterator();
		
		System.out.print("아이디 > ");
		String id = sc.next();
		
		System.out.print("비밀번호 > ");
		String pw = sc.next();
		
		while(it.hasNext()) {
		
			UserVO vo = it.next();
			
			if(id.equals(vo.getUserID()) && pw.equals(vo.getUserPW())) {
				System.out.println("로그인 성공!");
				break;
			}
			else if(!(id.equals(vo.getUserID()) && pw.equals(vo.getUserPW()))) {
				System.out.print("[오류] 존재하지 않는 ID 혹은 PW 오류");
				return;
			}
		}
	}
	
	public void print() {//회원출력
		
		Iterator<UserVO> it = lists.iterator();
		while(it.hasNext()) {
			
			UserVO vo = it.next();
			
			System.out.println(vo.toString());
		}
	}
	
	public void save() throws Exception {//파일저장
		
		FileOutputStream fos = new FileOutputStream("c:\\doc\\pcroom.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(lists);
		oos.close();
		fos.close();
		
		System.out.println("파일 저장 성공!");
	}
	
	public void selectSeat() {//좌석선택
		
		System.out.println("좌석 선택");
		int ch = sc.nextInt();
		System.out.printf("%d번 자리를 선택하셨습니다.\n",ch);
		System.out.println();
		
		seat[ch-1] = 1;
		for(int i=0; i<seat.length;i++) {
			if(seat[i]==0) {
				System.out.printf("이용 가능\n");
				
			}else {
				System.out.printf("이용 중\n");
			}
		}
	}
	
	public void time() {//시간 선택
		
		int hour[] = {1,2,3,4,5};
		int hourPrice[] = {1000,2000,3000,4000,5000};
		
		System.out.println("=====================<시간 선택>=====================");
		System.out.println("1.시간선택 2.이전");
		System.out.println("======================================================");
		System.out.print("메뉴를 선택하세요.");
		selectNum = sc.nextInt();
		
		do {
			if(selectNum==1) {
				System.out.println("=================<시간 요금>=================");
				System.out.println("번호 시간 금액");
				for(i=0;i<5;i++) {
					System.out.printf("%d %s시간 %d원\n",i+1,hour[i],hourPrice[i]);
				}
				System.out.println("=============================================");
				System.out.print("사용할 시간을 선택하세요.");
				menuNum = sc.nextInt();
				
				selectHour = hour[menuNum-1];
				selectHourPrice = hourPrice[menuNum-1];
				
				System.out.printf("%d시간 %d원 추가되었습니다.\n",selectHour,selectHourPrice);
				System.out.println("=============================================");
			}else if(selectNum==2) {
				return;
			}
		}while(selectNum<1 || selectNum>2);
		
	}
	
	public void order() {//메뉴 주문
		
		UserVO vo = new UserVO();
		
		String rice[] = {"떡국","공기밥","비빔밥","불고기덮밥","돈까스마요덮밥","참치마요덮밥","치킨마요덮밥",
				"떡갈비마요덮밥","참치볶음김치덮밥","대패삼겹덮밥","낚지볶음밥","김치볶음밥","돈까스"};
		int ricePrice[] = {3000,1000,4500,5500,5500,5500,5500,5500,5500,5500,5500,5500,6000};
		
		String noodle[] = {"라면","떡라면","치즈라면","만두라면","비빔면","짜파게티","붉닭볶음면","물냉면","비빔냉면"};
		int noodlePrice[] = {4000,4500,4500,4500,4000,4000,4000,5000,5000};
		
		String snack[] = {"닭강정","떡볶이","라볶이","까르보나라떡볶이","감자튀김","치즈감자튀김","버터갈릭감자튀김",
				"소떡소떡","뉴욕핫도그","치즈핫도그","고기만두","김치만두"};
		int snackPrice[] = {5000,4000,4000,4500,2000,2500,2500,2000,2500,2500,2800,2800};
		
		String drink[] = {"체리에이드","애플망고에이드","청포도에이드","레몬에이드","블루레몬에이드","핫초코",
				"아이스초코","레몬아이스티","복숭아아이스티","콜라","사이다","마운틴듀","아메리카노"};
		int drinkPrice[] = {3200,3200,3200,3200,3200,3000,3000,1900,1900,1900,1900,1900,3000};
		
		do {
			System.out.println("=================<메뉴 주문>=================");
			System.out.println("1.밥류  2.면류  3.간식류  4.음료/커피 5.이전");
			System.out.println("=============================================");
			System.out.print("메뉴를 선택하세요.");
			selectNum = sc.nextInt();
			
			if(selectNum==1) {
				System.out.println("=================<상품 목록>=================");
				System.out.println("번호     상품명      금액");
				for(i=0;i<rice.length;i++) {
					System.out.printf("%2d   %-8s  %-2d\n",i+1,rice[i],ricePrice[i]);
				}
				System.out.println("=============================================");
				System.out.print("주문하실 메뉴를 선택하세요.");
				menuNum = sc.nextInt();
				vo.setMenuNum(menuNum);
//				vo.setMenuNum(sc.nextInt());
				
				menu = rice[menuNum-1];//선택한 메뉴이름,금액 가져오고 출력
				menuPrice = ricePrice[menuNum-1];
				
			}else if(selectNum==2) {
				System.out.println("=================<상품 목록>=================");
				System.out.println("번호 상품명 금액");
				for(i=0;i<noodle.length;i++) {
					System.out.printf("%d %s %d\n",i+1,noodle[i],noodlePrice[i]);
				}
				System.out.println("=============================================");
				System.out.print("주문하실 메뉴를 선택하세요.");
				menuNum = sc.nextInt();
				vo.setMenuNum(menuNum);

				menu = noodle[menuNum-1];
				menuPrice = noodlePrice[menuNum-1];
				
			}else if(selectNum==3) {
				System.out.println("=================<상품 목록>=================");
				System.out.println("번호      상품명      금액");
				for(i=0;i<snack.length;i++) {
					System.out.printf("%d %10s %d\n",i+1,snack[i],snackPrice[i]);
				}
				System.out.println("=============================================");
				System.out.print("주문하실 메뉴를 선택하세요.");
				menuNum = sc.nextInt();
				vo.setMenuNum(menuNum);
				
				menu = snack[menuNum-1];
				menuPrice = snackPrice[menuNum-1];
				
			}else if(selectNum==4) {
				System.out.println("=================<상품 목록>=================");
				System.out.println("번호 상품명 금액");
				for(i=0;i<drink.length;i++) {
					System.out.printf("%d %s %d\n",i+1,drink[i],drinkPrice[i]);
				}
				System.out.println("=============================================");
				System.out.print("주문하실 메뉴를 선택하세요.");
				menuNum = sc.nextInt();
				vo.setMenuNum(menuNum);
				
				menu = drink[menuNum-1];
				menuPrice = drinkPrice[menuNum-1];
				
			}else if(selectNum==5) {
				return;
			}
			
			System.out.printf("%s %d원 주문완료되었습니다.\n",menu,menuPrice);
			System.out.println("=============================================");
			
			lists.add(vo);
//			시간되면 음식조리 thread
			
		}while(selectNum<1 || selectNum>5);
		
	}
	
	public void pay() {//결제
		
		do {
			System.out.println("============<포인트 및 요금결제>============");
			System.out.println("1.포인트적립 2.요금결제 3.이전");
			System.out.println("============================================");
			System.out.print("메뉴를 선택하세요.");
			selectNum = sc.nextInt();
			
			totPrice=selectHourPrice+menuPrice;
				
			if(selectNum==1) {
				
				System.out.println("포인트를 적립하시겠습니까?");
				System.out.print("1.네 2.아니오");
				payNum = sc.nextInt();
				System.out.println("=============================================");
				
				if(payNum==1) {
					bonusPoint ++;
					bonusPoint = (int)(totPrice*0.05);
					System.out.println("포인트 적립이 완료되었습니다.\n");
					System.out.println("성함 합계금액 포인트");
					System.out.printf("%s님 %d원 %d원\n",user,totPrice,bonusPoint);
					System.out.println("=============================================");
				}else {
					return;
				}
			}
			
			if(selectNum==2) {
				
				System.out.println("=================<요금 결제>=================");
				System.out.println("성함 이용시간 금액 주문메뉴 금액 합계금액");
				System.out.printf("%s님 %d시간 %d원 %s %d원 %d원\n",
						user,selectHour,selectHourPrice,menu,menuPrice,totPrice);
				System.out.println("=============================================");
				System.out.println("요금을 결제하시겠습니까?");
				System.out.print("1.네 2.아니오");
				payNum = sc.nextInt();//selctNum를 같은 method에서 2번 사용 가능?X
				System.out.println("=============================================");
				
				if(payNum==1) {
					
					System.out.printf("%s님의 현재 포인트는 %d입니다\n"
							+ "포인트를 사용하시겠습니까?\n",user,bonusPoint);
					System.out.print("1.네 2.아니오");
					payNum = sc.nextInt();
					System.out.println("=============================================");
					
					if(payNum==1) {
						bonusPoint = 0;
					}
					
					selectHourPrice = 0;
					menuPrice = 0;
					totPrice = 0;
					
					System.out.println("결제가 완료되었습니다.\n");
					System.out.println("성함 현재금액 포인트");
					System.out.printf("%s님 %d원 %d원\n",user,totPrice,bonusPoint);
					
				}else {
					return;
				}
					
			}else {
				return;
			}
			
		if(selectNum==4) {
			return;
		}
		
	}while(selectNum<1 || selectNum>4);
		
	}
}

