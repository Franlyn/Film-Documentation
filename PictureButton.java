import java.awt.Image;
import java.io.*;


import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.SwingConstants; 
import java.lang.Object;
import java.awt.Desktop;
import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;

 
public class PictureButton {
   public static void main(String[] args) throws IOException {
      JFrame animation=new JFrame("Choose your film");
      animation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel pic=new JPanel();
      animation.add(pic);
      
      //Add Dispicable Me
      JButton dm=new JButton();
         
      ImageIcon ani1=new ImageIcon(("Dispicable Me.jpg"));
      ani1=new ImageIcon(ani1.getImage().getScaledInstance(270, 350, Image.SCALE_SMOOTH));
         
      dm.setIcon(ani1);
      pic.add(dm);
         
         //Add listener
      dm.addActionListener(
            new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent e) {
                     //Add Frame for Dispicable Me
                  JFrame dm=new JFrame("Dispicable Me");
                  dm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  JPanel dmpic=new JPanel();
                  dm.add(dmpic);
                  
                  //********************************
                  //Add decription
                  ImageIcon ani1=new ImageIcon(("Dispicable Me.jpg"));
                  ani1=new ImageIcon(ani1.getImage().getScaledInstance(270, 350, Image.SCALE_SMOOTH));
                  JLabel dmlabel = new JLabel(
                     "<html>BRIEF INTRODUCTION:<br><br>"
                     +"When a criminal mastermind uses a trio of<br>orphan girls "
                     +"as pawns for a grand scheme, <br>he finds their love"
                     +"is profoundly changing him<br> for the better.</html>"
                     ,ani1,SwingConstants.CENTER); 
               
                  dmpic.add(dmlabel);
                  //Play Trailer 
                  JButton dmButton=new JButton("Play Trailer");
                  dmpic.add(dmButton);
                     
                  //Listener for opening the website
                  dmButton.addActionListener(
                        new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent a) {
                              OpenWeb web = new OpenWeb();
                              web.openWebpage("https://www.youtube.com/watch?v=sUkZFetWYY0&spfreload=10");        
                           }  
                        });
                   //Add back button
                  JButton back = new JButton("Exit");
                  dmpic.add(back);
                  back.addActionListener(
                        new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent e) {
                              dm.setVisible(false);
                           }});
                     
               
                  //**********************************
                  dmpic.add(dmButton);
                  dm.setSize(600,450);
                  dm.setVisible(true);            
               }  
            });
         
                  
      //Set Screen size 
      animation.setSize(1200,400);
      animation.setVisible(true);
   }
}