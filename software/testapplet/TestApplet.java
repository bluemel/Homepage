package de.bluemel.testapplet.javaplugin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestApplet extends JApplet {
    public static final String OS_NAME_WINNT = "Windows NT";

    public static final String OS_NAME_WIN2000 = "Windows 2000";

    public static final String OS_NAME_WINXP = "Windows XP";

    public static final String OS_ARCH_INTEL = "x86";

    private int messageCount = 0;

    private String osName = System.getProperty("os.name");

    private String osVersion = System.getProperty("os.version");

    private String osArch = System.getProperty("os.arch");

    private JPanel jPanelMain = new JPanel();

    private BorderLayout layoutPanelMain = new BorderLayout(10, 10);

    private JPanel jPanelCenter = new JPanel();

    private GridBagLayout layoutPanelCenter = new GridBagLayout();

    private JScrollPane jScrollPaneMessage = new JScrollPane();

    private JTextArea jTextAreaMessage = new JTextArea();

    private JPanel jPanelTestSandbox = new JPanel();

    private GridBagLayout layoutPanelTestSandbox = new GridBagLayout();

    private JButton jButtonWrite = new JButton();

    private JButton jButtonConnect = new JButton();

    private JPanel jPanelTestTextField = new JPanel();

    private GridBagLayout layoutPanelTestTextField = new GridBagLayout();

    private JLabel jLabelTestTextField = new JLabel();

    private JTextField jTextFieldTest = new JTextField();

    private JPanel jPanelNorth = new JPanel();

    private JPanel jPanelEast = new JPanel();

    private JPanel jPanelSouth = new JPanel();

    private JPanel jPanelWest = new JPanel();

    private BorderLayout layoutPanelWest = new BorderLayout(10, 10);

    private JPanel jPanelWestWest = new JPanel();

    private JLabel jButtonIcon = new JLabel();

    public TestApplet() {
        super();
        System.out.println("@@@ Constructor TestApplet()");
    }

    public void init() {
        System.out.println("@@@ TestApplet.init()");
        try {
            this.setName("TestApplet Netscape Java-Plug-in");

            this.jPanelMain.setLayout(layoutPanelMain);

            this.jPanelCenter.setLayout(layoutPanelCenter);

            this.jPanelTestSandbox.setLayout(layoutPanelTestSandbox);

            this.jPanelWest.setLayout(layoutPanelWest);
            this.jPanelWest.setBackground(Color.white);

            this.jButtonWrite.setText("Write Local File");
            this.jButtonWrite.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonWriteActionPerformed(e);
                }
            });

            this.jButtonConnect.setText("Connect Foreign Web Server");
            this.jButtonConnect.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jButtonConnectActionPerformed(e);
                }
            });

            this.jPanelTestTextField.setLayout(layoutPanelTestTextField);

            this.jLabelTestTextField.setText("Test Text Field:");

            String urlString = "jar:" + this.getCodeBase() + this.getParameter("archive") + "!/icons/duke.gif";
            java.net.URL iconURL = new java.net.URL(urlString);

            ImageIcon imageIcon = new ImageIcon(iconURL, "Duke");
            this.jButtonIcon.setPreferredSize(new Dimension(100, 100));
            this.jButtonIcon.setIcon(imageIcon);

            this.jTextAreaMessage.setEditable(false);

            this.setContentPane(this.jPanelMain);
            this.jPanelMain.add(this.jPanelCenter, BorderLayout.CENTER);
            this.jPanelCenter.add(this.jScrollPaneMessage, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
            jScrollPaneMessage.getViewport().add(jTextAreaMessage);
            this.jPanelCenter.add(this.jPanelTestTextField, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 0, 0), 0, 0));
            this.jPanelTestTextField.add(this.jLabelTestTextField, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
            this.jPanelTestTextField.add(this.jTextFieldTest, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 10, 0, 0), 0, 0));
            this.jPanelCenter.add(this.jPanelTestSandbox, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 0, 0), 0, 0));
            this.jPanelTestSandbox.add(this.jButtonWrite, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
            this.jPanelTestSandbox.add(this.jButtonConnect, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
            this.jPanelMain.add(this.jPanelNorth, BorderLayout.NORTH);
            this.jPanelMain.add(this.jPanelEast, BorderLayout.EAST);
            this.jPanelMain.add(this.jPanelSouth, BorderLayout.SOUTH);
            this.jPanelMain.add(this.jPanelWest, BorderLayout.WEST);
            this.jPanelWest.add(this.jButtonIcon, BorderLayout.CENTER);
            this.jPanelWest.add(this.jPanelWestWest, BorderLayout.WEST);
        } catch (Exception e) {
            this.printStackTrace(e);
            this.message("ERROR during initialization of the Test Applet");
        }
    }

    public void start() {
        System.out.println("@@@ TestApplet.start()");
        jTextFieldTest.requestFocus();

        try {
            if (this.osName.equals(OS_NAME_WIN2000)) {
                File dirEcApps = new File("C:\\EC-Apps");
                if (dirEcApps.exists() && dirEcApps.isDirectory()) {
                    this.osName = "Windows XP";
                    this.osVersion = "?.?";
                }
            }

            // Win NT 4.0: os.name = "Windows NT", os.arch = "x86", os.version =
            // "4.0"
            this.message("Operating System: " + this.osName + " " + this.osVersion + ", " + this.osArch);
            String jreVersion = System.getProperty("java.version");
            this.message("JRE-Version:\t\t" + jreVersion);
            this.message("JRE-Vendor:\t\t" + System.getProperty("java.vendor"));
            this.message("JRE-Home-Directory:\t" + new File(System.getProperty("java.home")).getCanonicalPath());
            this.message("JVM:\t\t" + System.getProperty("java.vm.name") + ",  Version: "
                    + System.getProperty("java.vm.version"));
            this.message("JVM-Vendor:\t\t" + System.getProperty("java.vm.vendor"));
        } catch (Exception e) {
            this.printStackTrace(e);
            this.message("ERROR start of TestApplet.");
        }
    }

    public void message(String msg) {
        if (this.messageCount == 0)
            this.jTextAreaMessage.setText(msg);
        else
            this.jTextAreaMessage.setText(this.jTextAreaMessage.getText() + "\n" + msg);
        this.messageCount++;
    }

    static int wroteFile = 0;

    private void writeLocalFile() {
        try {
            this.message("writing local file...");
            File testFile = new File(System.getProperty("user.home") + File.separator + "TestApplet.txt");
            FileWriter testFileWriter = new FileWriter(testFile);

            testFileWriter.write("test", 0, 4);
            testFileWriter.close();
            testFile.delete();
            TestApplet.wroteFile++;
            this.message("wrote local file succesfully " + TestApplet.wroteFile + " times.");
        } catch (Exception e) {
            this.printStackTrace(e);
            this.message("ERROR during writing local file.");
        }
    }

    private void connectToForeignWebServer() {
        try {
            this.message("connect foreign web server...");
            String proxyHost = System.getProperty("http.proxyHost");
            String proxyPort = System.getProperty("http.proxyPort");
            if (proxyHost != null && proxyHost.length() > 0
                    && proxyPort != null && proxyPort.length() > 0) {
                this.message("HTTP proxy settings: " + proxyHost + ":" + proxyPort);
            } else {
                this.message("no HTTP proxy settings used.");
            }
            URL url = new URL("http://www.google.de");

            this.message("opening URLConnection for URL \"" + url + "\"...");
            URLConnection con = url.openConnection();

            this.message("configuring the URLConnection...");
            con.setDoInput(true);
            con.setDefaultUseCaches(false);
            con.setUseCaches(false);
            this.message("getting Reader for URLConnection \"" + con + "\"");
            new BufferedReader(new InputStreamReader(con.getInputStream()));
            this.message("opened URL connection \"" + url + "\" and got Reader succesfully.");
        } catch (Exception e) {
            this.printStackTrace(e);
            this.message("ERROR during connecting foreign web server.");
        }
    }

    public void printStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        this.message(sw.toString());
    }

    private void jButtonWriteActionPerformed(ActionEvent e) {
        this.writeLocalFile();
    }

    private void jButtonConnectActionPerformed(ActionEvent e) {
        this.connectToForeignWebServer();
    }
}
