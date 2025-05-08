import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

public class App implements ActionListener {
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

    JFrame frame;

    public App(){
        choices.add("✊");
        choices.add("✌");
        choices.add("✋");

        Border border = BorderFactory.createLineBorder(Color.WHITE);

        JPanel computerPanel = new JPanel();
        computerPanel.setLayout(new BorderLayout());
        computerPanel.setPreferredSize(new Dimension(100, 500));
        computerPanel.setBackground(Color.BLACK);

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BorderLayout());
        userPanel.setPreferredSize(new Dimension(100, 500));
        userPanel.setBackground(Color.BLACK);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BorderLayout());
        resultPanel.setBackground(Color.BLACK);
        resultPanel.setPreferredSize(new Dimension(200, 300));

        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1, 2));

        computerResult = new JLabel("Computer score: " + Integer.toString(computerScore));
        computerResult.setBorder(border);
        computerResult.setForeground(Color.WHITE);
        computerResult.setHorizontalAlignment(JLabel.CENTER);
        computerResult.setBackground(Color.BLACK);
        computerResult.setOpaque(true);

        playerResult = new JLabel("Your score: " + Integer.toString(playerScore));
        playerResult.setBorder(border);
        playerResult.setForeground(Color.WHITE);
        playerResult.setHorizontalAlignment(JLabel.CENTER);
        playerResult.setBackground(Color.BLACK);
        playerResult.setOpaque(true);

        matchResult = new JLabel("V.S");
        matchResult.setForeground(Color.WHITE);
        matchResult.setHorizontalAlignment(JLabel.CENTER);
        matchResult.setVerticalAlignment(JLabel.CENTER);
        matchResult.setBackground(Color.YELLOW);
        matchResult.setFont(matchResult.getFont().deriveFont(20f));
        matchResult.setBackground(Color.BLACK);
        matchResult.setOpaque(true);

        user = new JLabel();
        user.setForeground(Color.CYAN);
        user.setFont(user.getFont().deriveFont(90f));
        user.setHorizontalAlignment(JLabel.CENTER);
        user.setVerticalAlignment(JLabel.CENTER);

        computer = new JLabel();
        computer.setForeground(Color.RED);
        computer.setFont(user.getFont().deriveFont(90f));
        computer.setHorizontalAlignment(JLabel.CENTER);
        computer.setVerticalAlignment(JLabel.CENTER);

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

        frame = new JFrame();
        frame.setSize(500,500);
        frame.setTitle("Jack and Poy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.add(choicePanel, BorderLayout.SOUTH);
        frame.add(user, BorderLayout.WEST);
        frame.add(computer, BorderLayout.EAST);

        userPanel.add(user, BorderLayout.CENTER);
        computerPanel.add(computer, BorderLayout.CENTER);
        resultPanel.add(matchResult);
        scorePanel.add(playerResult);
        scorePanel.add(computerResult);
        frame.add(resultPanel, BorderLayout.CENTER);
        frame.add(scorePanel, BorderLayout.NORTH);
        frame.add(userPanel, BorderLayout.WEST);
        frame.add(computerPanel, BorderLayout.EAST);

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        new App();
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
            JOptionPane.showMessageDialog(frame, "You win");
            reset();
        }else if(computerScore == 5){
            JOptionPane.showMessageDialog(frame, "You lose");
            reset();
        }
    }
}
