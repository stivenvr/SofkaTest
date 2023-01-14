package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import view.View;
import model.*;
//When we use MVC, the controller makes all the actions between the view to the model of the program
//this controller has to implement the ActionListener to control the actions from the view and pass the request to
//the model
public class Controller implements ActionListener {
    //Variable declarations
    private View view = new View(); //this is the view we have to control
    private SpacecrafDAO dao = new SpacecrafDAO(); //This is the Persistence layer
    DefaultTableModel tableModel = new DefaultTableModel(); //A model we will use to put everything in the table

//--------------------------------------------------------------------------
    //
    public Controller (View vi){ //Constructor
        this.view = vi;
        this.start();
        this.view.btList.addActionListener(this);
        this.view.btLoad.addActionListener(this);
        this.view.btSearch.addActionListener(this);
        this.view.setVisible(true);
    }
    public void start(){//initialize all the view's components
        view.initialize();

    }

    @Override
    public void actionPerformed(ActionEvent e) {// we have to override the actionPerformed method from ActionListener
        //to control the requests from the view

        if (e.getSource() == this.view.btList){//this happens when we click on the button List spacecrafts
            this.view.Clear_Table1();
            this.list(this.view.table);
        }
        if (e.getSource() == this.view.btLoad){// this happens when we click on the button Store spacecraft
           this.load();
        }
        if (e.getSource() == this.view.btSearch){// This happens when we click on the button Search spacecraft
            this.view.Clear_Table1();
            this.list(this.view.table, this.view.jcSearchType.getSelectedItem().toString());
            this.functions(this.view.lbMethods, this.view.jcSearchType.getSelectedItem().toString());
        }
    }

    public void load(){//This is the method executed when we click on Store Spacecraft

        //We get all the variables in the textBoxes from the view;
        String name = this.view.tfCraftName.getText(), type = this.view.jcCraftType.getSelectedItem().toString()
                , fuel = this.view.tfFuel.getText();
        String thrust = this.view.tfThrust.getText(), weight = this.view.tfWeight.getText(),
                height = this.view.tfHeight.getText();
        //create a Spacecraft object to store the data
        Spacecraft aCraft = Factory.create(type);
        aCraft.setName(name); aCraft.setType(type); aCraft.setFuel(fuel); aCraft.setThrust(thrust);
        aCraft.setWeight(weight); aCraft.setHeight(height);
        //Use the load method from SpacecraftDAO, the persistence layer, to update the data in database.
        int r = dao.load(aCraft);
        if(r == 1){
            JOptionPane.showMessageDialog(this.view,"Spacecraft created successfully");
        }
        else {
            JOptionPane.showMessageDialog(this.view,"Failed to create spacecraft");
        }

    }
    public void list(JTable table){ //this method put the content of database in the view's table
        tableModel = (DefaultTableModel)table.getModel();
        List<Spacecraft> list = dao.list();
        Object[] object = new Object[6];
        for (int i = 0; i < list.size(); i++){
            object[0] = list.get(i).getName();
            object[1] = list.get(i).getType();
            object[2] = list.get(i).getFuel();
            object[3] = list.get(i).getThrust();
            object[4] = list.get(i).getWeight();
            object[5] = list.get(i).getHeight();
            tableModel.addRow(object);
        }
        this.view.table.setModel(tableModel);
    }
    public void list(JTable table, String type){ //This method put in the table only the
        // crafts that matches the type searched

        tableModel = (DefaultTableModel)table.getModel();
        List<Spacecraft> list = dao.list(type);
        Object[] object = new Object[6];
        for (int i = 0; i < list.size(); i++){
            object[0] = list.get(i).getName();
            object[1] = list.get(i).getType();
            object[2] = list.get(i).getFuel();
            object[3] = list.get(i).getThrust();
            object[4] = list.get(i).getWeight();
            object[5] = list.get(i).getHeight();
            tableModel.addRow(object);
        }
        this.view.table.setModel(tableModel);
    }
    public void functions(JLabel label, String type){//This method set the text at the bottom of the window
        // to let us knows what different methods or functions have the craft searched
        List<Spacecraft> list = dao.list(type);
        switch (type){
            case "Rocket Launcher":
                Launcher launch = (Launcher) Factory.create(type);
                label.setText(launch.separate() + " ");
                break;
            case "Unmanned Spacecraft":
                UnmannedCraft unmCraft = (UnmannedCraft) Factory.create(type);
                label.setText(unmCraft.takePicture() + " " + unmCraft.investigate());
                break;
            case "Manned Spacecraft":
                MannedCraft manned = (MannedCraft) Factory.create(type);
                label.setText(manned.passengerBoarding() + " " + manned.landing());
                break;
        }

    }

}
