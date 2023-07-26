package calculator.lldwb.top.stream;

import java.util.ArrayList;
import java.util.List;

public class WithStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        int sum = numbers.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .reduce(0, Integer::sum);

        System.out.println("使用Stream的平方和为：" + sum);
    }
}
