package sports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//�˶�Ա�ˣ�
//��¼�ɹ���
//1.�ɱ���������
//2.����ɲ�ѯ�Լ��ĳɼ�������,�Լ��������а�ǰ10������
//3.�ɲ鿴����Ա�������йر�����֪ͨ��
//
//����Ա�ˣ�
//��¼�ɹ���
//1.�ɶ�ע���û���������\��ѯ\�˻�����\��������ȹ���
//2.����ͣ�����,������������,�鿴��ͳ�����±��������
//3.��¼������ɼ�,��ѯ�˶�Ա�ı����ɼ�������,�Լ����������˶�Ա�ɼ������а�
//4.�ɷ���֪ͨ��
public class marathon {
	public static List<User> userList=new ArrayList<User>();
	public static List<User> managerList=new ArrayList<User>();
	public static List<Competition>competitionList=new ArrayList<Competition>();
	public static List<Grade>GradeList=new ArrayList<Grade>();
	public static List<Notice> noticeList=new ArrayList<Notice>();
	public static void main(String[] args) {
		//�����û�
		User user=new User();
		user.setUsername("user");
		user.setPassword("123");
		userList.add(user);
		//���Թ���Ա
		User manager=new User();
		manager.setUsername("manager");
		manager.setPassword("123");
		managerList.add(manager);
		//��������
		Competition c=new Competition();
		c.setName("������");
		competitionList.add(c);
		//���Գɼ�
		Grade Grade=new Grade();
		Grade.setCompetition(c);
		Grade.setUser(user);
		Grade.setGrade(84.3);
		GradeList.add(Grade);
		//����֪ͨ
		Notice notice=new Notice();
		notice.setName("�����ɴ���֪ͨ");
	    notice.setContent("�����ɴ���֪ͨ����");
	    noticeList.add(notice);
		
		Scanner input = new Scanner(System.in);
		//ҳ����Ϣչʾ
		System.out.println("======����������Ϣ����ϵͳ======");
		System.out.println("���������ֺ󣬰��»س������в���");
		System.out.println("(�˶�Ա�͹���Ա�����˺����ֱ�Ϊuser��manager�������Ϊ123��");
		System.out.println("1.�˶�Ա�˵�¼");
		System.out.println("2.����Ա�˵�¼");
		System.out.println("3.�û�ע��");
		System.out.println("4.�˳�ϵͳ");
		//����Ҫѡ��Ĺ���
		int num = input.nextInt();
		//����ѡ��
		switch (num) {
        	case 1:
        		userLogin();//�˶�Ա�˵�¼
        		break;
        	case 2:
        		managerLogin();//����Ա�˵�½
        		break;
        	case 3:
        		register();//�û�ע��
        		break;
        	case 4:
        		System.out.println("------�˳�ϵͳ------");
        		System.exit(0);//�˳�ϵͳ
		}
	}
	
	//�˶�Ա��¼
	public static void userLogin() {
		System.out.println("------�˶�Ա�˵�¼------");
		Scanner input = new Scanner(System.in);
	 	String username=null;
	 	String password=null;
	 	boolean allow=false;
	 	//�����û�������
		System.out.println("�������û���:");
		username=input.nextLine();
		System.out.println("����������:");
		password=input.nextLine();
		//�û���֤	
		for(User user:userList) {
			if(user.getUsername().equals(username)){
				if(user.getPassword().equals(password)) {
					if(user.isAvalible()==true)
						allow=true;
					else {
						System.out.println("���˻��ѱ�����");
					}
					break;
				}
			}
		}
		if(allow) {
			System.out.println("------��¼�ɹ���������ת���˶�Ա��ҳ------");
			userIndex();
		}
		else {
			System.out.println("------��¼ʧ�ܣ�����������ҳ------");
			main(null);
		}
	}
	
	//����Ա��½
	public static void managerLogin() {
		System.out.println("------����Ա�˵�¼------");
		Scanner input=new Scanner(System.in);
		String username=null;
		String password=null;
		boolean allow=false;
		//�����û�������
		System.out.println("�������û���:");
		username=input.nextLine();
		System.out.println("����������:");
		password=input.nextLine();
		//�û���֤
		for(User user:managerList) {
			if(user.getUsername().equals(username)){
				if(user.getPassword().equals(password)) {
					allow=true;
					break;
				}
			}
		}
		if(allow) {
			System.out.println("------��¼�ɹ���������ת������ԱԱ��ҳ------");
			managerIndex();
		}
		else {
			System.out.println("------��¼ʧ�ܣ�����������ҳ------");
			main(null);
		}
	}
	
	//�û�ע��
	public static void register() {
		System.out.println("------�û�ע��------");
		Scanner input=new Scanner(System.in); 
		String username = null;
		String password = null;
		//�����û�������
		System.out.println("�������û���:");
		username=input.nextLine();
		System.out.println("����������:");
		password=input.nextLine();
		//�������
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		userList.add(user);
		
		System.out.println("------ע��ɹ�------");
		System.out.println("���������ֺ󣬰��»س������в���");
		System.out.println("1.������¼");
		System.out.println("2.������ҳ");
		System.out.println("3.�˳�ϵͳ");
		int num = input.nextInt();
		//����ѡ��
        switch (num) {
            case 1:
            	userLogin();
                break;
            case 2:
            	main(null);
                break;
            case 3:
                System.out.println("------�˳�ϵͳ------");
                System.exit(0);
        }
	}
	//�˶�Ա����ҳ
	public static void userIndex() {
		Scanner input=new Scanner(System.in); 
		System.out.println("------�˶�Ա��ҳ------");
		System.out.println("���������ֺ󣬰��»س������в���");
		System.out.println("1.��������");
		System.out.println("2.��ѯ�ɼ�");
		System.out.println("3.�鿴����");
		System.out.println("4.������ҳ");
		System.out.println("5.�˳�ϵͳ");
		int num = input.nextInt();
		//����ѡ��
        switch (num) {
            case 1:
            	competitionRegister();
                break;
            case 2:
            	competitionGrade();
                break;
            case 3:
            	competitionNotice();
                break;
            case 4:
            	main(null);
                break;
            case 5:
                System.out.println("------�˳�ϵͳ------");
                System.exit(0);
        }
	}
	//�˶�Ա����
	public static void competitionRegister() {
		Scanner input=new Scanner(System.in);
		//����������
		System.out.println("��������Ҫ������������:");
		String compName=input.nextLine();
		//�ж�����������Ƿ����
		boolean flagComp=false;
		Competition comp = null;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(compName)) {
				flagComp=true;
				comp=competition;
			}
		}
		if(!flagComp) {
			System.out.println("------���²����ڣ����������û���ҳ------");
			userIndex();
		}
		else {
			System.out.println("����������û���:");
			String username=input.nextLine();
			boolean isExist=false;
			for(User user:userList) {
				if(user.getUsername().equals(username)) {
					isExist=true;
					if(comp!=null) {
						comp.getUsersList().add(user);
						comp.setNumber(comp.getNumber()+1);
						System.out.println("------�����ɹ������������û���ҳ------");
						userIndex();
					}
					else {
						System.out.println("------����ʧ�ܣ����������û���ҳ------");
						userIndex();
					}
				}
			}
			if(!isExist) {
				System.out.println("------�û����뵱ǰ�û���ƥ�䣬����ʧ�ܣ����������û���ҳ------");
				userIndex();
			}
		}
	}
	//�����ɼ���ѯ
	public static void competitionGrade() {
		Scanner input=new Scanner(System.in);
		List <Grade> datas = new ArrayList<Grade>() ;
		boolean flagComp=false;
		boolean flagUser=false;
		System.out.println("��������Ҫ��ѯ������:");
		String compName=input.nextLine();
		
		for(Grade data:GradeList) {
			if(data.getCompetition().getName().equals(compName)) {
				flagComp=true;
				datas.add(data);
			}
		}
		
		Collections.sort(datas);
		//�û��ɼ���ѯ
		System.out.println("��������Ҫ��ѯ���û�:");
		String username=input.nextLine();
		int i=1;
		System.out.println(compName);
		for(Grade data:datas) {
			if(data.getUser().getUsername().equals(username)) {
				flagUser=true;
				System.out.println("���ĳɼ�:"+data.getGrade()+"��������:"+i);
				i++;
				break;
			}
		}
		//�������а�
		if(flagComp) {
			System.out.println(compName+"�������а�(ǰ10��):");
			i=1;
			for(Grade competitionGrade:datas) {
				if(i>10)
					break;
				System.out.println("��"+i+"��:"+competitionGrade.getUser().getUsername());
				i++;
			}
		}
		else {
			System.out.println("��ѯʧ�ܣ����²����ڡ����˲����������ʱδ�����");
		}
		System.out.println("------���������û���ҳ------");
		userIndex();

	}
	//�û���ù���
	public static void competitionNotice() {
		System.out.println("����Ϊ����֪ͨ");
		for(int i = 0; i < noticeList.size(); i++) {
			System.out.println("֪ͨ"+(i+1)+":");
			System.out.println(noticeList.get(i).getName());
			System.out.println(noticeList.get(i).getContent());
		}
		System.out.println("------����չʾ��ϣ����������û���ҳ------");
		userIndex();
	}
	
	//����Ա����ҳ
	public static void managerIndex() {
		Scanner input=new Scanner(System.in); 
		System.out.println("------����Ա��ҳ------");
		System.out.println("���������ֺ󣬰��»س������в���");
		System.out.println("1.�û�����");
		System.out.println("2.���¹���");
		System.out.println("3.�ɼ�����");
		System.out.println("4.֪ͨ����");
		System.out.println("5.������ҳ");
		System.out.println("6.�˳�ϵͳ");
		int num = input.nextInt();
		//����ѡ��
        switch (num) {
            case 1:
            	userManage();
                break;
            case 2:
            	competitionManage();
                break;
            case 3:
            	gradeManage();
                break;
            case 4:
            	noticeManage();
                break;
            case 5:
            	main(null);
                break;
            case 6:
                System.out.println("------�˳�ϵͳ------");
                System.exit(0);
        }
	}
	//�û�����
	public static void userManage() {
		Scanner input=new Scanner(System.in); 
		System.out.println("------����Ա��-�û�����ҳ------");
		System.out.println("���������ֺ󣬰��»س������в���");
		System.out.println("1.�˻�����");
		System.out.println("2.�˻���ѯ");
		System.out.println("3.�˻�����");
		System.out.println("4.��������");
		System.out.println("5.���ع���Ա��ҳ");
		System.out.println("6.�˳�ϵͳ");
		int num = input.nextInt();
		//����ѡ��
        switch (num) {
            case 1:
            	userApproval();
                break;
            case 2:
            	userSelect();
                break;
            case 3:
            	userDisabled();
                break;
            case 4:
            	resetPassword();
                break;
            case 5:
            	managerIndex();
                break;
            case 6:
                System.out.println("------�˳�ϵͳ------");
                System.exit(0);
        }
	}
	//�˻�����
	public static void userApproval() {
		System.out.println("------���������û�����ҳ------");
		userManage();
	}
	//�˻���ѯ
	public static void userSelect() {
		Scanner input=new Scanner(System.in);
		System.out.println("��������Ҫ��ѯ���û���:");
		String username=input.nextLine();
		boolean isSuccess=false;
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				isSuccess=true;
				System.out.println(user);
				break;
			}
		}
		if(!isSuccess)
			System.out.println("��ѯʧ�ܣ��޴��û�");
		System.out.println("------���������û�����ҳ------");
		userManage();
	}
	//�˻�����
	public static void userDisabled() {
		System.out.println("��������õ��˻���:");
		Scanner input=new Scanner(System.in);
		String username=input.nextLine();
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
					user.setAvalible(false);
					System.out.println("���óɹ�");
					break;
			}
		}
		System.out.println("------���������û�����ҳ------");
		userManage();
	}
	//��������
	public static void resetPassword() {
		System.out.println("��������Ҫ����������˻���:");
		Scanner input=new Scanner(System.in);
		String username=input.nextLine();
		boolean isSuccess=false;
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				isSuccess=true;
					System.out.println("����������������ã�");
					String password=input.next();
					user.setPassword(password);
					System.out.println("���óɹ�");
					break;
			}
		}
		if(!isSuccess)
			System.out.println("����ʧ�ܣ��޴��˻�����˶�");
		System.out.println("------���������û�����ҳ------");
		userManage();
	}
	//���¹���
	public static void competitionManage() {
		System.out.println("------����Ա��-���¹���ҳ------");
		Scanner input=new Scanner(System.in); 
		System.out.println("���������ֺ󣬰��»س������в���");
		System.out.println("1.�������");
		System.out.println("2.��ͣ����");
		System.out.println("3.������������");
		System.out.println("4.���±������");
		System.out.println("5.���ع���Ա��ҳ");
		System.out.println("6.�˳�ϵͳ");
		int num = input.nextInt();
		//����ѡ��
        switch (num) {
            case 1:
            	insertCompetition();
                break;
            case 2:
            	handleCompetition();
                break;
            case 3:
            	approvalCompetition();
                break;
            case 4:
            	selectRegister();
                break;
            case 5:
            	managerIndex();
                break;
            case 6:
                System.out.println("------�˳�ϵͳ------");
                System.exit(0);
        }
	}
	//�������
	public static void insertCompetition() {
		Scanner input=new Scanner(System.in);
		System.out.println("������������:");
		String name=input.nextLine();
		System.out.println("��������������");
		String content=input.nextLine();
		Competition competition=new Competition(name,content);
		competitionList.add(competition);
		System.out.println("------��ӳɹ��������������¹���ҳ------");
		competitionManage();
	}
	//��ͣ����
	public static void handleCompetition() {
		Scanner input=new Scanner(System.in);
		System.out.println("��ѡ����ͣ�ı�������");
		String name=input.nextLine();
		boolean isExist=false;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isExist=true;
				System.out.println("����1�������£�����2ֹͣ����:");
				int num=input.nextInt();
				if(num==1) {
					competition.setAvalible(true);
					System.out.println("���¿����ɹ�");
				}
				else if(num==2) {
					competition.setAvalible(false);
					System.out.println("����ֹͣ�ɹ�");
				}
			}
			
		}
		if(!isExist) {
			System.out.println("���²�����");
		}
		System.out.println("------�����������¹���ҳ------");
		competitionManage();
	}
	//������������
	public static void approvalCompetition() {
		System.out.println("------�����������¹���ҳ------");
		competitionManage();
	}
	//��ѯ�������
	public static void selectRegister() {
		System.out.println("��������Ҫ��ѯ�ı�����");
		Scanner input=new Scanner(System.in);
		String name=input.nextLine();
		boolean isExist=false;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isExist=true;
				System.out.println(competition.getName()+"������Ա�������");
				System.out.println("�ܱ�������:"+competition.getNumber());
				for(User user:competition.getUsersList()) {
					System.out.println(user.getUsername());
				}
			}
			
		}
		if(!isExist) {
			System.out.println("���²�����");
		}
		System.out.println("------�����������¹���ҳ------");
		competitionManage();
	}
	
	//�ɼ�����
	public static void gradeManage() {
		System.out.println("------����Ա��-�ɼ�����ҳ------");
		Scanner input=new Scanner(System.in); 
		System.out.println("���������ֺ󣬰��»س������в���");
		System.out.println("1.¼��ɼ�");
		System.out.println("2.��ѯ�ɼ�����");
		System.out.println("3.��ѯ���а�");
		System.out.println("4.���ع���Ա��ҳ");
		System.out.println("5.�˳�ϵͳ");
		int num = input.nextInt();
		//����ѡ��
        switch (num) {
            case 1:
            	insertGrade();
                break;
            case 2:
            	selectGrade();
                break;
            case 3:
            	selectList();
                break;
            case 4:
            	managerIndex();
                break;
            case 5:
                System.out.println("------�˳�ϵͳ------");
                System.exit(0);
        }
	}
	//¼��ɼ�
	public static void insertGrade() {
		Scanner input=new Scanner(System.in);
		System.out.println("�������������");
		String name=input.nextLine();
		boolean isCompExist=false;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isCompExist=true;
				boolean isUserExist=false;
				System.out.println("�������û���:");
				String username=input.nextLine();
				for(User user:userList) {
					if(user.getUsername().equals(username)) {
						isUserExist=true;
						System.out.println("��������û��ĳɼ�:");
						double grade=input.nextDouble();
						Grade Grade=new Grade();
						Grade.setCompetition(competition);
						Grade.setUser(user);
						Grade.setGrade(grade);
						GradeList.add(Grade);
						System.out.println("�ɼ�¼��ɹ�");
						break;
					}	
				}
				if(!isUserExist)
					System.out.println("���û�������");
				break;
			}
		}
		if(!isCompExist) {
			System.out.println("���²�����!");
		}
		System.out.println("------�������سɼ�����ҳ------");
		gradeManage();
	}
	//��ѯ�ɼ�����
	public static void selectGrade() {
		List <Grade> grade = new ArrayList<Grade>() ;
		Scanner input=new Scanner(System.in);
		System.out.println("������������");
		String name=input.nextLine();
		boolean isCompExist=false;
		for(Grade competitionGrade2:GradeList) {
			if(competitionGrade2.getCompetition().getName().equals(name)) {
				isCompExist=true;
			 grade.add(competitionGrade2);
			}
		}
		Collections.sort(grade);
		if(!isCompExist) {
			System.out.println("------���²����ڻ�����Ա�������������سɼ�����ҳ------");
			gradeManage();
		}
		else {
			boolean isUserExist=false;
			System.out.println("������Ҫ��ѯ���û���");
			String username=input.nextLine();
			int i=1;
			for(Grade competitionGrade3:grade) {
				if(competitionGrade3.getUser().getUsername().equals(username)) {
					isUserExist=true;
					System.out.println("��ѯ�ɹ�");
					System.out.println("���û��ĳɼ�Ϊ:"+competitionGrade3.getGrade()+" ������:"+"��"+i+"��");
				}
				i++;
			}
			if(!isUserExist) {
				System.out.println("���û�������");
			}
			System.out.println("------�������سɼ�����ҳ------");
			gradeManage();
		}
	}
	//��ѯ���а�
	public static void selectList() {
		List <Grade> grade = new ArrayList<Grade>() ;
		Scanner input=new Scanner(System.in);
		System.out.println("��������Ҫ��ѯ������:");
		String name=input.nextLine();
		boolean isCompExist=false;
		for(Grade competitionGrade2:GradeList) {
			if(competitionGrade2.getCompetition().getName().equals(name)) {
				isCompExist=true;
			 grade.add(competitionGrade2);
			}
		}
		Collections.sort(grade);
		if(!isCompExist) {
			System.out.println("���²����ڻ�����Ա����");
		}
		else {
			System.out.println("����"+name+"���а�����:");
			int i=1;
		for(Grade competitionGrade3:grade) {
			System.out.println("��"+i+"��:"+competitionGrade3.getUser().getUsername());
			i++;
		}
		}
		System.out.println("------�������سɼ�����ҳ------");
		gradeManage();
	}
	
	//֪ͨ����
	public static void noticeManage() {
		System.out.println("------����Ա��-֪ͨ����ҳ------");
		Scanner input=new Scanner(System.in); 
		System.out.println("���������ֺ󣬰��»س������в���");
		System.out.println("1.���֪ͨ");
		System.out.println("2.ɾ��֪ͨ");
		System.out.println("3.�޸�֪ͨ");
		System.out.println("4.��ѯ֪ͨ");
		System.out.println("5.���ع���Ա��ҳ");
		System.out.println("6.�˳�ϵͳ");
		int num = input.nextInt();
		//����ѡ��
        switch (num) {
            case 1:
            	insertNotice();
                break;
            case 2:
            	deleteNotice();
                break;
            case 3:
            	updateNotice();
                break;
            case 4:
            	selectNotice();
                break;
            case 5:
            	managerIndex();
                break;
            case 6:
                System.out.println("------�˳�ϵͳ------");
                System.exit(0);
        }
	}
	//���֪ͨ
	public static void insertNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("������֪ͨ��:");
		String name=input.nextLine();
		System.out.println("������֪ͨ����:");
		String content=input.nextLine();
		
	    Notice notice=new Notice();
	    notice.setName(name);
	    notice.setContent(content);
	    noticeList.add(notice);
	   
		System.out.println("------��ӳɹ�����������֪ͨ����ҳ------");
		noticeManage();
	}
	//ɾ��֪ͨ
	public static void deleteNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("������֪ͨ��");
		String name=input.nextLine();
		boolean isNoticeExist=false;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				isNoticeExist=true;
				noticeList.remove(notice);
				System.out.println("ɾ���ɹ�");
				System.out.println("------��������֪ͨ����ҳ------");
				noticeManage();
			}
			else {
				System.out.println("֪ͨ�����ڣ�ɾ��ʧ��");
				System.out.println("------��������֪ͨ����ҳ------");
				noticeManage();
			}
		}
	}
	//�޸�֪ͨ
	public static void updateNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("��������Ҫ�޸ĵ�֪ͨ��:");
		String name=input.nextLine();
		boolean isNoticeExist=false;
		for(int i = 0; i < noticeList.size(); i++) {
			if(noticeList.get(i).getName().equals(name)) {
				isNoticeExist=true;
				System.out.println("��������Ҫ�޸ĵ�֪ͨ��:");
				String newname=input.nextLine();
				noticeList.get(i).setName(newname);
				System.out.println("��������Ҫ�޸ĵ�����:");
				String content=input.nextLine();
				noticeList.get(i).setContent(content);
				System.out.println("------֪ͨ�޸ĳɹ�,��������֪ͨ����ҳ------");
				noticeManage();
			}
			else {
				System.out.println("------��֪ͨ������,��������֪ͨ����ҳ------");
				noticeManage();
			}
		}
	}
	//��ѯ֪ͨ
	public static void selectNotice() {
		for(Notice notice:noticeList) {
				System.out.println("֪ͨ��:"+notice.getName()+"֪ͨ����:"+notice.getContent());
		}
		System.out.println("------��ѯ��ϣ���������֪ͨ����ҳ------");
		noticeManage();
	}
}
