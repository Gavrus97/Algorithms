import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CustomCollection implements ICustomCollection {

    private final List<Long> list;
    private final HashMap<Long, Integer> map;
    private final Random rnd;

    public CustomCollection() {
        this.rnd = new Random();
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }


    @Override
    public boolean add(Long elt) {
        if (!map.containsKey(elt)) {
            list.add(elt);
            map.put(elt, list.size() - 1);
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(Long elt) {
        if (!map.containsKey(elt))
            return false;

        int index = map.get(elt);
        long lastElt = list.get(list.size() - 1);

        list.set(index,lastElt);
        list.remove(list.size() - 1);
        map.put(lastElt, index);

        return true;
    }


    @Override
    public Long getRandom() {
        if (list.size() == 0) {
            throw new EmptyCollectionException("Collection is empty. Add something!");
        }

        int index = rnd.nextInt(list.size());
        return list.get(index);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
