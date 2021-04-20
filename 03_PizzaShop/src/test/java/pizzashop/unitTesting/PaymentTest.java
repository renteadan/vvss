package pizzashop.unitTesting;

import org.junit.jupiter.api.Test;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    @Test
    public void testGetters() {
        Payment payment = new Payment(1, PaymentType.Cash, 10d);

        assertEquals(1, payment.getTableNumber());
        assertEquals(PaymentType.Cash, payment.getType());
        assertEquals(10d, payment.getAmount());
    }

    @Test
    public void testSetters() {
        Payment payment = new Payment(0, PaymentType.Card, 0d);

        payment.setTableNumber(1);
        payment.setType(PaymentType.Cash);
        payment.setAmount(10d);

        assertEquals(1, payment.getTableNumber());
        assertEquals(PaymentType.Cash, payment.getType());
        assertEquals(10d, payment.getAmount());

    }
}