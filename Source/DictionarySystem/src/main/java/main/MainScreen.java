package main;
import java.awt.Dimension;
import java.util.Arrays;
import java.util.Random;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.SwingUtilities;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import Model.Word;
import Model.StatisticWord;
import org.xml.sax.SAXException;


public class MainScreen extends javax.swing.JFrame {
    private final File englishVietFile = new File("./src/main/java/data/Anh_Viet.xml");
    private final File vietEnglishFile = new File("./src/main/java/data/Viet_Anh.xml");
    public static File historyFile = new File("./src/main/java/data/searchHistory.txt");
    public static File favoriteFile = new File("./src/main/java/data/favoriteWords.txt");
    boolean isEnglish = true;
    private boolean isChangingEnglishDictionary = false;
    private boolean isChangingVietDictionary = false;
    private boolean True = true;
    private final String mainScreem = "Màn hình chính";
    private final String SegoeUI = "Segoe UI";
    private final String Word = "Chữ:";
    private final String Meaning = "Nghĩa:";
    private final String Record = "Ghi";
    private final String Createnewword = "niu guốt";
    private final String Save = "";
    private final String Inputkeyword = "Input your key Word";
    private final String Create = "vứt vô";
    private final String Dictionary = "Từ điển tiếng em";
    private final String Myfavoriteword= "Từ mày ghét";
    private final String Statistics= "Game";
    private final String Doyouwanttodeletethisword = "mày muốn xoá cái này thiệt à";
    private final String Delete = "xoá cmnl";
    private final String Addintoyourfavoritelist = "Đưa vào danh sách đen";
    private final String Ask = "Hỏi thật";
    private final String fileName = "./src/main/java/main/logo.png";
    private final String text = "text/html";
    private final String AV = "Anh - Việt";
    private final String VA = "Việt - Anh";
    private final String Adddingsucess = "Nhỡ cho mất rồi!";
    private final String Info = "Tình hình ";
    private final String Wordormeaningisempty = "Trắng như tiền đồ chị Dậu";
    private final String Warn = "Hỏi chấm";
    private  int num0 = 0;
    private final int num6 =6;
    private  int num2 = 2;
    private final int num3 = 3;
    private final int num4 = 4;
    private final int num5 = 5;
    private final int num10 = 10;
    private final int num16 = 16;
    private final int num30 = 30;
    private final int num14 = 14;
    private final int num312 = 312;
    private final int num219 = 219;
    private final int num29 = 29;
    private final int num224 = 224;
    private final int num50 = 50;
    private final int num150 = 150;
    private final int num101 = 101;
    private final int num28 = 28;
    private final int num43 = 43;
    private final int num18 = 18;
    private int num201 = 201;
    private  int num250 = 250;
    private final int num234 = 234;
    private  int num119 = 119;
    private int num229 = 229;
    private  int num24 = 24;
    private final int num12 = 12;
    private final int num1 = 1;
    private final int num85 = 85;
    private final int num480 = 480;
    private final int num31 = 31;
    private final int num19 = 19;
    private final int num404 = 404;
    private final int num369 = 369;
    private final int num26 = 26;
    private final int num47 = 47;
    private final int num44 = 44;
    private final int num68 = 68;
    private final int num330 = 330;
    private final int num136 = 136;
    private static int erorr = 0;
    private static int runTime = 0;
    private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private List<Word> dictionaryEnglishViet;
    private List<Word> dictionaryVietAnh;
    private static List<Word> favoriteWordList;
    private List<StatisticWord> historyList;
    private DefaultListModel<String> listModel;
    private JPopupMenu popupMenu;
    private int row;

    public MainScreen() throws ClassNotFoundException {
        changeColor();
        initComponents();
        init();
        assignData(dictionaryEnglishViet);
        loadDictionary(vietEnglishFile, dictionaryVietAnh);
        loadDictionary(englishVietFile, dictionaryEnglishViet);
        readFavorite();
        readHistory();
    }

    private void init() {
        try {
            dictionaryEnglishViet = new ArrayList<>();
            titleLabel.setIcon(new ImageIcon(fileName));
            historyList = new ArrayList<>();
            dictionaryVietAnh = new ArrayList<>();
            listModel = new DefaultListModel<>();
            popupMenu = new JPopupMenu();
            wordList.setModel(listModel);
            favoriteWordList = new ArrayList<>();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int y = (screenSize.height - this.getHeight()) / num2 - num30;
            int x = (screenSize.width - this.getWidth()) / num2;
            this.setLocation(x, y);
            addPopupMenu();
            this.setTitle(mainScreem);
        } catch (Exception e) {
            System.out.println(e);
            erorr ++;
        }

    }
    private static void playGame(){
           List <Word> game = new ArrayList<Word>();
           game = favoriteWordList;
//        game.add(new Word("apple", "quả táo"));
//        game.add(new Word("banana", "quả chuối"));
//        game.add(new Word("grape", "quả nho"));
//        game.add(new Word("lemon", "quả chanh"));
//        game.add(new Word("orange", "quả cam"));
//        game.add(new Word("peach", "quả đào"));
//        game.add(new Word("pear", "quả lê"));
//        game.add(new Word("pineapple", "quả dứa"));
        Game play = new Game(game);
    }
    private void changeColor(){
        //num24: 224 vàng//num229: 29 tím//num119 : 219 xanh dương
        int last = num0;
        Random rand1 = new Random();
        int iRand1 = rand1.nextInt(num6);
         if(iRand1 % num6 == num0){
             num119 = num219;
         }
         else if(iRand1 % num6 == num1){
             num229 = num29;
         }
         else if(iRand1 % num6 == num2){
             num24 = num224;
         }
         else if(iRand1 % num6 == num3){
             num24 = num250;
             num229 = num201;
             num119 = num201;
             last = 1;
         }
         else if(iRand1 % num6 == num4 ){
             num24 = num250;
             num229 = num101;
             num119 = num101;
             last = num2;
         }
         else {
             return;
         }
        //num250 : 50 blue   150 white//num201 : 101 red
        Random rand2 = new Random();
        int iRand2 = rand2.nextInt(num4);
        if(iRand2 % num4 == num0){
            num201 = num101;
        }
        else if(iRand2 % num4 == num1){
            num250 = num50;
        }
        else if(iRand2 % num4 == num2){
            num250 = num150;
        }
        else if(last == num1 ){
            num201 = num101;
        }
        else if(last == num2 ){
            num250 = num50;
        }
    }
    private void assignData(List<Word> list) {
        try {
            listModel.removeAllElements();
            for (Word item : list) {
                listModel.addElement(item.getWord());
            }
        } catch (Exception ex) {
            System.out.println(ex);
            erorr ++;
        }

    }

    private void addPopupMenu() {
        try {
            JMenuItem addFovarite = new JMenuItem(Addintoyourfavoritelist);
            JMenuItem delete = new JMenuItem(Delete);
            //Adding popup
            popupMenu.add(addFovarite);
            popupMenu.add(delete);
            //Handle events
            delete.addActionListener((ActionEvent e) -> {
                int opt = JOptionPane.showConfirmDialog(this, Doyouwanttodeletethisword, Ask, JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (opt == JOptionPane.YES_OPTION) {
                    listModel.remove(row);
                    if (isEnglish) {
                        isChangingEnglishDictionary = True;
                        dictionaryEnglishViet.remove(row);
                    } else {
                        isChangingVietDictionary = True;
                        dictionaryVietAnh.remove(row);
                    }
                    setTitle(mainScreem);
                }
            });
            addFovarite.addActionListener((ActionEvent e) -> {
                Word word;
                if (isEnglish) {
                    word = dictionaryEnglishViet.get(row);
                } else {
                    word = dictionaryVietAnh.get(row);
                }

                setTitle(mainScreem);
                favoriteWordList.add(word);
            });
        } catch (Exception ex) {
            System.out.println(ex);
            erorr ++;
        }

    }
    private void loadDictionary(File rawFile, List<Word> list) {
        try {
            dbFactory = DocumentBuilderFactory.newDefaultInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            try {
                Document doc = dBuilder.parse(rawFile);
                doc.getDocumentElement().normalize();
                NodeList nodeListStudent = doc.getElementsByTagName(Record);
                for (int i = num0; i < nodeListStudent.getLength(); i++) {
                    Node currentNode = nodeListStudent.item(i);
                    if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element currentElement = (Element) currentNode;
                        list.add(new Word(currentElement.getElementsByTagName(Word)
                                .item(num0).getTextContent(),
                                currentElement.getElementsByTagName(Meaning)
                                        .item(num0).getTextContent()));
                    }
                }
            } catch (IOException | SAXException e) {
                System.out.println(e);
            }

        } catch (ParserConfigurationException e) {
            System.out.println(e);
            erorr ++;
        }
    }

    private void readHistory() throws ClassNotFoundException {
        try {
            FileInputStream in = new FileInputStream(historyFile);
            ObjectInputStream ifs = new ObjectInputStream(in);
            while (true) {
                StatisticWord obj;
                try {
                    obj = (StatisticWord) ifs.readObject();
                    historyList.add(obj);
                } catch (EOFException ex) {
                    break;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex);
            erorr ++;
        }
    }
    private void readFavorite() throws ClassNotFoundException {
        try {
            FileInputStream in = new FileInputStream(favoriteFile);
            ObjectInputStream ifs = new ObjectInputStream(in);
            while (true) {
                Word obj;
                    obj = (Word) ifs.readObject();
                    favoriteWordList.add(obj);
            }
        } catch (IOException ex) {
            System.out.println(ex);
            erorr ++;
        }
    }
    private void writeDictionary(File file, List<Word> list) {
        Document doc = dBuilder.newDocument();
        Element rootElement = doc.createElement(Dictionary);

        for (Word item : list) {
            Element record = doc.createElement(Record);
            Element meaning = doc.createElement(Meaning);
            meaning.appendChild(doc.createTextNode(item.getMeaning()));
            record.appendChild(meaning);
            Element word = doc.createElement(Word);
            word.appendChild(doc.createTextNode(item.getWord()));
            record.appendChild(word);
            rootElement.appendChild(record);
        }
        doc.appendChild(rootElement);

        // ghi nội dung vào file XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        try {

            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (TransformerException ex) {
            System.out.println(ex);
            erorr ++;
        }
    }
    public static <T> void writeList(List<T> list, File file) {
        try {
            FileOutputStream out = new FileOutputStream(file);
            ObjectOutputStream ofs = new ObjectOutputStream(out);
            for (T item : list) {
                runTime++;
                ofs.writeObject(item);
            }
            ofs.close();
        } catch (IOException ex) {
            System.out.println(ex);
            erorr ++;
        }
    }
    private void initComponents() {
        titleLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        wordListScrollPane = new javax.swing.JScrollPane();
        searchInput = new javax.swing.JTextField();
        typeDictionaryCombobox = new javax.swing.JComboBox<>();
        wordList = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        wordInput = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        meaningTextPane = new javax.swing.JTextPane();
        meaningInput = new javax.swing.JTextField();
        openForariteListBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        createBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        openStatisticBtn = new javax.swing.JButton();
        setResizable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        mainPanel.setBackground(new java.awt.Color(num24, num229, num119));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setFont(new java.awt.Font(SegoeUI, num1, num18)); // NOI18N
        titleLabel.setText(Dictionary);
        jPanel2.setOpaque(false);
        jPanel2.setBackground(new java.awt.Color(num24, num229, num119));
        jPanel2.setPreferredSize(new java.awt.Dimension(num480, num30));
        typeDictionaryCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { AV, VA }));

        typeDictionaryCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeDictionaryComboboxActionPerformed(evt);
            }
        });

        searchInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchInputKeyTyped(evt);
            }
        });
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(searchInput, javax.swing.GroupLayout.DEFAULT_SIZE, num312, Short.MAX_VALUE)
                .addGap(num5, num5, num5)
                .addComponent(typeDictionaryCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(typeDictionaryCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, num28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(searchInput)
                .addContainerGap())
        );

        wordListScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        wordList.setFont(new java.awt.Font(SegoeUI, num0, num14)); // NOI18N
        wordList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
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
        wordListScrollPane.setViewportView(wordList);
        jLabel2.setText(Word);
        jLabel2.setPreferredSize(new java.awt.Dimension(num43, num30));
        jLabel2.setFont(new java.awt.Font(SegoeUI, num0, num14)); // NOI18N
        meaningTextPane.setContentType(text); // NOI18N
        meaningTextPane.setFocusable(false);
        jScrollPane4.setViewportView(meaningTextPane);
        jPanel3.setBackground(new java.awt.Color(num24, num229, num119));
        jLabel3.setText(Createnewword);
        jLabel3.setFont(new java.awt.Font(SegoeUI, num1, num16)); // NOI18N
        jLabel4.setPreferredSize(new java.awt.Dimension(num43, num30));
        jLabel4.setText(Word);
        jLabel4.setFont(new java.awt.Font(SegoeUI, num0, num14)); // NOI18N
        wordInput.setFont(new java.awt.Font(SegoeUI, num0, num14)); // NOI18N
        wordInput.setToolTipText(Inputkeyword);
        wordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                wordInputActionPerformed(evt);
            }
        });
        jLabel5.setFont(new java.awt.Font(SegoeUI, num0, num14)); // NOI18N
        jLabel5.setPreferredSize(new java.awt.Dimension(num43, num30));
        jLabel5.setText(Meaning);
        meaningInput.setFont(new java.awt.Font(SegoeUI, num0, num14)); // NOI18N
        meaningInput.setToolTipText(Inputkeyword);
        meaningInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                meaningInputActionPerformed(evt);
            }
        });
        createBtn.setBackground(new java.awt.Color(num250, num201, num201));
        createBtn.setText(Create);
        createBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        createBtn.setFont(new java.awt.Font(SegoeUI, num1, num12)); // NOI18N
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });
        openForariteListBtn.setBackground(new java.awt.Color(num250, num201, num201));
        openForariteListBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openForariteListBtn.setText(Myfavoriteword);
        openForariteListBtn.setFont(new java.awt.Font(SegoeUI, num1, num14)); // NOI18N
        openForariteListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openForariteListBtnActionPerformed(evt);
            }
        });
        openStatisticBtn.setBackground(new java.awt.Color(num250, num201, num201));
        openStatisticBtn.setText(Statistics);
        openStatisticBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        openStatisticBtn.setFont(new java.awt.Font(SegoeUI, num1, num14)); // NOI18N
        openStatisticBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {playGame();}
        });
        saveBtn.setBackground(new java.awt.Color(num24, num229, num119));
        saveBtn.setText(Save);
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.setFont(new java.awt.Font(SegoeUI, num1, num12)); // NOI18N
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(num5, num5, num5)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(wordInput, javax.swing.GroupLayout.PREFERRED_SIZE, num30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(meaningInput, javax.swing.GroupLayout.PREFERRED_SIZE, num30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(num5, num5, num5)
                                .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, num31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(openForariteListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, num31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(openStatisticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, num31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, num31, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, num47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, num68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(meaningInput)
                    .addComponent(wordInput)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addContainerGap(num330, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, num85, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, num85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(num44, num44, num44)
                .addComponent(openForariteListBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(openStatisticBtn, javax.swing.GroupLayout.PREFERRED_SIZE, num136, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, num19, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, num404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(wordListScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, num369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(num10, num10, num10)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, num26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(wordListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, num234, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane4))
                                .addGap(num10, num10, num10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(num0, num0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void wordListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_wordListValueChanged
        if (!wordList.isSelectionEmpty() && !evt.getValueIsAdjusting()) {
            int selectedIndex = wordList.getSelectedIndex();
            if (isEnglish) {
                Word word = dictionaryEnglishViet.get(selectedIndex);
                meaningTextPane.setText(word.parse());
                row = selectedIndex;
                historyList.add(new StatisticWord(word, LocalDate.now()));
            } else {
                Word word = dictionaryVietAnh.get(selectedIndex);
                meaningTextPane.setText(word.getMeaning());
                historyList.add(new StatisticWord(word, LocalDate.now()));
            }
            JScrollBar sb = wordListScrollPane.getVerticalScrollBar();
            row = selectedIndex;
        }
    }//GEN-LAST:event_wordListValueChanged

    private void openStatisticBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openStatisticBtnActionPerformed

        StatisticScreen statisticScreen = new StatisticScreen();
        statisticScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int y = (screenSize.height - statisticScreen.getHeight()) / num2;
        int x = (screenSize.width - statisticScreen.getWidth()) / num2;
        statisticScreen.assignData(historyList);
        statisticScreen.setLocation(x, y);
        statisticScreen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Handle the closing of this frame
                statisticScreen.dispose(); // Close the frame
            }
        });

        statisticScreen.show();
    }//GEN-LAST:event_openStatisticBtnActionPerformed

    private void wordListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wordListMouseClicked

        //Checking if right click is active
        if (SwingUtilities.isRightMouseButton(evt)) {
            if (!wordList.isSelectionEmpty()) {
                popupMenu.show(wordList, evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_wordListMouseClicked

    private void searchInputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchInputKeyTyped
        String keyword = searchInput.getText();
        keyword += evt.getKeyChar();
        keyword = keyword.trim().toLowerCase();
        meaningTextPane.setText("");
        runTime ++;
        if (isEnglish) {
            for (int i = num0; i < listModel.size(); i++) {
                if (listModel.getElementAt(i).toLowerCase().startsWith(keyword)) {
                    JScrollBar sb = wordListScrollPane.getVerticalScrollBar();
                    sb.setValue(i * num24);
                    return;
                }
            }
        } else {
            for (int i = num0; i < listModel.size(); i++) {
                String curString = listModel.getElementAt(i);
                if (Helper.unicodeToASCII(curString).toLowerCase().startsWith(
                        Helper.unicodeToASCII(keyword).toLowerCase()
                )) {
                    JScrollBar sb = wordListScrollPane.getVerticalScrollBar();
                    sb.setValue(i * num24);
                    return;
                }
            }
        }
        wordList.clearSelection();
    }//GEN-LAST:event_searchInputKeyTyped

    private void typeDictionaryComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeDictionaryComboboxActionPerformed

        String language = (String) typeDictionaryCombobox.getSelectedItem();
        runTime ++;
        switch (language) {
            case AV -> {
                isEnglish = true;runTime ++;
                assignData(dictionaryEnglishViet);
            }
            case VA -> {
                isEnglish = false;
                assignData(dictionaryVietAnh);
            }
            default -> {
            }

        }
    }//GEN-LAST:event_typeDictionaryComboboxActionPerformed

    private void openForariteListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openForariteListBtnActionPerformed

        FavoriteWordScreen favoriteWordScreen = new FavoriteWordScreen();

        favoriteWordScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int y = (screenSize.height - favoriteWordScreen.getHeight()) / num2;
        int x = (screenSize.width - favoriteWordScreen.getWidth()) / num2;
        favoriteWordScreen.setLocation(x, y);
        favoriteWordScreen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                favoriteWordScreen.dispose();
            }
        });
        favoriteWordScreen.assignAndRenderData(favoriteWordList);
        favoriteWordScreen.show();
    }//GEN-LAST:event_openForariteListBtnActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        String meaningText = meaningInput.getText();
        String wordText = wordInput.getText();
        if (wordText.length() > num0 && meaningText.length() > num0) {
            Word word = new Word(wordText, meaningText);
            if (isEnglish) {
                dictionaryEnglishViet.add(word);
                isChangingEnglishDictionary = true;
            } else {
                dictionaryVietAnh.add(word);
                isChangingVietDictionary = true;
            }
            listModel.addElement(word.getWord());
            JOptionPane.showMessageDialog(this, Adddingsucess, Info,
                    JOptionPane.INFORMATION_MESSAGE);
            meaningInput.setText("");
            wordInput.setText("");
            setTitle(mainScreem);
        } else {
            JOptionPane.showMessageDialog(this, Wordormeaningisempty, Warn,
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        //Save dictionary
        if (isChangingEnglishDictionary) {
            writeDictionary(englishVietFile, dictionaryEnglishViet);
        }
        if (isChangingVietDictionary) {
            writeDictionary(vietEnglishFile, dictionaryVietAnh);
        }
        writeList(historyList, historyFile);
        //Save favorite word list
        writeList(favoriteWordList, favoriteFile);
        setTitle(mainScreem);
    }//GEN-LAST:event_saveBtnActionPerformed
    public static int getRunTime(){
        return runTime;
    }
    public static int getErorr(){
        return erorr;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new MainScreen().setVisible(true);runTime ++;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextPane meaningTextPane;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField meaningInput;
    private javax.swing.JTextField searchInput;
    private javax.swing.JButton openForariteListBtn;
    private javax.swing.JButton openStatisticBtn;
    private javax.swing.JButton saveBtn;
    private javax.swing.JScrollPane wordListScrollPane;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> typeDictionaryCombobox;
    private javax.swing.JTextField wordInput;
    private javax.swing.JList<String> wordList;

    // End of variables declaration//GEN-END:variables
}
