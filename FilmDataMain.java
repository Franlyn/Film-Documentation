//Liu Yushan 2014085104
//ICS 4U Period 1
//Film Data Main Method
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Dimension;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import java.io.*;
import java.util.Scanner; 
import java.lang.Object;
import java.awt.Desktop;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.*;
import javax.swing.event.*;


public class FilmDataMain
{
   public static void main (String[] args) throws IOException
   {
      String[] list = readFile("Film List");
      String[] animation = readFile("Animation");
      String[] romance = readFile("Romance");
      String[] drama = readFile("Drama");
      String[] fantasy = readFile("Fantasy");
      String[] usaList = readFile("USA");
      String[] ukList = readFile("UK");
      String[] franceList = readFile("France");
      String[] italyList = readFile("Italy");
      String[] aList = readFile("1970-1984");
      String[] bList = readFile("1985-1994");
      String[] cList = readFile("1995-2004");
      String[] dList = readFile("2005-2015");
      String[] afterAdd = new String[50];
      
      
      JOptionPane.showMessageDialog(null,"Welcome to Film Data Library!","Welcome",JOptionPane.PLAIN_MESSAGE);
   
   //Choose the way
      JFrame choose=new JFrame("Which way would you like to find your film");
      choose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      JPanel choosep=new JPanel();
      choose.add(choosep);
            //Add genre botton
      JButton genreButton=new JButton("A. Genre");
      genreButton.setPreferredSize(new Dimension(150,50));
      choosep.add(genreButton);
         
         //Add listener
      genreButton.addActionListener(
            new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent e) {
                  
                  {
                     JFrame genre=new JFrame("Choose the genre");
                     genre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                     JPanel genrep=new JPanel();
                     genre.add(genrep);
                  //Add Animation botton
                     JButton animationButton=new JButton("A. Animation Films");
                     animationButton.setPreferredSize(new Dimension(150,50));
                     genrep.add(animationButton);
                  
                  //Add listener
                     animationButton.addActionListener(
                           new java.awt.event.ActionListener() {
                              public void actionPerformed(java.awt.event.ActionEvent e) {
                              
                              //Choose the genre
                                 JFrame animationFrame=new JFrame("Choose your animation");
                                 animationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                 JPanel pic = new JPanel();
                                 animationFrame.add(pic,BorderLayout.SOUTH);
                                 JPanel pic2 = new JPanel();
                                 animationFrame.add(pic2,BorderLayout.CENTER);
                                 
                                 for(int i = 0; i < animation.length; i++)
                                 {
                                 //Add animations
                                    JLabel film=new JLabel();
                                 
                                    ImageIcon ani1=new ImageIcon((animation[i] + ".jpg"));
                                    ani1=new ImageIcon(ani1.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH));
                                 
                                    film.setIcon(ani1);
                                    pic2.add(film);
                                  
                                 
                                    film.setVisible(true);         
                                          
                                 }
                               
                               //Add Delete button
                                 JButton deleteButton=new JButton("Delete Animations From library");
                                 deleteButton.setPreferredSize(new Dimension(300,40));     
                                 pic.add(deleteButton);
                              
                              //Add listener
                                 deleteButton.addActionListener(
                                       new java.awt.event.ActionListener() {
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                             animationFrame.setVisible(false);
                                             
                                             String[] newAni = newArray(animation);
                                            
                                             int deleteFilm = Integer.parseInt(JOptionPane.showInputDialog(null,
                                                newAni,
                                                "Enter in the position."
                                                ,JOptionPane.PLAIN_MESSAGE));
                                          
                                             animation [deleteFilm] = null; // delete the item
                                          
                                          
                                             for (int i = deleteFilm ; i < animation.length - 1 ; i++)
                                                animation [i] = animation [i + 1];
                                          
                                             
                                             
                                             JOptionPane.showMessageDialog(null,"Deleting Successfully!");
                                          
                                          }
                                       });
                                       
                                       //Add ADD button
                                 JButton addButton=new JButton("Add Animations to library");
                                 addButton.setPreferredSize(new Dimension(300,40));      
                                 pic.add(addButton);
                              
                              //Add listener
                                 addButton.addActionListener(
                                       new java.awt.event.ActionListener() {
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                             animationFrame.setVisible(false);
                                             
                                             JOptionPane.showMessageDialog(null,"Add the picture of the film into the folder first"
                                          + "\n(Remember to check the picture has the same name as the film!)","Tip"
                                          ,JOptionPane.PLAIN_MESSAGE);
                                          
                                             String addFilm = JOptionPane.showInputDialog(null,animation,
                                                "Enter in the name."
                                                ,JOptionPane.PLAIN_MESSAGE);
                                                
                                             int appeartime = sequentialSearch(animation, addFilm);
                                                
                                             if(appeartime > 0)
                                                JOptionPane.showMessageDialog(null,"This film already exists");
                                             else
                                             {
                                                int count = 0;
                                                for(int i = 0; i < animation.length; i++)
                                                {
                                                   if(animation[i]!= null)
                                                      count ++;
                                                }
                                                animation [count] = addFilm; // add the item
                                             
                                                JOptionPane.showMessageDialog(null,"Adding Successfully!");
                                             }
                                          }
                                       });

                                                                                         
                              //Add BACK for animation
                                 JButton aniback=new JButton("Back");
                              
                                 pic.add(aniback);
                              
                              //Add listener
                                 aniback.addActionListener(
                                       new java.awt.event.ActionListener() {
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                             animationFrame.setVisible(false);
                                          }
                                       });
                                       
                                     
                                                    
                              
                              //Set Screen size 
                                 animationFrame.setSize(1200,1000);
                                 animationFrame.setVisible(true);
                              }});
                  
                  //Add Romance botton
                     JButton romanceButton=new JButton("B. Romance Film");
                     romanceButton.setPreferredSize(new Dimension(150,50));
                     genrep.add(romanceButton);
                  
                  //Add listener
                     romanceButton.addActionListener(
                           new java.awt.event.ActionListener() {
                              public void actionPerformed(java.awt.event.ActionEvent e) {
                              
                              
                              //Choose the genre
                                 JFrame romanceFrame=new JFrame("Choose your romance film");
                                 romanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                 
                                 JPanel romancepic=new JPanel();
                                 romanceFrame.add(romancepic,BorderLayout.SOUTH);
                                 
                                 JPanel romancepic2 = new JPanel();
                                 romanceFrame.add(romancepic2,BorderLayout.CENTER);
                                 
                                 for(int i = 0; i < romance.length; i++)
                                 {
                                 //Add romance
                                    JLabel film=new JLabel();
                                 
                                    ImageIcon ani1=new ImageIcon((romance[i] + ".jpg"));
                                    ani1=new ImageIcon(ani1.getImage().getScaledInstance(190, 240, Image.SCALE_SMOOTH));
                                 
                                    film.setIcon(ani1);
                                    romancepic2.add(film);
                                  
                                 
                                    film.setVisible(true);         
                                          
                                 }
                               
                               //Add Delete button
                                 JButton deleteButton=new JButton("Delete romance films From library");
                                 deleteButton.setPreferredSize(new Dimension(300,40));      
                                 romancepic.add(deleteButton);
                              
                              //Add listener
                                 deleteButton.addActionListener(
                                       new java.awt.event.ActionListener() {
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                          
                                             romanceFrame.setVisible(false);
                                             
                                             String[] newRom = newArray(romance);
                                             int deleteFilm = Integer.parseInt(JOptionPane.showInputDialog(null,newRom,
                                                "Enter in the position."
                                                ,JOptionPane.PLAIN_MESSAGE));
                                          
                                             romance [deleteFilm] = null; // delete the item
                                          
                                             for (int i = deleteFilm ; i < romance.length - 1 ; i++)
                                                romance [i] = romance [i + 1];
                                                                                     
                                             JOptionPane.showMessageDialog(null,"Deleting Successfully!");
                                          
                                          }
                                       });
                                       
                                       //Add ADD button
                                 JButton addButton=new JButton("Add romance films to library");
                                 addButton.setPreferredSize(new Dimension(300,40));      
                                 romancepic.add(addButton);
                              
                              //Add listener
                                 addButton.addActionListener(
                                       new java.awt.event.ActionListener() {
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                             romanceFrame.setVisible(false);
                                             
                                             JOptionPane.showMessageDialog(null,"Add the picture of the film into the folder first"
                                          + "\n(Remember to check the picture has the same name as the film!)","Tip"
                                          ,JOptionPane.PLAIN_MESSAGE);
                                          
                                             String addFilm = JOptionPane.showInputDialog(null,romance,
                                                "Enter in the name."
                                                ,JOptionPane.PLAIN_MESSAGE);
                                                
                                             int appeartime2 = sequentialSearch(romance, addFilm);
                                                
                                             if(appeartime2 > 0)
                                                JOptionPane.showMessageDialog(null,"This film already exists");
                                             else
                                             {
                                             
                                                int count = 0;
                                                for(int i = 0; i < romance.length; i++)
                                                {
                                                   if(romance[i]!= null)
                                                      count ++;
                                                }
                                                romance [count] = addFilm; // add the item
                                             
                                             
                                             
                                                JOptionPane.showMessageDialog(null,"Adding Successfully!");
                                             }
                                          }
                                       });
                              
                              
                                 //Add BACK for Romance
                                 JButton romback=new JButton("Back");
                              
                                 romancepic.add(romback);
                              
                              //Add listener
                                 romback.addActionListener(
                                       new java.awt.event.ActionListener() {
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                             romanceFrame.setVisible(false);
                                          }
                                       });
                              
                              
                              //Set Screen size 
                                 romanceFrame.setSize(1200,800);
                                 romanceFrame.setVisible(true);               
                              }});
                  
                  //Add Drama botton
                     JButton dramaButton=new JButton("C. Drama");
                     dramaButton.setPreferredSize(new Dimension(150,50)); 
                     genrep.add(dramaButton); 
                  
                  //Add listener
                     dramaButton.addActionListener(
                           new java.awt.event.ActionListener() {
                              public void actionPerformed(java.awt.event.ActionEvent e) {
                              
                              
                              //Choose the DRAMA
                                 JFrame dramaFrame=new JFrame("Choose your Drama");
                                 dramaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                 
                                 JPanel dramapic=new JPanel();
                                 dramaFrame.add(dramapic,BorderLayout.SOUTH);
                                 
                                 JPanel dramapic2 = new JPanel();
                                 dramaFrame.add(dramapic2,BorderLayout.CENTER);
                              
                                 for(int i = 0; i < drama.length; i++)
                                 {
                                 //Add drama
                                    JLabel film=new JLabel();
                                 
                                    ImageIcon ani1=new ImageIcon((drama[i] + ".jpg"));
                                    ani1=new ImageIcon(ani1.getImage().getScaledInstance(190, 240, Image.SCALE_SMOOTH));
                                 
                                    film.setIcon(ani1);
                                    dramapic2.add(film);
                                  
                                 
                                    film.setVisible(true);         
                                          
                                 }
                               
                               //Add Delete button
                                 JButton deleteButton=new JButton("Delete dramas From library");
                                 deleteButton.setPreferredSize(new Dimension(300,40));      
                                 dramapic.add(deleteButton);
                              
                              //Add listener
                                 deleteButton.addActionListener(
                                       new java.awt.event.ActionListener() {
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                          
                                             dramaFrame.setVisible(false);
                                             String[] newDra = newArray(drama);
                                             int deleteFilm = Integer.parseInt(JOptionPane.showInputDialog(null,newDra,
                                                "Enter in the position."
                                                ,JOptionPane.PLAIN_MESSAGE));
                                          
                                             drama [deleteFilm] = null; // delete the item
                                          
                                             for (int i = deleteFilm ; i < drama.length - 1 ; i++)
                                                drama [i] = drama[i + 1];
                                          
                                             
                                             JOptionPane.showMessageDialog(null,"Deleting Successfully!");
                                          
                                          }
                                       });
                                       
                                       //Add ADD button
                                 JButton addButton=new JButton("Add drama films to library");
                                 addButton.setPreferredSize(new Dimension(300,40));      
                                 dramapic.add(addButton);
                              
                              //Add listener
                                 addButton.addActionListener(
                                       new java.awt.event.ActionListener() {
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                             dramaFrame.setVisible(false);
                                             
                                             JOptionPane.showMessageDialog(null,"Add the picture of the film into the folder first"
                                          + "\n(Remember to check the picture has the same name as the film!)","Tip"
                                          ,JOptionPane.PLAIN_MESSAGE);
                                          
                                             String addFilm = JOptionPane.showInputDialog(null,drama,
                                                "Enter in the name."
                                                ,JOptionPane.PLAIN_MESSAGE);
                                                
                                             int appeartime3 = sequentialSearch(drama, addFilm);
                                                
                                             if(appeartime3 > 0)
                                                JOptionPane.showMessageDialog(null,"This film already exists");
                                             else
                                             {
                                             
                                                int count = 0;
                                                for(int i = 0; i < drama.length; i++)
                                                {
                                                   if(drama[i]!= null)
                                                      count ++;
                                                }
                                                drama [count] = addFilm; // add the item
                                             
                                                JOptionPane.showMessageDialog(null,"Adding Successfully!");
                                             }
                                          }
                                       });
                              //Add BACK for drama
                                 JButton draback=new JButton("Back");
                              
                                 dramapic.add(draback);
                              
                              //Add listener
                                 draback.addActionListener(
                                       new java.awt.event.ActionListener() {
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                             dramaFrame.setVisible(false);
                                          }
                                       });
                              
                              //Set Screen size 
                                 dramaFrame.setSize(1300,800);
                                 dramaFrame.setVisible(true);               
                              }});
                              
                  //Add Fantasy botton
                     JButton fantasyButton=new JButton("D. Fantasy Films");
                     fantasyButton.setPreferredSize(new Dimension(150,50));
                     genrep.add(fantasyButton);
                  
                  //Add listener
                     fantasyButton.addActionListener(
                           new java.awt.event.ActionListener() {
                              public void actionPerformed(java.awt.event.ActionEvent e) {
                              
                              
                              //Choose the genre
                                 JFrame fantasyFrame=new JFrame("Choose your fantasy film");
                                 fantasyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                 
                                 JPanel fantasypic=new JPanel();
                                 fantasyFrame.add(fantasypic,BorderLayout.SOUTH);
                                 
                                 JPanel fantasypic2 = new JPanel();
                                 fantasyFrame.add(fantasypic2,BorderLayout.CENTER);
                              
                              
                              
                                 for(int i = 0; i < fantasy.length; i++)
                                 {
                                 //Add fantasy
                                    JLabel film=new JLabel();
                                 
                                    ImageIcon ani1=new ImageIcon((fantasy[i] + ".jpg"));
                                    ani1=new ImageIcon(ani1.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH));
                                 
                                    film.setIcon(ani1);
                                    fantasypic2.add(film);
                                  
                                 
                                    film.setVisible(true);         
                                          
                                 }
                               
                               //Add Delete button
                                 JButton deleteButton=new JButton("Delete fantasy films From library");
                                 deleteButton.setPreferredSize(new Dimension(300,40));      
                                 fantasypic.add(deleteButton);
                              
                              //Add listener
                                 deleteButton.addActionListener(
                                       new java.awt.event.ActionListener() {
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                          
                                             fantasyFrame.setVisible(false);
                                             String[] newFan = newArray(fantasy);
                                             int deleteFilm = Integer.parseInt(JOptionPane.showInputDialog(null,newFan,
                                                "Enter in the position."
                                                ,JOptionPane.PLAIN_MESSAGE));
                                          
                                             fantasy [deleteFilm] = null; // delete the item
                                          
                                             for (int i = deleteFilm ; i < fantasy.length - 1 ; i++)
                                                fantasy [i] = fantasy[i + 1];
                                          
                                             
                                             JOptionPane.showMessageDialog(null,"Deleting Successfully!");
                                          
                                          }
                                       });
                                       
                                       //Add ADD button
                                 JButton addButton=new JButton("Add fantasy films to library");
                                 addButton.setPreferredSize(new Dimension(300,40));      
                                 fantasypic.add(addButton);
                              
                              //Add listener
                                 addButton.addActionListener(
                                       new java.awt.event.ActionListener() {
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                             fantasyFrame.setVisible(false);
                                             
                                             JOptionPane.showMessageDialog(null,"Add the picture of the film into the folder first"
                                          + "\n(Remember to check the picture has the same name as the film!)","Tip"
                                          ,JOptionPane.PLAIN_MESSAGE);
                                          
                                             String addFilm = JOptionPane.showInputDialog(null,fantasy,
                                                "Enter in the name."
                                                ,JOptionPane.PLAIN_MESSAGE);
                                                
                                             int appeartime4 = sequentialSearch(fantasy, addFilm);
                                                
                                             if(appeartime4 > 0)
                                                JOptionPane.showMessageDialog(null,"This film already exists");
                                             else
                                             {
                                             
                                                int count = 0;
                                                for(int i = 0; i < fantasy.length; i++)
                                                {
                                                   if(fantasy[i]!= null)
                                                      count ++;
                                                }
                                                fantasy [count] = addFilm; // add the item
                                             
                                                JOptionPane.showMessageDialog(null,"Adding Successfully!");
                                             }
                                          }
                                       });
                              
                              
                              //Add BACK for fantasy
                                 JButton fanback=new JButton("Back");
                              
                                 fantasypic.add(fanback);
                              
                              //Add listener
                                 fanback.addActionListener(
                                       new java.awt.event.ActionListener() {
                                          public void actionPerformed(java.awt.event.ActionEvent e) {
                                             fantasyFrame.setVisible(false);
                                          }
                                       });
                              
                              
                              //Set Screen size 
                                 fantasyFrame.setSize(1200,600);
                                 fantasyFrame.setVisible(true);
                              }});
                              
                              //Add BACK for genre
                     JButton genreback=new JButton("Back");
                              
                     genrep.add(genreback);
                              
                              //Add listener
                     genreback.addActionListener(
                           new java.awt.event.ActionListener() {
                              public void actionPerformed(java.awt.event.ActionEvent e) {
                                 genre.setVisible(false);
                              }
                           });
                  
                              
                  //Set Screen size 
                     genre.setSize(350,180);
                     genre.setVisible(true);
                     genre.setLocation(420,300);
                  
                  }}});
                  
                  //Add country button
      JButton countryButton=new JButton("B. Publish Country");
      countryButton.setPreferredSize(new Dimension(150,50));        
      choosep.add(countryButton);
                              
                     //Add listener
      countryButton.addActionListener(
            new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent e) {
                  JFrame country=new JFrame("Choose the publish country");
                  country.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  JPanel countryp=new JPanel();
                  country.add(countryp);
               
                                 //Add USA
                  JButton usa=new JButton();
                              
                  ImageIcon usaicon=new ImageIcon(("USA.jpg"));
                  usaicon = new ImageIcon(usaicon.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH));
                              
                  usa.setIcon(usaicon);
                  countryp.add(usa);
                              
                              //Add listener
                  usa.addActionListener(
                        new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent e) {
                                          //Add Frame USA
                              JFrame usa=new JFrame("American Film");
                              usa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                              
                              JPanel usapic=new JPanel();
                              usa.add(usapic,BorderLayout.SOUTH);
                                 
                              JPanel usapic2 = new JPanel();
                              usa.add(usapic2,BorderLayout.CENTER);
                                             
                              for(int i = 0; i < usaList.length; i++)
                              {
                                 //Add usaList
                                 JLabel film=new JLabel();
                                 
                                 ImageIcon ani1=new ImageIcon((usaList[i] + ".jpg"));
                                 ani1=new ImageIcon(ani1.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH));
                                 
                                 film.setIcon(ani1);
                                 usapic2.add(film);
                                  
                                 
                                 film.setVisible(true);         
                                          
                              }
                               
                               //Add Delete button
                              JButton deleteButton=new JButton("Delete USA films From library");
                              deleteButton.setPreferredSize(new Dimension(300,40));      
                              usapic.add(deleteButton);
                              
                              //Add listener
                              deleteButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          
                                          usa.setVisible(false);
                                          
                                          String[] newUSA = newArray(usaList);
                                          int deleteFilm = Integer.parseInt(JOptionPane.showInputDialog(null,newUSA,
                                                "Enter in the position."
                                                ,JOptionPane.PLAIN_MESSAGE));
                                          
                                          usaList [deleteFilm] = null; // delete the item
                                          
                                          for (int i = deleteFilm ; i < usaList.length - 1 ; i++)
                                             usaList [i] = usaList[i + 1];
                                          
                                             
                                          JOptionPane.showMessageDialog(null,"Deleting Successfully!");
                                          
                                       }
                                    });
                                       
                                       //Add ADD button
                              JButton addButton=new JButton("Add USA films to library");
                              addButton.setPreferredSize(new Dimension(300,40));      
                              usapic.add(addButton);
                              
                              //Add listener
                              addButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          usa.setVisible(false);
                                          
                                          JOptionPane.showMessageDialog(null,"Add the picture of the film into the folder first"
                                          + "\n(Remember to check the picture has the same name as the film!)","Tip"
                                          ,JOptionPane.PLAIN_MESSAGE);
                                          
                                          String addFilm = JOptionPane.showInputDialog(null,usaList,
                                                "Enter in the name."
                                                ,JOptionPane.PLAIN_MESSAGE);
                                                
                                          int appeartime5 = sequentialSearch(usaList, addFilm);
                                                
                                          if(appeartime5 > 0)
                                             JOptionPane.showMessageDialog(null,"This film already exists");
                                          else
                                          {
                                          
                                             int count = 0;
                                             for(int i = 0; i < usaList.length; i++)
                                             {
                                                if(usaList[i]!= null)
                                                   count ++;
                                             }
                                             usaList [count] = addFilm; // add the item
                                          
                                             JOptionPane.showMessageDialog(null,"Adding Successfully!");
                                          }
                                       }
                                    });
                           
                               //Add back for usa frame
                              JButton back=new JButton("Back");
                              back.setPreferredSize(new Dimension(60,40));
                              usapic.add(back);
                              
                              //Add listener
                              back.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          usa.setVisible(false);                  
                                       }  
                                    });    
                                                    
                              usa.setSize(1100,900);
                              usa.setVisible(true);                  
                           }  
                        });
                                     //Add UK
                  JButton uk=new JButton();
                              
                  ImageIcon ukicon=new ImageIcon(("UK.jpg"));
                  ukicon = new ImageIcon(ukicon.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH));
                              
                  uk.setIcon(ukicon);
                  countryp.add(uk);
                              
                              //Add listener
                  uk.addActionListener(
                        new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent e) {
                                          //Add Frame UK
                              JFrame uk=new JFrame("British Film");
                              uk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                              
                              JPanel ukpic=new JPanel();
                              uk.add(ukpic,BorderLayout.SOUTH);
                                 
                              JPanel ukpic2 = new JPanel();
                              uk.add(ukpic2,BorderLayout.CENTER);
                                             
                              for(int i = 0; i < ukList.length; i++)
                              {
                                 //Add ukList
                                 JLabel film=new JLabel();
                                 
                                 ImageIcon ani1=new ImageIcon((ukList[i] + ".jpg"));
                                 ani1=new ImageIcon(ani1.getImage().getScaledInstance(190, 240, Image.SCALE_SMOOTH));
                                 
                                 film.setIcon(ani1);
                                 ukpic2.add(film);
                                  
                                 
                                 film.setVisible(true);         
                                          
                              }
                               
                               //Add Delete button
                              JButton deleteButton=new JButton("Delete UK films From library");
                              deleteButton.setPreferredSize(new Dimension(300,40));      
                              ukpic.add(deleteButton);
                              
                              //Add listener
                              deleteButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          
                                          uk.setVisible(false);
                                          
                                          String[] newUK = newArray(ukList);
                                          int deleteFilm = Integer.parseInt(JOptionPane.showInputDialog(null,newUK,
                                                "Enter in the position."
                                                ,JOptionPane.PLAIN_MESSAGE));
                                          
                                          ukList [deleteFilm] = null; // delete the item
                                          
                                          for (int i = deleteFilm ; i < ukList.length - 1 ; i++)
                                             ukList [i] = ukList[i + 1];
                                             
                                          JOptionPane.showMessageDialog(null,"Deleting Successfully!");
                                          
                                       }
                                    });
                                       
                                       //Add ADD button
                              JButton addButton=new JButton("Add UK films to library");
                              addButton.setPreferredSize(new Dimension(300,40));      
                              ukpic.add(addButton);
                              
                              //Add listener
                              addButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          uk.setVisible(false);
                                          
                                          JOptionPane.showMessageDialog(null,"Add the picture of the film into the folder first"
                                          + "\n(Remember to check the picture has the same name as the film!)","Tip"
                                          ,JOptionPane.PLAIN_MESSAGE);
                                          
                                          String addFilm = JOptionPane.showInputDialog(null,ukList,
                                                "Enter in the name."
                                                ,JOptionPane.PLAIN_MESSAGE);
                                          int appeartime6 = sequentialSearch(ukList, addFilm);
                                                
                                          if(appeartime6 > 0)
                                             JOptionPane.showMessageDialog(null,"This film already exists");
                                          else
                                          {
                                          
                                             int count = 0;
                                             for(int i = 0; i < ukList.length; i++)
                                             {
                                                if(ukList[i]!= null)
                                                   count ++;
                                             }
                                             ukList [count] = addFilm; // add the item
                                          
                                             JOptionPane.showMessageDialog(null,"Adding Successfully!");
                                          }
                                       }
                                    });
                           
                                  //Add back for uk frame
                              JButton back=new JButton("Back");
                              ukpic.add(back);
                              
                              //Add listener
                              back.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          uk.setVisible(false);                  
                                       }  
                                    });
                           
                              uk.setSize(1300,600);
                              uk.setVisible(true);                  
                           }  
                        });
                                       
                                       //Add France
                  JButton france=new JButton();
                              
                  ImageIcon franceicon=new ImageIcon(("France.jpg"));
                  franceicon = new ImageIcon(franceicon.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH));
                              
                  france.setIcon(franceicon);
                  countryp.add(france);
                              
                              //Add listener
                  france.addActionListener(
                        new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent e) {
                                          //Add Frame France
                              JFrame france=new JFrame("French Film");
                              france.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                              
                              JPanel francepic=new JPanel();
                              france.add(francepic,BorderLayout.SOUTH);
                                 
                              JPanel francepic2 = new JPanel();
                              france.add(francepic2,BorderLayout.CENTER);
                           
                                             
                              for(int i = 0; i < franceList.length; i++)
                              {
                                 //Add franceList
                                 JLabel film=new JLabel();
                                 
                                 ImageIcon ani1=new ImageIcon((franceList[i] + ".jpg"));
                                 ani1=new ImageIcon(ani1.getImage().getScaledInstance(190, 240, Image.SCALE_SMOOTH));
                                 
                                 film.setIcon(ani1);
                                 francepic2.add(film);
                                  
                                 
                                 film.setVisible(true);         
                                          
                              }
                               
                               //Add Delete button
                              JButton deleteButton=new JButton("Delete France films From library");
                              deleteButton.setPreferredSize(new Dimension(300,40));      
                              francepic.add(deleteButton);
                              
                              //Add listener
                              deleteButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          
                                          france.setVisible(false);
                                          
                                          String[] newFrance = newArray(franceList);
                                          int deleteFilm = Integer.parseInt(JOptionPane.showInputDialog(null,newFrance,
                                                "Enter in the position."
                                                ,JOptionPane.PLAIN_MESSAGE));
                                          
                                          franceList [deleteFilm] = null; // delete the item
                                          
                                          for (int i = deleteFilm ; i < franceList.length - 1 ; i++)
                                             franceList [i] = franceList[i + 1];
                                             
                                          JOptionPane.showMessageDialog(null,"Deleting Successfully!");
                                          
                                       }
                                    });
                                       
                                       //Add ADD button
                              JButton addButton=new JButton("Add France films to library");
                              addButton.setPreferredSize(new Dimension(300,40));      
                              francepic.add(addButton);
                              
                              //Add listener
                              addButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          france.setVisible(false);
                                          
                                          JOptionPane.showMessageDialog(null,"Add the picture of the film into the folder first"
                                          + "\n(Remember to check the picture has the same name as the film!)","Tip"
                                          ,JOptionPane.PLAIN_MESSAGE);
                                          
                                          String addFilm = JOptionPane.showInputDialog(null,franceList,
                                                "Enter in the name."
                                                ,JOptionPane.PLAIN_MESSAGE);
                                                
                                          int appeartime7 = sequentialSearch(franceList, addFilm);
                                                
                                          if(appeartime7 > 0)
                                             JOptionPane.showMessageDialog(null,"This film already exists");
                                          else
                                          {
                                          
                                             int count = 0;
                                             for(int i = 0; i < franceList.length; i++)
                                             {
                                                if(franceList[i]!= null)
                                                   count ++;
                                             }
                                             franceList [count] = addFilm; // add the item
                                          
                                             JOptionPane.showMessageDialog(null,"Adding Successfully!");
                                          }  
                                       }
                                    });
                                          
                                          //Add back for france frame
                              JButton back=new JButton("Back");
                              back.setPreferredSize(new Dimension(60,40));
                              francepic.add(back);
                              
                              //Add listener
                              back.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          france.setVisible(false);                  
                                       }  
                                    });
                           
                              france.setSize(1200,800);
                              france.setVisible(true);                  
                           }  
                        });
               
                                 //Add Italy
                  JButton italy=new JButton();
                              
                  ImageIcon italyicon=new ImageIcon(("Italy.jpg"));
                  italyicon = new ImageIcon(italyicon.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH));
                              
                  italy.setIcon(italyicon);
                  countryp.add(italy);
                              
                              //Add listener
                  italy.addActionListener(
                        new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent e) {
                                          //Add Frame Italy
                              JFrame italy=new JFrame("Italian Film");
                              italy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                              
                              JPanel italypic=new JPanel();
                              italy.add(italypic,BorderLayout.SOUTH);
                                 
                              JPanel italypic2 = new JPanel();
                              italy.add(italypic2,BorderLayout.CENTER);
                           
                              for(int i = 0; i < italyList.length; i++)
                              {
                                 //Add italyList
                                 JLabel film=new JLabel();
                                 
                                 ImageIcon ani1=new ImageIcon((italyList[i] + ".jpg"));
                                 ani1=new ImageIcon(ani1.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH));
                                 
                                 film.setIcon(ani1);
                                 italypic2.add(film);
                                  
                                 
                                 film.setVisible(true);         
                                          
                              }
                               
                               //Add Delete button
                              JButton deleteButton=new JButton("Delete Italy films From library");
                              deleteButton.setPreferredSize(new Dimension(300,40));      
                              italypic.add(deleteButton);
                              
                              //Add listener
                              deleteButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          
                                          italy.setVisible(false);
                                          
                                          String[] newItaly = newArray(italyList);
                                          int deleteFilm = Integer.parseInt(JOptionPane.showInputDialog(null,newItaly,
                                                "Enter in the position."
                                                ,JOptionPane.PLAIN_MESSAGE));
                                          
                                          italyList [deleteFilm] = null; // delete the item
                                          
                                          for (int i = deleteFilm ; i < italyList.length - 1 ; i++)
                                             italyList [i] = italyList[i + 1];
                                          
                                             
                                          JOptionPane.showMessageDialog(null,"Deleting Successfully!");
                                          
                                       }
                                    });
                                       
                                       //Add ADD button
                              JButton addButton=new JButton("Add Italy films to library");
                              addButton.setPreferredSize(new Dimension(300,40));      
                              italypic.add(addButton);
                              
                              //Add listener
                              addButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          italy.setVisible(false);
                                          
                                          JOptionPane.showMessageDialog(null,"Add the picture of the film into the folder first"
                                          + "\n(Remember to check the picture has the same name as the film!)","Tip"
                                          ,JOptionPane.PLAIN_MESSAGE);
                                          
                                          String addFilm = JOptionPane.showInputDialog(null,
                                          italyList,
                                                "Enter in the name"
                                                ,JOptionPane.PLAIN_MESSAGE);
                                                
                                          int appeartime8 = sequentialSearch(italyList, addFilm);
                                                
                                          if(appeartime8 > 0)
                                             JOptionPane.showMessageDialog(null,"This film already exists");
                                          else
                                          {
                                          
                                             int count = 0;
                                             for(int i = 0; i < italyList.length; i++)
                                             {
                                                if(italyList[i]!= null)
                                                   count ++;
                                             }
                                             italyList [count] = addFilm; // add the item
                                          
                                             JOptionPane.showMessageDialog(null,"Adding Successfully!");
                                          
                                          }}
                                    });
                                       //Add back for italy frame
                              JButton back=new JButton("Back");
                              italypic.add(back);
                              
                              //Add listener
                              back.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          italy.setVisible(false);                  
                                       }  
                                    });
                           
                           
                              italy.setSize(1200,700);
                              italy.setVisible(true);                  
                           }  
                        });
                                       
                                       //Add back for country frame
                  JButton back=new JButton("Back");
                  countryp.add(back);
                              
                              //Add listener
                  back.addActionListener(
                        new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent e) {
                              country.setVisible(false);                  
                           }  
                        });
               
                     //Set Screen size 
                  country.setSize(500,360);
                  country.setVisible(true);
                  country.setLocation(420,300);
               
                                 
               }
            });
            
            //Add time button
      JButton timeButton=new JButton("C. Publish Time");
      timeButton.setPreferredSize(new Dimension(150,50));        
      choosep.add(timeButton);
                              
                     //Add listener
      timeButton.addActionListener(
            new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent e) {
                                 
                  JFrame time=new JFrame("Choose the publish time");
                  time.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  JPanel timep=new JPanel();
                  time.add(timep);
               
                                 //Add 1970-1984
                  JButton a=new JButton("1970-1984");
                  a.setPreferredSize(new Dimension(150,50));
                  timep.add(a);
                              
                              //Add listener
                  a.addActionListener(
                        new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent e) {
                                          //Add Frame 1970-1984
                              JFrame a=new JFrame("1970-1984");
                              a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                              
                              JPanel apic=new JPanel();
                              a.add(apic,BorderLayout.SOUTH);
                                 
                              JPanel apic2 = new JPanel();
                              a.add(apic2,BorderLayout.CENTER);
                                 
                              for(int i = 0; i < aList.length; i++)
                              {
                                 //Add aList
                                 JLabel film=new JLabel();
                                 
                                 ImageIcon ani1=new ImageIcon((aList[i] + ".jpg"));
                                 ani1=new ImageIcon(ani1.getImage().getScaledInstance(190, 240, Image.SCALE_SMOOTH));
                                 
                                 film.setIcon(ani1);
                                 apic2.add(film);
                                  
                                 
                                 film.setVisible(true);         
                                          
                              }
                               
                               //Add Delete button
                              JButton deleteButton=new JButton("Delete 1970-1984 films From library");
                              deleteButton.setPreferredSize(new Dimension(300,40));      
                              apic.add(deleteButton);
                              
                              //Add listener
                              deleteButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          
                                          a.setVisible(false);
                                          
                                          String[] newA = newArray(aList);
                                          int deleteFilm = Integer.parseInt(JOptionPane.showInputDialog(null,newA,
                                                "Enter in the position."
                                                ,JOptionPane.PLAIN_MESSAGE));
                                          
                                          aList [deleteFilm] = null; // delete the item
                                          
                                          for (int i = deleteFilm ; i < aList.length - 1 ; i++)
                                             aList [i] = aList[i + 1];
                                          
                                             
                                          JOptionPane.showMessageDialog(null,"Deleting Successfully!");
                                          
                                       }
                                    });
                                       
                                       //Add ADD button
                              JButton addButton=new JButton("Add 1970-1984 films to library");
                              addButton.setPreferredSize(new Dimension(300,40));      
                              apic.add(addButton);
                              
                              //Add listener
                              addButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          a.setVisible(false);
                                          
                                          JOptionPane.showMessageDialog(null,"Add the picture of the film into the folder first"
                                          + "\n(Remember to check the picture has the same name as the film!)","Tip"
                                          ,JOptionPane.PLAIN_MESSAGE);
                                          
                                          String addFilm = JOptionPane.showInputDialog(null,aList,
                                                "Enter in the name."
                                                ,JOptionPane.PLAIN_MESSAGE);
                                                
                                          int appear1 = sequentialSearch(aList, addFilm);
                                                
                                          if(appear1 > 0)
                                             JOptionPane.showMessageDialog(null,"This film already exists");
                                          else
                                          {
                                          
                                             int count = 0;
                                             for(int i = 0; i < aList.length; i++)
                                             {
                                                if(aList[i] != null)
                                                   count ++;
                                             }
                                             aList [count] = addFilm; // add the item
                                          
                                             JOptionPane.showMessageDialog(null,"Adding Successfully!");
                                          }
                                       }
                                    });
                           
                                          //Add back for a frame
                              JButton back=new JButton("Back");
                              apic.add(back);
                              
                              //Add listener
                              back.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          a.setVisible(false);                  
                                       }  
                                    });
                           
                              a.setSize(1200,600);
                              a.setVisible(true);                  
                           }  
                        });
                                     //Add 1985-1994
                  JButton b=new JButton("1985-1994");
                  b.setPreferredSize(new Dimension(150,50));
                  timep.add(b);
                              
                              //Add listener
                  b.addActionListener(
                        new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent e) {
                                          //Add Frame 1985-1994
                              JFrame b=new JFrame("1985-1994");
                              b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                              
                              JPanel bpic=new JPanel();
                              b.add(bpic,BorderLayout.SOUTH);
                                 
                              JPanel bpic2 = new JPanel();
                              b.add(bpic2,BorderLayout.CENTER);
                                 
                              for(int i = 0; i < bList.length; i++)
                              {
                                 //Add bList
                                 JLabel film=new JLabel();
                                 
                                 ImageIcon ani1=new ImageIcon((bList[i] + ".jpg"));
                                 ani1=new ImageIcon(ani1.getImage().getScaledInstance(190, 240, Image.SCALE_SMOOTH));
                                 
                                 film.setIcon(ani1);
                                 bpic2.add(film);
                                  
                                 
                                 film.setVisible(true);         
                                          
                              }
                               
                               //Add Delete button
                              JButton deleteButton=new JButton("Delete 1985-1994 films From library");
                              deleteButton.setPreferredSize(new Dimension(300,40));      
                              bpic.add(deleteButton);
                              
                              //Add listener
                              deleteButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          
                                          b.setVisible(false);
                                          
                                          String[] newB = newArray(bList);
                                          int deleteFilm = Integer.parseInt(JOptionPane.showInputDialog(null,newB,
                                                "Enter in the position."
                                                ,JOptionPane.PLAIN_MESSAGE));
                                          
                                          bList [deleteFilm] = null; // delete the item
                                          
                                          for (int i = deleteFilm ; i < bList.length - 1 ; i++)
                                             bList [i] = bList[i + 1];
                                          
                                             
                                          JOptionPane.showMessageDialog(null,"Deleting Successfully!");
                                          
                                       }
                                    });
                                       
                                       //Add ADD button
                              JButton addButton=new JButton("Add 1985-1994 films to library");
                              addButton.setPreferredSize(new Dimension(300,40));      
                              bpic.add(addButton);
                              
                              //Add listener
                              addButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          b.setVisible(false);
                                          
                                          JOptionPane.showMessageDialog(null,"Add the picture of the film into the folder first"
                                          + "\n(Remember to check the picture has the same name as the film!)","Tip"
                                          ,JOptionPane.PLAIN_MESSAGE);
                                          
                                          String addFilm = JOptionPane.showInputDialog(null,bList,
                                                "Enter in the name."
                                                ,JOptionPane.PLAIN_MESSAGE);
                                                
                                          int appear2 = sequentialSearch(bList, addFilm);
                                                
                                          if(appear2 > 0)
                                             JOptionPane.showMessageDialog(null,"This film already exists");
                                          else
                                          {
                                             int count = 0;
                                             for(int i = 0; i < bList.length; i++)
                                             {
                                                if(bList[i] != null)
                                                   count ++;
                                             }
                                             bList [count] = addFilm; // add the item
                                          
                                             JOptionPane.showMessageDialog(null,"Adding Successfully!");
                                          
                                          }}
                                    });
                           
                                          //Add back for b frame
                              JButton back=new JButton("Back");
                             
                              bpic.add(back);
                              
                              //Add listener
                              back.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          b.setVisible(false);                  
                                       }  
                                    });
                           
                              b.setSize(1200,700);
                              b.setVisible(true);                  
                           }  
                        });
                                       
                                       //Add 1995-2004
                  JButton c=new JButton("1995-2004");
                  c.setPreferredSize(new Dimension(150,50));
                  timep.add(c);
                              
                              //Add listener
                  c.addActionListener(
                        new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent e) {
                                          //Add Frame 1995-2004
                              JFrame c=new JFrame("1995-2004");
                              c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                              
                              JPanel cpic=new JPanel();
                              c.add(cpic,BorderLayout.SOUTH);
                                 
                              JPanel cpic2 = new JPanel();
                              c.add(cpic2,BorderLayout.CENTER);
                                 
                              for(int i = 0; i < cList.length; i++)
                              {
                                 //Add cList
                                 JLabel film=new JLabel();
                                 
                                 ImageIcon ani1=new ImageIcon((cList[i] + ".jpg"));
                                 ani1=new ImageIcon(ani1.getImage().getScaledInstance(190, 240, Image.SCALE_SMOOTH));
                                 
                                 film.setIcon(ani1);
                                 cpic2.add(film);
                                  
                                 
                                 film.setVisible(true);         
                                          
                              }
                               
                               //Add Delete button
                              JButton deleteButton=new JButton("Delete 1995-2004 films From library");
                              deleteButton.setPreferredSize(new Dimension(300,40));      
                              cpic.add(deleteButton);
                              
                              //Add listener
                              deleteButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          
                                          c.setVisible(false);
                                          String[] newC = newArray(cList);
                                          int deleteFilm = Integer.parseInt(JOptionPane.showInputDialog(null,newC,
                                                "Enter in the position."
                                                ,JOptionPane.PLAIN_MESSAGE));
                                          
                                          cList [deleteFilm] = null; // delete the item
                                          
                                          for (int i = deleteFilm ; i < cList.length - 1 ; i++)
                                             cList [i] = cList[i + 1];
                                          
                                                   
                                          JOptionPane.showMessageDialog(null,"Deleting Successfully!");
                                          
                                       }
                                    });
                                       
                                       //Add ADD button
                              JButton addButton=new JButton("Add 1995-2004 films to library");
                              addButton.setPreferredSize(new Dimension(300,40));      
                              cpic.add(addButton);
                              
                              //Add listener
                              addButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          c.setVisible(false);
                                          
                                          JOptionPane.showMessageDialog(null,"Add the picture of the film into the folder first"
                                          + "\n(Remember to check the picture has the same name as the film!)","Tip"
                                          ,JOptionPane.PLAIN_MESSAGE);
                                          
                                          String addFilm = JOptionPane.showInputDialog(null,cList,
                                                "Enter in the name."
                                                ,JOptionPane.PLAIN_MESSAGE);
                                                
                                          int appear3 = sequentialSearch(cList, addFilm);
                                                
                                          if(appear3 > 0)
                                             JOptionPane.showMessageDialog(null,"This film already exists");
                                          else
                                          {
                                             int count = 0;
                                             for(int i = 0; i < cList.length; i++)
                                             {
                                                if(cList[i] != null)
                                                   count ++;
                                             }
                                             cList [count] = addFilm; // add the item
                                          
                                             JOptionPane.showMessageDialog(null,"Adding Successfully!");
                                          }
                                       }
                                    });
                           
                                          //Add back for c frame
                              JButton back=new JButton("Back");
                              cpic.add(back);
                              
                              //Add listener
                              back.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          c.setVisible(false);                  
                                       }  
                                    });
                           
                              c.setSize(1200,700);
                              c.setVisible(true);                  
                           }  
                        });
                                       
                                     //Add 2005-2015
                  JButton d=new JButton("2005-2015");
                  d.setPreferredSize(new Dimension(150,50));
                  timep.add(d);
                              
                              //Add listener
                  d.addActionListener(
                        new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent e) {
                                          //Add Frame 2005-2015
                              JFrame d=new JFrame("2005-2015");
                              d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                              
                              JPanel dpic=new JPanel();
                              d.add(dpic,BorderLayout.SOUTH);
                                 
                              JPanel dpic2 = new JPanel();
                              d.add(dpic2,BorderLayout.CENTER);
                                 
                              for(int i = 0; i < dList.length; i++)
                              {
                                 //Add dList
                                 JLabel film=new JLabel();
                                 
                                 ImageIcon ani1=new ImageIcon((dList[i] + ".jpg"));
                                 ani1=new ImageIcon(ani1.getImage().getScaledInstance(190, 240, Image.SCALE_SMOOTH));
                                 
                                 film.setIcon(ani1);
                                 dpic2.add(film);
                                  
                                 
                                 film.setVisible(true);         
                                          
                              }
                               
                               //Add Delete button
                              JButton deleteButton=new JButton("Delete 2005-2015 films From library");
                              deleteButton.setPreferredSize(new Dimension(300,40));      
                              dpic.add(deleteButton);
                              
                              //Add listener
                              deleteButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          
                                          d.setVisible(false);
                                          
                                          String[] newD = newArray(dList);
                                          int deleteFilm = Integer.parseInt(JOptionPane.showInputDialog(null,newD,
                                                "Enter in the position."
                                                ,JOptionPane.PLAIN_MESSAGE));
                                          
                                          dList [deleteFilm] = null; // delete the item
                                          
                                          for (int i = deleteFilm ; i < dList.length - 1 ; i++)
                                             dList [i] = dList[i + 1];
                                          
                                         JOptionPane.showMessageDialog(null,"Deleting Successfully!");
                                          
                                       }
                                    });
                                       
                                       //Add ADD button
                              JButton addButton=new JButton("Add 2005-2015 films to library");
                              addButton.setPreferredSize(new Dimension(300,40));      
                              dpic.add(addButton);
                              
                              //Add listener
                              addButton.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          d.setVisible(false);
                                          
                                          JOptionPane.showMessageDialog(null,"Add the picture of the film into the folder first"
                                          + "\n(Remember to check the picture has the same name as the film!)","Tip"
                                          ,JOptionPane.PLAIN_MESSAGE);
                                          
                                          String addFilm = JOptionPane.showInputDialog(null,dList,
                                                "Enter in the name."
                                                ,JOptionPane.PLAIN_MESSAGE);
                                                
                                          int appear4 = sequentialSearch(dList, addFilm);
                                                
                                          if(appear4 > 0)
                                             JOptionPane.showMessageDialog(null,"This film already exists");
                                          else
                                          {
                                             int count = 0;
                                             for(int i = 0; i < dList.length; i++)
                                             {
                                                if(dList[i] != null)
                                                   count ++;
                                             }
                                             dList [count] = addFilm; // add the item
                                          
                                             JOptionPane.showMessageDialog(null,"Adding Successfully!");
                                          }
                                       }
                                    });
                           
                                          //Add back for d frame
                              JButton back=new JButton("Back");
                              dpic.add(back);
                              
                              //Add listener
                              back.addActionListener(
                                    new java.awt.event.ActionListener() {
                                       public void actionPerformed(java.awt.event.ActionEvent e) {
                                          d.setVisible(false);                  
                                       }  
                                    });
                           
                              d.setSize(1400,700);
                              d.setVisible(true);                  
                           }  
                        });
               
                                       
                                //Add back for time frame
                  JButton back=new JButton("Back");
                  timep.add(back);
                              
                              //Add listener
                  back.addActionListener(
                        new java.awt.event.ActionListener() {
                           public void actionPerformed(java.awt.event.ActionEvent e) {
                              time.setVisible(false);                  
                           }  
                        });
               
                     //Set Screen size 
                  time.setSize(350,200);
                  time.setVisible(true);
                  time.setLocation(420,300);
                          
               }
            });
            
            //Add search button
      JButton searchButton=new JButton("D. Search Film Name");
      searchButton.setPreferredSize(new Dimension(150,50));        
      choosep.add(searchButton);
                              
                     //Add listener
      searchButton.addActionListener(
            new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent e) {
                  String search = JOptionPane.showInputDialog(null,"Enter the film name"
                     ,JOptionPane.PLAIN_MESSAGE);
                     
                  int results = sequentialSearch(list,search);
                     
                  if(results > 0)
                  {
                     JFrame searchArray = new JFrame("Search Result");
                     
                     ImageIcon a=new ImageIcon((search + ".jpg"));
                     a=new ImageIcon(a.getImage().getScaledInstance(270, 350, Image.SCALE_SMOOTH));
                     JLabel label = new JLabel(search,a,SwingConstants.CENTER);
                     searchArray.add(label); 
                     
                     searchArray.setVisible(true); 
                     searchArray.setSize(500,500);                     
                  }
                  
                  else 
                     JOptionPane.showMessageDialog(null,"No result");
                           
                                 
               }
            });                      
   
           
            //Add exit button
      JButton exitButton=new JButton("exit");  
      exitButton.setPreferredSize(new Dimension(300,40));      
      choosep.add(exitButton);
      
                              
                     //Add listener
      exitButton.addActionListener(
            new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent e) {
                  System.exit(0);
               }
            });
            
      choose.setSize(350,200);
      choose.setVisible(true);
      choose.setLocation(420,300);      
   }  //main method
   
   
   private static String[] readFile (String name) throws IOException
   {
      String str;
      int fileSize;
   
      BufferedReader infile;
      infile = new BufferedReader (new FileReader (name + ".txt"));
      
      str = infile.readLine ();
      fileSize = Integer.parseInt(str);
      
      String[] A = new String[fileSize + 50];
   
      for (int i = 0 ; i < fileSize ; i++)
      {
         A [i] = infile.readLine();
      
      }
   
      infile.close ();
      return A;
   }
   
   private static int sequentialSearch(String [] array, String target) 
   {
      int count = 0;
      int count2 = 0;
      for(int i = 0; i < array.length; i++)
      {
         if(array[i] != null)
            count2 ++;
      }
   
     
      for(int i = 0; i< count2 ; i++)
      {
         if (array [i].equals(target))
            count = count+1;
      }
      return count;
   }  
   
   
   private static String[] newArray (String[] name)
   {
      String[] newArray = new String[50];
      int count = 0;
      for(int i = 0; i < name.length; i++)
      {
         if(name[i] != null)
            count ++;
      }
   
      for (int i = 0 ; i < count ; i++)
      {
         newArray [i] = i + ". " + name[i];
      
      }
   
      return newArray;
   }



}