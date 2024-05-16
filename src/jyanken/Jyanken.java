package jyanken;

import java.util.Random;
import java.util.Scanner;

public class Jyanken {
	private Scanner scanner;
	private String myChoise;
	private String partnerChoise;
	
//	ゲームを開始するメソッド
	public void startGame() {
		System.out.println("自分のじゃんけんの手を入力しましょう");
		System.out.println("グーはrockのrを入力しましょう");
		System.out.println("チョキはscissorsのsを入力しましょう");
		System.out.println("パーはpaperのpを入力しましょう");
		myChoise = getMyChoice();
		partnerChoise = getPartnerChoise();
		System.out.println("自分の手は" + myChoise + ",対戦相手の手は" + partnerChoise);
		judgeGame(myChoise, partnerChoise);
	}
	
//	自分の手を決めるメソッド
	private String getMyChoice() {
		scanner = new Scanner(System.in);
		String myChoise = scanner.next();
		do {
			if (myChoise.equals("r")) {
				myChoise = "グー";
			} else if (myChoise.equals("s")) {
				myChoise = "チョキ";
			} else if (myChoise.equals("p")) {
				myChoise = "パー";
			} else {
				System.out.println("入力された値が不正です");
				System.out.println("もう一度入力してみてください");
				myChoise = "不正";
			}
		} while (myChoise.equals("不正"));
		return myChoise;
	}
	
//	相手の手を決めるメソッド
	private String getPartnerChoise() {
		Random random = new Random();
		int num = (random.nextInt(3) + 1);
		switch (num) {
		  case 1: {
			partnerChoise = "グー";
			break;
		} case 2: {
			partnerChoise = "チョキ";
			break;
		} case 3: {
			partnerChoise = "パー";
			break;
			}
		}
		return partnerChoise;
	}
	
//	勝負を判定するメソッド
	private void judgeGame(String myChoise, String partnerChoise) {
		if ((myChoise.equals("グー") && partnerChoise.equals("チョキ")) || (myChoise.equals("チョキ") && partnerChoise.equals("パー"))  || (myChoise.equals("パー") && partnerChoise.equals("グー"))) {
			System.out.println("自分の勝ちです");
		} else if ((myChoise.equals("グー") && partnerChoise.equals("パー")) || (myChoise.equals("チョキ") && partnerChoise.equals("グー"))  || (myChoise.equals("パー") && partnerChoise.equals("チョキ"))) {
			System.out.println("相手の勝ちです");
		} else {
			System.out.println("あいこです");
			startGame();
		}
		
	}
	
}
