package reflection;

import reflection.generics.LinkedList;

public class Test {
    public LinkedList<Integer> get() {
        Integer[] ints = {1, 2, 3, 4};
        return LinkedList.create(ints);
    }










//    Method[] declaredMethods = Test.class.getDeclaredMethods();
//        for (var method : declaredMethods) {
//        System.out.println(method.getReturnType().getTypeName());
//        ParameterizedType types = (ParameterizedType)method.getGenericReturnType();
//        for (var type : types.getActualTypeArguments()) {
//            System.out.println(type.getTypeName());
//        }
//
//    }
}