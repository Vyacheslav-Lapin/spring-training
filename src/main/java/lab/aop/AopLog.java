package lab.aop;

public class AopLog {

    private static StringBuilder value = new StringBuilder();

    @SuppressWarnings({"WeakerAccess", "SameParameterValue"})
    public static void append(String str, Object... args) {
        append(String.format(str, args));
    }

    public static void append(String str){
        value.append(str);
    }

    public static String getStringValue(){
        return value.toString();
    }

    public static void clear(){
        value = new StringBuilder();
    }
}
