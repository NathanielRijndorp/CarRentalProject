package com.example.carrentalproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CarRentalController implements Initializable {
    //
    int id_num = 0;

    // TABLE VIEW FXML (OUTPUT)

    @FXML
    public TableView<Customer> tableView;
    @FXML
    private TableColumn<Customer, String> car_column;

    @FXML
    private TableColumn<Customer, String> car_type_column;

    @FXML
    private TableColumn<Customer, String> color_column;

    @FXML
    private TableColumn<Customer, Integer> id_column;

    @FXML
    private TableColumn<Customer, String> name_column;

    @FXML
    private TableColumn<Customer, Integer> price_column;

    @FXML
    private TableColumn<Customer, Integer> rent_day_column;

    @FXML
    private TableColumn<Customer, String> rent_end_column;

    @FXML
    private TableColumn<Customer, String> rent_start_column;

    // INPUT FXML
    @FXML
    private TextField id_input;
    @FXML
    private TextField name_input;
    @FXML
    private TextField car_input;
    @FXML
    private TextField car_type_input;
    @FXML
    private ColorPicker color_input;
    @FXML
    private DatePicker rent_start_input;

    @FXML
    private DatePicker rent_end_input;
    @FXML
    private TextField price_input;

    public void setID() {
        ObservableList<Customer> customers = tableView.getItems();
        id_input.setText(String.valueOf(customers.size()));
        for (int i = 1; i < customers.size(); i++) {
            Customer customer = customers.get(i);

        }
    }

    public void export() {
        ObservableList<Customer> customers = tableView.getItems();
        tableView.getItems().clear();
        String data[];
        try {
            File file = new File("src/main/resources/customer_info.txt");
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                data = sc.nextLine().split("#");
                Customer customer = new Customer(Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5],
                        data[6],
                        Integer.parseInt(data[7]),
                        Integer.parseInt(data[8])
                );
                customers.add(customer);
                tableView.setItems(customers);
            }
        } catch (Exception e) {

        }
        setID();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        export();

        id_column.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id"));
        name_column.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        car_column.setCellValueFactory(new PropertyValueFactory<Customer, String>("car"));
        car_type_column.setCellValueFactory(new PropertyValueFactory<Customer, String>("car_type"));
        color_column.setCellValueFactory(new PropertyValueFactory<Customer, String>("color"));
        rent_day_column.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("days"));
        rent_start_column.setCellValueFactory(new PropertyValueFactory<Customer, String>("date_start"));
        rent_end_column.setCellValueFactory(new PropertyValueFactory<Customer, String>("date_end"));
        price_column.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("price"));

        tableView.setEditable(true);
        name_column.setCellFactory(TextFieldTableCell.forTableColumn());
        name_column.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
                Customer customer = customerStringCellEditEvent.getRowValue();
                customer.setName(customerStringCellEditEvent.getNewValue());
            }
        });
        car_column.setCellFactory(TextFieldTableCell.forTableColumn());
        car_column.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
                Customer customer = customerStringCellEditEvent.getRowValue();
                customer.setCar(customerStringCellEditEvent.getNewValue());
            }
        });
        car_type_column.setCellFactory(TextFieldTableCell.forTableColumn());
        car_type_column.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
                Customer customer = customerStringCellEditEvent.getRowValue();
                customer.setCar_type(customerStringCellEditEvent.getNewValue());
            }
        });
        color_column.setCellFactory(TextFieldTableCell.forTableColumn());
        color_column.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
                Customer customer = customerStringCellEditEvent.getRowValue();
                customer.setColor(customerStringCellEditEvent.getNewValue());
            }
        });
        rent_day_column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        rent_day_column.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Customer, Integer> customerIntegerCellEditEvent) {
                Customer customer = customerIntegerCellEditEvent.getRowValue();
                customer.setDays(customerIntegerCellEditEvent.getNewValue());
            }
        });
        rent_start_column.setCellFactory(TextFieldTableCell.forTableColumn());
        rent_start_column.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
                Customer customer = customerStringCellEditEvent.getRowValue();
                customer.setDate_start(customerStringCellEditEvent.getNewValue());
            }
        });
        rent_end_column.setCellFactory(TextFieldTableCell.forTableColumn());
        rent_end_column.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
                Customer customer = customerStringCellEditEvent.getRowValue();
                customer.setDate_end(customerStringCellEditEvent.getNewValue());
            }
        });
        price_column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        price_column.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Customer, Integer>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Customer, Integer> customerIntegerCellEditEvent) {
                Customer customer = customerIntegerCellEditEvent.getRowValue();
                customer.setPrice(customerIntegerCellEditEvent.getNewValue());
            }
        });

    }
    @FXML
    void submit(ActionEvent event) {
        try {
            ObservableList<Customer> customers = tableView.getItems();
            setID();
            long day1 = rent_start_input.getValue().toEpochDay();
            long day2 = rent_end_input.getValue().toEpochDay();
            long days = (int) Math.abs(day1 - day2);
            Customer customer = new Customer(Integer.parseInt(id_input.getText()),
                    name_input.getText(),
                    car_input.getText(),
                    (car_type_input.getText()),
                    String.valueOf(color_input.getValue()),
                    String.valueOf(rent_start_input.getValue()),
                    String.valueOf(rent_end_input.getValue()),
                    (int) days,
                    (Integer.parseInt(price_input.getText()) * (int) days));
            customers.add(customer);
            tableView.setItems(customers);
        } catch (Exception e) {
            System.out.println("ERROR 999 MISSING ITEMS!");
        }
        setID();
    }
    @FXML
    void removeCustomer(ActionEvent event) {
        try {
            int selectedID = tableView.getSelectionModel().getSelectedIndex();
            tableView.getItems().remove(selectedID);
        } catch (Exception e) {
            System.out.println("ERROR 405 TABLE ROW CLICK!");
        }
        setID();
    }

    @FXML
    void onlyInteger() {
       try {
           price_input.textProperty().addListener(new ChangeListener<String>() {
               @Override
               public void changed(ObservableValue<? extends String> observable, String oldValue,
                                   String newValue) {
                   if (!newValue.matches("\\d*")) {
                       price_input.setText(newValue.replaceAll("[^\\d]", ""));
                   }
               }
           });
       } catch (Exception e) {
           System.out.println("ERROR 121 NO LETTERS ALLOWED");
       }

    }
    @FXML
    void saveFile() {
        String header = "";
        ObservableList<Customer> customers = tableView.getItems();
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            header += customer.getId() + "#" +
            customer.getName() + "#" +
            customer.getCar() + "#" +
            customer.getCar_type() + "#" +
            customer.getColor() + "#" +
            customer.getDate_start() + "#" +
            customer.getDate_end() + "#" +
            customer.getDays() + "#" +
            customer.getPrice() + "\n";
        }
        try {
            String clear = "";
            File file = new File("src/main/resources/customer_info.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(clear);
            writer.write(header);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setID();
    }

}