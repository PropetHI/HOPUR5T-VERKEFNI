package tests;

import database.Mock;
import org.junit.jupiter.api.BeforeEach;

public class ServiceInteractor_Test {

    Mock mockObject;
    @BeforeEach
    void initializeTests() {
        mockObject = new Mock();
    }
}
