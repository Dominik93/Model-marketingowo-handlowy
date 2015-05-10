/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.slusarzwozniak.modelmarketingowohandlowy;

import com.slusarzwozniak.controller.Controller;
import com.slusarzwozniak.model.Model;
import com.slusarzwozniak.view.Login;

/**
 *
 * @author Dominik
 */
public class ModelMarketingowoHandlowy {
    public static void main(String args[]) throws ClassNotFoundException {
        Controller controller = new Controller(new Model(), new Login());
        controller.start();
    }
}
