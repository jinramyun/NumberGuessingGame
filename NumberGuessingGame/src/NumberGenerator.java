
public class NumberGenerator {
	private int answer;
	
	public int getAnswer() {
		return answer;
	}
	
	public void changeAnswer() {
		answer = (int)(Math.random() * 20);
		
	}

}