
package main;

import Model.Word;
import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;


public class FavoriteWordScreen extends javax.swing.JFrame {
    private List<Word> favoriteWordList;
    private DefaultListModel<String> listModel;
    private JPopupMenu popupMenu;
    private final String SegoeUI = "Segoe UI";
    private final String Word = "Word";
    private final String Meaning = "Meaning";
    private final String Remove = "Bỏ cmnd";
    private final String Screen = "Sờ cờ rim";
    private final String Fovaritewordlist = "Danh sách đen ";
    private final String Sortby= "Cùng";
    private final String Doyouwanttodeletethisword = "Muốn làm lại cuộc đời không?";
    private final String Ask = "Hỏi thật";
    private final String text = "text/html";
    private final String AZ = "lên đèo ";
    private final String ZA = "ngã núi";
    private final boolean False = false;

    private static int runTime = 0;
    private int row;
    private int num0 = 0;
    private  int num1 = 1;
    private  int num11 = 11;
    private  int num84 = 84;
    private  int num79 = 79;
    private final int num10 = 10;
    private final int num18 = 18;
    private final int num30 = 30;
    private final int num349 = 349;
    private final int num14 = 14;
    private final int num348 = 348;
    private final int num8 = 8;
    private final int num56 = 56;
    private final int num80 = 80;
    private final int num12 = 12;
    private final int num346 = 346;
    private final int num407 = 407;
    private final int num26 = 26;
    private final int num9 = 9;
    private final int num781 = 781;
    private final int num437 = 437;
    public FavoriteWordScreen() {
        changeColor();
        initComponents();
        init();
    }

    private void init() {
        try{
            popupMenu = new JPopupMenu();
            runTime ++;
            listModel = new DefaultListModel<>();
            wordList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            wordList.setModel(listModel);
            addPopupMenu();
        }
        catch(Exception e){
            System.out.println(e);
        }

    }
    private void changeColor(){
        int num24 = 24;
        int num119 = 119;
        int num229 = 229;
        //num119 : 219 xanh dương//num229: 29 tím//num24: 224 vàng
        Random rand1 = new Random();
        int iRand1 = rand1.nextInt();
        if(iRand1 % 4 == 0){
            num119 = 219;
        }
        else if(iRand1 % 4 == 1){
            num229 = 29;
        }
        else if(iRand1 % 4 == 2){
            num24 = 224;
        }
        num11 = num24;
        num84 = num229;
        num79 = num119;
    }
    public void assignAndRenderData(List<Word> list) {

        try{
            this.favoriteWordList = list;
            renderData(list);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    private void renderData(List<Word> list) {

        try{
            listModel.removeAllElements();
            for (Word word : list) {
                listModel.addElement(word.getWord());runTime ++;
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    private void addPopupMenu() {
        JMenuItem remove = new JMenuItem(Remove);
        remove.addActionListener((ActionEvent e) -> {
            int opt = JOptionPane.showConfirmDialog(this,
                    Doyouwanttodeletethisword,
                    Ask, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            runTime ++;
            if (opt == JOptionPane.YES_OPTION) {
                favoriteWordList.remove(row);
                listModel.remove(row);
                runTime ++;
                setTitle(Screen);
            }
        });
        try{
            popupMenu.add(remove);
        }
        catch(Exception e){
            System.out.println(e);
        }

    }

    private void initComponents() {
        try{
            jScrollPane5 = new javax.swing.JScrollPane();
            meaningTextPane = new javax.swing.JTextPane();
            titleLabel3 = new javax.swing.JLabel();
            runTime ++;
            favoritePanel = new javax.swing.JPanel();
            wordList = new javax.swing.JList<>();
            runTime ++;
            jLabel6 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            runTime ++;
            sortingComboBox = new javax.swing.JComboBox<>();
            jLabel2 = new javax.swing.JLabel();
            runTime ++;
            jLabel1 = new javax.swing.JLabel();
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            favoritePanel.setBackground(new java.awt.Color(num11, num84, num79));
            runTime ++;
            titleLabel3.setFont(new java.awt.Font(SegoeUI, num1, num18)); // NOI18N
            runTime ++;
            titleLabel3.setText(Fovaritewordlist);
            titleLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            meaningTextPane.setContentType(text); // NOI18N
            meaningTextPane.setEditable(False);
            meaningTextPane.setMaximumSize(new java.awt.Dimension(num349, num348));
            jScrollPane5.setViewportView(meaningTextPane);
            meaningTextPane.setToolTipText("");
            meaningTextPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            runTime ++;
            meaningTextPane.setFocusable(False);
            wordList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            wordList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            wordList.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    wordListMouseClicked(evt);
                }
            });
            wordList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    wordListValueChanged(evt);
                }
            });
            jScrollPane1.setViewportView(wordList);
            jLabel1.setFont(new java.awt.Font(SegoeUI, num1, num14)); // NOI18N
            jLabel6.setText(Meaning);
            jLabel6.setFont(new java.awt.Font(SegoeUI, num1, num14)); // NOI18N
            jLabel1.setText(Word);
            sortingComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { AZ, ZA }));
            sortingComboBox.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    sortingComboBoxActionPerformed(evt);
                }
            });
        }
        catch(Exception e){
            System.out.println(e);
        }
        jLabel2.setFont(new java.awt.Font(SegoeUI, num1, num14)); // NOI18N
        jLabel2.setText(Sortby);
        try{
            javax.swing.GroupLayout favoritePanelLayout = new javax.swing.GroupLayout(favoritePanel);
            favoritePanel.setLayout(favoritePanelLayout);
            favoritePanelLayout.setHorizontalGroup(
                    favoritePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(favoritePanelLayout.createSequentialGroup()
                                    .addGap(num8, num8, num8)
                                    .addGroup(favoritePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, False)
                                            .addGroup(favoritePanelLayout.createSequentialGroup()
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, num56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, num56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(sortingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, num80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, num346, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(favoritePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(favoritePanelLayout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, num12, Short.MAX_VALUE)
                                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, num407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(num8, num8, num8))
                                            .addGroup(favoritePanelLayout.createSequentialGroup()
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel6)
                                                    .addContainerGap())))
            );  favoritePanelLayout.setVerticalGroup(
                    favoritePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(favoritePanelLayout.createSequentialGroup()
                                    .addGap(num10, num10, num10)
                                    .addComponent(titleLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, num26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(favoritePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(favoritePanelLayout.createSequentialGroup()
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(favoritePanelLayout.createSequentialGroup()
                                                    .addGroup(favoritePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                            .addComponent(sortingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, num30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel6))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, num9, Short.MAX_VALUE)))
                                    .addGroup(favoritePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, False)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, num348, Short.MAX_VALUE)
                                            .addComponent(jScrollPane5))
                                    .addGap(num8, num8, num8))
            );
        }
        catch(Exception e){
            System.out.println(e);
        }
        try{
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            runTime ++;
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(num0, num781, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(favoritePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(num0, num437, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                            .addComponent(favoritePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(num0, num0, Short.MAX_VALUE)))
            );
        }
        catch(Exception e){
            System.out.println(e);
        }
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void wordListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_wordListValueChanged
        try{
            if (!wordList.isSelectionEmpty()) {
                int selectedIndex = wordList.getSelectedIndex();
                Word selectedWord = favoriteWordList.get(selectedIndex);
                runTime ++;
                row = selectedIndex;
                runTime ++;
                meaningTextPane.setText(selectedWord.parse());
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

    }//GEN-LAST:event_wordListValueChanged

    private void sortingComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortingComboBoxActionPerformed
        try {
            String option = (String) sortingComboBox.getSelectedItem();
            meaningTextPane.setText("");
            switch (option) {
                case AZ ->
                        Collections.sort(favoriteWordList, (Word o1, Word o2) -> o1.getWord().compareTo(o2.getWord()));
                case ZA ->
                        Collections.sort(favoriteWordList, (Word o1, Word o2) -> o2.getWord().compareTo(o1.getWord()));
                default -> {
                }
            }
            renderData(favoriteWordList);
            runTime ++;
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_sortingComboBoxActionPerformed

    private void wordListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wordListMouseClicked
        try{
            if (!wordList.isSelectionEmpty()) {
                if (SwingUtilities.isRightMouseButton(evt)) {
                    runTime ++;
                    popupMenu.show(wordList, evt.getX(), evt.getY());
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_wordListMouseClicked

    public static void main(String args[]) {
        runTime ++;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FavoriteWordScreen().setVisible(true);
        }); runTime ++;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel favoritePanel;
    private javax.swing.JComboBox<String> sortingComboBox;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane meaningTextPane;
    private javax.swing.JList<String> wordList;
    private javax.swing.JLabel titleLabel3;

}
