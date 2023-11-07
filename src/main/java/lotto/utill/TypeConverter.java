package lotto.utill;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TypeConverter {

    public static int stringToInt(String input){
        int result = Integer.parseInt(input);
        return result;
    }

    public static List<Integer> StringToIntegerList(String input){
        List<Integer> result = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return result;
    }
}