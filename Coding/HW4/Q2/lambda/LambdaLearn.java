//package Chuwa20241209.Coding.HW4.Q2.lambda;
//
//import org.junit.Test;
////import com.chuwa.tutorial.t00_common.pojos.Employee;
////import com.chuwa.tutorial.t00_common.utils.EmployeeData;
//
//public class LambdaLearn {
//
//    @Test
//    public void overrideFoo() {
//
//        // Anonymous class
//        Foo fooByIC = new Foo() {
//            @Override
//            public String aMethod(String string) {
//                return string + " from Foo - not default";
//            }
//        };
//
//        String hello = fooByIC.aMethod("hello");
//        System.out.println(hello);
//    }
//
//    @Test
//    public void lambdaFoo() {
//        // More concise than Anonymous class above
//        Foo foo = parameter -> parameter + " from Foo - not default - lambda";
//
//        String hello = foo.aMethod("hello");
//        System.out.println(hello);
//    }
//
//    @Test
//    public void lambdaFoo2() {
//        // Can offer more method bodies
//        Foo foo = parameter -> parameter.toUpperCase() + " from Foo";
//
//        String hello = foo.aMethod("hello");
//        System.out.println(hello);
//    }
//
//    @Test
//    public void testFinal() {
//        final String localVariable = "Local";
//        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
//        };
//
//        System.out.println(foo.aMethod("hello"));
//    }
//
//    // Effectively Final Variables
//    @Test
//    public void testEffectivelyFinal() {
//        String localVariable = "Local";
//        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
//        };
//        // no localVariable changes
//        System.out.println(foo.aMethod("hello"));
//    }
//
//    @Test
//    public void testFinal21() {
//        String localVariable = "Local";
//        // localVariable changes -> error
//        localVariable = "LOCAL";
//
//        Foo foo = parameter -> {
////            return parameter + " " + localVariable;
//            return parameter;
//        };
//
//        System.out.println(foo.aMethod("hello"));
//    }
//
//    @Test
//    public void testFinal22() {
//        String localVariable = "Local";
//
//        Foo foo = parameter -> {
////            return parameter + " " + localVariable;
//            return parameter;
//        };
//
//        localVariable = "LOCAL"; // new addr
//
//        System.out.println(foo.aMethod("hello"));
//    }
//
//
////    @Test
////    public void testFinal3() {
////        List<Employee> employees = EmployeeData.getEmployees();
////
////        Employee employee = employees.get(0);
////        employee.setAge(55);
////        Foo foo = parameter -> {
////            return parameter + " " + employee;
////        };
////
////        System.out.println(foo.aMethod("hello"));
////    }
//}
