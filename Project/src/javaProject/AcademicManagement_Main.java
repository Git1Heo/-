package javaProject;

import java.util.*;

public class AcademicManagement_Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean run=true;
		boolean runpro=true;
		boolean runstu=true;
		
		AcademicManagement_Service ams=new AcademicManagement_Service();
		
		List <ProfessorDTO> professorList = new ArrayList<> ();
		List <StudentDTO> studentList = new ArrayList<> ();
		List <LoginPS> loginList = new ArrayList<> ();
		List <ClassDTO> classList = new ArrayList<>();
		//LoginPS lg =new LoginPS();
		int index=0;
		while(run) {
			System.out.println("================================= 학사페이지 ======================================");
			System.out.println("1. 회원가입    	2.  로그인        3. 교수 목록        4. 학생 목록        99. 종료                                  ");
			System.out.println("================================================================================");
			int n=scan.nextInt();
			if(n==1)
				ams.memberJoin(professorList, studentList,loginList);
			else if(n==3)
				ams.temppro(professorList);
			else if(n==4)
				ams.tempstu(studentList);

			
			//로그인후 교수 페이지 학생페이지 나누는 기능
			else if(n==2) {
				index =ams.loginStudentProfessor(loginList,professorList,studentList);
				if(index==0) {
					System.out.println("아이디 비밀번호 학인하고 다시 입력하세요");
					//System.out.println(index);
					}
				
//====================================================학생 학사 페이지=====================================================
				
				else if (index<0) {
					 runstu=true;
					while(runstu) {
						System.out.println("================================================================================");
						System.out.println("                          학생 학사관리 페이지.");
						System.out.println("      1. 수강신청              2. 수강취소        3. 내가 신청한 과목        99.로그아웃");
						System.out.println("================================================================================");
						int stu=scan.nextInt();
						
						if(stu==1)
							ams.enrolment(studentList, classList, index);
						else if (stu==2)
							ams.dropOut(studentList, classList, index);	
						else if (stu==3)
							ams.myClassView(studentList, classList, index);
						else if(stu==99) 
							runstu=false;
						else
							System.out.println("목록 중에서 선택하세요.");
						
					}
				}
				
				
//====================================================교수 학사 페이지====================================================
				
				else if (index>0) {
						 runpro=true;
					while(runpro) {
						System.out.println("================================================================================");
						System.out.println("                          교수 학사관리 페이지.");
						System.out.println("1. 강의 과목 생성      2. 과목 폐지      3. 과목 목록      4.내가 생성한 과목 목록     99.로그아웃");
						System.out.println("================================================================================");
					int pro=scan.nextInt();
					if(pro==1)
						ams.establishClass(professorList, classList, index);
					
					else if(pro==3)
						ams.classView(classList);
					
					else if(pro==2)
						ams.abolishClass(professorList, classList, index);
					
					else if (pro==4)
						ams.proclassView(professorList, classList, index);
						
					else if(pro==99)
						runpro=false;
					else
						System.out.println("목록 중에서 선택하세요.");
					}
					
				}
			
			
			
			
			
			}
			
			else if(n==99)
				run=false;
			
			else 
				System.out.println("> 메뉴 중에서 선택하세요");
			
			
		}
				
		
		
	}

}
