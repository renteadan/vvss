package pizzashop.unitTesting;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pizzashop.model.MenuDataModel;
import pizzashop.repository.MenuRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class MenuRepositoryTest {
    private MenuRepository menuRepository;

    @Test
    public void testGet() {
        menuRepository = mock(MenuRepository.class);

        Mockito.when(menuRepository.getMenuItem("Margherita,8.00")).thenReturn(new MenuDataModel("Margherita", 0, 8.00d));

        menuRepository.getMenuItem("Margherita,8.00");

        Mockito.verify(menuRepository).getMenuItem("Margherita,8.00");
    }

    @Test
    public void testGetAll() {
        menuRepository = mock(MenuRepository.class);

        MenuDataModel menuDataModel1 = new MenuDataModel("Hawaii", 0, 7.49d);
        MenuDataModel menuDataModel2 = new MenuDataModel("Margherita", 0, 8.00d);
        MenuDataModel menuDataModel3 = new MenuDataModel("Funghi", 0, 11.50d);
        MenuDataModel menuDataModel4 = new MenuDataModel("Capricciosa", 0, 13.00d);
        MenuDataModel menuDataModel5 = new MenuDataModel("Quattro Stagioni", 0, 12.00d);
        MenuDataModel menuDataModel6 = new MenuDataModel("Marinara", 0, 12.00d);
        MenuDataModel menuDataModel7 = new MenuDataModel("Calzone", 0, 11.00d);
        MenuDataModel menuDataModel8 = new MenuDataModel("Rucola", 0, 12.5d);
        MenuDataModel menuDataModel9 = new MenuDataModel("Napolitana", 0, 10.00d);

        Mockito.when(menuRepository.getMenu()).thenReturn(Arrays.asList(menuDataModel1, menuDataModel2, menuDataModel3, menuDataModel4, menuDataModel5, menuDataModel6, menuDataModel7, menuDataModel8, menuDataModel9));

        menuRepository.getMenu();

        Mockito.verify(menuRepository).getMenu();
    }
}