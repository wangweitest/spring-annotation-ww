package com.ww.bean;

public class Person {
	
	//ʹ��@Value��ֵ��
	//1��������ֵ
	//2������дSpEL�� #{}
	//3������д${}��ȡ�������ļ���properties���е�ֵ�������л������������ֵ��
	
	private String name;
	private Integer age;
	private String nickName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {
		super();
	}
	
}
