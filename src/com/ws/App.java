package com.ws;

import com.ws.system.controller.SystemController;
import com.ws.wiseSaying.controller.WiseSayingController;

public class App {

	private byte system_status = 1;

	public App() {

	}

	public void run() { // 메인클래스에서 run을 실행해서 아래의 메서드 바디 내용을 실행하기 위함 
		System.out.println("== 명언 앱 실행 =="); // 첫 문장으로 출력됨 

		SystemController systemController = new SystemController(); // systemcontroller에 담긴 메서드를 연결해서 
		WiseSayingController wiseSayingController = new WiseSayingController();

		while (system_status == 1) {
			System.out.print("명령어 ) ");
			String cmd = Container.getScanner().nextLine().trim();
			Rq rq = new Rq(cmd);

			switch (rq.getActionCode()) {
			case "종료":
				systemController.exit();
				system_status = 0;
				break;
			case "등록":
				wiseSayingController.write();
				break;
			case "목록":
				wiseSayingController.list();
				break;
			case "삭제":
				wiseSayingController.remove(rq);
				break;
			case "수정":
				wiseSayingController.modify(rq);
				break;
			default:
				System.out.println("존재하지 않는 명령어입니다");
				break;
			}
		}

	}
}