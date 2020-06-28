package servlet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private String gender;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    @JsonIgnore
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Test
    public void test1() throws JsonProcessingException {
        Person p = new Person();
        p.setName("张三");
        p.setAge(20);
        p.setGender("boy");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);

        List<Person> ps = new ArrayList<>();
        ps.add(p);
        ps.add(p);
        ps.add(p);
        System.out.println(mapper.writeValueAsString(ps));
    }
}
