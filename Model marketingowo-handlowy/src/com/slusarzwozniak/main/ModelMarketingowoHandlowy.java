package com.slusarzwozniak.main;


import com.slusarzwozniak.controller.Controller;
import com.slusarzwozniak.model.Model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dominik
 */
public class ModelMarketingowoHandlowy {
    public static void main(String args[]) {
        Controller controller = new Controller(new Model());
        controller.start();
    }
}
