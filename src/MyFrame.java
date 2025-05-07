import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener{
    ArrayList<String>choices = new ArrayList<String>();
    JLabel user;
    JLabel computer;
    JLabel matchResult;
    JLabel playerResult;
    JLabel computerResult;

    JButton rock;
    JButton paper;
    JButton scissor;

    int playerScore = 0;
    int computerScore = 0;

    MyFrame(){
        choices.add("Rock");
        choices.add("Paper");
        choices.add("Scissor");

        JPanel resultPanel = new JPanel();

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1, 2));

        computerResult = new JLabel("Computer Score" + Integer.toString(computerScore));
        playerResult = new JLabel("Your score: " + Integer.toString(playerScore));
        matchResult = new JLabel("Result");
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

        resultPanel.add(matchResult);
        scorePanel.add(playerResult);
        scorePanel.add(computerResult);
        this.add(resultPanel, BorderLayout.CENTER);
        this.add(scorePanel, BorderLayout.NORTH);

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
                matchResult.setText("You lose");
                computerScore += 1;
                computerResult.setText("Computer Score" + Integer.toString(computerScore));
            }else if(comp == "Scissor"){
                matchResult.setText("You win");
                playerScore += 1;
                playerResult.setText("Your score: " + Integer.toString(playerScore));
            }else if(comp == "Rock"){
                matchResult.setText("Tie");
            }
        }else if(e.getSource() == paper){
            user.setText("Paper");
            computer.setText(comp);
            if(comp == "Scissor"){
                matchResult.setText("You lose");
                computerScore += 1;
                computerResult.setText("Computer Score" + Integer.toString(computerScore));
            }else if(comp == "Rock"){
                matchResult.setText("You win");
                playerScore += 1;
                playerResult.setText("Your score: " + Integer.toString(playerScore));
            }else if(comp == "Paper"){
                matchResult.setText("Tie");
            }
        }else if(e.getSource() == scissor){
            user.setText("Scissor");
            computer.setText(comp);
            if(comp == "Rock"){
                matchResult.setText("You lose");
                computerScore += 1;
                computerResult.setText("Computer Score" + Integer.toString(computerScore));
            }else if(comp == "Paper"){
                matchResult.setText("You win");
                playerScore += 1;
                playerResult.setText("Your score: " + Integer.toString(playerScore));
            }else if(comp == "Scissor"){
                matchResult.setText("Tie");
            }
        }
    }


}
