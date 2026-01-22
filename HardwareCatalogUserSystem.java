import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.net.URL;

// Base User class (needed for Customer)
abstract class User {
    private String username;
    private String password;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public abstract void displayRole();
    
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}

// Base Product class
abstract class Product {
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;
    
    public Product(String productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    
    public abstract String getCategory();
    
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
}

// Enhanced Product class with image support
abstract class ProductWithImage extends Product {
    private String imageUrl;
    private String brand;
    
    public ProductWithImage(String productId, String name, double price, int stockQuantity, String brand, String imageUrl) {
        super(productId, name, price, stockQuantity);
        this.brand = brand;
        this.imageUrl = imageUrl;
    }
    
    public String getImageUrl() { return imageUrl; }
    public String getBrand() { return brand; }
}

// Tool class
class ToolWithImage extends ProductWithImage {
    private String toolType;
    
    public ToolWithImage(String productId, String name, double price, int stockQuantity, String brand, String toolType, String imageUrl) {
        super(productId, name, price, stockQuantity, brand, imageUrl);
        this.toolType = toolType;
    }
    
    @Override
    public String getCategory() { return "Tools"; }
    public String getToolType() { return toolType; }
}

// Equipment class
class EquipmentWithImage extends ProductWithImage {
    private String equipmentType;
    
    public EquipmentWithImage(String productId, String name, double price, int stockQuantity, String brand, String equipmentType, String imageUrl) {
        super(productId, name, price, stockQuantity, brand, imageUrl);
        this.equipmentType = equipmentType;
    }
    
    @Override
    public String getCategory() { return "Equipment"; }
    public String getEquipmentType() { return equipmentType; }
}

// Paint class
class PaintWithImage extends ProductWithImage {
    private String paintColor;
    
    public PaintWithImage(String productId, String name, double price, int stockQuantity, String brand, String paintColor, String imageUrl) {
        super(productId, name, price, stockQuantity, brand, imageUrl);
        this.paintColor = paintColor;
    }
    
    @Override
    public String getCategory() { return "Paints"; }
    public String getPaintColor() { return paintColor; }
}

// Plumbing class
class PlumbingWithImage extends ProductWithImage {
    private String plumbingType;
    
    public PlumbingWithImage(String productId, String name, double price, int stockQuantity, String brand, String plumbingType, String imageUrl) {
        super(productId, name, price, stockQuantity, brand, imageUrl);
        this.plumbingType = plumbingType;
    }
    
    @Override
    public String getCategory() { return "Plumbing"; }
    public String getPlumbingType() { return plumbingType; }
}

// Electrical class
class ElectricalWithImage extends ProductWithImage {
    private String electricalType;
    
    public ElectricalWithImage(String productId, String name, double price, int stockQuantity, String brand, String electricalType, String imageUrl) {
        super(productId, name, price, stockQuantity, brand, imageUrl);
        this.electricalType = electricalType;
    }
    
    @Override
    public String getCategory() { return "Electrical"; }
    public String getElectricalType() { return electricalType; }
}

// Enhanced Inventory Manager
class EnhancedInventoryManager {
    private ArrayList<ProductWithImage> products;
    
    public EnhancedInventoryManager() {
        products = new ArrayList<>();
    }
    
    public void addProduct(ProductWithImage product) {
        products.add(product);
    }
    
    public ArrayList<ProductWithImage> getAllProducts() {
        return products;
    }
    
    public ArrayList<ProductWithImage> filterProducts(String searchText, String category, String brand) {
        ArrayList<ProductWithImage> results = new ArrayList<>(products);
        
        if (!searchText.isEmpty()) {
            String lowerKeyword = searchText.toLowerCase();
            results.removeIf(p -> 
                !p.getName().toLowerCase().contains(lowerKeyword) &&
                !p.getProductId().toLowerCase().contains(lowerKeyword) &&
                !p.getCategory().toLowerCase().contains(lowerKeyword) &&
                !p.getBrand().toLowerCase().contains(lowerKeyword)
            );
        }
        
        if (!category.equals("All Categories")) {
            results.removeIf(p -> !p.getCategory().equals(category));
        }
        
        if (!brand.equals("All Brands")) {
            results.removeIf(p -> !p.getBrand().equals(brand));
        }
        
        return results;
    }
    
    public ArrayList<String> getAllBrands() {
        ArrayList<String> brands = new ArrayList<>();
        brands.add("All Brands");
        for (ProductWithImage p : products) {
            if (!brands.contains(p.getBrand())) {
                brands.add(p.getBrand());
            }
        }
        return brands;
    }
}

// Main User Interface
class UserCatalogFrame extends JFrame {
    private EnhancedInventoryManager inventory;
    private JPanel productGridPanel;
    private JTextField searchField;
    private JComboBox<String> categoryFilter;
    private JComboBox<String> brandFilter;
    private JLabel resultsCountLabel;
    
    public UserCatalogFrame(EnhancedInventoryManager inventory) {
        this.inventory = inventory;
        
        setTitle("Lourdes Mini Hardware - Product Catalog");
        setSize(1400, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        
        mainPanel.add(createHeaderPanel(), BorderLayout.NORTH);
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(createFilterPanel(), BorderLayout.NORTH);
        centerPanel.add(createProductsPanel(), BorderLayout.CENTER);
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(createFooterPanel(), BorderLayout.SOUTH);
        
        add(mainPanel);
        setVisible(true);
    }
    
    private JPanel createHeaderPanel() {
        JPanel headerPanel = new JPanel(null);
        headerPanel.setBackground(new Color(20, 20, 20));
        headerPanel.setPreferredSize(new Dimension(1400, 100));
        
        JLabel titleLabel = new JLabel("🔨 LOURDES MINI HARDWARE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36));
        titleLabel.setForeground(new Color(255, 193, 7));
        titleLabel.setBounds(40, 15, 600, 45);
        headerPanel.add(titleLabel);
        
        JLabel subtitleLabel = new JLabel("\"Small Store, Big Solutions.\"");
        subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 18));
        subtitleLabel.setForeground(new Color(255, 193, 7));
        subtitleLabel.setBounds(40, 60, 400, 25);
        headerPanel.add(subtitleLabel);
        
        JLabel contactLabel = new JLabel("📞 (045) 982-4587 | 📍 Brgy. Lourdes, Tarlac City, Philippines");
        contactLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        contactLabel.setForeground(Color.WHITE);
        contactLabel.setBounds(900, 35, 480, 30);
        headerPanel.add(contactLabel);
        
        return headerPanel;
    }
    
    private JPanel createFilterPanel() {
        JPanel filterPanel = new JPanel();
        filterPanel.setBackground(new Color(245, 245, 245));
        filterPanel.setPreferredSize(new Dimension(1400, 120));
        filterPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        filterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        
        JLabel searchLabel = new JLabel("🔍 Search:");
        searchLabel.setFont(new Font("Arial", Font.BOLD, 16));
        filterPanel.add(searchLabel);
        
        searchField = new JTextField(30);
        searchField.setPreferredSize(new Dimension(350, 40));
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200), 2),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        searchField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                applyFilters();
            }
        });
        filterPanel.add(searchField);
        
        JLabel categoryLabel = new JLabel("📂 Category:");
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 16));
        filterPanel.add(categoryLabel);
        
        categoryFilter = new JComboBox<>(new String[]{
            "All Categories", "Tools", "Equipment", "Paints", "Plumbing", "Electrical"
        });
        categoryFilter.setPreferredSize(new Dimension(180, 40));
        categoryFilter.setFont(new Font("Arial", Font.PLAIN, 14));
        categoryFilter.addActionListener(e -> applyFilters());
        filterPanel.add(categoryFilter);
        
        JLabel brandLabel = new JLabel("🏷️ Brand:");
        brandLabel.setFont(new Font("Arial", Font.BOLD, 16));
        filterPanel.add(brandLabel);
        
        ArrayList<String> brands = inventory.getAllBrands();
        brandFilter = new JComboBox<>(brands.toArray(new String[0]));
        brandFilter.setPreferredSize(new Dimension(180, 40));
        brandFilter.setFont(new Font("Arial", Font.PLAIN, 14));
        brandFilter.addActionListener(e -> applyFilters());
        filterPanel.add(brandFilter);
        
        JButton clearBtn = new JButton("Clear Filters");
        clearBtn.setPreferredSize(new Dimension(140, 40));
        clearBtn.setBackground(new Color(100, 100, 100));
        clearBtn.setForeground(Color.WHITE);
        clearBtn.setFont(new Font("Arial", Font.BOLD, 13));
        clearBtn.setFocusPainted(false);
        clearBtn.setBorderPainted(false);
        clearBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearBtn.addActionListener(e -> clearFilters());
        filterPanel.add(clearBtn);
        
        return filterPanel;
    }
    
    private JScrollPane createProductsPanel() {
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.setBackground(Color.WHITE);
        containerPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        
        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(Color.WHITE);
        
        resultsCountLabel = new JLabel("📦 Showing " + inventory.getAllProducts().size() + " products");
        resultsCountLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headerPanel.add(resultsCountLabel);
        
        containerPanel.add(headerPanel, BorderLayout.NORTH);
        
        productGridPanel = new JPanel(new GridLayout(0, 4, 20, 20));
        productGridPanel.setBackground(Color.WHITE);
        productGridPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
        
        applyFilters();
        
        containerPanel.add(productGridPanel, BorderLayout.CENTER);
        
        JScrollPane scrollPane = new JScrollPane(containerPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);
        
        return scrollPane;
    }
    
    private JPanel createFooterPanel() {
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(40, 40, 40));
        footerPanel.setPreferredSize(new Dimension(1400, 50));
        
        JLabel footerLabel = new JLabel("© 2025 Lourdes Mini Hardware | lourdeminihardware@gmail.com");
        footerLabel.setForeground(Color.WHITE);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        footerPanel.add(footerLabel);
        
        return footerPanel;
    }
    
    private void applyFilters() {
        String searchText = searchField.getText().trim();
        String category = (String) categoryFilter.getSelectedItem();
        String brand = (String) brandFilter.getSelectedItem();
        
        ArrayList<ProductWithImage> filteredProducts = inventory.filterProducts(searchText, category, brand);
        
        productGridPanel.removeAll();
        
        for (ProductWithImage product : filteredProducts) {
            productGridPanel.add(createProductCard(product));
        }
        
        resultsCountLabel.setText("📦 Showing " + filteredProducts.size() + " products");
        
        productGridPanel.revalidate();
        productGridPanel.repaint();
    }
    
    private void clearFilters() {
        searchField.setText("");
        categoryFilter.setSelectedIndex(0);
        brandFilter.setSelectedIndex(0);
        applyFilters();
    }
    
    private JPanel createProductCard(ProductWithImage product) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(new Color(255, 193, 7));
        card.setBorder(BorderFactory.createLineBorder(new Color(255, 193, 7), 3));
        card.setPreferredSize(new Dimension(300, 350));
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(new Color(255, 193, 7));
        imagePanel.setPreferredSize(new Dimension(294, 220));
        
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setBackground(new Color(255, 193, 7));
        imageLabel.setOpaque(true);
        
        try {
            ImageIcon icon = new ImageIcon(new URL(product.getImageUrl()));
            Image img = icon.getImage().getScaledInstance(280, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            imageLabel.setText("📦");
            imageLabel.setFont(new Font("Arial", Font.BOLD, 48));
            imageLabel.setForeground(new Color(80, 80, 80));
        }
        
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(20, 20, 20));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JLabel nameLabel = new JLabel(product.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel brandLabel = new JLabel(product.getBrand());
        brandLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        brandLabel.setForeground(new Color(255, 193, 7));
        brandLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel priceLabel = new JLabel("₱" + String.format("%.2f", product.getPrice()));
        priceLabel.setFont(new Font("Arial", Font.BOLD, 18));
        priceLabel.setForeground(new Color(255, 193, 7));
        priceLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        buttonPanel.setBackground(new Color(20, 20, 20));
        buttonPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JButton viewBtn = new JButton("View Details");
        viewBtn.setPreferredSize(new Dimension(120, 30));
        viewBtn.setBackground(new Color(255, 193, 7));
        viewBtn.setForeground(Color.BLACK);
        viewBtn.setFont(new Font("Arial", Font.BOLD, 11));
        viewBtn.setFocusPainted(false);
        viewBtn.setBorderPainted(false);
        viewBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        viewBtn.addActionListener(e -> showProductDetails(product));
        buttonPanel.add(viewBtn);
        
        infoPanel.add(nameLabel);
        infoPanel.add(Box.createVerticalStrut(5));
        infoPanel.add(brandLabel);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(priceLabel);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(buttonPanel);
        
        card.add(imagePanel, BorderLayout.NORTH);
        card.add(infoPanel, BorderLayout.CENTER);
        
        card.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                card.setBorder(BorderFactory.createLineBorder(new Color(255, 215, 0), 5));
            }
            
            public void mouseExited(MouseEvent e) {
                card.setBorder(BorderFactory.createLineBorder(new Color(255, 193, 7), 3));
            }
        });
        
        return card;
    }
    
    private void showProductDetails(ProductWithImage product) {
        JDialog dialog = new JDialog(this, "Product Details", true);
        dialog.setSize(600, 650);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());
        
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(20, 20, 20));
        headerPanel.setPreferredSize(new Dimension(600, 70));
        
        JLabel titleLabel = new JLabel(product.getName());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(255, 193, 7));
        headerPanel.add(titleLabel);
        
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(25, 35, 25, 35));
        
        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(new Color(245, 245, 245));
        imagePanel.setPreferredSize(new Dimension(530, 280));
        imagePanel.setMaximumSize(new Dimension(530, 280));
        imagePanel.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        
        try {
            ImageIcon icon = new ImageIcon(new URL(product.getImageUrl()));
            Image img = icon.getImage().getScaledInstance(500, 260, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            imageLabel.setText("📦 Product Image");
            imageLabel.setFont(new Font("Arial", Font.BOLD, 20));
        }
        
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        contentPanel.add(imagePanel);
        contentPanel.add(Box.createVerticalStrut(25));
        
        addDetailRow(contentPanel, "Product ID:", product.getProductId());
        addDetailRow(contentPanel, "Category:", product.getCategory());
        addDetailRow(contentPanel, "Brand:", product.getBrand());
        addDetailRow(contentPanel, "Price:", "₱" + String.format("%.2f", product.getPrice()));
        addDetailRow(contentPanel, "Stock:", product.getStockQuantity() > 0 ? "In Stock (" + product.getStockQuantity() + " units)" : "Out of Stock");
        
        contentPanel.add(Box.createVerticalStrut(15));
        
        JTextArea noteArea = new JTextArea("NOTE: Please visit our store at Brgy. Lourdes, Tarlac City to purchase this product. For inquiries, call (045) 982-4587 or email lourdeminihardware@gmail.com");
        noteArea.setFont(new Font("Arial", Font.ITALIC, 12));
        noteArea.setForeground(new Color(100, 100, 100));
        noteArea.setBackground(new Color(245, 245, 245));
        noteArea.setEditable(false);
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);
        noteArea.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        noteArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(noteArea);
        
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(null);
        
        JPanel footerPanel = new JPanel();
        footerPanel.setBackground(new Color(40, 40, 40));
        footerPanel.setPreferredSize(new Dimension(600, 65));
        
        JButton closeBtn = new JButton("Close");
        closeBtn.setPreferredSize(new Dimension(120, 38));
        closeBtn.setBackground(new Color(255, 193, 7));
        closeBtn.setForeground(Color.BLACK);
        closeBtn.setFont(new Font("Arial", Font.BOLD, 13));
        closeBtn.setFocusPainted(false);
        closeBtn.setBorderPainted(false);
        closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeBtn.addActionListener(e -> dialog.dispose());
        footerPanel.add(closeBtn);
        
        dialog.add(headerPanel, BorderLayout.NORTH);
        dialog.add(scrollPane, BorderLayout.CENTER);
        dialog.add(footerPanel, BorderLayout.SOUTH);
        
        dialog.setVisible(true);
    }
    
    private void addDetailRow(JPanel panel, String label, String value) {
        JPanel rowPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 10));
        rowPanel.setBackground(Color.WHITE);
        rowPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        rowPanel.setMaximumSize(new Dimension(550, 35));
        
        JLabel labelText = new JLabel(label + " ");
        labelText.setFont(new Font("Arial", Font.BOLD, 15));
        labelText.setForeground(new Color(60, 60, 60));
        
        JLabel valueText = new JLabel(value);
        valueText.setFont(new Font("Arial", Font.PLAIN, 15));
        valueText.setForeground(new Color(20, 20, 20));
        
        rowPanel.add(labelText);
        rowPanel.add(valueText);
        panel.add(rowPanel);
    }
}

// Main class
public class HardwareCatalogUserSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EnhancedInventoryManager inventory = new EnhancedInventoryManager();
            
            // Add sample products with reliable image URLs
            inventory.addProduct(new ToolWithImage("T001", "Claw Hammer", 350.00, 25, "Stanley", "Hand Tool",
                "https://www.tooled-up.com/artwork/prodzoom/STA151621.jpg"));
            
            inventory.addProduct(new ToolWithImage("T002", "Ball Peen Hammer", 320.00, 18, "Stanley", "Hand Tool",
                "https://rukminim1.flixcart.com/image/1408/1408/hammer/z/k/h/54-115-stanley-original-imadu93axnrrxzy6.jpeg?q=90"));
            
            inventory.addProduct(new ToolWithImage("T003", "Sledge Hammer", 850.00, 12, "Truper", "Hand Tool",
                "https://d435eq762vwe7.cloudfront.net/wp-content/uploads/HAMM219.jpg"));
            
            inventory.addProduct(new ToolWithImage("T004", "Adjustable Wrench 10\"", 450.00, 20, "Stanley", "Hand Tool",
                "https://gztrading.com.sg/wp-content/uploads/2022/11/buy-STANLEY-HD-ADJUSTABLE-WRENCH-10-online.jpg"));
            
            inventory.addProduct(new EquipmentWithImage("E001", "Cordless Drill", 3200.00, 12, "Bosch", "Power Tool",
                "https://www.bestchoicereviews.org/wp-content/uploads/2012/12/Bosch5.jpg"));
            
            inventory.addProduct(new EquipmentWithImage("E002", "Electric Impact Drill", 4500.00, 8, "Makita", "Power Tool",
                "https://images.homedepot-static.com/productImages/066983d5-487e-42d6-b1b2-5faa7bdd6271/svn/makita-power-tool-combo-kits-xt211a-64_1000.jpg"));
            
            inventory.addProduct(new EquipmentWithImage("E003", "Angle Grinder", 2800.00, 15, "Bosch", "Power Tool",
                "https://cdn11.bigcommerce.com/s-of9567zot7/images/stencil/1920w/products/293/562/angle-grinder-bosch-gws-9-125-125-mm-900-w__64924.1621342566.jpg?c=1"));
            
            inventory.addProduct(new PaintWithImage("P001", "Interior Latex Paint White", 850.00, 40, "Davies", "White",
                "https://cebuhomebuilders.com/wp-content/uploads/2020/01/davies-megcryl-flat-ltx-white.jpg"));
            
            inventory.addProduct(new PaintWithImage("P002", "Interior Latex Paint Beige", 850.00, 35, "Davies", "Beige",
                "https://down-ph.img.susercontent.com/file/eaaa43c6c17f6f93f9ba9124b4d87617"));
            
            inventory.addProduct(new PlumbingWithImage("PL001", "PVC Pipe 1/2 inch", 180.00, 50, "Pipelife", "Pipe",
                "https://static.pipestock.com/media/catalog/product/cache/070ee71ad710a97d4d3f07810eb950b6/p/i/pipelife_pb_lengths.jpg"));
            
            inventory.addProduct(new PlumbingWithImage("PL005", "Basin Faucet", 850.00, 15, "American Standard", "Faucet",
                "https://prod-rebuild-assets.americanstandard-apac.com/vn/WT-T823_EasyFLO_Basin-Faucet_613x613.jpg"));
            
            inventory.addProduct(new ElectricalWithImage("EL001", "Extension Cord 3 Meters", 280.00, 35, "Omni", "Wire",
                "https://winlanddepot.com/cdn/shop/files/WEE-003-PK.jpg?v=1723691962"));
            
            new UserCatalogFrame(inventory);
        });
    }
}