import java.util.Comparator;
import java.util.List;

public class BinaryRepresentationListSort {

    // Имеется список положительных Integer (>0). Необходимо отсортировать их таким образом,
    // что сначала идут числа с наименьшем количеством единиц в двоичной записи числа.
    // Если по этому параметру числа совпадают, то сначала идут меньшие числа. Пример
    // {5, 8, 2, 4, 3, 128} -> {101, 1000, 10, 100, 11, 10000000} ->
    // {10, 100, 1000, 10000000, 11, 101} ->{2, 4, 8, 128, 3, 5}
    // 128. Каунтер = 0. Если 128 не делится на 2, то мы добавляем к каунтеру 1.
    // После чего делим 128 на 2 и повторяем таким образом, пока число > 0.

    public void sortByBinaryOnesAndValue(List<Integer> numbers) {
        numbers.sort(Comparator.comparing(this::getBinaryOnes).thenComparing(Integer::compare));
    }

    private int getBinaryOnes(int number) {
        int counter = 0;
        while (number > 0) {
            if (number % 2 != 0)
                counter++;
            number /= 2;
        }
        return counter;
    }
}
