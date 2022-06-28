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
	
	public void sign() {//ȸ�����
		
		Iterator<UserVO> it = lists.iterator();
		UserVO vo = new UserVO();
		
		System.out.println("================================================");
		System.out.println("         [1] ȸ��            [2] ��ȸ�� ");
		System.out.println("================================================");
		System.out.print("�޴��� �����ϼ��� : ");	
		
		int num = sc.nextInt();
		if(num==1) {
			
			//ID
			System.out.print("���̵� > ");
			String ID = sc.next();
			
			while(it.hasNext()) {
				UserVO uv = it.next();
				
				if(uv.getUserID().equals(ID)) {
					System.out.print("�̹� ������� ���̵� �Դϴ�.");
					return;
				}
			}
			vo.setUserID(ID);
			user = vo.getUserID();
			
			//PW
			System.out.print("��й�ȣ > ");
			String pw1 = sc.next();
	
			System.out.print("��й�ȣ Ȯ�� > ");
			String pw2 = sc.next();
			
			if(!pw1.equals(pw2)) {
				System.out.println("��й�ȣ�� �ٸ��ϴ�.");
				return;
			}
			vo.setUserPW(pw1);
			
			//��ȭ��ȣ
			System.out.print("����ó(010-****-****) > ");
			String pNum = sc.next();
			
			while(it.hasNext()) {
				UserVO uv = it.next();
				
				if(uv.getUserPhoneNum().equals(pNum)) {
					System.out.print("�̹� ������� ��ȭ��ȣ�Դϴ�.");
					return;
				}
			}
			vo.setUserPhoneNum(pNum);
			
			//ȸ����ȣ
			System.out.println("================< ȸ������ Ȯ�� >===============");
			System.out.println("    ȸ������           ID              ����ó");
			System.out.printf("%9d %15s %22s\n",userNum,ID,pNum);
			System.out.println("================================================");
			vo.setUserNum(userNum);

			lists.add(vo);
			
			userNum++;
			
			return;
		}
		
		else if(num==2) {
			
			System.out.print("����ó > ");		
			String pNumb = sc.next();
			
			while(it.hasNext()) {
				UserVO uv = it.next();
				
				if(uv.getUserPhoneNum().equals(pNumb)) {
					System.out.println("�̹� �̿����� ��ȣ �Դϴ�.");
					return;
				}
			}
		}
	}
	
	public void login() {//�α���
		
		Iterator<UserVO> it = lists.iterator();
		
		System.out.print("���̵� > ");
		String id = sc.next();
		
		System.out.print("��й�ȣ > ");
		String pw = sc.next();
		
		while(it.hasNext()) {
		
			UserVO vo = it.next();
			
			if(id.equals(vo.getUserID()) && pw.equals(vo.getUserPW())) {
				System.out.println("�α��� ����!");
				break;
			}
			else if(!(id.equals(vo.getUserID()) && pw.equals(vo.getUserPW()))) {
				System.out.print("[����] �������� �ʴ� ID Ȥ�� PW ����");
				return;
			}
		}
	}
	
	public void print() {//ȸ�����
		
		Iterator<UserVO> it = lists.iterator();
		while(it.hasNext()) {
			
			UserVO vo = it.next();
			
			System.out.println(vo.toString());
		}
	}
	
	public void save() throws Exception {//��������
		
		FileOutputStream fos = new FileOutputStream("c:\\doc\\pcroom.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(lists);
		oos.close();
		fos.close();
		
		System.out.println("���� ���� ����!");
	}
	
	public void selectSeat() {//�¼�����
		
		System.out.println("�¼� ����");
		int ch = sc.nextInt();
		System.out.printf("%d�� �ڸ��� �����ϼ̽��ϴ�.\n",ch);
		System.out.println();
		
		seat[ch-1] = 1;
		for(int i=0; i<seat.length;i++) {
			if(seat[i]==0) {
				System.out.printf("�̿� ����\n");
				
			}else {
				System.out.printf("�̿� ��\n");
			}
		}
	}
	
	public void time() {//�ð� ����
		
		int hour[] = {1,2,3,4,5};
		int hourPrice[] = {1000,2000,3000,4000,5000};
		
		System.out.println("=====================<�ð� ����>=====================");
		System.out.println("1.�ð����� 2.����");
		System.out.println("======================================================");
		System.out.print("�޴��� �����ϼ���.");
		selectNum = sc.nextInt();
		
		do {
			if(selectNum==1) {
				System.out.println("=================<�ð� ���>=================");
				System.out.println("��ȣ �ð� �ݾ�");
				for(i=0;i<5;i++) {
					System.out.printf("%d %s�ð� %d��\n",i+1,hour[i],hourPrice[i]);
				}
				System.out.println("=============================================");
				System.out.print("����� �ð��� �����ϼ���.");
				menuNum = sc.nextInt();
				
				selectHour = hour[menuNum-1];
				selectHourPrice = hourPrice[menuNum-1];
				
				System.out.printf("%d�ð� %d�� �߰��Ǿ����ϴ�.\n",selectHour,selectHourPrice);
				System.out.println("=============================================");
			}else if(selectNum==2) {
				return;
			}
		}while(selectNum<1 || selectNum>2);
		
	}
	
	public void order() {//�޴� �ֹ�
		
		UserVO vo = new UserVO();
		
		String rice[] = {"����","�����","�����","�Ұ�ⵤ��","������䵤��","��ġ���䵤��","ġŲ���䵤��",
				"�����񸶿䵤��","��ġ������ġ����","���л�㵤��","����������","��ġ������","���"};
		int ricePrice[] = {3000,1000,4500,5500,5500,5500,5500,5500,5500,5500,5500,5500,6000};
		
		String noodle[] = {"���","�����","ġ����","���ζ��","�����","¥�İ�Ƽ","�Ӵߺ�����","���ø�","����ø�"};
		int noodlePrice[] = {4000,4500,4500,4500,4000,4000,4000,5000,5000};
		
		String snack[] = {"�߰���","������","����","������󶱺���","����Ƣ��","ġ���Ƣ��","���Ͱ�������Ƣ��",
				"�Ҷ��Ҷ�","�����ֵ���","ġ���ֵ���","��⸸��","��ġ����"};
		int snackPrice[] = {5000,4000,4000,4500,2000,2500,2500,2000,2500,2500,2800,2800};
		
		String drink[] = {"ü�����̵�","���ø����̵�","û�������̵�","�����̵�","��緹���̵�","������",
				"���̽�����","������̽�Ƽ","�����ƾ��̽�Ƽ","�ݶ�","���̴�","����ƾ��","�Ƹ޸�ī��"};
		int drinkPrice[] = {3200,3200,3200,3200,3200,3000,3000,1900,1900,1900,1900,1900,3000};
		
		do {
			System.out.println("=================<�޴� �ֹ�>=================");
			System.out.println("1.���  2.���  3.���ķ�  4.����/Ŀ�� 5.����");
			System.out.println("=============================================");
			System.out.print("�޴��� �����ϼ���.");
			selectNum = sc.nextInt();
			
			if(selectNum==1) {
				System.out.println("=================<��ǰ ���>=================");
				System.out.println("��ȣ     ��ǰ��      �ݾ�");
				for(i=0;i<rice.length;i++) {
					System.out.printf("%2d   %-8s  %-2d\n",i+1,rice[i],ricePrice[i]);
				}
				System.out.println("=============================================");
				System.out.print("�ֹ��Ͻ� �޴��� �����ϼ���.");
				menuNum = sc.nextInt();
				vo.setMenuNum(menuNum);
//				vo.setMenuNum(sc.nextInt());
				
				menu = rice[menuNum-1];//������ �޴��̸�,�ݾ� �������� ���
				menuPrice = ricePrice[menuNum-1];
				
			}else if(selectNum==2) {
				System.out.println("=================<��ǰ ���>=================");
				System.out.println("��ȣ ��ǰ�� �ݾ�");
				for(i=0;i<noodle.length;i++) {
					System.out.printf("%d %s %d\n",i+1,noodle[i],noodlePrice[i]);
				}
				System.out.println("=============================================");
				System.out.print("�ֹ��Ͻ� �޴��� �����ϼ���.");
				menuNum = sc.nextInt();
				vo.setMenuNum(menuNum);

				menu = noodle[menuNum-1];
				menuPrice = noodlePrice[menuNum-1];
				
			}else if(selectNum==3) {
				System.out.println("=================<��ǰ ���>=================");
				System.out.println("��ȣ      ��ǰ��      �ݾ�");
				for(i=0;i<snack.length;i++) {
					System.out.printf("%d %10s %d\n",i+1,snack[i],snackPrice[i]);
				}
				System.out.println("=============================================");
				System.out.print("�ֹ��Ͻ� �޴��� �����ϼ���.");
				menuNum = sc.nextInt();
				vo.setMenuNum(menuNum);
				
				menu = snack[menuNum-1];
				menuPrice = snackPrice[menuNum-1];
				
			}else if(selectNum==4) {
				System.out.println("=================<��ǰ ���>=================");
				System.out.println("��ȣ ��ǰ�� �ݾ�");
				for(i=0;i<drink.length;i++) {
					System.out.printf("%d %s %d\n",i+1,drink[i],drinkPrice[i]);
				}
				System.out.println("=============================================");
				System.out.print("�ֹ��Ͻ� �޴��� �����ϼ���.");
				menuNum = sc.nextInt();
				vo.setMenuNum(menuNum);
				
				menu = drink[menuNum-1];
				menuPrice = drinkPrice[menuNum-1];
				
			}else if(selectNum==5) {
				return;
			}
			
			System.out.printf("%s %d�� �ֹ��Ϸ�Ǿ����ϴ�.\n",menu,menuPrice);
			System.out.println("=============================================");
			
			lists.add(vo);
//			�ð��Ǹ� �������� thread
			
		}while(selectNum<1 || selectNum>5);
		
	}
	
	public void pay() {//����
		
		do {
			System.out.println("============<����Ʈ �� ��ݰ���>============");
			System.out.println("1.����Ʈ���� 2.��ݰ��� 3.����");
			System.out.println("============================================");
			System.out.print("�޴��� �����ϼ���.");
			selectNum = sc.nextInt();
			
			totPrice=selectHourPrice+menuPrice;
				
			if(selectNum==1) {
				
				System.out.println("����Ʈ�� �����Ͻðڽ��ϱ�?");
				System.out.print("1.�� 2.�ƴϿ�");
				payNum = sc.nextInt();
				System.out.println("=============================================");
				
				if(payNum==1) {
					bonusPoint ++;
					bonusPoint = (int)(totPrice*0.05);
					System.out.println("����Ʈ ������ �Ϸ�Ǿ����ϴ�.\n");
					System.out.println("���� �հ�ݾ� ����Ʈ");
					System.out.printf("%s�� %d�� %d��\n",user,totPrice,bonusPoint);
					System.out.println("=============================================");
				}else {
					return;
				}
			}
			
			if(selectNum==2) {
				
				System.out.println("=================<��� ����>=================");
				System.out.println("���� �̿�ð� �ݾ� �ֹ��޴� �ݾ� �հ�ݾ�");
				System.out.printf("%s�� %d�ð� %d�� %s %d�� %d��\n",
						user,selectHour,selectHourPrice,menu,menuPrice,totPrice);
				System.out.println("=============================================");
				System.out.println("����� �����Ͻðڽ��ϱ�?");
				System.out.print("1.�� 2.�ƴϿ�");
				payNum = sc.nextInt();//selctNum�� ���� method���� 2�� ��� ����?X
				System.out.println("=============================================");
				
				if(payNum==1) {
					
					System.out.printf("%s���� ���� ����Ʈ�� %d�Դϴ�\n"
							+ "����Ʈ�� ����Ͻðڽ��ϱ�?\n",user,bonusPoint);
					System.out.print("1.�� 2.�ƴϿ�");
					payNum = sc.nextInt();
					System.out.println("=============================================");
					
					if(payNum==1) {
						bonusPoint = 0;
					}
					
					selectHourPrice = 0;
					menuPrice = 0;
					totPrice = 0;
					
					System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
					System.out.println("���� ����ݾ� ����Ʈ");
					System.out.printf("%s�� %d�� %d��\n",user,totPrice,bonusPoint);
					
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

