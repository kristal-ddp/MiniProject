package project1.java;//member1

import java.util.Scanner;

public class PCMain {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		UserData ud = new UserData();
		
		int ch;
		
		while(true) {
			
			do {
				System.out.println("================================================");
				System.out.println("1.ȸ����� 2.�α��� 3.ȸ����� 4.�¼����� 5.����");
				System.out.println("================================================");
				System.out.print("�޴��� �����ϼ��� : ");
				ch = sc.nextInt();
			}while(ch<1);
			
			switch(ch) {
				case 1: ud.sign();break;//ȸ�����
				case 2:	ud.login();break;//�α���
				case 3:	ud.print();break;//ȸ�����
				case 4: ud.selectSeat();break;//�¼�����
				case 5: 
				default:
					System.out.println("�ý����� �����մϴ�.");
					ud.save();
					System.exit(0);
			}
			
			System.out.println();
			
		}

	}

}
