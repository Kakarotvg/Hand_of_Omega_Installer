package kakarotvg.install;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

public class Installwindow extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    final URI uri = new URI("https://www.facebook.com/AetherMod?ref=br_tf");
    final String uria = "http://www.minecraftforum.net/topic/1850853-162hand-of-omega/";

    JLabel label, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10;
    ButtonGroup group;
    JRadioButton b1, b2;
    JButton b, c, d;
    static JProgressBar progressBar;

    public Installwindow() throws Exception {
        super("Minecraft Aether/other mods install Tutorial");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.gray);

        JPanel p = new JPanel();
        p.setBackground(Color.lightGray);
        JPanel p2 = new JPanel(new GridBagLayout());
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        p2.setAlignmentX(LEFT_ALIGNMENT);
        p2.setBackground(Color.lightGray);
        JPanel p3 = new JPanel(new GridBagLayout());
        p3.setAlignmentX(LEFT_ALIGNMENT);
        p3.setBackground(Color.lightGray);

        b1 = new JRadioButton("Was the installation succesful?");
        b1.setActionCommand("Great thats good.");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Great, you can now exit this application and play minecraft");
            }
        });

        b2 = new JRadioButton("was the installation unsuccesful");
        b2.setActionCommand("Thats Too Bad.");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thats Too bad. Try again, if it still doesn't work then contact Jacob Connet.");
            }
        });

        group = new ButtonGroup();
        group.add(b1);
        group.add(b2);

        b = new JButton("Close");

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        });

        c = new JButton("Aether");
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();

                    try {
                        desktop.browse(uri);
                    }
                    catch (Exception ex) {

                    }

                }
                else {

                }
            }
        });

        d = new JButton("Hand of Omega");
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new thread1()).start();
                URL url; // represents the location of the file we want to dl.
                URLConnection con; // represents a connection to the url we want
                                   // to dl.
                DataInputStream dis; // input stream that will read data from
                                     // the file.
                FileOutputStream fos; // used to write data from inut stream to
                                      // file.
                byte[] fileData; // byte aray used to hold data from downloaded
                                 // file.
                try {
                    url = new URL("http://download1174.mediafire.com/wf1ssu07qfzg/7s8azqd66ayqc33/Hand+of+Omega.zip");
                    con = url.openConnection(); // open the url connection.
                    dis = new DataInputStream(con.getInputStream()); // get a
                                                                     // data
                                                                     // stream
                                                                     // from the
                                                                     // url
                                                                     // connection.
                    fileData = new byte[con.getContentLength()]; // determine
                                                                 // how many
                                                                 // byes the
                                                                 // file size is
                                                                 // and make
                                                                 // array big
                                                                 // enough to
                                                                 // hold the
                                                                 // data
                    for (int x = 0; x < fileData.length; x++) { // fill byte
                                                                // array with
                                                                // bytes from
                                                                // the data
                                                                // input stream
                        fileData[x] = dis.readByte();
                    }
                    dis.close(); // close the data input stream
                    fos = new FileOutputStream(new File(System.getProperty("user.home") + "/Library/Application Support/aether/mods/Hand_of_Omega.jar")); // create
                    // an

                    // object
                    // representing
                    // the
                    // file we
                    // want to
                    // save
                    fos.write(fileData); // write out the file we want to save.
                    fos.close(); // close the output stream writer
                }
                catch (MalformedURLException m) {
                    System.out.println(m);
                }
                catch (IOException io) {
                    System.out.println(io);
                }

            }
        });

        // labels
        label = new JLabel("Welcome to aether/hand of omega Installation tutorial");
        label1 = new JLabel("---------------------------------------------------------");
        label2 = new JLabel("Aether Installation");
        label3 = new JLabel("First: download the Aether Launcher(see button below)");
        label4 = new JLabel("Second: place the Aether launcher .jar file anywhere on your computer and double click it.");
        label5 = new JLabel("Third: Log in and play the aether.");
        label6 = new JLabel("---------------------------------------------------------");
        label7 = new JLabel("Hand of Omega installation with aether");
        label8 = new JLabel("Download Hand of Omega(See Button Below)");
        label9 = new JLabel("Check to see that Hand of Omega is downlaoded and placed in mods folder of aether folder.");
        label10 = new JLabel("Run the aether launcher.  Enjoy!!!");

        progressBar = new JProgressBar(0, 100);

        progressBar.setBounds(10, 10, 280, 20);

        p.add(b);
        p.add(c);

        gbc.gridx = 0;
        gbc.gridy = 0;
        p2.add(label, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        p2.add(label1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        p2.add(label2, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        p2.add(label3, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        p2.add(label4, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        p2.add(label5, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        p2.add(label6, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        p2.add(label7, gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        p2.add(label8, gbc);
        gbc.gridx = 0;
        gbc.gridy = 9;
        p2.add(label9, gbc);
        gbc.gridx = 0;
        gbc.gridy = 10;
        p2.add(label10, gbc);
        gbc.gridx = 0;
        gbc.gridy = 11;
        p2.add(c, gbc);
        gbc.gridx = 0;
        gbc.gridy = 12;
        p2.add(d, gbc);
        gbc.gridx = 0;
        gbc.gridy = 13;
        p2.add(progressBar);

        p3.add(b1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        p3.add(b2);

        add(p, BorderLayout.SOUTH);
        add(p2, BorderLayout.NORTH);
        add(p3, BorderLayout.CENTER);

    }

    public static class thread1 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                progressBar.setValue(i);
                progressBar.repaint();
                try {
                    Thread.sleep(50);
                }
                catch (InterruptedException err) {
                }
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
