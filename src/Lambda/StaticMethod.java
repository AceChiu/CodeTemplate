package Lambda;

public class StaticMethod {
    public static void main(String[] args) {
       StaticInterface instance = new StaticInterface() {
           @Override
           public Integer strToInt(String str) {
               // Static Method
               return Integer.parseInt(str);
           }

           @Override
           public Boolean judgeSuffix(String str) {
               return null;
           }
       };

       StaticInterface instance2 = str -> Integer.parseInt(str);
       StaticInterface instance3 = Integer::parseInt;

       System.out.println(instance.strToInt("13") == 13);
       System.out.println(instance2.strToInt("13") == 13);
       System.out.println(instance3.strToInt("13") == 13);
    }
}
