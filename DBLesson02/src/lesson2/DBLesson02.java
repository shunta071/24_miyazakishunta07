package lesson2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DBLesson02{
	public static void main(String[] args) {

		List<Word>lists = new ArrayList<>();
		WordDAO dao = new WordDAO();


		// コマンドラインから入力
		System.out.println("英単語と日本語をスペースで区切って入力して下さい。");
		Scanner sc  = new Scanner(System.in);
		String input = sc.nextLine(); //inputに入力値を読み込む

			int index = 0;
			while(!input.equals("e")){
				String[] tmp = new String[2];
				tmp = input.split(" ");
				lists.add(new Word(tmp[0], tmp[1]));
				index++;
				System.out.println("英単語と日本語をスペースで区切って入力して下さい。 \"e\"で終了します。");
				input = sc.nextLine();
			}

			int result = dao.registWord(lists);
			System.out.println( index + "件、登録しました。");


		List<Word> wResult = new ArrayList<>();
		wResult = dao.getWords();


		int wordNum = 0;
		for(Word tmp : wResult){
			System.out.println(tmp);
			wordNum++;
		}
		System.out.println("\n 登録されている単語は" + wordNum + "件です。");
	}

}
