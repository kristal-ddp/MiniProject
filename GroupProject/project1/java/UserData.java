package project1.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;

public class UserData {
	
	String userID,menu="",phonenum;
	int userNum=1,i=1;
	int seat[] = new int[6];
	int selectNum,selectHour=0,selectHourPrice;
	int menuNum,menuPrice=0;
	int totPrice,bonusPoint,payNum;

	private List<UserVO> list;
	
	Scanner sc = new Scanner(System.in);

	public UserData(List<UserVO> list) throws Exception {

		this.list = list;
		UserSign us = new UserSign(list);

		File f = new File("c:\\doc\\pcroom.txt");
		if(f.exists()) {	
			FileInputStream fos = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fos);
			list = (List<UserVO>) ois.readObject();
		}
	}

	public void print() {//회원출력

			System.out.println();
			System.out.println("==================< 회원정보 >=================\r\n");
			System.out.println("    회원정보           ID              연락처");
			System.out.printf("%9d %15s %22s\n",userNum,list.get(0).getUserID(),list.get(0).getUserPhoneNum());
			System.out.println();
			System.out.println("================================================\r\n");
	}

	public void save() throws Exception {//파일저장

		FileOutputStream fos = new FileOutputStream("c:\\doc\\pcroom.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(list);
		oos.close();
		fos.close();
	}

	public void selectSeat() {//좌석선택
		System.out.println	("\r\n" +
							"                                  ^ ^ ♥ \r\n" + 
							"                               （'v ') \r\n" + 	
							"=================================U==U========\r\n");
		System.out.println("        ① 좌석 선택          ② 이전 \r\n");
		System.out.println("=============================================");
		System.out.print("메뉴를 선택하세요 ▶ ");
		selectNum = sc.nextInt();

			if(selectNum==1) {
				System.out.println("---------------------------------------------\r\n");
				System.out.println(" 1 번 좌석 : □ 이용가능");
				System.out.println(" 2 번 좌석 : □ 이용가능");
				System.out.println(" 3 번 좌석 : □ 이용가능");
				System.out.println(" 4 번 좌석 : □ 이용가능");
				System.out.println(" 5 번 좌석 : □ 이용가능");
				System.out.println(" 6 번 좌석 : □ 이용가능\r\n");
				System.out.println("=============================================");
				System.out.print("이용할 좌석번호 입력하세요 ▶ ");
				int ch = sc.nextInt();
				list.get(0).setSeatNum(ch);
				System.out.println("---------------------------------------------");
				seat[ch-1] = 1;
				for(int i=0; i<seat.length;i++) {
					if(seat[i]==0) {
						System.out.println((i+1) + "번 좌석 : □ 이용가능");
					}else {
						System.out.println((i+1) + "번 좌석 : ■ 이용 중");
					}
				}
				System.out.println("---------------------------------------------");
				System.out.printf("[SYSTEM]▶ %d번 자리를 선택하셨습니다.\n",ch);
				System.out.println(); 
			}else if(selectNum==2) {
				return;
			}
	}

	public void time() {//시간 선택

		int hour[] = {1,2,3,4,5};
		int hourPrice[] = {1000,2000,3000,4000,5000};

		System.out.println	("\r\n" +
							"                                   ^ ^ ♥\r\n" + 
							"                                 （'v ') \r\n" + 	
							"=================<시간 선택>=======U==U======\r\n");
		System.out.println("          ① 시간선택       ② 이전 \r\n");
		System.out.println("=============================================");
		System.out.print("메뉴를 선택하세요 ▶ ");
		selectNum = sc.nextInt();

		do {
			if(selectNum==1) {
				System.out.println("=================<시간 요금>=================\r\n");
				System.out.println("      번호           시간           금액 \r\n");
				for(i=0;i<5;i++) {
					System.out.printf("%9d %11s시간 %13d원\n",i+1,hour[i],hourPrice[i]);
				}
				System.out.println("\r\n=============================================");
				System.out.print("사용할 시간을 선택하세요 ▶ ");
				menuNum = sc.nextInt();

				list.get(0).setHour(menuNum);
				list.get(0).setHourPrice(menuNum*1000);

				selectHour = hour[menuNum-1];
				selectHourPrice = hourPrice[menuNum-1];

				System.out.printf("☆★☆ %d시간 %d원 추가되었습니다.\n",list.get(0).getHour(),list.get(0).getHourPrice());
				System.out.println("=============================================");
			}else if(selectNum==2) {
				return;
			}
		}while(selectNum<1 || selectNum>2);
	}

	public void order() {//메뉴 주문

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
			System.out.println	("\r\n" +
								"                                   ^ ^ ♥\r\n" + 
								"                                 （'v ') \r\n" + 	
								"=================<메뉴 주문>=======U==U======\r\n");
			System.out.println("① 밥류  ② 면류 ③ 간식류 ④ 음료/커피 ⑤이전\r\n");
			System.out.println("=============================================");
			System.out.print("메뉴를 선택하세요 ▶ ");
			selectNum = sc.nextInt();

			if(selectNum==1) {
				System.out.println("=================<상품 목록>=================\r\n");
				System.out.println("	번호       상품명          금액 \r\n");
				for(i=0;i<rice.length;i++) {
					System.out.printf("	%3d    %-8s\t   %-9d\n",i+1,rice[i],ricePrice[i]);
				}
				System.out.println();
				System.out.println("=============================================");
				System.out.print("주문하실 메뉴를 선택하세요 ▶ ");
				menuNum = sc.nextInt();

				list.get(0).setMenuNum(menuNum);
				//vo.setMenuNum(sc.nextInt());

				menu = rice[menuNum-1];//선택한 메뉴이름,금액 가져오고 출력
				menuPrice = ricePrice[menuNum-1];
				list.get(0).setMenuPrice(menuPrice);

			}else if(selectNum==2) {
				System.out.println("=================<상품 목록>=================\r\n");
				System.out.println("	번호     상품명            금액 \r\n");
				for(i=0;i<noodle.length;i++) {
					System.out.printf("	%3d    %-8s\t   %-9d\n",i+1,noodle[i],noodlePrice[i]);
				}
				System.out.println();
				System.out.println("=============================================");
				System.out.print("주문하실 메뉴를 선택하세요 ▶ ");
				menuNum = sc.nextInt();
				list.get(0).setMenuNum(menuNum);

				menu = noodle[menuNum-1];
				menuPrice = noodlePrice[menuNum-1];
				list.get(0).setMenuPrice(menuPrice);

			}else if(selectNum==3) {
				System.out.println("=================<상품 목록>=================\r\n");
				System.out.println("	번호       상품명          금액 \r\n");
				for(i=0;i<snack.length;i++) {
					System.out.printf("	%3d    %-8s\t   %-9d\n",i+1,snack[i],snackPrice[i]);
				}
				System.out.println();
				System.out.println("=============================================");
				System.out.print("주문하실 메뉴를 선택하세요 ▶ ");
				menuNum = sc.nextInt();
				list.get(0).setMenuNum(menuNum);

				menu = snack[menuNum-1];
				menuPrice = snackPrice[menuNum-1];
				list.get(0).setMenuPrice(menuPrice);

			}else if(selectNum==4) {
				System.out.println("=================<상품 목록>=================\r\n");
				System.out.println("	번호       상품명          금액 \r\n");
				for(i=0;i<drink.length;i++) {
					System.out.printf("	%3d    %-8s\t   %-9d\n",i+1,drink[i],drinkPrice[i]);
				}
				System.out.println();
				System.out.println("=============================================");
				System.out.print("주문하실 메뉴를 선택하세요 ▶ ");
				menuNum = sc.nextInt();
				list.get(0).setMenuNum(menuNum);

				menu = drink[menuNum-1];
				menuPrice = drinkPrice[menuNum-1];
				list.get(0).setMenuPrice(menuPrice);

			}else if(selectNum==5) {
				return;
			}

			System.out.printf("%s %d원 주문완료되었습니다.\n",menu,menuPrice);
			System.out.println("=============================================");

			//시간되면 음식조리 thread

		}while(selectNum<1 || selectNum>5);
	}

	public void pay() {//결제

		do {
			System.out.println	("\r\n" +
								"                                    ^ ^ ♥\r\n" + 
								"                                  （'v ') \r\n" + 	
								"=============<포인트 및 요금결제>===U==U====\r\n");
			System.out.println("    ① 포인트적립  ② 요금결제   ③ 이전\r\n");
			System.out.println("============================================");
			System.out.print("메뉴를 선택하세요 ▶ ");
			selectNum = sc.nextInt();

			totPrice=selectHourPrice+menuPrice;

			if(selectNum==1) {
				System.out.println("┏━━━━━━━━━━━━━━━┓\r\n \r\n"+
									"☆  포인트를 적립하시겠습니까?  ☆\r\n \r\n"+
									"┗━━━━━━━━━━━━━━━┛");
				System.out.print("      [1] 네        [2] 아니오     ▶ ");
				payNum = sc.nextInt();
				System.out.println("=============================================");

				if(payNum==1) {
					bonusPoint ++;
					bonusPoint = (int)((list.get(0).getMenuPrice()+list.get(0).getHourPrice())*0.05);
					list.get(0).setBonusPoint(bonusPoint);

					int totalPrice = list.get(0).getMenuPrice()+list.get(0).getHourPrice();
					list.get(0).setSumPrice(totalPrice);
					System.out.println("   ***** 포인트 적립이 완료되었습니다 ***** ");
					System.out.println("---------------------------------------------");
					System.out.println("       ID         합계금액        포인트");
					System.out.printf("%8s님 %10d원 %15d원\n",
							list.get(0).getUserID(),totalPrice,list.get(0).getBonusPoint());
					System.out.println("=============================================");
				}else {
					return;
				}
			}

			if(selectNum==2) {

				System.out.println	("\r\n" +
									"  ♥ ^ ^ \r\n" + 
									"   （' v') \r\n" + 	
									"=====U==U=======<요금 결제>=================\r\n");
				System.out.println("성함 이용시간 금액 주문메뉴 금액 합계금액\r\n");
				System.out.println("---------------------------------------------\r\n");
				System.out.printf("%s님 %d시간 %d원 %s %d원 %d원\r\n",
						list.get(0).getUserID(),list.get(0).getHour(),list.get(0).getHourPrice()
						,menu,list.get(0).getMenuPrice(),list.get(0).getSumPrice());
				System.out.println();
				System.out.println("=============================================\r\n");
				System.out.print("요금을 결제하시겠습니까?  [1] 네   [2] 아니오  ▶");
				int payNum = sc.nextInt();//selctNum를 같은 method에서 2번 사용 가능?X
				System.out.println();
				System.out.println("=============================================");

				int sumPrice = 0;
				list.get(0).setSumPrice(sumPrice);

				if(payNum==1) {

					System.out.printf(" ★ %s님의 현재 포인트는 %d 입니다 ★ \n"
							+ "    포인트를 사용하시겠습니까??\n"
							,list.get(0).getUserID(),list.get(0).getBonusPoint());
					System.out.println();
					System.out.print("[1]네    [2]아니오   ▶ ");
					payNum = sc.nextInt();
					System.out.println("=============================================");
					
					if(payNum==1) {
						bonusPoint = 0;
						list.get(0).setBonusPoint(bonusPoint);
					}
					
//					selectHourPrice = 0;
//					menuPrice = 0;
//
//					list.get(0).setSelectHourPrice(selectHourPrice);
//					list.get(0).setMenuPrice(menuPrice);
					
					System.out.println("        (>”  ”<)\r\n" + 
										"        ( =' o'= )\r\n" + 
										"┏-------(,,)-(,,)-------┓\r\n" +
										"\r\n" + 
										"     결제가 완료됐다 냥! \r\n" +
										"\r\n" + 
										"┗-----------------------┛");  
					System.out.printf("현재 %s님 보유 금액 %d원, 보유 포인트는 %d원 입니다.\n"
							,list.get(0).getUserID(),list.get(0).getSumPrice(),list.get(0).getBonusPoint());
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

	public void Bpay() {//결제

		do {
			System.out.println("============<포인트 및 요금결제>============\r\n");
			System.out.println("	    ① 요금결제          ② 이전	\r\n");
			System.out.println("============================================");
			System.out.print("메뉴를 선택하세요 ▶ ");
			selectNum = sc.nextInt();

			int totalPrice = list.get(0).getMenuPrice()+list.get(0).getHourPrice();
			list.get(0).setSumPrice(totalPrice);
			if(selectNum==1) {

				System.out.println	("\r\n" +
									"  ♥ ^ ^ \r\n" + 
									"   （' v') \r\n" + 	
									"=====U==U=======<요금 결제>=================\r\n");
				System.out.println("좌석번호 이용시간 금액 주문메뉴 금액 합계금액\r\n");
				System.out.println("---------------------------------------------\r\n");
				System.out.printf("%3d번 %4d시간 %5d원 %4s %4d원 %3d원\n",
						list.get(0).getSeatNum(),list.get(0).getHour(),list.get(0).getHourPrice(),
						menu,list.get(0).getMenuPrice(),list.get(0).getSumPrice());
				System.out.println();
				System.out.println("=============================================");
				System.out.println("요금을 결제하시겠습니까?  [1] 네   [2] 아니오  ▶");
				
				payNum = sc.nextInt();//selctNum를 같은 method에서 2번 사용 가능?X
				System.out.println("=============================================");

				if(payNum==1) {
					int sumPrice = 0;
					list.get(0).setSumPrice(sumPrice);
				}

				System.out.println("        (>”  ”<)\r\n" + 
									"        ( =' o'= )\r\n" + 
									"┏-------(,,)-(,,)-------┓\r\n" +
									"\r\n" + 
									"     결제가 완료됐다 냥! \r\n" +
									"\r\n" + 
									"┗-----------------------┛");  
			
				System.out.printf("%s님의 현재 보유 금액 %d원입니다.\n",
						list.get(0).getUserPhoneNum(),list.get(0).getSumPrice());

			}else {
				return;
			}

			if(selectNum==3) {
				return;
			}

		}while(selectNum<1 || selectNum>2);

	}
}

