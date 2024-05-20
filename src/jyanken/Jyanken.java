package jyanken;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Jyanken {	
//	ゲームを開始するメソッド
	public void startGame() {
		HashMap<String, String> jyanken = new HashMap<>();
		jyanken.put("r", "グー");
		jyanken.put("s", "チョキ");
		jyanken.put("p", "パー");
		
		String myChoise = jyanken.get(getMyChoice());
		String partnerChoise = jyanken.get(getPartnerChoise());
		System.out.println("自分の手は" + myChoise + ",対戦相手の手は" + partnerChoise);
		judgeGame(myChoise, partnerChoise);
	}
	
//	自分の手を決めるメソッド
	private String getMyChoice() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("自分のじゃんけんの手を入力しましょう");
			System.out.println("グーはrockのrを入力しましょう");
			System.out.println("チョキはscissorsのsを入力しましょう");
			System.out.println("パーはpaperのpを入力しましょう");
			String myChoise = scanner.next();
			if (!(myChoise.equals("r") || myChoise.equals("s") || myChoise.equals("p"))) {
				System.out.println("グーのr、チョキのs、パーのpのどれかを入力してください");
				continue;
			} else {
				scanner.close();
				return myChoise;
			}
		}
	}
	
//	相手の手を決めるメソッド
	private String getPartnerChoise() {
		String[] partnerChoise = {"r", "s", "p"};
		Random random = new Random();
		int i = (random.nextInt(3) + 1);
		return partnerChoise[i];
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
