package pizzashop.service;

import pizzashop.model.MenuDataModel;
import pizzashop.model.Payment;
import pizzashop.model.PaymentType;
import pizzashop.repository.MenuRepository;
import pizzashop.repository.PaymentRepository;

import java.util.List;

public class PizzaService {

    private MenuRepository menuRepo;
    private PaymentRepository payRepo;

    public void validate(Payment payment) throws Exception {
        if(payment.getAmount() <= 0d) {
            throw new Exception("Invalid ammount !!!");
        }

        if(payment.getTableNumber() < 1 || payment.getTableNumber() > 8) {
            throw new Exception("Invalid table");
        }
    }

    public PizzaService(MenuRepository menuRepo, PaymentRepository payRepo){
        this.menuRepo=menuRepo;
        this.payRepo=payRepo;
    }

    public List<MenuDataModel> getMenuData(){return menuRepo.getMenu();}

    public List<Payment> getPayments(){return payRepo.getAll(); }

    public boolean addPayment(int table, PaymentType type, double amount) throws Exception {
        Payment payment= new Payment(table, type, amount);
        validate(payment);
        payRepo.add(payment);
        return true;
    }

    public double getTotalAmount(PaymentType type){
        double total=0.0d; //1
        List<Payment> l=getPayments(); //2
        if ((l==null) || l.isEmpty()) //3
            return total; //4
        for (Payment p:l){ //5
            if (p.getType().equals(type)) //6
                total+=p.getAmount(); //7
        } //8
        return total; //9
    } //10

}
