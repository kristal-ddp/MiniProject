package project1.java;//member1

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
	
	public void save() throws Exception {//��������
		FileOutputStream fos = new FileOutputStream("c:\\doc\\pcroom.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(lists);
		oos.close();
		fos.close();
		
		System.out.println("���� ���� ����!");
	}
}

