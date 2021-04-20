package pizzashop.unitTesting;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.PaymentRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PaymentRepositoryTest {

    private PaymentRepository paymentRepository;

    @Test
    public void testAdd() {
        paymentRepository = mock(PaymentRepository.class);

        Payment payment1 = new Payment(1, PaymentType.Card, 20d);
        Payment payment2 = new Payment(2, PaymentType.Card, 40d);
        Payment payment3 = new Payment(3, PaymentType.Card, 30d);

        Mockito.doNothing().when(paymentRepository).add(payment1);
        Mockito.doNothing().when(paymentRepository).add(payment2);
        Mockito.doNothing().when(paymentRepository).add(payment3);

        paymentRepository.add(payment1);
        paymentRepository.add(payment2);
        paymentRepository.add(payment3);

        Mockito.verify(paymentRepository).add(payment1);
        Mockito.verify(paymentRepository).add(payment2);
        Mockito.verify(paymentRepository).add(payment3);
    }

    @Test
    public void testGetAll() {
        paymentRepository = mock(PaymentRepository.class);

        Payment payment1 = new Payment(1, PaymentType.Card, 20d);
        Payment payment2 = new Payment(2, PaymentType.Card, 40d);
        Payment payment3 = new Payment(3, PaymentType.Card, 30d);

        paymentRepository.add(payment1);
        paymentRepository.add(payment2);
        paymentRepository.add(payment3);

        Mockito.when(paymentRepository.getAll()).thenReturn(Arrays.asList(payment1, payment2, payment3));

        paymentRepository.getAll();

        Mockito.verify(paymentRepository).getAll();

    }
}