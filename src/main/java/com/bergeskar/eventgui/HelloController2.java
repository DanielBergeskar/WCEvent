package com.bergeskar.eventgui;


import com.bergeskar.eventgui.dao.CustomerDAO;

import com.bergeskar.eventgui.entity.Customer;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javax.security.auth.callback.Callback;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController2 implements Initializable {

    private CustomerDAO customerDAO = new CustomerDAO();
    @FXML
    private Label welcomeText;

    @FXML
    private TableView<Customer> customerTableView;
    @FXML
    private TableColumn<Customer, Integer> customer_idColumn;
    @FXML
    private TableColumn<Customer, String> f_nameColumn;
    @FXML
    private TableColumn<Customer, String> l_nameColumn;
    @FXML
    private TableColumn<Customer, Timestamp> b_dateColumn;
    @FXML
    private TableColumn<Customer, String> phone_nrColumn;
    @FXML
    private TextField f_nameConstructor;
    @FXML
    private TextField l_nameConstructor;
    @FXML
    private TextField b_dateConstructor;
    @FXML
    private TextField phone_nrConstructor;


    public HelloController2() {
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupCustomerTableView();
    }

    public void setupCustomerTableView() {
        List<Customer> read = customerDAO.read();
        customerTableView.setItems(FXCollections.observableList(read));

        //customer_idColumn.setCellValueFactory(new PropertyValueFactory<>("kund id"));
        f_nameColumn.setCellValueFactory(new PropertyValueFactory<>("f_name"));

        l_nameColumn.setCellValueFactory(new PropertyValueFactory<>("l_name"));

        b_dateColumn.setCellValueFactory(new PropertyValueFactory<>("b_date"));
        phone_nrColumn.setCellValueFactory(new PropertyValueFactory<>("phone_nr"));
        customerTableView.getItems().addAll();
        customerTableView.setEditable(true);
        f_nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        l_nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //b_dateColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phone_nrColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void updateCustomerTableView() {
        customerTableView.setItems(FXCollections.observableList(customerDAO.read()));
        customerTableView.getItems().addAll();
    }

    public void createCustomer() {
        if (f_nameConstructor != null &&
                l_nameConstructor != null &&
                b_dateConstructor != null &&
                phone_nrConstructor != null) {
            Customer customer = new Customer(f_nameConstructor.getText(),
                    l_nameConstructor.getText(),
                    b_dateConstructor.getText(),
                    phone_nrConstructor.getText());
            customerDAO.create(customer);
            updateCustomerTableView();
            f_nameConstructor.setText("");
            l_nameConstructor.setText("");
            b_dateConstructor.setText("");
            phone_nrConstructor.setText("");

        }
    }

    public void editFirstName(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEventStringCellEditEvent) {
        customerTableView.getSelectionModel().getSelectedItem().setF_name(customerStringCellEditEventStringCellEditEvent.getNewValue());

        customerDAO.update(customerTableView.getSelectionModel().getSelectedItem());
        updateCustomerTableView();
    }


        public void editLastName (TableColumn.CellEditEvent < Customer, String > customerStringCellEditEvent) {
            customerTableView.getSelectionModel().getSelectedItem().setL_name(customerStringCellEditEvent.getNewValue());

            customerDAO.update(customerTableView.getSelectionModel().getSelectedItem());
            updateCustomerTableView();
        }
    public void editBDate (TableColumn.CellEditEvent < Customer, String > customerStringCellEditEvent) {
        customerTableView.getSelectionModel().getSelectedItem().setB_date(customerStringCellEditEvent.getNewValue());

        customerDAO.update(customerTableView.getSelectionModel().getSelectedItem());
        updateCustomerTableView();
        }
    public void editPhoneNr (TableColumn.CellEditEvent < Customer, String > customerStringCellEditEvent) {
        customerTableView.getSelectionModel().getSelectedItem().setPhone_nr(customerStringCellEditEvent.getNewValue());

        customerDAO.update(customerTableView.getSelectionModel().getSelectedItem());
        updateCustomerTableView();
    }
        public void deleteCustomer () {
            Customer customer = customerTableView.getSelectionModel().getSelectedItem();
            new CustomerDAO().delete(customer);
            updateCustomerTableView();
        }

    }



