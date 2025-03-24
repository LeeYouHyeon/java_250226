package word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Word {
	private String word;
	private Map<String, ArrayList<String>> meanings = new HashMap<>();

	{
		// 각각의 품사에 대해 list를 초기화
		for (String type : Main.types) {
			meanings.put(type, new ArrayList<String>());
		}
	}

	public Word() {
	}

	public Word(String word) {
		this.word = word;
	}

	/* 단어 저장 예시
	 * smart
	 * 형용사
	 * 1. 눈치 빠른; 재치 있는, 영리한, 현명한; 조숙한(precocious); 건방진, 겉치레만의, 멋만의
	 * 2. 맵시 있는, 스마트한, <옷차림이> 말쑥한, 단정한, 멋있는
	 * 부사
	 * 1. (=SMARTLY)
	 * 자동사
	 * 1. 아리다, 따끔따끔 쓰리다
	 * 2. 괴로워하다, 상심하다; 양심에 찔리다
	 * */
	public String toString() {
		String result = "";
		result += word + "\n";
		for (String type : Main.types) {
			ArrayList<String> mean = meanings.get(type);
			if (!mean.isEmpty()) {
				result += type + "\n";
				for (int i = 0; i < mean.size(); i++) {
					result += (i + 1) + ". " + mean.get(i) + "\n";
				}
			}
		}

		return result;
	}

	public void addMeaning(String type, String meaning) {
		meanings.get(type).add(meaning);
	}

	// 등록된 뜻이 없으면 true, 있으면 false
	public boolean isEmpty() {
		for (String type : meanings.keySet()) {
			if (!meanings.get(type).isEmpty()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(word);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Map<String, ArrayList<String>> getMeanings() {
		return meanings;
	}
}
