package lesson2;

// フィールド
public class Word{
	private String english;  // 英語
	private String japanese; // 日本語


	// コンストラクタ
	public Word(String english, String japanese){
		this.english = english;
		this.japanese = japanese;
	}

	// メソッド
	public String getEnglish(){
		return this.english;
	}
	public void setEnglish(String english){
		this.english= english;
	}
	public String getJapanese(){
		return this.japanese;
	}
	public void setJapanese(String japanese){
		this.japanese= japanese;
	}

	public String toString(){
		return "英単語:" + this.english +"  " + "日本語：" + this.japanese;
	}
}

