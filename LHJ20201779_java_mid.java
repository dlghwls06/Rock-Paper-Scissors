package ch01;

import java.util.Scanner;

public class LHJ20201779_java_mid {

	public static void main(String[] args) {
	String[] choices = {"가위", "바위", "보"};
	
	
	System.out.println("가위바위보 게임을 시작합니다.");
	
	
	Scanner scanner = new Scanner(System.in);
	boolean playagain = true;
	
	while (playagain) {
		System.out.println("가위, 바위, 보 중 하나를 선택하세요.");
		System.out.println("무엇을 내시겠습니까? ");
	
	String mychoice = scanner.nextLine();
	int computerchoice = (int) (Math.random() * 3);
	
	System.out.println("나 : " + mychoice);
	System.out.println("컴퓨터 : " +choices[computerchoice]);
	
	if (mychoice.equals(choices[computerchoice])) { 
		System.out.println("비겼습니다!");
	} else {
		switch (mychoice) {
			case "가위":
				if (choices[computerchoice].equals("바위")) {
					System.out.println("졌습니다!");
				} else {
					System.out.println("이겼습니다!");
				}
			break;
			
			case "바위":
				if (choices[computerchoice].equals("보")) {
					System.out.println("졌습니다!");
				} else {
					System.out.println("이겼습니다!");
					
				}
			break;
			
			case "보":
				if (choices[computerchoice].equals("가위")) {
					System.out.println("졌습니다!");
				} else {
					System.out.println("이겼습니다!");
				}
			break;
			
		default:
				System.out.println("잘못된 입력입니다.");
				String retryInput = scanner.nextLine();
				if (retryInput.equalsIgnoreCase("네")) {
					continue;
				} else {
					playagain = false;
				break;
				}
			}
		}
		System.out.println("게임을 더 하시겠습니까? 네/아니오");
		String playagainInput = scanner.nextLine();
		playagain = playagainInput.equalsIgnoreCase("네");

	}

	System.out.println("게임을 종료합니다.");
	
	}
}


