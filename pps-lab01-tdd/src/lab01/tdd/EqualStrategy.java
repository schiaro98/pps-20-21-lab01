package lab01.tdd;

import lab01.tdd.SelectStrategy;

public class EqualStrategy implements SelectStrategy {

	private int target;

	public EqualStrategy(int num) {
		this.target = num;
	}

	public EqualStrategy(){

	}

	@Override
	public boolean apply(int element) {
		return element == target;
	}

	public void setTarget(int num){
		this.target = num;
	}
}
