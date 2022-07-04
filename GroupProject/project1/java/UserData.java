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

	public void print() {//ȸ�����

			System.out.println();
			System.out.println("==================< ȸ������ >=================\r\n");
			System.out.println("    ȸ������           ID              ����ó");
			System.out.printf("%9d %15s %22s\n",userNum,list.get(0).getUserID(),list.get(0).getUserPhoneNum());
			System.out.println();
			System.out.println("================================================\r\n");
	}

	public void save() throws Exception {//��������

		FileOutputStream fos = new FileOutputStream("c:\\doc\\pcroom.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(list);
		oos.close();
		fos.close();
	}

	public void selectSeat() {//�¼�����
		System.out.println	("\r\n" +
							"                                  ^ ^ �� \r\n" + 
							"                               ��'v ') \r\n" + 	
							"=================================U==U========\r\n");
		System.out.println("        �� �¼� ����          �� ���� \r\n");
		System.out.println("=============================================");
		System.out.print("�޴��� �����ϼ��� �� ");
		selectNum = sc.nextInt();

			if(selectNum==1) {
				System.out.println("---------------------------------------------\r\n");
				System.out.println(" 1 �� �¼� : �� �̿밡��");
				System.out.println(" 2 �� �¼� : �� �̿밡��");
				System.out.println(" 3 �� �¼� : �� �̿밡��");
				System.out.println(" 4 �� �¼� : �� �̿밡��");
				System.out.println(" 5 �� �¼� : �� �̿밡��");
				System.out.println(" 6 �� �¼� : �� �̿밡��\r\n");
				System.out.println("=============================================");
				System.out.print("�̿��� �¼���ȣ �Է��ϼ��� �� ");
				int ch = sc.nextInt();
				list.get(0).setSeatNum(ch);
				System.out.println("---------------------------------------------");
				seat[ch-1] = 1;
				for(int i=0; i<seat.length;i++) {
					if(seat[i]==0) {
						System.out.println((i+1) + "�� �¼� : �� �̿밡��");
					}else {
						System.out.println((i+1) + "�� �¼� : �� �̿� ��");
					}
				}
				System.out.println("---------------------------------------------");
				System.out.printf("[SYSTEM]�� %d�� �ڸ��� �����ϼ̽��ϴ�.\n",ch);
				System.out.println(); 
			}else if(selectNum==2) {
				return;
			}
	}

	public void time() {//�ð� ����

		int hour[] = {1,2,3,4,5};
		int hourPrice[] = {1000,2000,3000,4000,5000};

		System.out.println	("\r\n" +
							"                                   ^ ^ ��\r\n" + 
							"                                 ��'v ') \r\n" + 	
							"=================<�ð� ����>=======U==U======\r\n");
		System.out.println("          �� �ð�����       �� ���� \r\n");
		System.out.println("=============================================");
		System.out.print("�޴��� �����ϼ��� �� ");
		selectNum = sc.nextInt();

		do {
			if(selectNum==1) {
				System.out.println("=================<�ð� ���>=================\r\n");
				System.out.println("      ��ȣ           �ð�           �ݾ� \r\n");
				for(i=0;i<5;i++) {
					System.out.printf("%9d %11s�ð� %13d��\n",i+1,hour[i],hourPrice[i]);
				}
				System.out.println("\r\n=============================================");
				System.out.print("����� �ð��� �����ϼ��� �� ");
				menuNum = sc.nextInt();

				list.get(0).setHour(menuNum);
				list.get(0).setHourPrice(menuNum*1000);

				selectHour = hour[menuNum-1];
				selectHourPrice = hourPrice[menuNum-1];

				System.out.printf("�١ڡ� %d�ð� %d�� �߰��Ǿ����ϴ�.\n",list.get(0).getHour(),list.get(0).getHourPrice());
				System.out.println("=============================================");
			}else if(selectNum==2) {
				return;
			}
		}while(selectNum<1 || selectNum>2);
	}

	public void order() {//�޴� �ֹ�

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
			System.out.println	("\r\n" +
								"                                   ^ ^ ��\r\n" + 
								"                                 ��'v ') \r\n" + 	
								"=================<�޴� �ֹ�>=======U==U======\r\n");
			System.out.println("�� ���  �� ��� �� ���ķ� �� ����/Ŀ�� ������\r\n");
			System.out.println("=============================================");
			System.out.print("�޴��� �����ϼ��� �� ");
			selectNum = sc.nextInt();

			if(selectNum==1) {
				System.out.println("=================<��ǰ ���>=================\r\n");
				System.out.println("	��ȣ       ��ǰ��          �ݾ� \r\n");
				for(i=0;i<rice.length;i++) {
					System.out.printf("	%3d    %-8s\t   %-9d\n",i+1,rice[i],ricePrice[i]);
				}
				System.out.println();
				System.out.println("=============================================");
				System.out.print("�ֹ��Ͻ� �޴��� �����ϼ��� �� ");
				menuNum = sc.nextInt();

				list.get(0).setMenuNum(menuNum);
				//vo.setMenuNum(sc.nextInt());

				menu = rice[menuNum-1];//������ �޴��̸�,�ݾ� �������� ���
				menuPrice = ricePrice[menuNum-1];
				list.get(0).setMenuPrice(menuPrice);

			}else if(selectNum==2) {
				System.out.println("=================<��ǰ ���>=================\r\n");
				System.out.println("	��ȣ     ��ǰ��            �ݾ� \r\n");
				for(i=0;i<noodle.length;i++) {
					System.out.printf("	%3d    %-8s\t   %-9d\n",i+1,noodle[i],noodlePrice[i]);
				}
				System.out.println();
				System.out.println("=============================================");
				System.out.print("�ֹ��Ͻ� �޴��� �����ϼ��� �� ");
				menuNum = sc.nextInt();
				list.get(0).setMenuNum(menuNum);

				menu = noodle[menuNum-1];
				menuPrice = noodlePrice[menuNum-1];
				list.get(0).setMenuPrice(menuPrice);

			}else if(selectNum==3) {
				System.out.println("=================<��ǰ ���>=================\r\n");
				System.out.println("	��ȣ       ��ǰ��          �ݾ� \r\n");
				for(i=0;i<snack.length;i++) {
					System.out.printf("	%3d    %-8s\t   %-9d\n",i+1,snack[i],snackPrice[i]);
				}
				System.out.println();
				System.out.println("=============================================");
				System.out.print("�ֹ��Ͻ� �޴��� �����ϼ��� �� ");
				menuNum = sc.nextInt();
				list.get(0).setMenuNum(menuNum);

				menu = snack[menuNum-1];
				menuPrice = snackPrice[menuNum-1];
				list.get(0).setMenuPrice(menuPrice);

			}else if(selectNum==4) {
				System.out.println("=================<��ǰ ���>=================\r\n");
				System.out.println("	��ȣ       ��ǰ��          �ݾ� \r\n");
				for(i=0;i<drink.length;i++) {
					System.out.printf("	%3d    %-8s\t   %-9d\n",i+1,drink[i],drinkPrice[i]);
				}
				System.out.println();
				System.out.println("=============================================");
				System.out.print("�ֹ��Ͻ� �޴��� �����ϼ��� �� ");
				menuNum = sc.nextInt();
				list.get(0).setMenuNum(menuNum);

				menu = drink[menuNum-1];
				menuPrice = drinkPrice[menuNum-1];
				list.get(0).setMenuPrice(menuPrice);

			}else if(selectNum==5) {
				return;
			}

			System.out.printf("%s %d�� �ֹ��Ϸ�Ǿ����ϴ�.\n",menu,menuPrice);
			System.out.println("=============================================");

			//�ð��Ǹ� �������� thread

		}while(selectNum<1 || selectNum>5);
	}

	public void pay() {//����

		do {
			System.out.println	("\r\n" +
								"                                    ^ ^ ��\r\n" + 
								"                                  ��'v ') \r\n" + 	
								"=============<����Ʈ �� ��ݰ���>===U==U====\r\n");
			System.out.println("    �� ����Ʈ����  �� ��ݰ���   �� ����\r\n");
			System.out.println("============================================");
			System.out.print("�޴��� �����ϼ��� �� ");
			selectNum = sc.nextInt();

			totPrice=selectHourPrice+menuPrice;

			if(selectNum==1) {
				System.out.println("����������������������������������\r\n \r\n"+
									"��  ����Ʈ�� �����Ͻðڽ��ϱ�?  ��\r\n \r\n"+
									"����������������������������������");
				System.out.print("      [1] ��        [2] �ƴϿ�     �� ");
				payNum = sc.nextInt();
				System.out.println("=============================================");

				if(payNum==1) {
					bonusPoint ++;
					bonusPoint = (int)((list.get(0).getMenuPrice()+list.get(0).getHourPrice())*0.05);
					list.get(0).setBonusPoint(bonusPoint);

					int totalPrice = list.get(0).getMenuPrice()+list.get(0).getHourPrice();
					list.get(0).setSumPrice(totalPrice);
					System.out.println("   ***** ����Ʈ ������ �Ϸ�Ǿ����ϴ� ***** ");
					System.out.println("---------------------------------------------");
					System.out.println("       ID         �հ�ݾ�        ����Ʈ");
					System.out.printf("%8s�� %10d�� %15d��\n",
							list.get(0).getUserID(),totalPrice,list.get(0).getBonusPoint());
					System.out.println("=============================================");
				}else {
					return;
				}
			}

			if(selectNum==2) {

				System.out.println	("\r\n" +
									"  �� ^ ^ \r\n" + 
									"   ��' v') \r\n" + 	
									"=====U==U=======<��� ����>=================\r\n");
				System.out.println("���� �̿�ð� �ݾ� �ֹ��޴� �ݾ� �հ�ݾ�\r\n");
				System.out.println("---------------------------------------------\r\n");
				System.out.printf("%s�� %d�ð� %d�� %s %d�� %d��\r\n",
						list.get(0).getUserID(),list.get(0).getHour(),list.get(0).getHourPrice()
						,menu,list.get(0).getMenuPrice(),list.get(0).getSumPrice());
				System.out.println();
				System.out.println("=============================================\r\n");
				System.out.print("����� �����Ͻðڽ��ϱ�?  [1] ��   [2] �ƴϿ�  ��");
				int payNum = sc.nextInt();//selctNum�� ���� method���� 2�� ��� ����?X
				System.out.println();
				System.out.println("=============================================");

				int sumPrice = 0;
				list.get(0).setSumPrice(sumPrice);

				if(payNum==1) {

					System.out.printf(" �� %s���� ���� ����Ʈ�� %d �Դϴ� �� \n"
							+ "    ����Ʈ�� ����Ͻðڽ��ϱ�??\n"
							,list.get(0).getUserID(),list.get(0).getBonusPoint());
					System.out.println();
					System.out.print("[1]��    [2]�ƴϿ�   �� ");
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
					
					System.out.println("        (>��  ��<)\r\n" + 
										"        ( =' o'= )\r\n" + 
										"��-------(,,)-(,,)-------��\r\n" +
										"\r\n" + 
										"     ������ �Ϸ�ƴ� ��! \r\n" +
										"\r\n" + 
										"��-----------------------��");  
					System.out.printf("���� %s�� ���� �ݾ� %d��, ���� ����Ʈ�� %d�� �Դϴ�.\n"
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

	public void Bpay() {//����

		do {
			System.out.println("============<����Ʈ �� ��ݰ���>============\r\n");
			System.out.println("	    �� ��ݰ���          �� ����	\r\n");
			System.out.println("============================================");
			System.out.print("�޴��� �����ϼ��� �� ");
			selectNum = sc.nextInt();

			int totalPrice = list.get(0).getMenuPrice()+list.get(0).getHourPrice();
			list.get(0).setSumPrice(totalPrice);
			if(selectNum==1) {

				System.out.println	("\r\n" +
									"  �� ^ ^ \r\n" + 
									"   ��' v') \r\n" + 	
									"=====U==U=======<��� ����>=================\r\n");
				System.out.println("�¼���ȣ �̿�ð� �ݾ� �ֹ��޴� �ݾ� �հ�ݾ�\r\n");
				System.out.println("---------------------------------------------\r\n");
				System.out.printf("%3d�� %4d�ð� %5d�� %4s %4d�� %3d��\n",
						list.get(0).getSeatNum(),list.get(0).getHour(),list.get(0).getHourPrice(),
						menu,list.get(0).getMenuPrice(),list.get(0).getSumPrice());
				System.out.println();
				System.out.println("=============================================");
				System.out.println("����� �����Ͻðڽ��ϱ�?  [1] ��   [2] �ƴϿ�  ��");
				
				payNum = sc.nextInt();//selctNum�� ���� method���� 2�� ��� ����?X
				System.out.println("=============================================");

				if(payNum==1) {
					int sumPrice = 0;
					list.get(0).setSumPrice(sumPrice);
				}

				System.out.println("        (>��  ��<)\r\n" + 
									"        ( =' o'= )\r\n" + 
									"��-------(,,)-(,,)-------��\r\n" +
									"\r\n" + 
									"     ������ �Ϸ�ƴ� ��! \r\n" +
									"\r\n" + 
									"��-----------------------��");  
			
				System.out.printf("%s���� ���� ���� �ݾ� %d���Դϴ�.\n",
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

