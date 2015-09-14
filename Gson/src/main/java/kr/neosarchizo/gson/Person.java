package kr.neosarchizo.gson;

/**
 * Created by JunhyukLee on 15. 9. 14..
 */
public class Person {

    private String name;
    private String sex;
    private int age;

    @Override
    public String toString() {
        return "name : " + name + "\nsex : " + sex + "\nage : "+ age;
    }
}
