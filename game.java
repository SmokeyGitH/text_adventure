import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game{
    JFrame window;
    Container container;
    JPanel titleNamepanel,startButtonpanel,mainTextpanel,choiceBtnpanel,playerPanel;
    JLabel titleNamelabel,hpLabel,hpLabelNo,weaponLabel, weaponLabelName;
    JTextArea mainTxtarea;
    
    titleScreenhandler tsHan = new titleScreenhandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    
    Font titleFont = new Font("Monospaced", Font.PLAIN, 55);
    JButton startButton,choice1,choice2,choice3,choice4;
    Font startButtonfont = new Font("Monospaced", Font.PLAIN, 45);
    Font normalFont = new Font("Monospaced", Font.PLAIN, 20);
    Font normalFont2 = new Font("Monospaced", Font.ITALIC, 25);
    int playerHp;
    String Weapon,pos;
    
    public static void main (String[] args){
        Game game = new Game();
                
    }
    
    public Game(){
        
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.DARK_GRAY);
        window.setLayout(null);
        window.setVisible(true);
        container = window.getContentPane();
        
        titleNamepanel = new JPanel();
        titleNamepanel.setBounds(150,150,500,100);
        titleNamepanel.setBackground(Color.DARK_GRAY);
        titleNamelabel = new JLabel("Adventure Game");
        titleNamelabel.setForeground(Color.WHITE);
        titleNamelabel.setFont(titleFont);
        
        startButtonpanel = new JPanel();
        startButtonpanel.setBounds(300,300,200,100);
        startButtonpanel.setBackground(Color.DARK_GRAY);
        startButton = new JButton("START");
        startButton.setBackground(Color.DARK_GRAY);
        startButton.setForeground(Color.white);
        startButton.setFont(startButtonfont);
        startButton.setFocusPainted(false);
        startButton.addActionListener(tsHan);
        
        //this is my own walkaround for playerPanel not showing up
        playerPanel = new JPanel();
        playerPanel.setBounds(100,25,500,50);
        playerPanel.setBackground(Color.lightGray);
        playerPanel.setLayout(new GridLayout(1,2));
        container.add(playerPanel);
        playerPanel.setVisible(false);
        
       
        
        
        startButtonpanel.add(startButton);
        titleNamepanel.add(titleNamelabel);
        container.add(titleNamepanel);
        container.add(startButtonpanel);
        
        
    }
    
    public void gameScreen(){
        
        titleNamepanel.setVisible(false);
        startButtonpanel.setVisible(false);
        playerPanel.setVisible(true);// this is my own walkaround for playerPanel not showing up
        
        mainTextpanel = new JPanel();
        mainTextpanel.setBounds(100, 100, 500, 250);
        mainTextpanel.setBackground(Color.black);
        container.add(mainTextpanel);
        
        mainTxtarea = new JTextArea("This is main text area where the lines of the story is visble");
        mainTxtarea.setBounds(150,150,500,250);
        mainTxtarea.setBackground(Color.black);
        mainTxtarea.setForeground(Color.white);
        mainTxtarea.setFont(normalFont);
        mainTxtarea.setLineWrap(true);
        mainTextpanel.add(mainTxtarea);
        
        //choice button 
        choiceBtnpanel = new JPanel();
        choiceBtnpanel.setBackground(Color.black);
        choiceBtnpanel.setBounds(100, 355, 500, 175);
        choiceBtnpanel.setLayout(new GridLayout(4,1));
        container.add(choiceBtnpanel);
        
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.gray);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceBtnpanel.add(choice1);
        
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.gray);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceBtnpanel.add(choice2);
        
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.gray);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceBtnpanel.add(choice3);
        
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.gray);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceBtnpanel.add(choice4);
        
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont2);
        hpLabel.setForeground(Color.black);
        playerPanel.add(hpLabel);
        
        hpLabelNo = new JLabel();
        hpLabelNo.setFont(normalFont2);
        hpLabelNo.setForeground(Color.black);
        playerPanel.add(hpLabelNo);
        
        weaponLabel = new JLabel("Weapon: ");
        weaponLabel.setFont(normalFont2);
        weaponLabel.setForeground(Color.black);
        playerPanel.add(weaponLabel);
        
        
        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont2);
        weaponLabelName.setForeground(Color.black);
        playerPanel.add(weaponLabelName);
        
        playerSetup(); //calls this function when all the above methods are executed
                
        }
    
    public void playerSetup(){
        
        playerHp = 10;
        Weapon = "fist";
        weaponLabelName.setText(Weapon);
        hpLabelNo.setText(""+playerHp); //a walkaround to display int in place of a string
        
        adminBlock();
    }
    
    public void adminBlock(){
       pos = "adminBlock";
       mainTxtarea.setText("You are at the admin block. \nWatchman is standing and you don't have your ID card \nWhat do you do?");
       choice1.setText("Pretend to search the bag");
       choice2.setText("Act normal and try to pass through");
       choice3.setText("Go back to get your  id card");
       choice4.setText("smile");
        
    }
    
    public void idk1(){
        pos = "wmEnconter";
        mainTxtarea.setText("He asks you to wear it and go inside \nwhat do you do?");
        choice1.setText("Fs");
        choice2.setText("run");
        choice3.setText("...");
        choice4.setText("...");
        
    }
    
    public class titleScreenhandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            gameScreen();
        }
    
    
    }
    public class ChoiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            
            String selectedChoice = event.getActionCommand();
            
            switch(pos){
            case "adminBlock":
                switch(selectedChoice){
                    case "c1":idk1(); break;
                    case "c2":break;
                    case "c3":break;
                    case "c4":break;
                }
                
            }
        }
    }
    
}
