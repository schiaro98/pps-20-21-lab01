package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

	final List<Integer> list = new ArrayList<>();
	int nextElement = 0;

	@Override
	public void add(int element) {
		list.add(element);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.size() == 0;
	}

	@Override
	public Optional<Integer> next() {
		if(list.isEmpty()){
			return Optional.empty();
		}
		Integer result;
		result = list.get(nextElement);
		nextElement++;

		if(nextElement == list.size()){
			reset();
		}
		return Optional.of(result);
	}

	@Override
	public Optional<Integer> previous() {
		if(list.isEmpty()){
			return Optional.empty();
		}
		if (nextElement == 0) {
			//Mi trovo a fine lista
			//Il previous è il penultimo elemento
			//Il next element diventa l'ultimo
			nextElement = list.size()-1;
			return Optional.ofNullable(list.get(nextElement-1));
		} else {
			if(nextElement == 1){
				//Mi trovo a inizio lista
				//Il previous è l'ultimo elemento
				//Il next element diventa il primo
				reset();
				return Optional.ofNullable(list.get(list.size()-1));
			} else {
				//Mi trovo dentro la lista (no inzio/fine)
				//Il previous è il next element - 2
				//Il next element diventa previous +1
				nextElement -= 1;
				return Optional.ofNullable(list.get(nextElement-1));
			}
		}
	}

	@Override
	public void reset() {
		nextElement = 0;
	}

	@Override
	public Optional<Integer> next(SelectStrategy strategy) {
		Optional<Integer> result = this.next();
		if(result.isPresent()){
			if(strategy.apply(result.get())){
				return result;
			} else {
				return next(strategy);
			}
		} else {
			return Optional.empty();
		}
	}
}
