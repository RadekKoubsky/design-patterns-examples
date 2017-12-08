package org.rkoubsky.examples.designpatterns.structural.proxy.virtual.cdcoverviewer;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class ImageProxyTestDrive {
    private ImageComponent imageComponent;
    private final JFrame frame = new JFrame("CD Cover Viewer");
    private JMenuBar menuBar;
    private JMenu menu;
    private final Map<String, URL> albums = new HashMap<>();

    public static void main(final String[] args) throws Exception {
        final ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }

    public ImageProxyTestDrive() throws Exception {
        initCds();
        initMenu();
        this.albums.keySet().forEach(name -> {
            final JMenuItem menuItem = new JMenuItem(name);
            this.menu.add(menuItem);
            menuItem.addActionListener(event -> {
                this.imageComponent.setIcon(new ImageProxy(this.albums.get(event.getActionCommand())));
                this.frame.repaint();
            });
        });
        initFrame();

    }

    private void initFrame() {
        final Icon icon = new ImageProxy(this.albums.values().stream().findFirst().get());
        this.imageComponent = new ImageComponent(icon);
        this.frame.getContentPane().add(this.imageComponent);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(1200, 800);
        this.frame.setVisible(true);
    }

    private void initMenu() {
        this.menuBar = new JMenuBar();
        this.menu = new JMenu("Favorite CDs");
        this.menuBar.add(this.menu);
        this.frame.setJMenuBar(this.menuBar);
    }

    private void initCds() {
        this.albums
                .put("Beatles - Abbey Road",
                        getUrl("https://cps-static.rovicorp.com/3/JPG_1080/MI0002/910/MI0002910443.jpg"));
        this.albums
                .put("Nirvana - Nevermind",
                        getUrl("https://cps-static.rovicorp.com/3/JPG_1080/MI0001/996/MI0001996061.jpg"));
        this.albums.put("Beastie Boys - Ill' Communication",
                getUrl("https://cps-static.rovicorp.com/3/JPG_1080/MI0000/702/MI0000702793.jpg"));

    }

    private URL getUrl(final String urlString) {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (final MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}
