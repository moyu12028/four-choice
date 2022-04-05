import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class yontaku extends JFrame implements ActionListener{
    JLabel label;
    JLabel label12;
    JLabel label2_1;
    JLabel label2_2;
    JLabel label2_3;
    JLabel label2_4;
    ImageIcon icon;
    ImageIcon icon2;
    int Count = 0;
    String Path2 = "data/";
    
    
    public static void main(String[] args) {
        yontaku frame = new yontaku("4択問題");
        frame.setVisible(true);
        
    }

    String[][] csv_data = new String[8][200];
    int x = 0;
    int X = 0;
    int y = 0;
    int Y = 0;

    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    int[] Turn;
    int count = 0;
    int Point = 0;

    yontaku(String title){
        setTitle(title);
        setBounds(50, 50, 1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(255, 194, 255));
        System.setProperty("file.encoding", "UTF-8");
    
        icon2 = new ImageIcon("moyumal.png");
        setIconImage(icon2.getImage());

        String path1 = "data/";
        File file1 = new File(path1);
        File fileArray1[] = file1.listFiles();
        int a = 1;
        for (File f: fileArray1){
            if(f.isFile()) {
                System.out.println(a+"|"+f.toString().substring(path1.length()));//ファイルを表示
                a++;
            }
        }
        try{
            Scanner scan = new Scanner(System.in);
            String fileselect = scan.nextLine();
            File file = new File(path1 + fileselect);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            char colon = ',';
        
            int c = 0;
            int turn = 0;
            while((line = br.readLine()) != null){
                Count++;
                System.out.println("_________"+turn+"_________");
                while(line != ""){
                    System.out.println(line.charAt(c));
                    if(line.charAt(c) == colon){

                        System.out.println(x);
                        System.out.println(y);
                        System.out.println("["+line.substring(0,c)+"]");
                        
                        
                        csv_data[x][y] = line.substring(0,c);
                        line = line.substring(c, line.length());
                        System.out.println(line);
                        System.out.println("---"+line.charAt(0));
                        if(line.charAt(0) == colon ){
                            line = line.substring(1, line.length());
                            System.out.println(line);
                        }
                        x++;
                        c = 0;
                    }
                    c++;
                }
                x = 0;
                c = 0;
                y++;
                //csv_data[x][y] = line;
                
                
            }

            System.out.println(y);

            Turn = new int[y];

            //X = scan.nextInt();
            X = 0;
            
            
            System.out.println("Y");
            //Y = scan.nextInt();
            Y = 0;
            csv_data[2][3] = "XYZ12028";
            System.out.println(csv_data[X][Y]);
            



            br.close();
            scan.close();
        }catch(IOException e){
            System.out.println(e);
        }



        //csv.Jcsv CsvX = new csv.Jcsv();
        //CsvX.print();

        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("ファイル");

        menubar.add(menu1);

        JMenuItem menuitem1_1 = new JMenuItem("Open");
        menu1.add(menuitem1_1);


        JPanel panel = new JPanel();
        panel.setBackground(new Color(194, 255, 255));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
         
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(255, 194, 255));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));

        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(255, 255, 194));

        int count = 0;

        StringBuilder mondai = new StringBuilder();
        mondai.append("<html>"+"　"+csv_data[0][Y]);

        if(mondai.length() > 500){
            mondai.delete(0, mondai.length());
            mondai.append("500文字以上は表示できません");
        }
        //while(sb.length()% 50 == 0){
        //    sb.insert(50,"<br>");
        //}
        System.out.println(mondai);
        label = new JLabel(mondai.toString());
        label.setFont(new Font("游明朝", Font.PLAIN, 20));
        label.setOpaque(true);
        label.setBackground(Color.YELLOW);
        //label.setPreferredSize(new Dimension(180, 100));
        //label.setVerticalTextPosition(JLabel.C);
        panel.add(label);


        
        label12 = new JLabel();

        


        System.out.println(count);



        icon = new ImageIcon(Path2+csv_data[6][Y]);
        label12.setIcon(icon);
        //label12.setHorizontalTextPosition(JLabel.RIGHT);
        panel3.add(label12);

        Container contentPane = getContentPane();
        Container contentPane2 = getContentPane();
        Container contentPane3 = getContentPane();



        button1 = new JButton("ア");
        button1.addActionListener(this);
        getContentPane().add(button1);

        button2 = new JButton("イ");
        button2.addActionListener(this);
        getContentPane().add(button2);

        button3 = new JButton("ウ");
        button3.addActionListener(this);
        getContentPane().add(button3);

        button4 = new JButton("エ");
        button4.addActionListener(this);
        getContentPane().add(button4);

        label2_1 = new JLabel("　"+csv_data[1][Y]);
        JLabel label3_1 = new JLabel("　");
        label2_2 = new JLabel("　"+csv_data[2][Y]);
        JLabel label3_2 = new JLabel("　");
        label2_3 = new JLabel("　"+csv_data[3][Y]);
        JLabel label3_3 = new JLabel("　");
        label2_4 = new JLabel("　"+csv_data[4][Y]);
        JLabel label3_4 = new JLabel("　");

        panel2.add(button1);
        panel2.add(label2_1);
        panel2.add(label3_1);
        panel2.add(button2);
        panel2.add(label2_2);
        panel2.add(label3_2);
        panel2.add(button3);
        panel2.add(label2_3);
        panel2.add(label3_3);
        panel2.add(button4);
        panel2.add(label2_4);
        panel2.add(label3_4);

        
        
        contentPane.add(panel2, BorderLayout.SOUTH);
        contentPane2.add(panel3, BorderLayout.EAST);
        contentPane3.add(panel, BorderLayout.CENTER);

        setJMenuBar(menubar);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == button1){
            System.out.println("アが押されました");
            Turn[count] = 1;
            if(Integer.parseInt(csv_data[5][Y]) == 1){
                Point = Point + 1;
            }
        }else if(ae.getSource()== button2){
            System.out.println("イが押されました");
            Turn[count] = 2;
            if(Integer.parseInt(csv_data[5][Y]) == 2){
                Point = Point + 1;
            }
        }else if(ae.getSource()== button3){
            System.out.println("ウが押されました");
            Turn[count] = 3;
            if(Integer.parseInt(csv_data[5][Y]) == 3){
                Point = Point + 1;
            }
        }else if(ae.getSource()== button4){
            System.out.println("エが押されました");
            Turn[count] = 4;
            if(Integer.parseInt(csv_data[5][Y]) == 4){
                Point = Point + 1;
            }
        }

        count++;


        Y= Y + 1;
        Count--;
        label.setText("<html>"+"　"+csv_data[0][Y]);
        label2_1.setText("　"+csv_data[1][Y]);
        label2_2.setText("　"+csv_data[2][Y]);
        label2_3.setText("　"+csv_data[3][Y]);
        label2_4.setText("　"+csv_data[4][Y]);
        icon = new ImageIcon(Path2+csv_data[6][Y]);
        label12.setIcon(icon);
        while(Count==0){
            setVisible(false);
            System.out.println(Arrays.toString(Turn));
            int one = 100 / Y;
            int manten = one * Point;
            System.out.println("100点満点中"+manten+"点");
            System.exit(0);
    
        }
    }       
}