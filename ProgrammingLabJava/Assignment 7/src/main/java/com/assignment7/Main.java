/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Assignment#: 7
*/

package com.assignment7;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);

        Label loan_label = new Label("Loan Amount: ");
        TextField loan_field = new TextField();
        gp.add(loan_label, 0, 0);
        gp.add(loan_field, 1, 0);

        Label num_label = new Label("Number of Years");
        gp.add(num_label, 0, 1);
        ObservableList<Integer> years = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);
        ListView year_list = new ListView(years);
        year_list.setMaxSize(100,100);
        gp.add(year_list, 0,2);

        Label interest_label = new Label("Interest Rates");
        gp.add(interest_label, 0,3);
        ObservableList<Double> rates = FXCollections.observableArrayList(3.00,3.50,4.00,4.50,5.00,5.50,6.00,6.50,7.00,7.50);
        ComboBox interest_combo = new ComboBox<>(rates);
        gp.add(interest_combo, 0, 4);

        Label deferment_label = new Label("In Deferment?");
        gp.add(deferment_label, 2, 1);
        ToggleGroup deferment_radio = new ToggleGroup();
        ToggleButton yes_radio = new ToggleButton("Yes");
        yes_radio.setToggleGroup(deferment_radio);
        yes_radio.setUserData("yes");
        ToggleButton no_radio = new ToggleButton("No");
        no_radio.setToggleGroup(deferment_radio);
        no_radio.setUserData("no");

        VBox radio_vbox = new VBox(8);
        radio_vbox.getChildren().addAll(yes_radio,no_radio);
        gp.add(radio_vbox, 2,2);


        Label option_label = new Label("Options");
        gp.add(option_label, 2, 3);
        VBox check_vbox = new VBox(8);
        CheckBox missed_check = new CheckBox("Missed Payments?");
        CheckBox auto_check = new CheckBox("Automatic Withdrawal");
        check_vbox.getChildren().addAll(missed_check, auto_check);
        gp.add(check_vbox, 2,4);


        Label calculated_label = new Label();
        gp.add(calculated_label, 1,5);
        Button calculate_button = new Button("Calculate");
        calculate_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double loan_amount = Double.parseDouble(loan_field.getText());
                int number_years = year_list.getSelectionModel().getSelectedIndex();
                double interest_rate = (double) interest_combo.getSelectionModel().getSelectedItem();
                boolean is_deferred = false;
                if (deferment_radio.getSelectedToggle().getUserData() == "yes"){
                    is_deferred = true;
                }
                boolean is_missed = false;
                if (missed_check.isSelected()){
                    is_missed = true;
                }
                boolean is_automatic = false;
                if (auto_check.isSelected()){
                    is_automatic = true;
                }
                Calculator calculator = new Calculator(loan_amount, number_years, interest_rate,is_deferred,is_missed, is_automatic);

                calculated_label.setText(String.valueOf(calculator.calculateLoan()));
            }
        });
        gp.add(calculate_button, 0, 5);




        Scene scene = new Scene(gp, 500, 500);
        stage.setTitle("Student Loan com.example.demo.Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}