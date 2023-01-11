package study.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2023-01-04-14:24
 */
class User{
    String name;
    String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
public class StreamToList {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setAge("12");
        user1.setName("zhangsan");
        User user = new User();
        user.setAge("18");
        user.setName("zidong");
        userList.add(user);
        userList.add(user1);
        String collect = userList.stream().map(User::getAge).collect(Collectors.joining(","));
        System.out.println(collect);
    }
}
