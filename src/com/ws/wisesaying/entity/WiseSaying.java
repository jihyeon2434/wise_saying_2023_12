package com.ws.wiseSaying.entity;

public class WiseSaying { // 입력된 명언 정보들을 모아 저장하기 위해 만들어 논 클래스 
	private int id; //wiseSaying에 id 변수값을 저장하기 위해 쓰임
	private String content; //wiseSaying에 content 변수값을 저장하기 위해 쓰임
	private String author; //wiseSaying에 author 변수값을 저장하기 위해 쓰임

	public WiseSaying(int id, String content, String author) { 
		this.id = id; // 입력받은 id 받아와서 본 클래스에 id 저장할 수 있도록 넘김
		this.content = content; // 입력받은 content 받아와서 본 클래스에 content 저장할 수 있도록 넘김
		this.author = author; // 입력받은 author 받아와서 본 클래스에 author 저장할 수 있도록 넘김
	}

	public int getId() { // private로 묶여있는 이 클래스 id를 다른 클래스에서 쓸수있게 만들어줌
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() { //// private로 묶여있는 이 클래스 content를 다른 클래스에서 쓸수있게 만들어줌
		return content;
	}

	public void setContent(String content) { 
		this.content = content;
	}

	public String getAuthor() { // // private로 묶여있는 이 클래스 author를 다른 클래스에서 쓸수있게 만들어줌
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}