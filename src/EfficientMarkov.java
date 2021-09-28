import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;
	
	public EfficientMarkov(){
		this(3);
		myMap.clear();

	}

	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}

	@Override
	public void setTraining(String text) {
		super.setTraining(text);

		for (int i = 0; i <= text.length() - this.getOrder(); i++) {
			String sub = text.substring(i, i + this.getOrder());

			if (i < text.length() - this.getOrder()) {
				if (!myMap.containsKey(sub)) {
					ArrayList<String> val = new ArrayList<>();
					val.add(text.substring(i + this.getOrder(), i + this.getOrder() + 1));
					myMap.put(sub, val);
				} else if (myMap.containsKey(sub)){
					myMap.get(sub).add(text.substring(i + this.getOrder(), i + this.getOrder() + 1));
				}
			} else {
				if (!myMap.containsKey(sub)) {
					ArrayList<String> val = new ArrayList<>();
					val.add(PSEUDO_EOS);
					myMap.put(sub, val);
				} else if (myMap.containsKey(sub)){
					myMap.get(sub).add(PSEUDO_EOS);
				}
			}
		}
	}

	@Override
	public ArrayList<String> getFollows(String key) {
		if (myMap.containsKey(key)) {
			return myMap.get(key);
		} else {
			throw new NoSuchElementException(key + " not in map");
		}
	}
}	
