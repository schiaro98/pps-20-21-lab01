import lab01.tdd.SelectStrategy;

public class EqualStrategy implements SelectStrategy {

	private int target = 1;

	@Override
	public boolean apply(int element) {
		return element == target;
	}

	public void setTarget(int num){
		this.target = num;
	}
}
