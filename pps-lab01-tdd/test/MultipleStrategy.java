import lab01.tdd.SelectStrategy;

public class MultipleStrategy implements SelectStrategy {

	private int multiplier = 1;

	@Override
	public boolean apply(int element) {
		return element % multiplier == 0;
	}

	public void setMultiplier(int num){
		this.multiplier = num;
	}
}
