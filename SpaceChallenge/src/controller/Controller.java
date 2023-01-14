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
public class Controller implements ActionListener {
    private View view = new View();
    private SpacecrafDAO dao = new SpacecrafDAO();
    DefaultTableModel tableModel = new DefaultTableModel();
    private List<Launcher> rLaunchers = new ArrayList<>();
    private List<UnmannedCraft> unManned = new ArrayList<>();
    private List<MannedCraft> manned = new ArrayList<>();

    public Controller (View vi){
        this.view = vi;
        this.start();
        this.view.btList.addActionListener(this);
        this.view.btLoad.addActionListener(this);
        this.view.btSearch.addActionListener(this);
        this.view.setVisible(true);
    }
    public void start(){
        view.initialize();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.btList){
            this.view.Clear_Table1();
            this.list(this.view.table);
            System.out.println("Click on list ");
        }
        if (e.getSource() == this.view.btLoad){
           this.load();
        }
        if (e.getSource() == this.view.btSearch){
            this.view.Clear_Table1();
            this.list(this.view.table, this.view.jcSearchType.getSelectedItem().toString());
        }
    }

    public void load(){
        String name = this.view.tfCraftName.getText(), type = this.view.jcCraftType.getSelectedItem().toString()
                , fuel = this.view.tfFuel.getText();
        String thrust = this.view.tfThrust.getText(), weight = this.view.tfWeight.getText(),
                height = this.view.tfHeight.getText();
        Spacecraft aCraft = Factory.create(type);
        aCraft.setName(name); aCraft.setType(type); aCraft.setFuel(fuel); aCraft.setThrust(thrust);
        aCraft.setWeight(weight); aCraft.setHeight(height);
        aCraft.startEngine();
        int r = dao.load(aCraft);
        if(r == 1){
            JOptionPane.showMessageDialog(this.view,"Spacecraft created successfully");
        }
        else {
            JOptionPane.showMessageDialog(this.view,"Failed to create spacecraft");
        }

    }
    public void list(JTable table){
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
    public void list(JTable table, String type){
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
}
