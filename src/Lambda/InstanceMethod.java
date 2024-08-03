package Lambda;

import java.util.List;

public class InstanceMethod {
    public static void main(String[] args) {

        String s = "sample.jpg";

        InstanceInterface instance = new InstanceInterface() {
            @Override
            public Boolean judgeSuffix(String str) {
                return s.endsWith(str); // instance method
            }
        };
        InstanceInterface instance2 = str -> s.endsWith(str);
        InstanceInterface instance3 = s::endsWith;

        System.out.println(instance.judgeSuffix(".jpg"));
        System.out.println(instance2.judgeSuffix(".jpg"));
        System.out.println(instance3.judgeSuffix(".jpg"));
    }
}
