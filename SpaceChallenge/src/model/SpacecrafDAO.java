package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpacecrafDAO {//this class is the persistence layer
    //Variable declaration
    Connect connect = new Connect();
    Connection conn;
    PreparedStatement peSt;
    ResultSet reSe;
//-----------------------------------------------------
    public int load(Spacecraft craft){//This method load the new data to the database
        String sql = "insert into spacecraft values (?,?,?,?,?,?)";
        try {
            conn = connect.getConnection();
            peSt = conn.prepareStatement(sql);
            peSt.setString(1, craft.getName());
            peSt.setString(2,craft.getType());
            peSt.setString(3,craft.getFuel());
            peSt.setInt(4,craft.getThrust());
            peSt.setInt(5,craft.getWeight());
            peSt.setInt(6,craft.getHeight());
            peSt.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
    public List list(){ //This method gets all the data from the database to be putted in the table by the controller
        List<Spacecraft> data = new ArrayList<>();
        String sql = "select * from spacecraft";
        try {
            conn = connect.getConnection();
            peSt = conn.prepareStatement(sql);
            reSe = peSt.executeQuery();
            while(reSe.next()){
                Spacecraft craft = Factory.create(reSe.getString(2));
                craft.setName(reSe.getString(1));
                craft.setType(reSe.getString(2));
                craft.setFuel(reSe.getString(3));
                craft.setThrust(reSe.getString(4));
                craft.setWeight(reSe.getString(5));
                craft.setHeight(reSe.getString(6));
                data.add(craft);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }
    public List list(String type){//This method gets all the data tha matches the type from the database
        // to be putted in the table by the controller
        List<Spacecraft> data = new ArrayList<>();
        String sql = "select * from spacecraft where type = ?";
        try {
            conn = connect.getConnection();
            peSt = conn.prepareStatement(sql);
            peSt.setString(1,type);
            reSe = peSt.executeQuery();
            while(reSe.next()){
                Spacecraft craft = Factory.create(reSe.getString(2));
                craft.setName(reSe.getString(1));
                craft.setType(reSe.getString(2));
                craft.setFuel(reSe.getString(3));
                craft.setThrust(reSe.getString(4));
                craft.setWeight(reSe.getString(5));
                craft.setHeight(reSe.getString(6));
                data.add(craft);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

}