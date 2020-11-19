package com.briup.day12;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import com.briup.day13.Teacher;

public class Studentmanage {
	// 存储学生
	private static List list = new ArrayList();

	public static void main(String[] args) {
		index();
	}

	private static void index() {
		System.out.println("欢迎使用学生管理系统，请先登录");
		System.out.println("请输入你的用户名");
		Scanner sc = new Scanner(System.in);
		String username = sc.next();
		System.out.println("请输入你的密码");
		Scanner sc2 = new Scanner(System.in);
		String password = sc2.next();
		if (username != null && password != null && ("admin").equals(username) && ("admin").equals(password)) {
			System.out.println("登陆成功");
			operation();
		} else {
			System.out.println("登陆失败，请重试");
			index();
		}
	}

	private static void operation() {
		System.out.println("请选择你所需要的操作编号");
		System.out.println("1.添加学生");
		System.out.println("2.查询学生");
		System.out.println("3.修改学生");
		System.out.println("4.删除学生");
		System.out.println("5.退出系统");
		Scanner sc = new Scanner(System.in);
		// 编号值
		int i = sc.nextInt();
		switch (i) {
		case 1:
			addStu();
			break;
		case 2:
			findStu();
			break;
		case 3:
			updateStu();
			break;
		case 4:
			delStu();
			break;
		case 5:
			exit();
			break;

		default:
			break;
		}
	}

	private static void addStu() {
		System.out.println("请输入你要添加学生的具体信息，以逗号分隔，依次输入姓名、年龄、性别、班级");
		Scanner sc = new Scanner(System.in);
		String string = sc.next();
		String[] information = string.split(",");
		if (4 == information.length) {
			Student student = new Student();
			student.setName(information[0]);
			student.setAge(Integer.parseInt(information[1]));
			student.setGender(information[2]);
			student.setClassroom(information[3]);
			list.add(student);
			System.out.println("添加成功");
			operation();
		} else {
			System.out.println("你输入的信息有误，请重试");
			addStu();
		}
	}

	private static void findStu() {
		System.out.println("请选择查询模式");
		System.out.println("1.查询所有");
		System.out.println("2.单个查询");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		if (1 == i) {
			System.out.println("学生列表：");
			for (Object object : list) {
				System.out.println(object);
			}
			operation();
		} else if (2 == i) {
			System.out.println("请输入你要查询的学生姓名");
			Scanner scanner = new Scanner(System.in);
			String name = scanner.next();
			for (Object object : list) {
				Student student = (Student) object;
				if (student.getName().equals(name)) {
					System.out.print("找到学生" + name);
					System.out.println(student);
					operation();
				}
			}
			System.out.println("未找到学生" + name);
			findStu();
		} else {
			System.out.println("你的输入有误，请重试");
			findStu();
		}

	}

	private static void updateStu() {
		System.out.println("请输入你所要修改的学生姓名");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		for (Object object : list) {
			Student student = (Student) object;
			if (student.getName().equals(name)) {
				System.out.println("请输入你要修改的信息，以逗号分隔，注意，姓名不能修改");
				Scanner scanner = new Scanner(System.in);
				String string = scanner.next();
				String[] strings = string.split(",");
				student.setAge(Integer.parseInt(strings[0]));
				student.setGender(strings[1]);
				student.setClassroom(strings[2]);
				System.out.println("修改成功");
				operation();
			}
		}
		System.out.println("你输入的有误，请重试");
		updateStu();
	}

	private static void delStu() {
		System.out.println("请选择你要的删除模式");
		System.out.println("1.删除所有");
		System.out.println("2.单个删除");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		if (1 == i) {
			list.clear();
			System.out.println("删除成功");
			operation();
		} else if (2 == i) {
			System.out.println("请输入你要删除的学生姓名");
			Scanner sc = new Scanner(System.in);
			String name = sc.next();
			ListIterator iterator = list.listIterator();
			while (iterator.hasNext()) {
				Student stu = (Student) iterator.next();
				if (stu.getName().equals(name)) {
					iterator.remove();
					System.out.println("删除成功");
				} else {
					continue;
				}
				operation();
			}
			System.out.println("你要删除的学生不存在");
			delStu();
		} else {
			System.out.println("你的输入有误，请重试");
			delStu();
		}
	}

	private static void exit() {
		System.out.println("你确定要退出吗？输入Y以表确定");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.next();
		if ("Y".equals(string)) {
			System.out.println("退出成功");
			System.exit(0);
		} else {
			operation();
		}
	}
}
