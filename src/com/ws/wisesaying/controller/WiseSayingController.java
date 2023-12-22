package com.ws.wiseSaying.controller;

import java.util.List;

import com.ws.Container;
import com.ws.Rq;
import com.ws.wiseSaying.entity.WiseSaying;
import com.ws.wiseSaying.service.WiseSayingService;

public class WiseSayingController {

	private WiseSayingService wiseSayingService;

	public WiseSayingController() {
		wiseSayingService = new WiseSayingService();
	}

	public void write() { // 사용자가 명언 정보를 등록하고 싶고 app클래스 switch문에서 actioncode가 등록과 일치할 때 실행
		System.out.print("명언 : "); // 명언 이름을 받기 전 앞에 명언 글자입력용
		String content = Container.getScanner().nextLine().trim(); // 명언 입력용
		System.out.print("작가 : "); // // 명언 이름을 받기 전 앞에 작가 입력용
		String author = Container.getScanner().nextLine().trim();// 작가이름 입력용

		int id = wiseSayingService.write(content, author); // 위에서 입력받은 명언과 작가 묶음

		System.out.printf("%d번 명언이 등록되었습니다.\n", id); // 위줄에서 묶인 명언 작가에 해당하는 번호를 받아서 숫자로 표현하기 위함
	}

	public void list() { // 
		List<WiseSaying> wiseSayings = wiseSayingService.findAll();

		System.out.println("번호  /  작가  /  명언  "); // 번호, 작가, 명언을 나눠 보여주기 위한 첫번째 구조화로 구성을 3개로 나눈 문장 출력
		System.out.println("=".repeat(30)); // = 30번 반복

		for (int i = wiseSayings.size() - 1; i >= 0; i--) { // wiseSayings의 숫자는 실제 값이 들어있는 칸의 번호보다 1 많으니까 -1을 해서 
			WiseSaying ws = wiseSayings.get(i);             // 해당 숫자 칸에 있는 내용을 가져오기 위함

			System.out.printf("%d  /  %s  /  %s\n", ws.getId(), ws.getAuthor(), ws.getContent()); // 칸 숫자에 맞는 내용 출력
		}
	}

	public void remove(Rq rq) { // 

		int id = rq.getIntParam("id", -1);

		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);

		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 삭제
		wiseSayingService.remove(wiseSaying);

		System.out.printf("%d번 명언이 삭제되었습니다.\n", id);

	}

	public void modify(Rq rq) {
		int id = rq.getIntParam("id", -1);

		if (id == -1) {
			System.out.println("id(정수)를 제대로 입력해주세요");
			return;
		}
		// 입력된 id와 일치하는 명언 객체 찾기
		WiseSaying wiseSaying = wiseSayingService.findById(id);

		if (wiseSaying == null) {
			System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
			return;
		}

		// 찾은 명언 객체를 object기반으로 수정
		System.out.println("명언(기존) :" + wiseSaying.getContent());
		System.out.println("작가(기존) :" + wiseSaying.getAuthor());

		System.out.print("명언 : ");
		String content = Container.getScanner().nextLine().trim();
		System.out.print("작가 : ");
		String author = Container.getScanner().nextLine().trim();

		wiseSayingService.modify(wiseSaying, content, author);

		System.out.printf("%d번 명언이 수정되었습니다.\n", id);

	}

}