public class EmptyCollectionException extends RuntimeException {

    private final String s;

    public EmptyCollectionException(String s) {
        this.s = s;
    }

    public String getMessage(){
        return s;
    }
}
