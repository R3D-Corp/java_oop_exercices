package labs.math.matrices_bits.graphics;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

public class Image {
	/**
	 * Returns a BufferedImage as the result of decoding the file with supplied
	 * pathname.
	 * 
	 * @param pathname
	 *            A pathname String.
	 * @return A BufferedImage containing the decoded contents of the input, or
	 *         null.
	 */
	public static BufferedImage loadImage(String pathname) {
		BufferedImage canvas = null;
		try {
			canvas = ImageIO.read(new File(pathname));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return canvas;
	}

	/**
	 * Displays a BufferedImage in a window.
	 * 
	 * @param image	a BufferedImage to be displayed
	 * @param title the window's title
	 */
    public static DrawingPanel displayImage(BufferedImage image, String title) {
    	if (image == null) return null;
		DrawingPanel p = new DrawingPanel(image.getWidth(), image.getHeight());
		if (title != null) p.setTitle(title);
		Graphics g = p.getGraphics();
		g.drawImage(image, 0, 0, null);
		return p;
	}
    
	/**
	 * Displays a BufferedImage in a window.
	 * 
	 * @param image	a BufferedImage to be displayed
	 * @param title the window's title
	 */
    public static void updateImage(DrawingPanel p, BufferedImage image, String title) {
    	if (image == null || p == null) return;
		if (title != null) p.setTitle(title);
		Graphics g = p.getGraphics();
		g.drawImage(image, 0, 0, null);
	}
    
    /**
     * Converts a BufferedImage to GIF format
     * 
     * @param image a BufferedImage to be converted to GIF
     * @return byte array representing the image in GIF format
     * @throws ImageFormatException
     * @throws IOException
     */
    public static byte[] imageToGif(BufferedImage image) throws IOException  {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(image, "GIF", output);
        return output.toByteArray();
    }
    
    /**
     * Encodes binary data in Base64
     * 
     * @param data the byte array to encode
     * @return A String containing the resulting Base64 encoded characters
     */
    public static String encodeToBase64(byte[] data) {
    	return Base64.getEncoder().encodeToString(data);
    }
}
