package lambda;

import org.junit.Test;

import java.util.List;

public class LambdaLearn {

    @Test
    public void overrideFoo() {
        Foo fooByIC = new Foo() {
            @Override
            public String aMethod(String s) {
                return s + " by FooIC";
            }
        };

        String hello = fooByIC.aMethod("Hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo() {
        Foo fooByLambda = s -> s + " by FooLambda";
        String hello = fooByLambda.aMethod("Hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo2() {
        Foo fooByLambda = s -> s.toUpperCase() + " by FooLambda2";
        String hello = fooByLambda.aMethod("Hello");
        System.out.println(hello);
    }

    // final
    @Test
    public void testFinal() {
        final String finalString = " by FooLambda2";
        Foo fooByLambda = s -> s.toUpperCase() + finalString;
        String hello = fooByLambda.aMethod("Hello");
        System.out.println(hello);
    }

    /**
     * Use “Effectively Final” Variables
     * 当variable只赋值一次，没有任何变动的时候，Java默认是final。
     * 注意，在lambda expression的前后都不能被改变
     */
    @Test
    public void testEffectiveFinal() {
        String finalString = " by FooLambda2";
        Foo fooByLambda = s -> s.toUpperCase() + finalString;
        String hello = fooByLambda.aMethod("Hello");
        System.out.println(hello);
    }

    /**
     * 换object会报错，因为换了内存地址
     */
    @Test
    public void testFinal21() {
        String localVariable = "Local";
        localVariable = "LOCAL"; // 新的内存地址

        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal22() {
        String localVariable = "Local";

        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        localVariable = "LOCAL"; // 新的内存地址

        System.out.println(foo.aMethod("hello"));
    }
    /**
     * Object 的set方法不会报错
     */
    @Test
    public void testFinal3() {
        List<Employee> employees = EmployeeData.getEmployees();

        Employee employee = employees.get(0);
        employee.setAge(55);
        Foo foo = parameter -> {
            return parameter + " " + employee;
        };

        System.out.println(foo.aMethod("hello"));
    }
}
