
package group.chatting.apps;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.net.*;
import java.io.*;
public class Client implements ActionListener{
     JTextField text;
     static JPanel a1;
     static Box vertical=Box.createVerticalBox();
     static JFrame f=new JFrame();
     static DataOutputStream dout;
    Client(){
          f.setLayout(null);
         //JPane se frame par color aata hai
         JPanel p1=new JPanel();
         p1.setBackground(new Color(7,94,84));
         p1.setBounds(0, 0, 450, 70);
         p1.setLayout(null);
         f.add(p1);
         //For image set
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
         //Iamge Scalling 
         Image i2=i1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel back=new JLabel(i3);
         back.setBounds(5, 20, 25, 20);
         p1.add(back);
         
        
         
         
         //Back Button k click pe action chaheye hume
        back.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent ae)
            {
                f.setVisible(false);
                //System.exit(0);
            }
        });
        //for second image
          ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
         //Iamge Scalling 
         Image i5=i4.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
         ImageIcon i6=new ImageIcon(i5);
         JLabel profile=new JLabel(i6);
         profile.setBounds(30, 15, 70, 50);
         p1.add(profile);
         //
         ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
         //Iamge Scalling 
         Image i8=i7.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
         ImageIcon i9=new ImageIcon(i8);
         JLabel video=new JLabel(i9);
         video.setBounds(300, 15, 30, 30);
         p1.add(video);
         
         //phone
         ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
         //Iamge Scalling 
         Image i11=i10.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
         ImageIcon i12=new ImageIcon(i11);
         JLabel phone=new JLabel(i12);
         phone.setBounds(360, 15, 30, 30);
         p1.add(phone);
    
          //three icons
         ImageIcon i13 =new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
         //Iamge Scalling 
         Image i14=i13.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
         ImageIcon i15=new ImageIcon(i14);
         JLabel more=new JLabel(i15);
         more.setBounds(410, 20, 5, 25);
         p1.add(more);
    
         //JLabel se freme k upar kucb v likh salte hai
         JLabel name=new JLabel("Ayan Ansari");
         name.setBounds(110,15, 200, 18);
         name.setForeground(Color.WHITE);
         name.setFont(new Font("SAN SERIF",Font.BOLD,18));
         p1.add(name);
         
         
         //JLabel se freme k upar kucb v likh salte hai
         JLabel status=new JLabel("Active Now");
         status.setBounds(110,35, 200, 14);
         status.setForeground(Color.WHITE);
         status.setFont(new Font("SAN SERIF",Font.BOLD,15));
         p1.add(status);
         
         //Another panel int the front of jFrame
         a1=new JPanel();
         a1.setBounds(5, 50, 444, 547);
         f.add(a1);
      
         //text likhna ho toh
         text=new JTextField();
         text.setBounds(5, 600, 300, 30);
         text.setFont(new Font("serif",Font.PLAIN,16));
         f.add(text);
         
         //FOR MAKING BUTTON
         JButton send=new JButton("Send");
         send.setBounds(320, 600, 120, 30);
         send.setBackground(new Color(7,94,84));
         //For click event karna ho toh
         send.addActionListener(this);
         send.setForeground(Color.WHITE);
         f.add(send);
         
         f.setSize(450,700);
         f.setLocation(800,50);
         //for the java frame is removal
         f.setUndecorated(true);
          f.getContentPane().setBackground(Color.WHITE);
         f.setVisible(true);
         
        
      
    }//funtionr4
    public void actionPerformed(ActionEvent ae)
    {  
        
        try{
        
                String out=text.getText();//YEh message jo hum log karte hai use show karta hain
      
      
                JPanel p2=formatLabel(out);//below calling JPanel and object is used in this object class
    
      
      
                   //System.out.println(out);
                a1.setLayout(new BorderLayout());//BorderLayout se messaage ko set kar sakte //top/left/buttom /up me
                JPanel right=new JPanel(new BorderLayout());//left me message send hoga 
                right.add(p2,BorderLayout.LINE_END);//message line ka end me set hoga
                vertical.add(right);
                vertical.add(Box.createVerticalStrut(15));//Message k bich me space kitna rakhna hai to 15 hai esme
               //all message a1 k andar jayega
                a1.add(vertical,BorderLayout.PAGE_START);
                //for the text send box of message removal]
               dout.writeUTF(out);
               text.setText("");
      
               //Frame k uppar message display karana
               f.repaint();
               f.invalidate();
               f.validate();
              }
                 catch (Exception e)
                {
                   e.printStackTrace();
                 }
      
      
    }
    //new funtion for J PannelAAAAA
    public static JPanel formatLabel(String out)
    {
        JPanel panel=new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        
        
        JLabel output=new JLabel("<html><p style=\"width:150px\">"+out+"</p></html>");
        output.setFont(new Font("Tahoma",Font.PLAIN,18));
        output.setForeground(Color.BLACK);
        output.setBackground(new Color(37,211,102));
        output.setOpaque(true);//for color showing 
        //Bording for padding
       
        output.setBorder(new EmptyBorder(15, 10,10,50));
       

        
        panel.add(output);
        
        //For time inserting in message
        Calendar cal=Calendar.getInstance();
        SimpleDateFormat sdf=new SimpleDateFormat();
        JLabel time=new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
       
        return panel;
    }
    public static void main(String []args)
    {
        new Client();
        try{
             Socket s=new Socket("127.0.0.1",6001); //Connect with the server
             DataInputStream din=new DataInputStream(s.getInputStream());//input for read message 
             dout=new DataOutputStream(s.getOutputStream());//output for write message
              while(true)
             {
                 a1.setLayout(new BorderLayout());
                 String msg=din.readUTF();//Take message from client
                 JPanel panel=formatLabel(msg);
                 JPanel left=new JPanel(new BorderLayout());
                 left.add(panel,BorderLayout.LINE_START);
                 vertical.add(left);
                 
                 vertical.add(Box.createVerticalStrut(15));
                 a1.add(vertical,BorderLayout.PAGE_START);
                 f.validate();
             }
    
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
