package edu.northeastern.qian._function;


public class MyFunction {
    public static void main(String[] args) {
        convert("123",  s -> Integer.parseInt(s));

        convert("123", Integer::parseInt);

        convert(100, (i -> String.valueOf(i + 100)));//200

        convert("345", s -> Integer.parseInt(s), i -> String.valueOf(i + 5));
        convertToString("345", (s) -> {
            Integer i = Integer.parseInt(s);
            return String.valueOf(i + 5);
        });
    }

    // Function<T, R> T:输入类型， R：结果类型
    private static void convert (String s, java.util.function.Function<String, Integer> fun) {
        int i = fun.apply(s);
        System.out.println(i);
    }

    private static void convert (int i, java.util.function.Function<Integer , String> fun) {
        String s = fun.apply(i);
        System.out.println(s);
    }
    //    private static void convert (String s, Function<String, Integer> fun1, Function<Integer, String> fun2) {
//        Integer i = fun1.apply(s);
//        String str = fun2.apply(i);
//        System.out.println(str);
//    }
    private static void convert (String s, java.util.function.Function<String, Integer> fun1, java.util.function.Function<Integer, String> fun2) {
        String str = fun1.andThen(fun2).apply(s);
        System.out.println(str);
    }

    private static void convertToString (String s, java.util.function.Function<String, String> fun) {
        String str = fun.apply(s);
        System.out.println(str);
    }
}
