package lab01.tdd;

public class MultipleStrategy implements SelectStrategy {

	private int multiplier = 1;

	public MultipleStrategy(){

	}

	public MultipleStrategy(int num){
		this.multiplier = num;
	}

	@Override
	public boolean apply(int element) {
		return element % multiplier == 0;
	}

	public void setMultiplier(int num){
		this.multiplier = num;
	}
}
