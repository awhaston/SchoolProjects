/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 8
*/

package com.lab8;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    private Label lbResult = new Label();
    @FXML
    private TextField tfX = new TextField();
    @FXML
    private TextField tfY = new TextField();
    private int result;


     @FXML
     public void onClearClick() {
         tfX.clear();
         tfY.clear();
         lbResult.setText("");
         result = 0;
    }



    public void onAddClick() {
         Calc calc = new Calc();
         int x = Integer.parseInt(tfX.getText());
         int y = Integer.parseInt(tfY.getText());
         result += calc.add(x,y);
         lbResult.setText(String.valueOf(result));
    }
}