package study.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jiava
 * @Description DOING
 * @date 2022-12-09-9:56
 */
public class StreamToMap {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("1");
            list.add("2");
            list.add("3");
        }
        List<HashMap<String, String>> collect = list.stream().map(res -> {
            HashMap<String, String> map = new HashMap<>();
            map.put(res, res);
            return map;
        }).collect(Collectors.toList());


    }
}
