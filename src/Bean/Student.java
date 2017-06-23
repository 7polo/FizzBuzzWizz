package Bean;

import rules.inter.IStrategy;

/**
 * Created by apologizebao on 2017/6/23.
 */
public class Student {
    private int id;

    public Student(int id) {
        this.id = id;
    }

    //传递报数策略给学生
    public void speak(IStrategy strategy){
        System.out.println(strategy.speak(id));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id == student.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
