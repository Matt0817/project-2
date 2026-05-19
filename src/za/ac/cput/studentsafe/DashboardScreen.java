package za.ac.cput.studentsafe;

/**
 * Application:  StudentSafe Accommodation Finder
 * Screen:       Dashboard Screen
 * Description:  Main home screen displayed after login. Shows the student's
 *               saved listings, application stats, alerts, and recommended
 *               properties near their campus.
 *
 * Author:       Matthew Smit
 * Student No:   222648767
 * Date:         May 2026
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class DashboardScreen extends JFrame {

    private static final Color BG_WHITE       = new Color(255, 255, 255);
    private static final Color BG_LIGHT       = new Color(248, 250, 252);

    private static final Color FILL_GREY      = new Color(241, 245, 249);
    private static final Color FILL_IMG       = new Color(226, 232, 240);

    private static final Color BORDER_GREY    = new Color(226, 232, 240);

    private static final Color BTN_PRIMARY    = new Color(37, 99, 235);
    private static final Color BTN_TEXT       = new Color(255, 255, 255);

    private static final Color TEXT_PRIMARY   = new Color(15, 23, 42);
    private static final Color TEXT_SECONDARY = new Color(100, 116, 139);
    private static final Color TEXT_HINT      = new Color(148, 163, 184);

    private static final Color NAV_ACTIVE     = new Color(37, 99, 235);

    private static final Font FONT_GREETING   = new Font("SansSerif", Font.PLAIN, 11);
    private static final Font FONT_NAME       = new Font("SansSerif", Font.BOLD, 16);
    private static final Font FONT_SECTION    = new Font("SansSerif", Font.BOLD, 13);
    private static final Font FONT_STAT_NUM   = new Font("SansSerif", Font.BOLD, 22);
    private static final Font FONT_STAT_LBL   = new Font("SansSerif", Font.PLAIN, 10);
    private static final Font FONT_CARD_TITLE = new Font("SansSerif", Font.BOLD, 12);
    private static final Font FONT_CARD_SUB   = new Font("SansSerif", Font.PLAIN, 10);
    private static final Font FONT_CARD_PRICE = new Font("SansSerif", Font.BOLD, 12);
    private static final Font FONT_NAV        = new Font("SansSerif", Font.PLAIN, 10);
    private static final Font FONT_SEARCH     = new Font("SansSerif", Font.PLAIN, 12);

    public DashboardScreen() {

        setTitle("StudentSafe – Dashboard");
        setSize(390, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel root = new JPanel(new BorderLayout());
        root.setBackground(BG_WHITE);

       
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(BG_WHITE);
        content.setBorder(new EmptyBorder(50, 20, 20, 20));

        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(BG_WHITE);
        topBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));

        JPanel greetingPanel = new JPanel();
        greetingPanel.setLayout(new BoxLayout(greetingPanel, BoxLayout.Y_AXIS));
        greetingPanel.setBackground(BG_WHITE);

        JLabel greetingLine = new JLabel("Good morning,");
        greetingLine.setFont(FONT_GREETING);
        greetingLine.setForeground(TEXT_SECONDARY);

        JLabel nameLine = new JLabel("Matthew");
        nameLine.setFont(FONT_NAME);
        nameLine.setForeground(TEXT_PRIMARY);

        greetingPanel.add(greetingLine);
        greetingPanel.add(nameLine);

        JPanel iconsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        iconsPanel.setBackground(BG_WHITE);

        JButton bellBtn = makeIconButton("🔔");

        JPanel avatarCircle = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(BTN_PRIMARY);
                g2.fillOval(0, 0, 34, 34);

                g2.setColor(Color.WHITE);
                g2.setFont(new Font("SansSerif", Font.BOLD, 12));

                FontMetrics fm = g2.getFontMetrics();
                String t = "M";

                g2.drawString(t,
                        (34 - fm.stringWidth(t)) / 2,
                        (34 + fm.getAscent()) / 2 - 2);
            }
        };

        avatarCircle.setPreferredSize(new Dimension(34, 34));
        avatarCircle.setOpaque(false);

        iconsPanel.add(bellBtn);
        iconsPanel.add(avatarCircle);

        topBar.add(greetingPanel, BorderLayout.WEST);
        topBar.add(iconsPanel, BorderLayout.EAST);

        JTextField searchBar = new JTextField("  Search near your campus...");
        searchBar.setFont(FONT_SEARCH);
        searchBar.setForeground(TEXT_HINT);
        searchBar.setCaretColor(TEXT_PRIMARY);
        searchBar.setBackground(FILL_GREY);

        searchBar.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(BORDER_GREY, 1, true),
                new EmptyBorder(0, 12, 0, 12)
        ));

        searchBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 42));

        JLabel statsTitle = makeSectionLabel("Your Stats");

        JPanel statsRow = new JPanel(new GridLayout(1, 3, 10, 0));
        statsRow.setBackground(BG_WHITE);
        statsRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

        statsRow.add(makeStatCard("Saved", "12"));
        statsRow.add(makeStatCard("Applied", "3"));
        statsRow.add(makeStatCard("Alerts", "5"));

        JLabel recTitle = makeSectionLabel("Recommended for You");

        JPanel listingsPanel = new JPanel();
        listingsPanel.setLayout(new BoxLayout(listingsPanel, BoxLayout.Y_AXIS));
        listingsPanel.setBackground(BG_WHITE);

        listingsPanel.add(makeListingCard(
                "2-Bed Apartment",
                "Rondebosch · 0.8km to UCT",
                "R5 200/mo"
        ));

        listingsPanel.add(Box.createVerticalStrut(12));

        listingsPanel.add(makeListingCard(
                "Student Studio",
                "Observatory · 1.2km to UCT",
                "R3 800/mo"
        ));

        listingsPanel.add(Box.createVerticalStrut(12));

        listingsPanel.add(makeListingCard(
                "Shared House",
                "Salt River · 1.1km to CPUT",
                "R2 800/mo"
        ));

        content.add(topBar);
        content.add(Box.createVerticalStrut(18));
        content.add(searchBar);
        content.add(Box.createVerticalStrut(22));
        content.add(statsTitle);
        content.add(Box.createVerticalStrut(8));
        content.add(statsRow);
        content.add(Box.createVerticalStrut(24));
        content.add(recTitle);
        content.add(Box.createVerticalStrut(10));
        content.add(listingsPanel);

        JScrollPane scrollPane = new JScrollPane(content);

        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        JPanel navBar = new JPanel(new GridLayout(1, 4));
        navBar.setBackground(BG_WHITE);
        navBar.setOpaque(true);

        navBar.setBorder(BorderFactory.createCompoundBorder(
                new MatteBorder(1, 0, 0, 0, BORDER_GREY),
                new EmptyBorder(8, 0, 8, 0)
        ));

        navBar.setPreferredSize(new Dimension(390, 70));

        navBar.add(makeNavItem("🏠", "Home", true));
        navBar.add(makeNavItem("🏢", "Listings", false));
        navBar.add(makeNavItem("🤍", "Saved", false));
        navBar.add(makeNavItem("👤", "Profile", false));

        root.add(scrollPane, BorderLayout.CENTER);
        root.add(navBar, BorderLayout.SOUTH);

        add(root);
        setVisible(true);
    }

    private JLabel makeSectionLabel(String text) {

        JLabel lbl = new JLabel(text);

        lbl.setFont(FONT_SECTION);
        lbl.setForeground(TEXT_PRIMARY);

        return lbl;
    }

    private JPanel makeStatCard(String label, String value) {

        JPanel card = new JPanel();

        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(BG_LIGHT);

        card.setBorder(new CompoundBorder(
                new LineBorder(BORDER_GREY, 1, true),
                new EmptyBorder(12, 12, 12, 12)
        ));

        JLabel lbl = new JLabel(label);
        lbl.setFont(FONT_STAT_LBL);
        lbl.setForeground(TEXT_SECONDARY);

        JLabel val = new JLabel(value);
        val.setFont(FONT_STAT_NUM);
        val.setForeground(TEXT_PRIMARY);

        card.add(lbl);
        card.add(Box.createVerticalStrut(2));
        card.add(val);

        return card;
    }

    
    private JPanel makeListingCard(String title, String location, String price) {

        JPanel card = new JPanel(new BorderLayout(12, 0));

        card.setBackground(BG_WHITE);

        card.setBorder(new CompoundBorder(
                new LineBorder(new Color(220, 225, 232), 1, true),
                new EmptyBorder(12, 12, 12, 12)
        ));

        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));

        JPanel imgBox = new JPanel() {

            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;

                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(FILL_IMG);

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

                g2.setColor(TEXT_HINT);

                g2.setFont(new Font("SansSerif", Font.PLAIN, 10));

                String t = "Image";

                FontMetrics fm = g2.getFontMetrics();

                g2.drawString(t,
                        (getWidth() - fm.stringWidth(t)) / 2,
                        getHeight() / 2);
            }
        };

        imgBox.setPreferredSize(new Dimension(65, 65));
        imgBox.setOpaque(false);

        JPanel info = new JPanel();

        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setBackground(BG_WHITE);

        JLabel titleLbl = new JLabel(title);
        titleLbl.setFont(FONT_CARD_TITLE);
        titleLbl.setForeground(TEXT_PRIMARY);

        JLabel locLbl = new JLabel(location);
        locLbl.setFont(FONT_CARD_SUB);
        locLbl.setForeground(TEXT_SECONDARY);

        JLabel priceLbl = new JLabel(price);
        priceLbl.setFont(FONT_CARD_PRICE);
        priceLbl.setForeground(BTN_PRIMARY);

        info.add(titleLbl);
        info.add(Box.createVerticalStrut(4));
        info.add(locLbl);
        info.add(Box.createVerticalStrut(6));
        info.add(priceLbl);

        JLabel heart = new JLabel("♡");

        heart.setFont(new Font("SansSerif", Font.PLAIN, 18));
        heart.setForeground(TEXT_HINT);

        heart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        heart.addMouseListener(new MouseAdapter() {

            boolean liked = false;

            public void mouseClicked(MouseEvent e) {

                liked = !liked;

                heart.setText(liked ? "♥" : "♡");

                heart.setForeground(liked ? BTN_PRIMARY : TEXT_HINT);
            }
        });

        card.add(imgBox, BorderLayout.WEST);
        card.add(info, BorderLayout.CENTER);
        card.add(heart, BorderLayout.EAST);

        return card;
    }

    // ── Navigation Item ─────────────────────────────────────────────
    private JPanel makeNavItem(String icon, String label, boolean active) {

        JPanel item = new JPanel();

        item.setLayout(new BoxLayout(item, BoxLayout.Y_AXIS));
        item.setBackground(BG_WHITE);

        JLabel iconLbl = new JLabel(icon);
        iconLbl.setFont(new Font("SansSerif", Font.PLAIN, 20));
        iconLbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel textLbl = new JLabel(label);

        textLbl.setFont(FONT_NAV);

        textLbl.setForeground(active ? NAV_ACTIVE : TEXT_HINT);

        textLbl.setAlignmentX(Component.CENTER_ALIGNMENT);

        item.add(iconLbl);
        item.add(Box.createVerticalStrut(2));
        item.add(textLbl);

        return item;
    }

    // ── Top Icon Button ─────────────────────────────────────────────
    private JButton makeIconButton(String icon) {

        JButton btn = new JButton(icon);

        btn.setFont(new Font("SansSerif", Font.PLAIN, 18));

        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);

        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        return btn;
    }

    // ── Main Method ─────────────────────────────────────────────────
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new DashboardScreen());
    }
}

