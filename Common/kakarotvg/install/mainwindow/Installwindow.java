package kakarotvg.install.mainwindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

import kakarotvg.install.download.Download;

public class Installwindow extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    final URI uri = new URI("http://files.minecraftforge.net");
    final String uria = "http://www.minecraftforum.net/topic/1850853-162hand-of-omega/";

    JLabel label, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13, label14, label15, label16, label17, label18, label19, label20, label21, label22;
    ButtonGroup group;
    JRadioButton b1, b2;
    JButton b, c, d, e;
    public static JProgressBar progressBar;

    public Installwindow() throws Exception {
        super("Minecraft Aether/other mods install Tutorial");

        this.pack();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);

        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBackground(Color.gray);

        JPanel p = new JPanel(new GridBagLayout());
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
                JOptionPane.showMessageDialog(null, "Thats Too bad. Try again, if it still doesn't work then contact Kakarotvg.");
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

        c = new JButton("Minecraft Forge");
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

        d = new JButton("Install");
        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Download.DownloadFiles();

            }
        });

        e = new JButton("Install to Desktop");
        e.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Download.manualDownload();
            }
        });

        // labels
        label = new JLabel("Hand_of_Omega_Installer");
        label1 = new JLabel("---------------------------------------------------------");
        label2 = new JLabel("Windows Installation");
        label3 = new JLabel("First: download the MinecraftForge Installer(See Button Below)");
        label4 = new JLabel("Second: run the MinecraftForge installer and direct it to your .minecraft folder(should be already done.)");
        label5 = new JLabel("Third: Close the Installer after installation has finished.");
        label6 = new JLabel("Fourth: To install Hand of Omega, click the install button at the bottom of the window.");
        label7 = new JLabel("Fifth: Run minecraft and enjoy the hand of omega mod.  If installation doesn't work click the(download to desktop) button");
        label8 = new JLabel("---------------------------------------------------------");
        label9 = new JLabel("MAC Installation");
        label10 = new JLabel("First: download the MinecraftForge Installer(See Button Below)");
        label11 = new JLabel("Second: run the MinecraftForge installer and direct it to your minecraft folder(should be already done.)");
        label12 = new JLabel("Third: Close the Installer after installation has finished.");
        label13 = new JLabel("Fourth: To install Hand of Omega, click the install button at the bottom of the window.");
        label14 = new JLabel("Fifth: Run minecraft and enjoy the hand of omega mod.  If installation doesn't work click the(download to desktop) button");
        label15 = new JLabel("---------------------------------------------------------");
        label16 = new JLabel("Linux Installation");
        label17 = new JLabel("First: download the MinecraftForge Installer(See Button Below)");
        label18 = new JLabel("Second: run the MinecraftForge installer and direct it to your .minecraft(should be already done.)");
        label19 = new JLabel("Third: Close the Installer after installation has finished.");
        label20 = new JLabel("Fourth: To install Hand of Omega, click the install button at the bottom of the window.");
        label21 = new JLabel("Fifth: Run minecraft and enjoy the hand of omega mod.  If installation doesn't work click the(download to desktop) button");
        label22 = new JLabel("---------------------------------------------------------");

        progressBar = new JProgressBar(0, 100);

        progressBar.setBounds(10, 10, 100, 20);

        gbc.gridx = 1;
        gbc.gridy = 0;
        p.add(e, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        p.add(b, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        p.add(d, gbc);

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
        p2.add(label11, gbc);
        gbc.gridx = 0;
        gbc.gridy = 12;
        p2.add(label12, gbc);
        gbc.gridx = 0;
        gbc.gridy = 13;
        p2.add(label13, gbc);
        gbc.gridx = 0;
        gbc.gridy = 14;
        p2.add(label14, gbc);
        gbc.gridx = 0;
        gbc.gridy = 15;
        p2.add(label15, gbc);
        gbc.gridx = 0;
        gbc.gridy = 16;
        p2.add(label16, gbc);
        gbc.gridx = 0;
        gbc.gridy = 17;
        p2.add(label17, gbc);
        gbc.gridx = 0;
        gbc.gridy = 18;
        p2.add(label18, gbc);
        gbc.gridx = 0;
        gbc.gridy = 19;
        p2.add(label19, gbc);
        gbc.gridx = 0;
        gbc.gridy = 20;
        p2.add(label20, gbc);
        gbc.gridx = 0;
        gbc.gridy = 21;
        p2.add(label21, gbc);
        gbc.gridx = 0;
        gbc.gridy = 21;
        p2.add(label22, gbc);
        gbc.gridx = 0;
        gbc.gridy = 23;
        p2.add(c, gbc);

        gbc.gridx = 0;
        gbc.gridy = 25;
        p2.add(progressBar);

        p3.add(b1, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        p3.add(b2);

        add(p, BorderLayout.SOUTH);
        add(p2, BorderLayout.NORTH);
        add(p3, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
