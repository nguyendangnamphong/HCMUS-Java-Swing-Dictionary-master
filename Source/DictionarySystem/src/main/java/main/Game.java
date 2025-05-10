package main;

import Model.Word;
import Model.StatisticWord;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends JFrame {
    private static List<Word> list;
    private int index;
    private String question;
    private String answer;
    private JPanel namePanel;
    private JButton button;
    private JTextField textField;
    private JLabel label;
    private final int num400 = 400;
    private final int num200 = 200;
    private final int num32 = 32;
    private final int num10 = 10;
    private final int num0 = 0;
    private final String Game = "Game";
    private final String Aria = "Aria";
    private final String Wrong = "Thiệt luôn, trắng như tiền đồ chị dậu";
    private final String Information = "Information";
    private final String Warn = "Warn";
    private final String Pass = "Có vẻ mày chịu học hành đấy. Chơi nữa không?";
    private final String Erorr = "Hết từ để hỏi rồi :)";
    private final String  Sai = "Mỗi thế này mà cũng sai. Viết lại!";
    public Game(List<Word> list){
        this.list = list;
        creatQuestion(list);
        question = question.toUpperCase();
        JFrame namePanel1 = new JFrame(Game);
        namePanel1.setSize(num400,num200);
        namePanel1.setVisible(true);
        namePanel1.setLocationRelativeTo(null);
        namePanel1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        label.setFont(new Font(Aria, Font.BOLD, num32));
        label.setText(question);
        label.setAlignmentX(JComponent.UNDEFINED_CONDITION);
        label.setHorizontalAlignment(JLabel.CENTER);
        namePanel1.setContentPane(namePanel);
        button.setSize(num10,num10);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String anser = textField.getText().toLowerCase();
                if(anser.isEmpty()){
                    JOptionPane.showMessageDialog(namePanel1, Wrong, Warn,JOptionPane.WARNING_MESSAGE);
                }
                else if(anser.equals(answer)){
                    int x = JOptionPane.showConfirmDialog(namePanel1, Pass, Information,JOptionPane.YES_NO_OPTION);
                    if(x == JOptionPane.YES_OPTION){
                        // loại bỏ question và answer ra khỏi list và chạy lại chương trình với hàm list mới
                        list.remove(index);
                        if (!list.isEmpty()) {
                            new Game(list);
                        } else {
                            JOptionPane.showMessageDialog(namePanel1, Erorr, Information, JOptionPane.INFORMATION_MESSAGE);
                            namePanel1.dispose();System.exit(num0);
                        }
                    }else {
                        namePanel1.dispose();System.exit(num0);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(namePanel1, Sai, Warn,JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
    private void creatQuestion(List<Word> list){
        int sizeList = list.size();
        Random random = new Random();
        index = random.nextInt(sizeList);
        Word word = list.get(index);
        question = word.getWord();
        answer = word.getMeaning();
    }
}

