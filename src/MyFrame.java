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
        choices.add("✊");
        choices.add("✌");
        choices.add("✋");

        JPanel computerPanel = new JPanel();
        computerPanel.setPreferredSize(new Dimension(100, 500));

        JPanel userPanel = new JPanel();
        userPanel.setPreferredSize(new Dimension(100, 500));

        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(Color.BLACK);
        resultPanel.setPreferredSize(new Dimension(200, 300));

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1, 2));

        computerResult = new JLabel("Computer score: " + Integer.toString(computerScore));
        computerResult.setForeground(Color.WHITE);
        computerResult.setHorizontalAlignment(JLabel.CENTER);
        computerResult.setBackground(Color.BLACK);
        computerResult.setOpaque(true);

        playerResult = new JLabel("Your score: " + Integer.toString(playerScore));
        playerResult.setForeground(Color.WHITE);
        playerResult.setHorizontalAlignment(JLabel.CENTER);
        playerResult.setBackground(Color.BLACK);
        playerResult.setOpaque(true);

        matchResult = new JLabel("V.S");
        matchResult.setForeground(Color.WHITE);
        matchResult.setHorizontalAlignment(JLabel.CENTER);
        matchResult.setBackground(Color.YELLOW);
        matchResult.setFont(matchResult.getFont().deriveFont(20f));
        matchResult.setBackground(Color.BLACK);
        matchResult.setOpaque(true);

        user = new JLabel();
        user.setForeground(Color.WHITE);
        user.setFont(user.getFont().deriveFont(90f));
        user.setHorizontalAlignment(JLabel.CENTER);
        user.setVerticalAlignment(JLabel.CENTER);
        user.setBackground(Color.BLACK);
        user.setOpaque(true);

        computer = new JLabel();
        computer.setForeground(Color.WHITE);
        computer.setFont(user.getFont().deriveFont(90f));
        computer.setHorizontalAlignment(JLabel.CENTER);
        computer.setVerticalAlignment(JLabel.CENTER);
        computer.setBackground(Color.BLACK);
        computer.setOpaque(true);


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

        userPanel.add(user);
        computerPanel.add(computer);
        resultPanel.add(matchResult);
        scorePanel.add(playerResult);
        scorePanel.add(computerResult);
        this.add(resultPanel, BorderLayout.CENTER);
        this.add(scorePanel, BorderLayout.NORTH);
        this.add(userPanel, BorderLayout.WEST);
        this.add(computerPanel, BorderLayout.EAST);

        this.getContentPane().setBackground(Color.BLACK);
        this.setVisible(true);
    }
    public String result(){
       Collections.shuffle(choices);
       String result = choices.get(0);
       return result;
    }

    public void reset(){
        playerScore = 0;
        computerScore = 0;
        playerResult.setText("Your score: 0");
        computerResult.setText("Computer score: 0");
        matchResult.setText("V.S");
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String comp = result();
        if(e.getSource() == rock){
            user.setText("✊");
            computer.setText(comp);
            String choice = "✊";
            if(comp == "✋"){
                matchResult.setText("You lose");
                computerScore += 1;
                computerResult.setText("Computer score: " + Integer.toString(computerScore));
            }else if(comp == "✌"){
                matchResult.setText("You win");
                playerScore += 1;
                playerResult.setText("Your score: " + Integer.toString(playerScore));
            }else if(comp == "✊"){
                matchResult.setText("Tie");
            }
        }else if(e.getSource() == paper){
            user.setText("✋");
            computer.setText(comp);
            if(comp == "✌"){
                matchResult.setText("You lose");
                computerScore += 1;
                computerResult.setText("Computer score: " + Integer.toString(computerScore));
            }else if(comp == "✊"){
                matchResult.setText("You win");
                playerScore += 1;
                playerResult.setText("Your score: " + Integer.toString(playerScore));
            }else if(comp == "✋"){
                matchResult.setText("Tie");
            }
        }else if(e.getSource() == scissor){
            user.setText("✌");
            computer.setText(comp);
            if(comp == "✊"){
                matchResult.setText("You lose");
                computerScore += 1;
                computerResult.setText("Computer score: " + Integer.toString(computerScore));
            }else if(comp == "✋"){
                matchResult.setText("You win");
                playerScore += 1;
                playerResult.setText("Your score: " + Integer.toString(playerScore));
            }else if(comp == "✌"){
                matchResult.setText("Tie");
            }
        }

        if(playerScore == 5){
            JOptionPane.showMessageDialog(this, "You win");
            reset();
        }else if(computerScore == 5){
            JOptionPane.showMessageDialog(this, "You lose");
            reset();
        }
    }


}
