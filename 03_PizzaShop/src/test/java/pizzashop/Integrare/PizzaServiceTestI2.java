package pizzashop.Integrare;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pizzashop.model.MenuDataModel;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;
import pizzashop.service.PizzaService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PizzaServiceTestI2 {

    @Test
    void testService() throws Exception {
        //Arrange
        int t = 3;
        PaymentType paymentType = PaymentType.Card;
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        //Act
        boolean result = pizzaService.addPayment(t, paymentType, 20d);

        //Assert
        assertEquals(true, result);
    }

    @Test
    void testMenuRepository() {
        MenuRepository menuRepository = new MenuRepository();

        menuRepository.getMenu();

        assertEquals(new MenuDataModel("Margherita", 0, 8.00d), menuRepository.getMenuItem("Margherita,8.00"));
    }

    @Test
    public void testPaymentRepository() {
        PaymentRepository paymentRepository = new PaymentRepository();

        Payment payment1 = new Payment(1, PaymentType.Card, 20d);
        Payment payment2 = new Payment(2, PaymentType.Card, 40d);
        Payment payment3 = new Payment(3, PaymentType.Card, 30d);

        paymentRepository.add(payment1);
        paymentRepository.add(payment2);
        paymentRepository.add(payment3);

        assertEquals(3, paymentRepository.getAll().size());
    }

    @Test
    void testPayment() {
        Payment payment = mock(Payment.class);

        Mockito.doNothing().when(payment).setTableNumber(1);
        Mockito.doNothing().when(payment).setType(PaymentType.Cash);
        Mockito.doNothing().when(payment).setAmount(20d);

        payment.setTableNumber(1);
        payment.setType(PaymentType.Cash);
        payment.setAmount(20d);

        Mockito.verify(payment).setTableNumber(1);
        Mockito.verify(payment).setType(PaymentType.Cash);
        Mockito.verify(payment).setAmount(20d);
    }

    @Test
    void testMenuItem() {
        MenuDataModel menuDataModel = mock(MenuDataModel.class);

        Mockito.doNothing().when(menuDataModel).setMenuItem("a");
        Mockito.doNothing().when(menuDataModel).setPrice(20d);
        Mockito.doNothing().when(menuDataModel).setQuantity(0);

        menuDataModel.setMenuItem("a");
        menuDataModel.setPrice(20d);
        menuDataModel.setQuantity(0);

        Mockito.verify(menuDataModel).setMenuItem("a");
        Mockito.verify(menuDataModel).setPrice(20d);
        Mockito.verify(menuDataModel).setQuantity(0);
    }
}