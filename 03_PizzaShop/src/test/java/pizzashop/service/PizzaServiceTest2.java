package pizzashop.service;

import org.junit.jupiter.api.Test;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import static org.junit.jupiter.api.Assertions.*;

class PizzaServiceTest2 {

    @Test
    void testP1() throws Exception {
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        pizzaService.setPayment(null);

        assertEquals(0d, pizzaService.getTotalAmount(PaymentType.Cash));
    }

    @Test
    void testP2() throws Exception {
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        assertEquals(0d, pizzaService.getTotalAmount(PaymentType.Cash));
    }


    @Test
    void testP3() throws Exception {
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        pizzaService.addPayment(1, PaymentType.Cash, 20d);
        pizzaService.addPayment(2, PaymentType.Cash, 20d);
        pizzaService.addPayment(3, PaymentType.Card, 20d);
        pizzaService.addPayment(4, PaymentType.Cash, 20d);
        pizzaService.addPayment(5, PaymentType.Card, 20d);
        pizzaService.addPayment(6, PaymentType.Cash, 20d);
        pizzaService.addPayment(7, PaymentType.Cash, 20d);

        System.out.println(pizzaService.getPayments());

        assertEquals(100d, pizzaService.getTotalAmount(PaymentType.Cash));
    }

    @Test
    void testP4() throws Exception {
        PizzaService pizzaService = new PizzaService(new MenuRepository(), new PaymentRepository());

        pizzaService.addPayment(1, PaymentType.Cash, 20d);
        pizzaService.addPayment(3, PaymentType.Cash, 20d);
        pizzaService.addPayment(4, PaymentType.Cash, 20d);
        pizzaService.addPayment(5, PaymentType.Cash, 20d);

        assertEquals(0d, pizzaService.getTotalAmount(PaymentType.Card));
    }

}