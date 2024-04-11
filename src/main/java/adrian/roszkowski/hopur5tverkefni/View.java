package adrian.roszkowski.hopur5tverkefni;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum View {
    MAIN("mainui-view.fxml"),
    CART("cart-view.fxml");

    private final String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
