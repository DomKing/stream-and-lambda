package org.prcode.functional.stream.middle.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentComparable implements Comparable<StudentComparable> {

    private String name;
    private int age;

    @Override
    public int compareTo(StudentComparable o) {
        return this.age - o.getAge();
    }

}
