package customexceptions;

public class EmptyShopException extends Exception {
    public EmptyShopException(String errorMessage) {
        super(errorMessage);
    }
}
