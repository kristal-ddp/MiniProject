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
	
	public void save() throws Exception {//파일저장
		FileOutputStream fos = new FileOutputStream("c:\\doc\\pcroom.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(lists);
		oos.close();
		fos.close();
		
		System.out.println("파일 저장 성공!");
	}
}

