package pizzashop.gui;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pizzashop.Observers.Observable;
import pizzashop.controller.OrdersGUIController;
import pizzashop.service.PizzaService;

import java.io.IOException;


public class OrdersGUI {

    protected int tableNumber;
    public int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber;}
    private PizzaService service;
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/OrdersGUIFXML.fxml"));
    OrdersGUIController ordersCtrl;
    VBox vBoxOrders = null;
    private boolean first = true;
    Stage stage = new Stage();

    public OrdersGUIController getController() {
        return ordersCtrl;
    }

    public OrdersGUI() {
        try {
            vBoxOrders = loader.load();
            ordersCtrl= loader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(vBoxOrders));

    }

    public void displayOrdersForm(PizzaService service){
        ordersCtrl.setService(service, tableNumber);
     stage.setTitle("Table"+getTableNumber()+" order form");
     stage.setResizable(false);
     // disable X on the window
     stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
      @Override
     public void handle(WindowEvent event) {
         // consume event
         event.consume();
            }
        });
     stage.show();
    }
}
