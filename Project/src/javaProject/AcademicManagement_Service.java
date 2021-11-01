package javaProject;

import java.util.*;

public class AcademicManagement_Service {
	Scanner scan=new Scanner(System.in);

	/*
	 * ID중복 여부 확인하는 메서드
	 * 중복되 ID인 경우 1반환
	 * 리턴타입 : 정수형
	 */
	
	int idCheck(String id,List<LoginPS> loginList) {
		
		int a=0;
		if(loginList.size()==0) {
			a=-1;
		}
		else  {
			for(int i=0;i<loginList.size();i++) {
				if(id.equals(loginList.get(i).getID())==false) {
					a=-1;
				}
				else if(id.equals(loginList.get(i).getID())==true)
					a= 1;						
			}		
		}

		return a;
	}
	
	
	/* 
	 * 회원가입 (등록) 기능 메서드
	 * 리턴타입 : void
	 */ 
	
	void memberJoin(List<ProfessorDTO> professorList, List<StudentDTO> studentList,List<LoginPS> loginList) {
		try {
		System.out.println("회원 가입");
		System.out.println("교수회원가입 1번\n학생회원가입 2번");
		String sp=scan.next();
		//교수 회원가입 페이지
		if(sp.equals("1")) {
			System.out.println("교수 회원가입 페이지 입니다.");
			System.out.print("이름 : ");
			String name=scan.next();
			System.out.print("핸드폰번호 : ");
			String pn=scan.next();
			System.out.print("아이디 (중복된 아이디 사용불가) : ");
			String id=scan.next();
			System.out.print("비밀번호 : ");
			String pw=scan.next();
	
			//idCheck 중복성 여부 검사
			int result=idCheck(id,loginList);
			if(result==-1) {
				ProfessorDTO proJoin=new ProfessorDTO(name,pn,id,pw);
				professorList.add(proJoin);
				LoginPS pJoin=new LoginPS(id,pw,1);
				loginList.add(pJoin);
			
			}
			else if(result==1) {
				System.out.println("중복된 아이디입니다.");
			}
		}
	
		//학생 회원가입 페이지
		else if(sp.equals("2")) {
			System.out.println("학생 로그인 페이지 입니다.");
			System.out.print("이름 : ");
			String name=scan.next();
			System.out.print("핸드폰 번호 : ");
			String pn=scan.next();
			System.out.print("아이디 (중복된 아이디 사용불가) : ");
			String id=scan.next();
			System.out.print("비밀번호 : ");
			String pw=scan.next();
			System.out.print("학번 (숫자): ");
			int y=scan.nextInt();
			
			//idCheck 중복성 여부 검사
			int result=idCheck(id,loginList);
			if(result==-1) {
				StudentDTO stuJoin=new StudentDTO(name,pn,y,id,pw);
				studentList.add(stuJoin);	
				LoginPS sJoin=new LoginPS(id,pw,-1);
				loginList.add(sJoin);
			}			
			else if(result==1) {
				System.out.println("중복된 아이디입니다.");
			}
		}
		
		else if(sp.equals(2)==false||sp.equals(1)==false){
			System.out.println("1번 2번중에서 입력하세요.");
			memberJoin(professorList,studentList,loginList);
		}
	}
		catch(InputMismatchException m){
			System.out.println("타입에 맞게 입력하세요");
			System.out.println("이전으로 돌아갑니다.");
		}
	}
	
	
	//교수 리스트 확인
	void temppro(List<ProfessorDTO> professorList) {
		for(int i=0;i<professorList.size();i++)
			System.out.println(professorList.get(i));
		
	}
	
	//학생 리스트 확인
	void tempstu(List<StudentDTO> studentList) {
		for(int i=0;i<studentList.size();i++)
			System.out.println(studentList.get(i));
		
	}

	/*
	 * 	아이디 비밀번호 입력하면 교수인지 학생인지 판단하고 교수나 학생리스트에서 인덱스값을 반환하는 메서드
	 *  리턴타입 : 정수형
	 */
	
		int loginStudentProfessor(List<LoginPS> loginList,List<ProfessorDTO> professorList, List<StudentDTO> studentList) {
			
			int index=0;
			int kk=0;
			System.out.print("아이디를 입력하세요 : ");
			String id=scan.next();
			System.out.print("비밀먼호를 입력하세요 : ");
			String pw=scan.next();
			
			
			for(int i=0; i<loginList.size();i++) {
				if(id.equals(loginList.get(i).getID())&&pw.equals(loginList.get(i).getPw())) {
					kk=i;
				}				
			}
			if( loginList.get(kk).getA()==1) {
				for(int i=0; i<professorList.size();i++) {
					if(id.equals(professorList.get(i).getProID())&&pw.equals(professorList.get(i).getProPassword())==true) {
						index=i+1;
					}
					else if (id.equals(professorList.get(i).getProID())&&pw.equals(professorList.get(i).getProPassword())==false)
						index=0;
				}
				
			}
			
			else if( loginList.get(kk).getA()==-1) {		
				for(int i=0; i<studentList.size();i++) {
					if(id.equals(studentList.get(i).getStuID())&&pw.equals(studentList.get(i).getStuPassword())==true) {
						index=(i*-1)-1;
					}
					else if (id.equals(studentList.get(i).getStuID())&&pw.equals(studentList.get(i).getStuPassword())==false)
						index=0;
				}
				
			}
			
			return index;
			
		}
	
		
//==================================교수 학사 페이지=====================================
//==================================과목 생성=====================================
		
		/*
		 * 	수강과목 생성 
		 * 	리턴타입 : void
		 */
		
		void establishClass(List<ProfessorDTO> professorList,List <ClassDTO> classList,int index){
			try {
			System.out.print("생성할 과목의 이름을 공백없이 입력해주세요 : ");
			String name=scan.next();

			System.out.print("수강 정원을 입력해주세요 (숫자) : ");
			int classPe=scan.nextInt();
			int num=classList.size()+1;
			ClassDTO addclass = new ClassDTO(num,name,professorList.get(index-1).getProName(),classPe,0);
			classList.add(addclass);	
			}
			catch(InputMismatchException m){
				System.out.println("타입에 맞게 입력하세요");
				System.out.println("이전으로 돌아갑니다.");
			}
		}
//==========================================================================
		/*	
		 * 	클래스 리스트를 출력하는 메서드
		 */
		void classView(List <ClassDTO> classList) {
			System.out.println("> 전체 강의목록 입니다.");
			for(int i=0;i<classList.size();i++)
				System.out.println(classList.get(i));
		}
		
		/*
		 *	자신이 생성한 클래스 출력하는 뷰 
		 */
		
		void proclassView(List<ProfessorDTO> professorList,List <ClassDTO> classList,int index){
			System.out.println("> "+ professorList.get(index-1).getProName()+"님이 생성한 강의목록 입니다.");
			for(int i=0; i<classList.size();i++) {
				if(professorList.get(index-1).getProName()==classList.get(i).getClassProf())
					System.out.println(classList.get(i));
			}
			
		}
		
	
//=================================== 과목 폐지 ===========================================			
		/*
		 *	생성한 과목을 삭제하는 메서드
		 *	해당과목을 생성한 교수만 삭제할 수 있다. 
		 *	리턴 타입 : void
		 */
		
		void abolishClass(List<ProfessorDTO> professorList,List <ClassDTO> classList,int index) {
			try {	
			for(int i=0;i<classList.size();i++)
				System.out.println(classList.get(i));
			System.out.println("삭제할 과목의 과목넘버를 입력해 주세요.  (본인이 생성한 과목만 제거됩니다)");
			
			int classnum=scan.nextInt();
			
		if(abolishClassNum(classList,classnum)==1) {
			if(abolishclassName(professorList,classList,index,classnum)==1) {
				String classname=classList.get(classnum-1).getClassTitle();
				classList.remove(classnum-1);
				System.out.println(classname+"과목이 제거 되었습니다.");				
			}
			else if(abolishclassName(professorList,classList,index,classnum)==0)
				System.out.println(professorList.get(index-1).getProName()+"님이 생성한 과목이 아닙니다.");
		}
		else
			System.out.println("과목넘버가 올바르지 않습니다.");	
			}
		catch(InputMismatchException m){
			System.out.println("타입에 맞게 입력하세요");
			System.out.println("이전으로 돌아갑니다.");
		}
		}
		
//====================== 과목 폐지시 사용되는 메서드=============================================	
		//입력한 과목넘버가 있는지 1일때 가능
		int abolishClassNum(List <ClassDTO> classList,int classnum) {
			int returnvalue=0;
			for(int i=0;i<classList.size();i++) {
				if(classList.get(i).getClassNum()==classnum) {	
					returnvalue=1;
				}				
			}			
			return returnvalue;			
		}
		
		// 내가 생성한 과목만 삭제하게 하는 기능
		int abolishclassName(List<ProfessorDTO> professorList,List <ClassDTO> classList,int index,int classnum) {
			int returnvalue=0;
			if(professorList.get(index-1).getProName().equals(classList.get(classnum-1).getClassProf())) {
				System.out.println(index);
				returnvalue=1;	
			}
			return returnvalue;
		}
//=====================================학생 학사 페이지 메서드=============================================
		
		
		/*	enrolment : 수강신청 기능 메서드
		 *	기능 : 개설된 강의식별, 중복 신청 불가능, 개설된 강의 과목넘버만 받음
		 *	각각 다른 메서드에서 따로 구현
		 *  
		 */
		
		void enrolment (List<StudentDTO> studentList,List <ClassDTO> classList,int index) {
			try {
			if(classList.size()==0) {
				System.out.println("개설된 강의가 없습니다.");
			}
			

			else {	
				System.out.println("수강 신청 페이지 입니다.");
				classView(classList);
				System.out.println("수강 신청할 과목의 과목넘버를 입력해 주세요");
				int classnum=scan.nextInt();
				
				if(enrolment_class(classList,classnum)==1){
					if(enrolment_ta(studentList,classList,index,classnum)==0) {
						if(enrolment_pe(studentList,classList,index,classnum)==1) {
							classList.get(classnum-1).setNowPersonnel(classList.get(classnum-1).getNowPersonnel()+1);				
							classList.get(classnum-1).setStuname((studentList.get((index*-1)-1).getStuName()));
						}
						else
							System.out.println("수강인원이 다 찼습니다.");
						
					}
					else if(enrolment_ta(studentList,classList,index,classnum)==1)
						System.out.println("이미 등록한 과목입니다.");
				}
				
				else if (enrolment_class(classList,classnum)==0)
					System.out.println("개설되지 않은 과목넘버입니다.");
				
			
			}	
			}
			catch(InputMismatchException m){
				System.out.println("타입에 맞게 입력하세요");
				System.out.println("이전으로 돌아갑니다.");
			}
			
		}
		
//=================================== 수강신청에 사용되는 메서드 ====================================
		//목록에 있는 과목만 수강 가능하게 하는 기능 메서드
		private int enrolment_class(List <ClassDTO> classList,int classnum) {
			int op=0;
			for(int i=0;i<classList.size();i++) {
				if(classnum==classList.get(i).getClassNum())
					op=1;
				
			}
			
			return op;
		}
		
		//수강신청 중복 불가기능 메서드
		private int enrolment_ta(List<StudentDTO> studnetList,List <ClassDTO> classList,int index,int classnum) {
			int op=0;
			for(int i=0;i<classList.get(classnum-1).getStuname().size();i++) {
				if(classList.get(classnum-1).getStunameArr(i)==studnetList.get((index*-1)-1).getStuName())
				op=1;
			}
			return op;
		}
		
		//수강인원 초과시 더이상 수강신청 못하게 하는 메서드
		private int enrolment_pe(List<StudentDTO> studnetList,List <ClassDTO> classList,int index,int classnum) {
			int op=0;
			if(classList.get(classnum-1).getClassPersonnel()>classList.get(classnum-1).getNowPersonnel()) {
				op=1;
			}
			return op;
		}

//========================================================= 수강취소 ========================================================		
		
		/*	수강 취소기능 메서드
		 * 	등록된 과목이 없을때, 해당과목의 수강중인 학생이 없을때, 자신이 생성한 과목이 아닐때
		 * 	리텁 타입 : 보이드
		 */
		
		void dropOut(List<StudentDTO> studentList,List <ClassDTO> classList,int index) {
			try {
			System.out.println("수강 취소 페이지 입니다.");
			for(int i=0;i<classList.size();i++) {
				System.out.println(classList.get(i));
			}
			
			
			if(classList.size()==0)
				System.out.println("등록된 과목이 없습니다.");
			
			else {
				System.out.println("삭제할 과목의 과목넘버를 입력해 주세요.  (본인이 생성한 과목만 제거됩니다) : ");			
				int classnum=scan.nextInt();
				if(dropoutClassNum(classList,classnum)==1) {
					if(dropoutClassBlank(classList,classnum)==0) {
						int classindex=dropoutMyclass(studentList,classList,index,classnum);
						if(classindex>=0) {
							classList.get(classnum-1).StunameRemove(classindex);
							classList.get(classnum-1).setNowPersonnel(classList.get(classnum-1).getNowPersonnel()-1);
							System.out.println(classnum+"과목의 수강이 취소되었습니다.");
																				
						}
						else
							System.out.println(studentList.get((index*-1)-1).getStuName() +"님이 신청한 과목이 아닙니다.");
					}
					else
						System.out.println("해당과목의 수강중인 학생이 없습니다.");
				}
				else
					System.out.println("과목넘버가 잘못되었습니다.");
					
					
			}
			}
			catch(InputMismatchException m){
				System.out.println("타입에 맞게 입력하세요");
				System.out.println("이전으로 돌아갑니다.");
			}
		}
//========================================= 수강취소시 사용하는 메서드 ===============================================
		//삭제할 과목의 넘버가 잘못될을때
		int dropoutClassNum(List <ClassDTO> classList,int classnum) {
			int returnvalue=0;
			for(int k=0;k<classList.size();k++) {
				if(classList.get(k).getClassNum()==classnum) {
					returnvalue=1;
				}
			}
			return returnvalue;
		}
		
		//삭제할 과목에 수강신청한 학생이 없을때
		int dropoutClassBlank(List <ClassDTO> classList,int classnum) {
			int returnvalue=0;
			if(classList.get(classnum-1).getStuname().size()==0) {
				returnvalue=1;
			}
			
			
			return returnvalue;
		}
		
		//삭제할 과목이 자신이 생성한것인지
		int dropoutMyclass(List<StudentDTO> studentList,List <ClassDTO> classList,int index,int classnum) {
			int returnvalue=-1;
			for(int i=0;i<classList.get(classnum-1).getStuname().size();i++) {
				if(classList.get(classnum-1).getStunameArr(i)==studentList.get((index*-1)-1).getStuName()) {
					returnvalue=i;
				}
				
			}
			
			return returnvalue;
		}
//=======================================================================================================================================================		
		
		//	자신이 수강한 과목만 보여주는 기능 메서드
		void myClassView(List<StudentDTO> studentList,List <ClassDTO> classList,int index) {
			System.out.println(studentList.get((index*-1)-1).getStuName() +"님이 신청한 과목들 입니다.");
			for(int j=0;j<classList.size();j++)
				for(int i=0;i<classList.get(j).getStuname().size();i++) {
					if(classList.get(j).getStunameArr(i)==studentList.get((index*-1)-1).getStuName())
						System.out.println(classList.get(j));

				}
		}

		
}



