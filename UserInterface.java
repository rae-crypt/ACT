import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii
// I love you so muchhh bebiiii

// Customer class
class Customer extends User {
    private String customerId;
    private ArrayList<String> purchaseHistory;
    
    public Customer(String username, String customerId) {
        super(username, ""); // No password needed for browsing
        this.customerId = customerId;
        this.purchaseHistory = new ArrayList<>();
    }
    
    public String getCustomerId() {
        return customerId;
    }
    
    @Override
    public void displayRole() {
        System.out.println("Role: Customer");
    }
    
    public void addPurchase(String purchase) {
        purchaseHistory.add(purchase);
    }
}

// User Home Frame
class UserHomeFrame extends JFrame {
    private InventoryManager inventory;
    
    public UserHomeFrame(InventoryManager inventory) {
        this.inventory = inventory;
        
        setTitle("Lourdes Mini Hardware - Home");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        
        // Header panel
        JPanel headerPanel = createHeaderPanel();
        
        // Navigation panel
        JPanel navPanel = createNavigationPanel();
        
        // Content panel
        JPanel contentPanel = createHomeContentPanel();
        
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(navPanel, BorderLayout.CENTER);
        mainPanel.add(contentPanel, BorderLayout.SOUTH);
        
        add(mainPanel);
        setVisible(true);
    }
    
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(20, 20, 20));
        headerPanel.setPreferredSize(new Dimension(1000, 100));
        headerPanel.setLayout(null);
        
        JLabel titleLabel = new JLabel("LOURDES MINI HARDWARE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setForeground(new Color(255, 193, 7));
        titleLabel.setBounds(30, 20, 500, 40);
        headerPanel.add(titleLabel);
        
        JLabel subtitleLabel = new JLabel("Your Trusted Hardware Partner");
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        subtitleLabel.setForeground(new Color(200, 200, 200));
        subtitleLabel.setBounds(30, 60, 400, 25);
        headerPanel.add(subtitleLabel);
        
        return headerPanel;
    }
    
    private JPanel createNavigationPanel() {
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(40, 40, 40));
        navPanel.setPreferredSize(new Dimension(1000, 60));
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        
        JButton homeBtn = createNavButton("HOME");
        homeBtn.setBackground(new Color(255, 193, 7));
        homeBtn.setForeground(Color.BLACK);
        
        JButton productsBtn = createNavButton("PRODUCTS");
        productsBtn.addActionListener(e -> {
            dispose();
            new ProductListFrame(inventory);
        });
        
        JButton contactBtn = createNavButton("CONTACT");
        contactBtn.addActionListener(e -> {
            dispose();
            new ContactFrame(inventory);
        });
        
        navPanel.add(homeBtn);
        navPanel.add(productsBtn);
        navPanel.add(contactBtn);
        
        return navPanel;
    }
    
    private JButton createNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(150, 35));
        btn.setBackground(new Color(60, 60, 60));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }
    
    private JPanel createHomeContentPanel() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        // Welcome section
        JLabel welcomeLabel = new JLabel("Welcome to Lourdes Mini Hardware!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 28));
        welcomeLabel.setForeground(new Color(20, 20, 20));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(welcomeLabel);
        
        contentPanel.add(Box.createVerticalStrut(20));
        
        JTextArea descArea = new JTextArea(
            "Browse our extensive catalog of quality tools and equipment.\n" +
            "Check product availability, prices, and specifications online\n" +
            "before visiting our store. We're here to help with all your\n" +
            "hardware needs!"
        );
        descArea.setFont(new Font("Arial", Font.PLAIN, 16));
        descArea.setForeground(new Color(80, 80, 80));
        descArea.setBackground(Color.WHITE);
        descArea.setEditable(false);
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(descArea);
        
        contentPanel.add(Box.createVerticalStrut(40));
        
        // Features section
        JPanel featuresPanel = new JPanel(new GridLayout(1, 3, 20, 0));
        featuresPanel.setBackground(Color.WHITE);
        featuresPanel.setMaximumSize(new Dimension(900, 200));
        
        featuresPanel.add(createFeatureCard("Browse Products", "View our complete\ncatalog of tools\nand equipment"));
        featuresPanel.add(createFeatureCard("Check Availability", "See real-time\nstock status\nand pricing"));
        featuresPanel.add(createFeatureCard("Find Location", "Get directions\nto our store\nand contact us"));
        
        contentPanel.add(featuresPanel);
        
        contentPanel.add(Box.createVerticalStrut(40));
        
        // Call to action button
        JButton browseBtn = new JButton("BROWSE PRODUCTS");
        browseBtn.setPreferredSize(new Dimension(250, 50));
        browseBtn.setMaximumSize(new Dimension(250, 50));
        browseBtn.setBackground(new Color(255, 193, 7));
        browseBtn.setForeground(Color.BLACK);
        browseBtn.setFont(new Font("Arial", Font.BOLD, 16));
        browseBtn.setFocusPainted(false);
        browseBtn.setBorderPainted(false);
        browseBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        browseBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        browseBtn.addActionListener(e -> {
            dispose();
            new ProductListFrame(inventory);
        });
        contentPanel.add(browseBtn);
        
        return contentPanel;
    }
    
    private JPanel createFeatureCard(String title, String description) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(245, 245, 245));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
            BorderFactory.createEmptyBorder(20, 15, 20, 15)
        ));
        
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(20, 20, 20));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(titleLabel);
        
        card.add(Box.createVerticalStrut(15));
        
        JTextArea descArea = new JTextArea(description);
        descArea.setFont(new Font("Arial", Font.PLAIN, 14));
        descArea.setForeground(new Color(80, 80, 80));
        descArea.setBackground(new Color(245, 245, 245));
        descArea.setEditable(false);
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        card.add(descArea);
        
        return card;
    }
}

// Product List Frame
class ProductListFrame extends JFrame {
    private InventoryManager inventory;
    private JTable productTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    
    public ProductListFrame(InventoryManager inventory) {
        this.inventory = inventory;
        
        setTitle("Lourdes Mini Hardware - Products");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        
        // Header
        JPanel headerPanel = createHeaderPanel();
        
        // Navigation
        JPanel navPanel = createNavigationPanel();
        
        // Search panel
        JPanel searchPanel = createSearchPanel();
        
        // Table panel
        JPanel tablePanel = createTablePanel();
        
        // Combine top panels
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(headerPanel, BorderLayout.NORTH);
        topPanel.add(navPanel, BorderLayout.CENTER);
        topPanel.add(searchPanel, BorderLayout.SOUTH);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(tablePanel, BorderLayout.CENTER);
        
        add(mainPanel);
        setVisible(true);
    }
    
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(20, 20, 20));
        headerPanel.setPreferredSize(new Dimension(1000, 80));
        headerPanel.setLayout(null);
        
        JLabel titleLabel = new JLabel("PRODUCT CATALOG");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(255, 193, 7));
        titleLabel.setBounds(30, 25, 400, 35);
        headerPanel.add(titleLabel);
        
        return headerPanel;
    }
    
    private JPanel createNavigationPanel() {
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(40, 40, 40));
        navPanel.setPreferredSize(new Dimension(1000, 60));
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        
        JButton homeBtn = createNavButton("HOME");
        homeBtn.addActionListener(e -> {
            dispose();
            new UserHomeFrame(inventory);
        });
        
        JButton productsBtn = createNavButton("PRODUCTS");
        productsBtn.setBackground(new Color(255, 193, 7));
        productsBtn.setForeground(Color.BLACK);
        
        JButton contactBtn = createNavButton("CONTACT");
        contactBtn.addActionListener(e -> {
            dispose();
            new ContactFrame(inventory);
        });
        
        navPanel.add(homeBtn);
        navPanel.add(productsBtn);
        navPanel.add(contactBtn);
        
        return navPanel;
    }
    
    private JButton createNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(150, 35));
        btn.setBackground(new Color(60, 60, 60));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }
    
    private JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(Color.WHITE);
        searchPanel.setPreferredSize(new Dimension(1000, 70));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        searchField = new JTextField(30);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setPreferredSize(new Dimension(400, 35));
        
        JButton searchBtn = new JButton("Search");
        searchBtn.setPreferredSize(new Dimension(100, 35));
        searchBtn.setBackground(new Color(255, 193, 7));
        searchBtn.setForeground(Color.BLACK);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 13));
        searchBtn.setFocusPainted(false);
        searchBtn.setBorderPainted(false);
        searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        searchBtn.addActionListener(e -> filterProducts());
        
        JButton resetBtn = new JButton("Show All");
        resetBtn.setPreferredSize(new Dimension(100, 35));
        resetBtn.setBackground(new Color(100, 100, 100));
        resetBtn.setForeground(Color.WHITE);
        resetBtn.setFont(new Font("Arial", Font.BOLD, 13));
        resetBtn.setFocusPainted(false);
        resetBtn.setBorderPainted(false);
        resetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetBtn.addActionListener(e -> {
            searchField.setText("");
            refreshTable();
        });
        
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchBtn);
        searchPanel.add(resetBtn);
        
        return searchPanel;
    }
    
    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 20));
        
        String[] columnNames = {"Product ID", "Name", "Category", "Price (₱)", "Stock", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        productTable = new JTable(tableModel);
        productTable.setRowHeight(35);
        productTable.setFont(new Font("Arial", Font.PLAIN, 14));
        productTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        productTable.getTableHeader().setBackground(new Color(20, 20, 20));
        productTable.getTableHeader().setForeground(new Color(255, 193, 7));
        productTable.setSelectionBackground(new Color(255, 240, 200));
        productTable.setSelectionForeground(Color.BLACK);
        
        // Add mouse listener for product details
        productTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int row = productTable.getSelectedRow();
                    if (row != -1) {
                        showProductDetails(row);
                    }
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(productTable);
        
        refreshTable();
        
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        return tablePanel;
    }
    
    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Product p : inventory.getAllProducts()) {
            String status = p.getStockQuantity() > 0 ? "Available" : "Out of Stock";
            tableModel.addRow(new Object[]{
                p.getProductId(),
                p.getName(),
                p.getCategory(),
                String.format("%.2f", p.getPrice()),
                p.getStockQuantity(),
                status
            });
        }
    }
    
    private void filterProducts() {
        String searchText = searchField.getText().toLowerCase().trim();
        if (searchText.isEmpty()) {
            refreshTable();
            return;
        }
        
        tableModel.setRowCount(0);
        for (Product p : inventory.getAllProducts()) {
            if (p.getName().toLowerCase().contains(searchText) ||
                p.getProductId().toLowerCase().contains(searchText) ||
                p.getCategory().toLowerCase().contains(searchText)) {
                
                String status = p.getStockQuantity() > 0 ? "Available" : "Out of Stock";
                tableModel.addRow(new Object[]{
                    p.getProductId(),
                    p.getName(),
                    p.getCategory(),
                    String.format("%.2f", p.getPrice()),
                    p.getStockQuantity(),
                    status
                });
            }
        }
    }
    
    private void showProductDetails(int row) {
        String productId = (String) tableModel.getValueAt(row, 0);
        
        Product product = null;
        for (Product p : inventory.getAllProducts()) {
            if (p.getProductId().equals(productId)) {
                product = p;
                break;
            }
        }
        
        if (product == null) return;
        
        JDialog dialog = new JDialog(this, "Product Details", true);
        dialog.setSize(450, 400);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());
        
        // Header
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(20, 20, 20));
        headerPanel.setPreferredSize(new Dimension(450, 70));
        
        JLabel titleLabel = new JLabel("PRODUCT DETAILS");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(new Color(255, 193, 7));
        headerPanel.add(titleLabel);
        
        // Content
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        
        addDetailLine(contentPanel, "Product ID:", product.getProductId());
        addDetailLine(contentPanel, "Name:", product.getName());
        addDetailLine(contentPanel, "Category:", product.getCategory());
        addDetailLine(contentPanel, "Price:", "₱" + String.format("%.2f", product.getPrice()));
        addDetailLine(contentPanel, "Stock:", String.valueOf(product.getStockQuantity()));
        
        String status = product.getStockQuantity() > 0 ? "Available" : "Out of Stock";
        Color statusColor = product.getStockQuantity() > 0 ? new Color(0, 150, 0) : new Color(200, 0, 0);
        
        contentPanel.add(Box.createVerticalStrut(10));
        JLabel statusLabel = new JLabel("Status: " + status);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusLabel.setForeground(statusColor);
        statusLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(statusLabel);
        
        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(40, 40, 40));
        buttonPanel.setPreferredSize(new Dimension(450, 60));
        
        JButton closeBtn = new JButton("Close");
        closeBtn.setPreferredSize(new Dimension(120, 35));
        closeBtn.setBackground(new Color(255, 193, 7));
        closeBtn.setForeground(Color.BLACK);
        closeBtn.setFont(new Font("Arial", Font.BOLD, 13));
        closeBtn.setFocusPainted(false);
        closeBtn.setBorderPainted(false);
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.addActionListener(e -> dialog.dispose());
        buttonPanel.add(closeBtn);
        
        dialog.add(headerPanel, BorderLayout.NORTH);
        dialog.add(contentPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        
        dialog.setVisible(true);
    }
    
    private void addDetailLine(JPanel panel, String label, String value) {
        JPanel linePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 8));
        linePanel.setBackground(Color.WHITE);
        linePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel labelText = new JLabel(label + " ");
        labelText.setFont(new Font("Arial", Font.BOLD, 15));
        labelText.setForeground(new Color(60, 60, 60));
        
        JLabel valueText = new JLabel(value);
        valueText.setFont(new Font("Arial", Font.PLAIN, 15));
        valueText.setForeground(new Color(20, 20, 20));
        
        linePanel.add(labelText);
        linePanel.add(valueText);
        panel.add(linePanel);
    }
}

// Contact Frame
class ContactFrame extends JFrame {
    private InventoryManager inventory;
    
    public ContactFrame(InventoryManager inventory) {
        this.inventory = inventory;
        
        setTitle("Lourdes Mini Hardware - Contact Us");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        
        // Header
        JPanel headerPanel = createHeaderPanel();
        
        // Navigation
        JPanel navPanel = createNavigationPanel();
        
        // Content
        JPanel contentPanel = createContactContentPanel();
        
        // Combine top panels
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(headerPanel, BorderLayout.NORTH);
        topPanel.add(navPanel, BorderLayout.SOUTH);
        
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        add(mainPanel);
        setVisible(true);
    }
    
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(20, 20, 20));
        headerPanel.setPreferredSize(new Dimension(1000, 80));
        headerPanel.setLayout(null);
        
        JLabel titleLabel = new JLabel("CONTACT US");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(new Color(255, 193, 7));
        titleLabel.setBounds(30, 25, 300, 35);
        headerPanel.add(titleLabel);
        
        return headerPanel;
    }
    
    private JPanel createNavigationPanel() {
        JPanel navPanel = new JPanel();
        navPanel.setBackground(new Color(40, 40, 40));
        navPanel.setPreferredSize(new Dimension(1000, 60));
        navPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 15));
        
        JButton homeBtn = createNavButton("HOME");
        homeBtn.addActionListener(e -> {
            dispose();
            new UserHomeFrame(inventory);
        });
        
        JButton productsBtn = createNavButton("PRODUCTS");
        productsBtn.addActionListener(e -> {
            dispose();
            new ProductListFrame(inventory);
        });
        
        JButton contactBtn = createNavButton("CONTACT");
        contactBtn.setBackground(new Color(255, 193, 7));
        contactBtn.setForeground(Color.BLACK);
        
        navPanel.add(homeBtn);
        navPanel.add(productsBtn);
        navPanel.add(contactBtn);
        
        return navPanel;
    }
    
    private JButton createNavButton(String text) {
        JButton btn = new JButton(text);
        btn.setPreferredSize(new Dimension(150, 35));
        btn.setBackground(new Color(60, 60, 60));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }
    
    private JPanel createContactContentPanel() {
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        // Store info section
        JLabel storeLabel = new JLabel("Lourdes Mini Hardware");
        storeLabel.setFont(new Font("Arial", Font.BOLD, 26));
        storeLabel.setForeground(new Color(20, 20, 20));
        storeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(storeLabel);
        
        contentPanel.add(Box.createVerticalStrut(30));
        
        // Contact details panel
        JPanel detailsPanel = new JPanel(new GridLayout(5, 1, 0, 15));
        detailsPanel.setBackground(Color.WHITE);
        detailsPanel.setMaximumSize(new Dimension(600, 250));
        
        addContactInfo(detailsPanel, "📍 Address:", "Tarlac City, Tarlac, Philippines");
        addContactInfo(detailsPanel, "📞 Phone:", "+63 XXX XXX XXXX");
        addContactInfo(detailsPanel, "📧 Email:", "lourdes.hardware@example.com");
        addContactInfo(detailsPanel, "🕒 Business Hours:", "Monday - Saturday: 8:00 AM - 6:00 PM");
        addContactInfo(detailsPanel, "", "Sunday: Closed");
        
        contentPanel.add(detailsPanel);
        
        contentPanel.add(Box.createVerticalStrut(40));
        
        // Map section
        JPanel mapPanel = new JPanel(new BorderLayout());
        mapPanel.setBackground(new Color(220, 220, 220));
        mapPanel.setMaximumSize(new Dimension(700, 200));
        mapPanel.setBorder(BorderFactory.createLineBorder(new Color(150, 150, 150), 2));
        
        JLabel mapLabel = new JLabel("[ Store Location Map ]", JLabel.CENTER);
        mapLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        mapLabel.setForeground(new Color(100, 100, 100));
        mapPanel.add(mapLabel, BorderLayout.CENTER);
        
        JButton viewMapBtn = new JButton("View Larger Map");
        viewMapBtn.setPreferredSize(new Dimension(150, 35));
        viewMapBtn.setBackground(new Color(255, 193, 7));
        viewMapBtn.setForeground(Color.BLACK);
        viewMapBtn.setFont(new Font("Arial", Font.BOLD, 12));
        viewMapBtn.setFocusPainted(false);
        viewMapBtn.setBorderPainted(false);
        viewMapBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewMapBtn.addActionListener(e -> 
            JOptionPane.showMessageDialog(this, 
                "Opening map in browser...\n(Feature would open Google Maps in actual implementation)", 
                "Map", 
                JOptionPane.INFORMATION_MESSAGE)
        );
        
        JPanel mapBtnPanel = new JPanel();
        mapBtnPanel.setBackground(new Color(220, 220, 220));
        mapBtnPanel.add(viewMapBtn);
        mapPanel.add(mapBtnPanel, BorderLayout.SOUTH);
        
        contentPanel.add(mapPanel);
        
        return contentPanel;
    }
    
    private void addContactInfo(JPanel panel, String label, String value) {
        JPanel linePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        linePanel.setBackground(Color.WHITE);
        
        JLabel labelText = new JLabel(label);
        labelText.setFont(new Font("Arial", Font.BOLD, 16));
        labelText.setForeground(new Color(60, 60, 60));
        labelText.setPreferredSize(new Dimension(180, 25));
        
        JLabel valueText = new JLabel(value);
        valueText.setFont(new Font("Arial", Font.PLAIN, 16));
        valueText.setForeground(new Color(20, 20, 20));
        
        linePanel.add(labelText);
        linePanel.add(valueText);
        panel.add(linePanel);
    }
}

// Main launcher with user entry point
class UserCatalogLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Initialize inventory with sample data
            InventoryManager inventory = new InventoryManager();
            inventory.addProduct(new Tool("T001", "Claw Hammer", 350.00, 25, "Hand Tool"));
            inventory.addProduct(new Equipment("E001", "Electric Drill", 2500.00, 10, "Power Tool"));