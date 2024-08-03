package Lambda;

@FunctionalInterface
public interface StaticInterface {
    Integer strToInt(String str);

    default Boolean judgeSuffix(String str) {
        return null;
    }
}
