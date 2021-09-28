import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class EfficientWordMarkov extends BaseWordMarkov{
    private Map<WordGram, ArrayList<String>> myMap;

    public EfficientWordMarkov(){
        this(3);
        myMap.clear();
    }

    public EfficientWordMarkov(int order) {
        super(order);
        myMap = new HashMap<>();
    }

    @Override
    public ArrayList<String> getFollows(WordGram kGram) {
        if (myMap.containsKey(kGram)) {
            return myMap.get(kGram);
        }

        throw new NoSuchElementException(kGram + " not in map");
    }

    @Override
    public void setTraining(String text) {
        myMap.clear();
        myWords = text.split("\\s+");

        for (int i = 0; i <= myWords.length - this.getOrder(); i++) {
            WordGram key = new WordGram(myWords, i, this.getOrder());

            if (i < myWords.length - this.getOrder()) {
                if (!myMap.containsKey(key)) {
                    ArrayList<String> val = new ArrayList<>();
                    val.add(myWords[i + this.getOrder()]);
                    myMap.put(key, val);
                } else if (myMap.containsKey(key)){
                    myMap.get(key).add(myWords[i + this.getOrder()]);
                }
            } else {
                if (!myMap.containsKey(key)) {
                    ArrayList<String> val = new ArrayList<>();
                    val.add(PSEUDO_EOS);
                    myMap.put(key, val);
                } else if (myMap.containsKey(key)){
                    myMap.get(key).add(PSEUDO_EOS);
                }
            }
        }
    }
}
