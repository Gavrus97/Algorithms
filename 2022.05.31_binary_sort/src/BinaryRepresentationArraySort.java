import java.util.Arrays;

public class BinaryRepresentationArraySort {


    // Имеется список положительных Integer (>0). Необходимо отсортировать их таким образом,
    // что сначала идут числа с наименьшем количеством единиц в двоичной записи числа.
    // Если по этому параметру числа совпадают, то сначала идут меньшие числа. Пример
    // {5, 8, 2, 4, 3, 128} -> {101, 1000, 10, 100, 11, 10000000} ->
    // {10, 100, 1000, 10000000, 11, 101} ->{2, 4, 8, 128, 3, 5}
    // 128. Каунтер = 0. Если 128 не делится на 2, то мы добавляем к каунтеру 1.
    // После чего делим 128 на 2 и повторяем таким образом, пока число > 0.

    public int[] sort(int[] array) {
        Node[] temp = makeNodes(array);
        Arrays.sort(temp);
        return makeArrayFromNodes(temp);
    }

    public void printArray(int[] array) {
        for (int n : array) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private Node[] makeNodes(int[] numbers) {
        Node[] res = new Node[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            res[i] = new Node(numbers[i], countOfOnes(numbers[i]));
        }
        return res;
    }

    private int[] makeArrayFromNodes(Node[] nodes) {
        int[] res = new int[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            res[i] = nodes[i].getValue();
        }
        return res;
    }

    private int countOfOnes(int number) {
        int count = 0;
        while (number > 0) {
            if (number % 2 == 1)
                count++;
            number /= 2;
        }
        return count;
    }
}


class Node implements Comparable<Node> {

    private final int value;
    private final int countOnes;

    Node(int value, int countOnes) {
        this.value = value;
        this.countOnes = countOnes;
    }

    public int getValue() {
        return value;
    }

    public int getCountOnes() {
        return countOnes;
    }



    @Override
    public int compareTo(Node o) {
        if (this.countOnes == o.countOnes)
            return Integer.compare(this.value, o.value);
        return Integer.compare(this.countOnes, o.countOnes);
    }
}
