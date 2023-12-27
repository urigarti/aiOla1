package customexceptions;

public class ShopItemNotFoundException extends Exception {

    public ShopItemNotFoundException(String itemTitle) {
        super("Shop Item with title: "  + itemTitle + " was not found.");
    }
}
