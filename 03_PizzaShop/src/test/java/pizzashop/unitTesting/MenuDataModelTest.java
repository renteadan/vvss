package pizzashop.unitTesting;

import org.junit.jupiter.api.Test;
import pizzashop.model.MenuDataModel;

import static org.junit.jupiter.api.Assertions.*;

class MenuDataModelTest {

    @Test
    public void testGetters() {
        MenuDataModel menuDataModel = new MenuDataModel("1", 1, 2d);

        assertEquals("1", menuDataModel.getMenuItem());
        assertEquals(1, menuDataModel.getQuantity());
        assertEquals(2d, menuDataModel.getPrice());
    }

    @Test
    public void testSetters() {
        MenuDataModel menuDataModel = new MenuDataModel("0", 0, 0d);

        menuDataModel.setMenuItem("1");
        menuDataModel.setQuantity(1);
        menuDataModel.setPrice(2d);

        assertEquals("1", menuDataModel.getMenuItem());
        assertEquals(1, menuDataModel.getQuantity());
        assertEquals(2d, menuDataModel.getPrice());
    }
}