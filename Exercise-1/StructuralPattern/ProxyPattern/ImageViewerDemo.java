// Main method for Proxy Pattern Demo
public class ImageViewerDemo {
    public static void main(String[] args) {
        Image image = new ProxyImage("TestImageProxyPattern.jpg");
        System.out.println("Image created, not loaded yet.");
        image.display(); // Loads and displays
        image.display(); // Only displays
    }
}
