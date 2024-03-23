public class NotUniqueNameException extends RuntimeException {
    public NotUniqueNameException(String dzialName) {
        super(dzialName + " is not a unique name");
    }
}
