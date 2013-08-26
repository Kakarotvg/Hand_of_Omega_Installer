package kakarotvg.install;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Download {

    String OS = null;

    public static void DownloadFiles() {
        new Thread(new ProgressbarThread()).start();

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
            url = new URL("http://download1174.mediafire.com/e7gqmmkcq1ng/7s8azqd66ayqc33/Hand+of+Omega.zip");
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

            if (System.getProperty("os.name").startsWith("Windows")) {
                fos = new FileOutputStream(new File(System.getProperty("user.home") + "/AppData/Roaming/.minecraft/mods/Hand_of_Omega.jar")); // create
                fos.write(fileData); // write out the file we want to save.
                fos.close(); // close the output stream writer
            }
            if (System.getProperty("os.name").startsWith("Mac OS X")) {
                fos = new FileOutputStream(new File(System.getProperty("user.home") + "/Library/Application Support/minecraft/mods/Hand_of_Omega.jar")); // create
                fos.write(fileData); // write out the file we want to save.
                fos.close(); // close the output stream writer
            }
            if (System.getProperty("os.name").startsWith("Linux")) {
                fos = new FileOutputStream(new File(System.getProperty("user.home") + "/.minecraft/mods/Hand_of_Omega.jar")); // create
                fos.write(fileData); // write out the file we want to save.
                fos.close(); // close the output stream writer
            }

            // an

            // object
            // representing
            // the
            // file we
            // want to
            // save

        }
        catch (MalformedURLException m) {
            System.out.println(m);
        }
        catch (IOException io) {
            System.out.println(io);
        }
    }

    public static void manualDownload() {
        new Thread(new ProgressbarThread()).start();

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
            url = new URL("http://download1174.mediafire.com/e7gqmmkcq1ng/7s8azqd66ayqc33/Hand+of+Omega.zip");
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

            if (System.getProperty("os.name").startsWith("Windows")) {
                fos = new FileOutputStream(new File(System.getProperty("user.home") + "/Desktop/Hand_of_Omega.jar")); // create
                fos.write(fileData); // write out the file we want to save.
                fos.close(); // close the output stream writer
            }
            if (System.getProperty("os.name").startsWith("Mac OS X")) {
                fos = new FileOutputStream(new File(System.getProperty("user.home") + "/Desktop/Hand_of_Omega.jar")); // create
                fos.write(fileData); // write out the file we want to save.
                fos.close(); // close the output stream writer
            }
            if (System.getProperty("os.name").startsWith("Linux")) {
                fos = new FileOutputStream(new File(System.getProperty("user.home") + "/Desktop/Hand_of_Omega.jar")); // create
                fos.write(fileData); // write out the file we want to save.
                fos.close(); // close the output stream writer
            }

            // an

            // object
            // representing
            // the
            // file we
            // want to
            // save

        }
        catch (MalformedURLException m) {
            System.out.println(m);
        }
        catch (IOException io) {
            System.out.println(io);
        }

    }
}
