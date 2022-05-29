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

//    @Override
//    public boolean remove(Long elt) {
//        if(!map.containsKey(elt))
//            return false;
//
//        int index = map.get(elt);
//        list.remove(index);
//        map.remove(elt);
//
//        for (int i = index; i < list.size(); i++) {
//            map.put(list.get(i), i);
//        }
//        return true;
//    }

    @Override
    public boolean remove(Long elt) {
        if (!map.containsKey(elt))
            return false;

        map.remove(elt);
        return true;
    }

    @Override
    public Long getRandom() {
        if (list.size() == 0) {
            throw new EmptyCollectionException("Collection is empty. Add something!");
        }

        int index = rnd.nextInt(list.size());
        Long res = list.get(index);

        if (map.containsKey(res))
            return res;

        else return getRandom();
    }

    @Override
    public void printCollection() {
        System.out.print("[ ");
        for (int i = 0; i < list.size(); i++) {
            long number = list.get(i);
            if (map.containsKey(number))
                System.out.print(number + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}
