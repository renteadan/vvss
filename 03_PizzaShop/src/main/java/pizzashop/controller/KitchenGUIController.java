package pizzashop.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import pizzashop.Observers.Observable;
import pizzashop.Observers.Observer;
import pizzashop.gui.OrdersGUI;
import pizzashop.model.Order;
import pizzashop.model.OrderStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class KitchenGUIController {
    @FXML
    private ListView kitchenOrdersList;
    @FXML
    public Button cook;
    @FXML
    public Button ready;
    @FXML
    public Button exit;

    public boolean isOpened() {
        return isOpened;
    }

    public static ObservableList<Order> order = FXCollections.observableArrayList();
    private Order selectedOrder;
    private Calendar now = Calendar.getInstance();
    private static List<OrdersGUI> observables = new ArrayList<>();
    private static boolean isOpened = true;
    //thread for adding data to kitchenOrderList
    public  Thread addOrders = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        kitchenOrdersList.setItems(order);
                        }
                });
                try {
                    Thread.sleep(100);
                  } catch (InterruptedException ex) {
                    break;
                }
            }
        }
    });

    public void initialize() {
        isOpened = true;
        //starting thread for adding data to kitchenOrderList
        addOrders.setDaemon(true);
        addOrders.start();
        //Controller for Cook Button
        cook.setOnAction(event -> {
            selectedOrder = (Order) kitchenOrdersList.getSelectionModel().getSelectedItem();
            if(!selectedOrder.status.equals(OrderStatus.ORDERED))
                return;
            selectedOrder.status = OrderStatus.COOKING;
            selectedOrder.setCookingStart(LocalDateTime.now());
            kitchenOrdersList.getItems().remove(selectedOrder);
            kitchenOrdersList.getItems().add(selectedOrder);
        });
        //Controller for Ready Button
        ready.setOnAction(event -> {
            selectedOrder = (Order) kitchenOrdersList.getSelectionModel().getSelectedItem();
            if(!selectedOrder.status.equals(OrderStatus.COOKING))
                return;
            selectedOrder.status = OrderStatus.READY;
            kitchenOrdersList.getItems().remove(selectedOrder);
            System.out.println("--------------------------");
            System.out.println("Table " + selectedOrder.getTableNumber() +" ready at: " + now.get(Calendar.HOUR)+":"+now.get(Calendar.MINUTE));
            System.out.println("--------------------------");
        });

        exit.setOnAction(event -> {
            if(chekObservables() == true) {
                isOpened = false;
                Stage stage = (Stage) exit.getScene().getWindow();
                stage.close();
            }
        });
    }

    public void addObservables(List<OrdersGUI> observables) {
        this.observables = observables;
    }

    public boolean chekObservables() {
        for(OrdersGUI observable : this.observables) {
            if(observable.getController().isOpen() == true) {
                return false;
            }
        }

        return true;
    }
}