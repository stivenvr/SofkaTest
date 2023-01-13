package controller;


import java.awt.*;
import javax.swing.*;

import view.View;
import model.Spacecraft;

public class Controller{
    
    private View view;
    private Spacecraft model;

    public Controller (View vie, Spacecraft mod){
        this.model = mod;
        this.view = vie;
    }

    public void start(){
        view.initialize();
    }

}
