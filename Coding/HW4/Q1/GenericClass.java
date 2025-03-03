package Chuwa20241209.Coding.HW4.Q1;

public class GenericClass<T> {
    // T from argument
    T obj;

    public GenericClass(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return this.obj;
    }
}
