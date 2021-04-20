package pizzashop.unitTesting;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.service.PizzaService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PizzaServiceTest3 {
    private PizzaService pizzaService;

    @Test
    public void testAdd() throws Exception {
        pizzaService = mock(PizzaService.class);

        Mockito.when(pizzaService.addPayment(1, PaymentType.Card, 20d)).thenReturn(true);
        Mockito.when(pizzaService.addPayment(3, PaymentType.Card, 30d)).thenReturn(true);
        Mockito.when(pizzaService.addPayment(4, PaymentType.Cash, 40d)).thenReturn(true);

        pizzaService.addPayment(1, PaymentType.Card, 20d);
        pizzaService.addPayment(3, PaymentType.Card, 30d);
        pizzaService.addPayment(4, PaymentType.Cash, 40d);

        Mockito.verify(pizzaService).addPayment(1, PaymentType.Card, 20d);
        Mockito.verify(pizzaService).addPayment(3, PaymentType.Card, 30d);
        Mockito.verify(pizzaService).addPayment(4, PaymentType.Cash, 40d);

    }

    @Test
    public void testTotalAmount() throws Exception {
        pizzaService = mock(PizzaService.class);

        pizzaService.addPayment(1, PaymentType.Card, 20d);
        pizzaService.addPayment(3, PaymentType.Card, 30d);
        pizzaService.addPayment(4, PaymentType.Cash, 40d);

        Mockito.when(pizzaService.getTotalAmount(PaymentType.Card)).thenReturn(50d);

        pizzaService.getTotalAmount(PaymentType.Card);

        Mockito.verify(pizzaService).getTotalAmount(PaymentType.Card);
    }

}