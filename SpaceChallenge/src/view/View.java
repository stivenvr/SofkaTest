package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class View extends JFrame {
    //variable declaration
    final private Font myFont = new Font("Segoe print", Font.PLAIN, 18);
    private JLabel lbCraftName, lbCraftType, lbFuel, lbThrust, lbWeight, lbHeight, lbSelectType;
    public JLabel lbMethods;
    public JTextField tfCraftName, tfFuel, tfThrust, tfWeight, tfHeight, tfNumOfEngines;
    public JComboBox<String> jcCraftType, jcSearchType;
    public JButton btLoad, btList, btSearch;
    private String[] dataTable = {"Name", "Type", "Fuel", "Thrust", "Weight", "Height"};
    private Object[][] object = new Object[0][0];
    public JTable table;
    private DefaultTableModel dtm = new DefaultTableModel(object, dataTable);


    public void initialize(){//This method starts the window
        setTitle("Welcome");
        setSize(1000, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents(); //use the initComponents method

    }
    public void Clear_Table1(){
        for (int i = 0; i < table.getRowCount(); i++) {
            dtm.removeRow(i);
            i-=1;
        }
    }
    //This method initialize all the components we will have on the window
    public void initComponents(){//This method initialize all the components tha are in the view, and also place them
        // in their frames

        lbCraftName = new JLabel("Craft name"); //initialize the component
        lbCraftName.setFont(myFont);        //set a font style to the component

        tfCraftName = new JTextField();
        tfCraftName.setFont(myFont);

        lbCraftType = new JLabel("Craft type");
        lbCraftType.setFont(myFont);

        jcCraftType = new JComboBox<>();
        jcCraftType.setFont(myFont);
        jcCraftType.setModel(new DefaultComboBoxModel<>(new String[] {"Rocket Launcher", "Unmanned Spacecraft",
                "Manned Spacecraft"})); // Create the items contained by the ComboBox

        jcSearchType = new JComboBox<>();
        jcSearchType.setFont(myFont);
        jcSearchType.setModel(new DefaultComboBoxModel<>(new String[] {"Rocket Launcher", "Unmanned Spacecraft",
                "Manned Spacecraft"}));

        lbFuel = new JLabel("Type of fuel");
        lbFuel.setFont(myFont);

        tfFuel = new JTextField();
        tfFuel.setFont(myFont);

        lbThrust = new JLabel("Tons of thrust");
        lbThrust.setFont(myFont);

        tfThrust = new JTextField();
        tfThrust.setFont(myFont);

        lbWeight = new JLabel("Weight");
        lbWeight.setFont(myFont);

        tfWeight = new JTextField();
        tfWeight.setFont(myFont);

        lbHeight = new JLabel("Height");
        lbHeight.setFont(myFont);

        tfHeight = new JTextField();
        tfHeight.setFont(myFont);

        btLoad = new JButton("Store Spacecraft");
        btLoad.setFont(myFont);

        btList = new JButton("List spacecrafts");
        btList.setFont(myFont);

        btSearch = new JButton("Search Spacecrafts");
        btSearch.setFont(myFont);

        lbMethods = new JLabel("Here comes the actions each craft can do"); //initialize the component
        lbMethods.setFont(myFont);        //set a font style to the component

        table = new JTable(dtm);
        table.setFont(myFont);

        lbSelectType = new JLabel("Type of craft");
        lbSelectType.setFont(myFont);

//-------------------------------------------------------------
        //Here are the panels created and what they will contain
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 25));

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());

        JPanel createPanel = new JPanel();
        createPanel.setLayout(new GridLayout(3, 4, 3, 3));;

        JPanel btPanel = new JPanel();
        btPanel.setLayout(new GridLayout(1,2,5,5));

        createPanel.add(lbCraftName);
        createPanel.add(tfCraftName);
        createPanel.add(lbCraftType);
        createPanel.add(jcCraftType);
        createPanel.add(lbFuel);
        createPanel.add(tfFuel);
        createPanel.add(lbThrust);
        createPanel.add(tfThrust);
        createPanel.add(lbWeight);
        createPanel.add(tfWeight);
        createPanel.add(lbHeight);
        createPanel.add(tfHeight);
        btPanel.add(btLoad);
        btPanel.add(btList);

        headerPanel.add(createPanel, BorderLayout.NORTH);
        headerPanel.add(btPanel, BorderLayout.CENTER);
//-------------------------------------------------------------
        JScrollPane tbPanel = new JScrollPane(table);
//-------------------------------------------------------------
        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1, 2,5,5));
        searchPanel.add(lbSelectType);
        searchPanel.add(jcSearchType);

        footerPanel.add(searchPanel, BorderLayout.NORTH);
        footerPanel.add(btSearch, BorderLayout.CENTER);
        footerPanel.add(lbMethods, BorderLayout.SOUTH);
//-------------------------------------------------------------
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(tbPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);



        add(mainPanel);

    }
}
