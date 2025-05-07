import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{
    ArrayList<String>choices = new ArrayList<String>();
    JLabel user;
    JLabel computer;
    JLabel result;

    JButton rock;
    JButton paper;
    JButton scissor;

    MyFrame(){
        choices.add("Rock");
        choices.add("Paper");
        choices.add("Scissor");

        result = new JLabel("Result");

        user = new JLabel("You");

        computer = new JLabel();
        computer.setText("Computer");

        rock = new JButton("Rock");
        rock.setPreferredSize(new Dimension(100, 100));
        rock.addActionListener(this);

        paper = new JButton("Paper");
        paper.setPreferredSize(new Dimension(100, 100));
        paper.addActionListener(this);

        scissor = new JButton("scissor");
        scissor.setPreferredSize(new Dimension(100, 100));
        scissor.addActionListener(this);

        JPanel choicePanel = new JPanel();
        choicePanel.setLayout(new GridLayout(1, 3));
        choicePanel.add(rock);
        choicePanel.add(scissor);
        choicePanel.add(paper);

        this.setSize(500,500);
        this.setTitle("Jack and Poy");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.add(choicePanel, BorderLayout.SOUTH);
        this.add(user, BorderLayout.WEST);
        this.add(computer, BorderLayout.EAST);
        this.add(result, BorderLayout.NORTH);

        this.setVisible(true);
    }
    public String result(){
       Collections.shuffle(choices);
       String result = choices.get(0);
       return result;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String comp = result();
        if(e.getSource() == rock){
            user.setText("Rock");
            computer.setText(comp);
            String choice = "Rock";
            if(comp == "Paper"){
                result.setText("You lose");
            }else if(comp == "Scissor"){
                result.setText("You win");
            }else if(comp == "Rock"){
                result.setText("Tie");
            }
        }
    }


}
