import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        System.out.println(checkTheLine3("Helo"));
        System.out.println(checkTheLine3("Hello"));
//        System.out.println(findNumberOfPlatforms(new String[]{"1:00", "1:30", "1:50", "2:00", "4:00"},
//                new String[]{"1:10", "3:00", "2:20", "2:30", "6:00"}));
    }

    //1.написать метод, проверяющий все ли символы в строке являются уникальными. Строка
    //состоит только из  букв английского алфавита.
    //Сложность метода не должна быть больше О(n) .  решить тремя способами

    public static boolean checkTheLine1(String line) {
        Set<String> set = Stream.of(line)
                .flatMap(x -> Arrays.stream(x.split("")))
                .collect(Collectors.toSet());
        return set.size() == line.length();
    }

    public static boolean checkTheLine2(String line) {
        Map<String, Integer> map = new HashMap<>();

        String[] strings = line.split("");
        for (String s : strings) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        return map.entrySet().stream()
                .filter(x -> x.getValue() > 1)
                .count() == 0L;
    }

    //using only String methods
    public static boolean checkTheLine3(String line) {
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (line.indexOf(c) != line.lastIndexOf(c))
                return false;
        }
        return true;
    }

    // using ascii
    public static boolean checkTheLine4(String line) {
        boolean[] chars26 = new boolean[26];

        for (int i = 0; i < line.length(); i++) {
            int asciiCode = (int) line.toUpperCase().charAt(i) - 65;

            if (!chars26[asciiCode]) {
                chars26[asciiCode] = true;
            } else {
                return false;
            }
        }
        return true;
    }


    //2. Посчитать минимальное количество платформ, необходимых
    //для железнодорожной станции  для приема всех приходящих по расписанию поездов.
    //Дано: время прибытия и отправления поезда
    //arrival[]={1:00,1:30,1:50;2:00;4:00} упорядочено.
    //departure[]={1:10,3:00,2:20;2:30;6:00}
    //решить со сложностью ниже чем O(n^2)

    public static int solution(int[] arrivals, int[] departures){
        int neededPlatforms = 0;
        int maxPlatforms = 0;
        Arrays.sort(departures);
        int i = 0;
        int j = 0;

        while(i < arrivals.length && j < departures.length){
             if(arrivals[i] < departures[j]){
                 neededPlatforms++;
                 i++;
                 if(neededPlatforms > maxPlatforms)
                     maxPlatforms = neededPlatforms;
             }
             else{
                 neededPlatforms--;
                 j++;
             }
        }
        return maxPlatforms;
    }


    public static int findNumberOfPlatforms(String[] arrivals, String[] departures) {

        List<Time> times = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");

        for (int i = 0; i < arrivals.length; i++) {
            TrainSchedule t = new TrainSchedule(LocalTime.parse(arrivals[i], formatter), LocalTime.parse(departures[i], formatter));
            times.add(new Time(t.getIn(), true));
            times.add(new Time(t.getOut(), false));
        }

        Collections.sort(times);
        int res = 0;
        int count = 0;
        for (Time time : times) {
            if (time.isIn) {
                count++;
            } else {
                if (res < count)
                    res = count;
                count--;
            }
        }
        return res;

    }

    private static class TrainSchedule implements Comparable<TrainSchedule> {
        private final LocalTime in;
        private final LocalTime out;

        private TrainSchedule(LocalTime in, LocalTime out) {
            this.in = in;
            this.out = out;
        }

        public LocalTime getIn() {
            return in;
        }

        public LocalTime getOut() {
            return out;
        }

        @Override
        public int compareTo(TrainSchedule o) {
            return this.getIn().compareTo(o.getIn());
        }
    }

    private static class Time implements Comparable<Time> {
        private final LocalTime time;
        private final boolean isIn;

        private Time(LocalTime time, boolean isIn) {
            this.time = time;
            this.isIn = isIn;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) {
                if (this.isIn && !o.isIn)
                    return -1;
                else if (!this.isIn && o.isIn)
                    return 1;
                else
                    return -1;
            }

            return this.time.compareTo(o.time);
        }
    }

    //3.Есть лист положительных целых чисел нечетной длины >=3 . Известно, что существует
    //индекс элемента, такой что сумма всех  элементов  слева от него равняется сумме
    //всех элементов справа от него. Найти этот индекс. решить задачу эффективно
    //со сложностью О(n)

    public static int balancedSum(List<Integer> ints) {
        int sum = ints.stream()
                .mapToInt(Integer::intValue)
                .sum();
        int lastPossiblePivotIndex = ints.size() - 2;
        int leftSum = ints.get(0);
        int pivotIndex = 0;

        for (int i = 1; i <= lastPossiblePivotIndex; i++) {
            int currentNum = ints.get(i);

            if (leftSum == sum - currentNum - leftSum)
                pivotIndex = i;
            leftSum += currentNum;
        }
        return pivotIndex;
    }


}

