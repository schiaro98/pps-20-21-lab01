package lab01.tdd;

public class StrategyFactoryImpl implements StrategyFactory {

	@Override
	public SelectStrategy createEvenStrategy() {
		return new EvenStrategy();
	}

	@Override
	public SelectStrategy createOddStrategy() {
		return new OddStrategy();
	}

	@Override
	public SelectStrategy createMultipleStrategy() {
		return new MultipleStrategy();
	}

	@Override
	public SelectStrategy createEqualStrategy() {
		return new EqualStrategy();
	}
}
