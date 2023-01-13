package view;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    
    //variable declaration
    final private Font myFont = new Font("Segoe print", Font.BOLD, 18);
    private JLabel lbCraftName, lbCraftType, lbFuel, lbThrust, lbWeight, lbHeight, lbNumOfEngines;
    private JTextField tfCraftName, tfFuel, tfThrust, tfWeight, tfHeight, tfNumOfEngines;
    private JComboBox<String> jcCraftType;
    private JButton btLoad, btClear;

    //This method starts the window
    public void initialize(){
        setTitle("Welcome");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();

    }

    //This method initialize all the components we will have on the window
    public void initComponents(){
        // Here are the panel located in the north of the main frame, this is used as the frame to create a spacecraft
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 25));

        lbCraftName = new JLabel("Craft name"); //initialize the component
        lbCraftName.setFont(myFont);        //set a font style to the component

        tfCraftName = new JTextField();
        tfCraftName.setFont(myFont);
        lbCraftType = new JLabel("Craft type");
        lbCraftType.setFont(myFont);
        jcCraftType = new JComboBox<>();
        jcCraftType.setFont(myFont);
        jcCraftType.setModel(new DefaultComboBoxModel<>(new String[] {"Rocket Launcher", "Unmanned Spacecraft", "Manned Spacecraft"})); // Create the items that will be contained by the ComboBox
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
        lbNumOfEngines = new JLabel("Number of engines");
        lbNumOfEngines.setFont(myFont);
        tfNumOfEngines = new JTextField();
        tfNumOfEngines.setFont(myFont);
        btLoad = new JButton("Store Spacecraft");
        btLoad.setFont(myFont);
        btClear = new JButton("Clear data");
        btClear.setFont(myFont);


        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());

        JPanel createPanel = new JPanel();
        createPanel.setLayout(new GridLayout(4, 4, 3, 3));;
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
        createPanel.add(lbNumOfEngines);
        createPanel.add(tfNumOfEngines);
        
        btPanel.add(btLoad);
        btPanel.add(btClear);

        headerPanel.add(createPanel, BorderLayout.NORTH);
        headerPanel.add(btPanel, BorderLayout.CENTER);
        mainPanel.add(headerPanel, BorderLayout.NORTH);

        
        add(mainPanel);

    }
}
