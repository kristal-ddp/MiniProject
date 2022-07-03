package project1.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.score4.UserData;
import com.score4.UserVO;

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

	public void login() throws Exception {//�α���

		Iterator<UserVO> it = list.iterator();

		System.out.print("���̵� �� ");
		String id = sc.next();

		System.out.print("��й�ȣ �� ");
		String pw = sc.next();

		while(it.hasNext()) {

			UserVO vo = it.next();

			if(!(id.equals(vo.getUserID()) && pw.equals(vo.getUserPW()))) {
				System.out.println("[����] �������� �ʴ� ID Ȥ�� PW ����");
				return;
			}
		}

		System.out.println(
				"      ��    ��      ��     ��   ��  \r\n" +
				"   ����������       ����       ��  �� \r\n"+
				"       ������ �������������� ��    \r\n" + 
				"       ������������������ ��������\r\n" + 
				"   ��   ��  ! �α��� ���� !     ��   \r\n" + 
				"       ��������������������������\r\n" + 
				"       �������� �� ������������\r\n" + 
				"  ��   ������      ����  ��   ��   �� \r\n" +
				"      ��    ��      �� ��       ��\r\n" +
				"");
		System.out.println();
		System.out.println();

		while(true) {

			System.out.println("\r\n" +
								"  �� ^ ^ \r\n" + 
								"   ��' v') \r\n" + 	
								"=====U==U====================================\r\n");
			System.out.println("    �� ȸ����� �� �¼����� �� �ð����� \r\n" +
								"    �� �޴��ֹ� �� ����Ʈ �� ���� �� ����\r\n");
			System.out.println("=============================================");
			System.out.print("�޴��� �����ϼ��� �� ");
			int ch1 = sc.nextInt();

			switch(ch1) {

			case 1:	ud.print();break;//ȸ�����
			case 2: ud.selectSeat();break;//�¼�����
			case 3: ud.time();break;//�ð�����
			case 4: ud.order();break;//�޴��ֹ�
			case 5: ud.pay();break;//����Ʈ �� ����
			default:
				System.out.print(
						"          ���ء����� ����   �� ��  \r\n" +
						"��         ��`�������� ��  ���� �� \r\n" +
						"   ��      ��|����--------���� |�� \r\n" +
						"         ����|���������� �� �� |�� \r\n" +
						"   ��       /��������������   ��  \r\n" + 
						"         ������-���������� -    ��\r\n" + 
						"          �������ܡ�������ܡ�  > \r\n" + 
						"         �� ����߲�� (_v_) ߲������\r\n" + 
						" ===========(^_^_^)=======(^_^_^)============ \r\n" + 
						"|                 .-.   .-.                  |\r\n" +  
						"|                /   \\ /   \\                 |\r\n" + 
						"|            .-. |    |    | .-.             |\r\n" + 
						"|          /   \\ \\  / \\  / /  \\              |\r\n" + 
						"|          |   |  '`.-.`'    |   |           |\r\n" + 
						"|           \\_.' .-`   `-. '._/              |\r\n" + 
						"|             .-'         '-.                |\r\n" + 
						"|            /               \\               |\r\n" + 
						"|            |   SEE YOU  ��  |              |\r\n" + 
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
