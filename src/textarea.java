import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

class JSample1_1 extends JFrame implements ActionListener{
  public static void main(String args[]){
    JSample1_1 frame = new JSample1_1("MyTitle");
    frame.setVisible(true);
    
  }

  ImageIcon icon2;
  JTextArea textarea1;
  JTextArea textarea2;
  JTextArea textarea3;
  JTextArea textarea4;
  JTextArea textarea5;
  JTextArea textarea6;
  JTextArea textarea7;

  JRadioButton radio1;
  JRadioButton radio2;
  JRadioButton radio3;
  JRadioButton radio4;

  ButtonGroup bgroup;

  File file;
  FileWriter fw;
  BufferedWriter bw;
  String flag;

  JSample1_1(String title){
    setTitle(title);
    setSize(1280 , 720);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    System.setProperty("file.encoding", "UTF-8");
    
    icon2 = new ImageIcon("moyu.png");
    setIconImage(icon2.getImage());

    textarea1 = new JTextArea();
    textarea2 = new JTextArea();
    textarea3 = new JTextArea();
    textarea4 = new JTextArea();
    textarea5 = new JTextArea();
    textarea6 = new JTextArea();
    textarea7 = new JTextArea();


    textarea1.setRows(1);
    textarea1.setLineWrap(true);
    textarea1.setWrapStyleWord(true);
    

    textarea2.setRows(10);
    textarea2.setLineWrap(true);
    textarea2.setWrapStyleWord(true);

    textarea3.setRows(5);
    textarea3.setLineWrap(true);
    textarea3.setWrapStyleWord(true);

    textarea4.setRows(5);
    textarea4.setLineWrap(true);
    textarea4.setWrapStyleWord(true);


    textarea5.setRows(5);
    textarea5.setLineWrap(true);
    textarea5.setWrapStyleWord(true);


    textarea6.setRows(5);
    textarea6.setLineWrap(true);
    textarea6.setWrapStyleWord(true);


    textarea7.setRows(1);
    textarea7.setLineWrap(true);
    textarea7.setWrapStyleWord(true);
    
    JLabel label1 = new JLabel("ファイル名を入力");
    JLabel label2 = new JLabel("問題を入力");
    JLabel label3 = new JLabel("選択肢アを入力");
    JLabel label4 = new JLabel("選択肢イを入力");
    JLabel label5 = new JLabel("選択肢ウを入力");
    JLabel label6 = new JLabel("選択肢エを入力");
    JLabel label7 = new JLabel("問題の答えの番号をクリック");
    JLabel label8 = new JLabel("画像のファイル名を入力(拡張子を含める)");
    


    radio1 = new JRadioButton("ア");
    radio2 = new JRadioButton("イ");
    radio3 = new JRadioButton("ウ");
    radio4 = new JRadioButton("エ");

    bgroup = new ButtonGroup();
    bgroup.add(radio1);
    bgroup.add(radio2);
    bgroup.add(radio3);
    bgroup.add(radio4);

    JButton button1 = new JButton("決定");

    radio1.addActionListener(this);
    radio2.addActionListener(this);
    radio3.addActionListener(this);
    radio4.addActionListener(this);
    button1.addActionListener(this);


    label1.setAlignmentX(Component.RIGHT_ALIGNMENT);
    label2.setAlignmentX(Component.RIGHT_ALIGNMENT);
    label3.setAlignmentX(Component.RIGHT_ALIGNMENT);
    label4.setAlignmentX(Component.RIGHT_ALIGNMENT);
    label5.setAlignmentX(Component.RIGHT_ALIGNMENT);
    label6.setAlignmentX(Component.RIGHT_ALIGNMENT);
    label7.setAlignmentX(Component.RIGHT_ALIGNMENT);
    label8.setAlignmentX(Component.RIGHT_ALIGNMENT);
    radio1.setAlignmentX(Component.RIGHT_ALIGNMENT);
    radio2.setAlignmentX(Component.RIGHT_ALIGNMENT);
    radio3.setAlignmentX(Component.RIGHT_ALIGNMENT);
    radio4.setAlignmentX(Component.RIGHT_ALIGNMENT);
    radio3.setAlignmentX(Component.RIGHT_ALIGNMENT);
    button1.setAlignmentX(Component.RIGHT_ALIGNMENT);

    

    JPanel p = new JPanel();
    JPanel p2 = new JPanel();

    p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
    
    p.add(label1);
    p.add(textarea1);

    p.add(label2);
    p.add(textarea2);

    p.add(label3);
    p.add(textarea3);

    p.add(label4);
    p.add(textarea4);

    p.add(label5);
    p.add(textarea5);

    p.add(label6);
    p.add(textarea6);

    p.add(label7);
    p.add(radio1);
    p.add(radio2);
    p.add(radio3);
    p.add(radio4);

    p.add(label8);
    p.add(textarea7);

    p.add(button1);

    getContentPane().add(p);
  }
  public void actionPerformed(ActionEvent a){
    String cmd = a.getActionCommand();

    if(cmd.equals("ア")){
      System.out.println("ア");
      flag = "1";
    }else if(cmd.equals("イ")){
      System.out.println("イ");
      flag = "2";
    }else if(cmd.equals("ウ")){
      System.out.println("ウ");
      flag = "3";
    }else if(cmd.equals("エ")){
      System.out.println("エ");
      flag = "4";
    }

    System.out.println("ボタンが押された．");
    

    if(cmd.equals("決定")){

      try {
        file = new File("data/"+ textarea1.getText() +".moyu");
        fw = new FileWriter(file,true);
        bw = new BufferedWriter(fw);

        System.out.println("問題");
        System.out.println(textarea2.getText());
        String problem = textarea2.getText();
        bw.write(problem+",");

        System.out.println("選択肢ア");
        String select_1 = textarea3.getText();
        bw.write(select_1+",");

        System.out.println("選択肢イ");
        String select_2 = textarea4.getText();
        bw.write(select_2+",");

        System.out.println("選択肢ウ");
        String select_3 = textarea5.getText();
        bw.write(select_3+",");

        System.out.println("選択肢エ");
        String select_4 = textarea6.getText();
        bw.write(select_4+",");

        System.out.println("答え");
        String answer = flag;
        bw.write(answer+",");

        System.out.println("画像ファイル");
        String image = textarea6.getText();
        bw.write(image+",");

        bw.newLine();
        bw.close();

        
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    textarea2.setText("");
    textarea3.setText("");
    textarea4.setText("");
    textarea5.setText("");
    textarea6.setText("");
    bgroup.clearSelection();
    textarea7.setText("");
    
    }
  }
}