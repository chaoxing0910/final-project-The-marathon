package sports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//运动员端：
//登录成功后
//1.可报名参赛。
//2.赛后可查询自己的成绩和排名,以及大赛排行榜（前10名）。
//3.可查看管理员发布的有关比赛的通知。
//
//管理员端：
//登录成功后
//1.可对注册用户进行审批\查询\账户禁用\重置密码等管理。
//2.可启停报名活动,审批参赛申请,查看和统计赛事报名情况。
//3.可录入比赛成绩,查询运动员的比赛成绩和排名,以及包含所有运动员成绩的排行榜
//4.可发布通知。
public class marathon {
	public static List<User> userList=new ArrayList<User>();
	public static List<User> managerList=new ArrayList<User>();
	public static List<Competition>competitionList=new ArrayList<Competition>();
	public static List<Grade>GradeList=new ArrayList<Grade>();
	public static List<Notice> noticeList=new ArrayList<Notice>();
	public static void main(String[] args) {
		//测试用户
		User user=new User();
		user.setUsername("user");
		user.setPassword("123");
		userList.add(user);
		//测试管理员
		User manager=new User();
		manager.setUsername("manager");
		manager.setPassword("123");
		managerList.add(manager);
		//测试赛事
		Competition c=new Competition();
		c.setName("马拉松");
		competitionList.add(c);
		//测试成绩
		Grade Grade=new Grade();
		Grade.setCompetition(c);
		Grade.setUser(user);
		Grade.setGrade(84.3);
		GradeList.add(Grade);
		//测试通知
		Notice notice=new Notice();
		notice.setName("马拉松大赛通知");
	    notice.setContent("马拉松大赛通知内容");
	    noticeList.add(notice);
		
		Scanner input = new Scanner(System.in);
		//页面信息展示
		System.out.println("======马拉松赛信息管理系统======");
		System.out.println("请输入数字后，按下回车键进行操作");
		System.out.println("(运动员和管理员测试账号名分别为user和manager，密码皆为123）");
		System.out.println("1.运动员端登录");
		System.out.println("2.管理员端登录");
		System.out.println("3.用户注册");
		System.out.println("4.退出系统");
		//输入要选择的功能
		int num = input.nextInt();
		//功能选择
		switch (num) {
        	case 1:
        		userLogin();//运动员端登录
        		break;
        	case 2:
        		managerLogin();//管理员端登陆
        		break;
        	case 3:
        		register();//用户注册
        		break;
        	case 4:
        		System.out.println("------退出系统------");
        		System.exit(0);//退出系统
		}
	}
	
	//运动员登录
	public static void userLogin() {
		System.out.println("------运动员端登录------");
		Scanner input = new Scanner(System.in);
	 	String username=null;
	 	String password=null;
	 	boolean allow=false;
	 	//输入用户名密码
		System.out.println("请输入用户名:");
		username=input.nextLine();
		System.out.println("请输入密码:");
		password=input.nextLine();
		//用户验证	
		for(User user:userList) {
			if(user.getUsername().equals(username)){
				if(user.getPassword().equals(password)) {
					if(user.isAvalible()==true)
						allow=true;
					else {
						System.out.println("该账户已被禁用");
					}
					break;
				}
			}
		}
		if(allow) {
			System.out.println("------登录成功，即将跳转到运动员首页------");
			userIndex();
		}
		else {
			System.out.println("------登录失败，即将返回首页------");
			main(null);
		}
	}
	
	//管理员登陆
	public static void managerLogin() {
		System.out.println("------管理员端登录------");
		Scanner input=new Scanner(System.in);
		String username=null;
		String password=null;
		boolean allow=false;
		//输入用户名密码
		System.out.println("请输入用户名:");
		username=input.nextLine();
		System.out.println("请输入密码:");
		password=input.nextLine();
		//用户验证
		for(User user:managerList) {
			if(user.getUsername().equals(username)){
				if(user.getPassword().equals(password)) {
					allow=true;
					break;
				}
			}
		}
		if(allow) {
			System.out.println("------登录成功，即将跳转到管理员员首页------");
			managerIndex();
		}
		else {
			System.out.println("------登录失败，即将返回首页------");
			main(null);
		}
	}
	
	//用户注册
	public static void register() {
		System.out.println("------用户注册------");
		Scanner input=new Scanner(System.in); 
		String username = null;
		String password = null;
		//输入用户名密码
		System.out.println("请输入用户名:");
		username=input.nextLine();
		System.out.println("请输入密码:");
		password=input.nextLine();
		//数据添加
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		userList.add(user);
		
		System.out.println("------注册成功------");
		System.out.println("请输入数字后，按下回车键进行操作");
		System.out.println("1.立即登录");
		System.out.println("2.返回首页");
		System.out.println("3.退出系统");
		int num = input.nextInt();
		//操作选择
        switch (num) {
            case 1:
            	userLogin();
                break;
            case 2:
            	main(null);
                break;
            case 3:
                System.out.println("------退出系统------");
                System.exit(0);
        }
	}
	//运动员端首页
	public static void userIndex() {
		Scanner input=new Scanner(System.in); 
		System.out.println("------运动员首页------");
		System.out.println("请输入数字后，按下回车键进行操作");
		System.out.println("1.报名参赛");
		System.out.println("2.查询成绩");
		System.out.println("3.查看公告");
		System.out.println("4.返回首页");
		System.out.println("5.退出系统");
		int num = input.nextInt();
		//操作选择
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
                System.out.println("------退出系统------");
                System.exit(0);
        }
	}
	//运动员报名
	public static void competitionRegister() {
		Scanner input=new Scanner(System.in);
		//输入赛事名
		System.out.println("请输入你要报名的赛事名:");
		String compName=input.nextLine();
		//判断输入的赛事是否存在
		boolean flagComp=false;
		Competition comp = null;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(compName)) {
				flagComp=true;
				comp=competition;
			}
		}
		if(!flagComp) {
			System.out.println("------赛事不存在，即将返回用户首页------");
			userIndex();
		}
		else {
			System.out.println("请输入参赛用户名:");
			String username=input.nextLine();
			boolean isExist=false;
			for(User user:userList) {
				if(user.getUsername().equals(username)) {
					isExist=true;
					if(comp!=null) {
						comp.getUsersList().add(user);
						comp.setNumber(comp.getNumber()+1);
						System.out.println("------报名成功，即将返回用户首页------");
						userIndex();
					}
					else {
						System.out.println("------报名失败，即将返回用户首页------");
						userIndex();
					}
				}
			}
			if(!isExist) {
				System.out.println("------用户名与当前用户不匹配，报名失败，即将返回用户首页------");
				userIndex();
			}
		}
	}
	//比赛成绩查询
	public static void competitionGrade() {
		Scanner input=new Scanner(System.in);
		List <Grade> datas = new ArrayList<Grade>() ;
		boolean flagComp=false;
		boolean flagUser=false;
		System.out.println("请输入需要查询的赛事:");
		String compName=input.nextLine();
		
		for(Grade data:GradeList) {
			if(data.getCompetition().getName().equals(compName)) {
				flagComp=true;
				datas.add(data);
			}
		}
		
		Collections.sort(datas);
		//用户成绩查询
		System.out.println("请输入您要查询的用户:");
		String username=input.nextLine();
		int i=1;
		System.out.println(compName);
		for(Grade data:datas) {
			if(data.getUser().getUsername().equals(username)) {
				flagUser=true;
				System.out.println("您的成绩:"+data.getGrade()+"您的排名:"+i);
				i++;
				break;
			}
		}
		//赛事排行榜
		if(flagComp) {
			System.out.println(compName+"大赛排行榜(前10名):");
			i=1;
			for(Grade competitionGrade:datas) {
				if(i>10)
					break;
				System.out.println("第"+i+"名:"+competitionGrade.getUser().getUsername());
				i++;
			}
		}
		else {
			System.out.println("查询失败，赛事不存在、无人参赛或比赛暂时未出结果");
		}
		System.out.println("------即将返回用户首页------");
		userIndex();

	}
	//用户获得公告
	public static void competitionNotice() {
		System.out.println("以下为比赛通知");
		for(int i = 0; i < noticeList.size(); i++) {
			System.out.println("通知"+(i+1)+":");
			System.out.println(noticeList.get(i).getName());
			System.out.println(noticeList.get(i).getContent());
		}
		System.out.println("------公告展示完毕，即将返回用户首页------");
		userIndex();
	}
	
	//管理员端首页
	public static void managerIndex() {
		Scanner input=new Scanner(System.in); 
		System.out.println("------管理员首页------");
		System.out.println("请输入数字后，按下回车键进行操作");
		System.out.println("1.用户管理");
		System.out.println("2.赛事管理");
		System.out.println("3.成绩管理");
		System.out.println("4.通知管理");
		System.out.println("5.返回主页");
		System.out.println("6.退出系统");
		int num = input.nextInt();
		//操作选择
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
                System.out.println("------退出系统------");
                System.exit(0);
        }
	}
	//用户管理
	public static void userManage() {
		Scanner input=new Scanner(System.in); 
		System.out.println("------管理员端-用户管理页------");
		System.out.println("请输入数字后，按下回车键进行操作");
		System.out.println("1.账户审批");
		System.out.println("2.账户查询");
		System.out.println("3.账户禁用");
		System.out.println("4.重置密码");
		System.out.println("5.返回管理员首页");
		System.out.println("6.退出系统");
		int num = input.nextInt();
		//操作选择
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
                System.out.println("------退出系统------");
                System.exit(0);
        }
	}
	//账户审批
	public static void userApproval() {
		System.out.println("------即将返回用户管理页------");
		userManage();
	}
	//账户查询
	public static void userSelect() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入需要查询的用户名:");
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
			System.out.println("查询失败，无此用户");
		System.out.println("------即将返回用户管理页------");
		userManage();
	}
	//账户禁用
	public static void userDisabled() {
		System.out.println("请输入禁用的账户名:");
		Scanner input=new Scanner(System.in);
		String username=input.nextLine();
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
					user.setAvalible(false);
					System.out.println("禁用成功");
					break;
			}
		}
		System.out.println("------即将返回用户管理页------");
		userManage();
	}
	//重置密码
	public static void resetPassword() {
		System.out.println("请输入需要重置密码的账户名:");
		Scanner input=new Scanner(System.in);
		String username=input.nextLine();
		boolean isSuccess=false;
		for(User user:userList) {
			if(user.getUsername().equals(username)) {
				isSuccess=true;
					System.out.println("请输入密码进行重置：");
					String password=input.next();
					user.setPassword(password);
					System.out.println("重置成功");
					break;
			}
		}
		if(!isSuccess)
			System.out.println("重置失败，无此账户，请核对");
		System.out.println("------即将返回用户管理页------");
		userManage();
	}
	//赛事管理
	public static void competitionManage() {
		System.out.println("------管理员端-赛事管理页------");
		Scanner input=new Scanner(System.in); 
		System.out.println("请输入数字后，按下回车键进行操作");
		System.out.println("1.添加赛事");
		System.out.println("2.启停赛事");
		System.out.println("3.审批参赛申请");
		System.out.println("4.赛事报名情况");
		System.out.println("5.返回管理员首页");
		System.out.println("6.退出系统");
		int num = input.nextInt();
		//操作选择
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
                System.out.println("------退出系统------");
                System.exit(0);
        }
	}
	//添加赛事
	public static void insertCompetition() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入赛事名:");
		String name=input.nextLine();
		System.out.println("请输入赛事内容");
		String content=input.nextLine();
		Competition competition=new Competition(name,content);
		competitionList.add(competition);
		System.out.println("------添加成功，即将返回赛事管理页------");
		competitionManage();
	}
	//启停赛事
	public static void handleCompetition() {
		Scanner input=new Scanner(System.in);
		System.out.println("请选择启停的比赛名：");
		String name=input.nextLine();
		boolean isExist=false;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isExist=true;
				System.out.println("输入1开启赛事，输入2停止赛事:");
				int num=input.nextInt();
				if(num==1) {
					competition.setAvalible(true);
					System.out.println("赛事开启成功");
				}
				else if(num==2) {
					competition.setAvalible(false);
					System.out.println("赛事停止成功");
				}
			}
			
		}
		if(!isExist) {
			System.out.println("赛事不存在");
		}
		System.out.println("------即将返回赛事管理页------");
		competitionManage();
	}
	//审批参赛申请
	public static void approvalCompetition() {
		System.out.println("------即将返回赛事管理页------");
		competitionManage();
	}
	//查询报名情况
	public static void selectRegister() {
		System.out.println("请输入需要查询的比赛名");
		Scanner input=new Scanner(System.in);
		String name=input.nextLine();
		boolean isExist=false;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isExist=true;
				System.out.println(competition.getName()+"大赛人员报名情况");
				System.out.println("总报名人数:"+competition.getNumber());
				for(User user:competition.getUsersList()) {
					System.out.println(user.getUsername());
				}
			}
			
		}
		if(!isExist) {
			System.out.println("赛事不存在");
		}
		System.out.println("------即将返回赛事管理页------");
		competitionManage();
	}
	
	//成绩管理
	public static void gradeManage() {
		System.out.println("------管理员端-成绩管理页------");
		Scanner input=new Scanner(System.in); 
		System.out.println("请输入数字后，按下回车键进行操作");
		System.out.println("1.录入成绩");
		System.out.println("2.查询成绩排名");
		System.out.println("3.查询排行榜");
		System.out.println("4.返回管理员首页");
		System.out.println("5.退出系统");
		int num = input.nextInt();
		//操作选择
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
                System.out.println("------退出系统------");
                System.exit(0);
        }
	}
	//录入成绩
	public static void insertGrade() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入比赛名称");
		String name=input.nextLine();
		boolean isCompExist=false;
		for(Competition competition:competitionList) {
			if(competition.getName().equals(name)) {
				isCompExist=true;
				boolean isUserExist=false;
				System.out.println("请输入用户名:");
				String username=input.nextLine();
				for(User user:userList) {
					if(user.getUsername().equals(username)) {
						isUserExist=true;
						System.out.println("请输入该用户的成绩:");
						double grade=input.nextDouble();
						Grade Grade=new Grade();
						Grade.setCompetition(competition);
						Grade.setUser(user);
						Grade.setGrade(grade);
						GradeList.add(Grade);
						System.out.println("成绩录入成功");
						break;
					}	
				}
				if(!isUserExist)
					System.out.println("该用户不存在");
				break;
			}
		}
		if(!isCompExist) {
			System.out.println("赛事不存在!");
		}
		System.out.println("------即将返回成绩管理页------");
		gradeManage();
	}
	//查询成绩排名
	public static void selectGrade() {
		List <Grade> grade = new ArrayList<Grade>() ;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入赛事名");
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
			System.out.println("------赛事不存在或无人员报名，即将返回成绩管理页------");
			gradeManage();
		}
		else {
			boolean isUserExist=false;
			System.out.println("请输入要查询的用户名");
			String username=input.nextLine();
			int i=1;
			for(Grade competitionGrade3:grade) {
				if(competitionGrade3.getUser().getUsername().equals(username)) {
					isUserExist=true;
					System.out.println("查询成功");
					System.out.println("该用户的成绩为:"+competitionGrade3.getGrade()+" 排名是:"+"第"+i+"名");
				}
				i++;
			}
			if(!isUserExist) {
				System.out.println("该用户不存在");
			}
			System.out.println("------即将返回成绩管理页------");
			gradeManage();
		}
	}
	//查询排行榜
	public static void selectList() {
		List <Grade> grade = new ArrayList<Grade>() ;
		Scanner input=new Scanner(System.in);
		System.out.println("请输入你要查询的赛事:");
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
			System.out.println("赛事不存在或无人员报名");
		}
		else {
			System.out.println("赛事"+name+"排行榜如下:");
			int i=1;
		for(Grade competitionGrade3:grade) {
			System.out.println("第"+i+"名:"+competitionGrade3.getUser().getUsername());
			i++;
		}
		}
		System.out.println("------即将返回成绩管理页------");
		gradeManage();
	}
	
	//通知管理
	public static void noticeManage() {
		System.out.println("------管理员端-通知管理页------");
		Scanner input=new Scanner(System.in); 
		System.out.println("请输入数字后，按下回车键进行操作");
		System.out.println("1.添加通知");
		System.out.println("2.删除通知");
		System.out.println("3.修改通知");
		System.out.println("4.查询通知");
		System.out.println("5.返回管理员首页");
		System.out.println("6.退出系统");
		int num = input.nextInt();
		//操作选择
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
                System.out.println("------退出系统------");
                System.exit(0);
        }
	}
	//添加通知
	public static void insertNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入通知名:");
		String name=input.nextLine();
		System.out.println("请输入通知内容:");
		String content=input.nextLine();
		
	    Notice notice=new Notice();
	    notice.setName(name);
	    notice.setContent(content);
	    noticeList.add(notice);
	   
		System.out.println("------添加成功，即将返回通知管理页------");
		noticeManage();
	}
	//删除通知
	public static void deleteNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入通知名");
		String name=input.nextLine();
		boolean isNoticeExist=false;
		for(Notice notice:noticeList) {
			if(notice.getName().equals(name)) {
				isNoticeExist=true;
				noticeList.remove(notice);
				System.out.println("删除成功");
				System.out.println("------即将返回通知管理页------");
				noticeManage();
			}
			else {
				System.out.println("通知不存在，删除失败");
				System.out.println("------即将返回通知管理页------");
				noticeManage();
			}
		}
	}
	//修改通知
	public static void updateNotice() {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入需要修改的通知名:");
		String name=input.nextLine();
		boolean isNoticeExist=false;
		for(int i = 0; i < noticeList.size(); i++) {
			if(noticeList.get(i).getName().equals(name)) {
				isNoticeExist=true;
				System.out.println("请输入需要修改的通知名:");
				String newname=input.nextLine();
				noticeList.get(i).setName(newname);
				System.out.println("请输入需要修改的内容:");
				String content=input.nextLine();
				noticeList.get(i).setContent(content);
				System.out.println("------通知修改成功,即将返回通知管理页------");
				noticeManage();
			}
			else {
				System.out.println("------该通知不存在,即将返回通知管理页------");
				noticeManage();
			}
		}
	}
	//查询通知
	public static void selectNotice() {
		for(Notice notice:noticeList) {
				System.out.println("通知名:"+notice.getName()+"通知内容:"+notice.getContent());
		}
		System.out.println("------查询完毕，即将返回通知管理页------");
		noticeManage();
	}
}
