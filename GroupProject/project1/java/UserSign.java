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

	public void sign() throws Exception {//ȸ�����

		Iterator<UserVO> it = list.iterator();

		UserVO vo = new UserVO();
		UserData ud = new UserData(list);//for ��ȸ��

		System.out.println("\r\n" +
				"  �� ^ ^ \r\n" + 
				"   ��' v') \r\n" + 
				" ��--U��U����������������������\r\n" + 
				"\r\n" +
				" ��  [1] ȸ��    [2] ��ȸ��  ��\r\n" +
				"\r\n" +
				" ������������������������������");
		System.out.print("�޴��� �����ϼ��� �� ");	
		ch = sc.nextInt();
		
		if(ch==1) {//ȸ��

			//ID
			System.out.print("���̵� �� ");//ID���� �ݺ���
			String ID = sc.next();

			while(it.hasNext()) {
				UserVO uv = it.next();

				if(uv.getUserID().equals(ID)) {
					System.out.print("�̹� ������� ���̵� �Դϴ�.");
					return;
				}
			}
			vo.setUserID(ID);

			//PW
			System.out.print("��й�ȣ �� ");
			String pw1 = sc.next();

			do {
				System.out.print("��й�ȣ Ȯ�� > ");
				String pw2 = sc.next();

				if(pw1.equals(pw2)) {
					pw2 = pw1;
					vo.setUserPW(pw1);
					panjung = true;
				}else {
					System.out.println("��й�ȣ�� �ٸ��ϴ�.");
					panjung = false;
				}
			}while(panjung == false);

			//��ȭ��ȣ
			do {
			System.out.print("��ȭ��ȣ(010-****-****) �� ");//��ȭ��ȣ ����, ��ȭ��ȣ���� �ݺ���
			pNum = sc.next();

			while(it.hasNext()) {
				UserVO uv = it.next();

				if(uv.getUserPhoneNum().equals(pNum)) {
					System.out.print("�̹� ������� ��ȭ��ȣ�Դϴ�.");
					panjung = false;
//					return;
				}
			}
			vo.setUserPhoneNum(pNum);
			}while(panjung == false);

			//ȸ����ȣ
			userNum += temp;//userNum ������
			
			System.out.println();
			System.out.println("================< ȸ������ Ȯ�� >===============\r\n");
			System.out.println("    ȸ������           ID              ����ó");
			System.out.printf("%9d %15s %22s\n",userNum,ID,pNum);
			System.out.println();
			System.out.println("================================================\r\n");
			
			vo.setUserNum(userNum);
			list.add(vo);

//			userNum++;
			temp++;

			return;
		}

		else if(ch==2) {//��ȸ��

			System.out.print("����ó > ");		
			pNumb = sc.next();

			while(it.hasNext()) {
				UserVO uv = it.next();

				if(uv.getUserPhoneNum().equals(pNumb)) {//��ȭ��ȣ ����, ��ȭ��ȣ���� �ݺ���
					System.out.println("�̹� �̿����� ��ȣ �Դϴ�.");
					return;
				}
			}
			vo.setUserPhoneNum(pNumb);
			list.add(vo);

			while(true) {

				System.out.println("\r\n" +
						"  �� ^ ^ \r\n" + 
						"   ��' v') \r\n" + 	
						"=====U==U===============================\r\n");
				System.out.println( "  �� �¼����� �� �ð�����\n" +
						"  �� �޴��ֹ� �� ���� �� ����\r\n");
				System.out.println("=========================================");
				System.out.print("�޴��� �����ϼ��� : ");
				ch = sc.nextInt();

				switch(ch) {
				case 1: ud.selectSeat();break;//�¼�����
				case 2: ud.time();break;//�ð�����
				case 3: ud.order();break;//�޴��ֹ�
				case 4: ud.Bpay();break;//��ȸ������
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
							"              BYE~ �ý����� �����մϴ�.");
					ud.save();
					System.exit(0);
				}
				System.out.println(); 

			}
		}
	}
}
