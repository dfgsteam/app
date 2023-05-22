import java.awt.*; 
import java.awt.event.*; 
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*; 


/**
 * Die Klasse AppDrawEvent stellt eine Anwendung dar, die ein Bild lädt und verschiedene Darstellungen davon anzeigt.
 * Die Anwendung enthält drei Buttons zum Wechseln zwischen Originalbild, Graustufenbild und Bild mit Mustern.
 * Außerdem gibt es einen Exit-Button, um die Anwendung zu schließen.
 * Die Bilder werden im 2x2-Pixel-Raster dargestellt.
 * @author Julius Hunold
 * Georg-August-Universität in Göttingen
 * @version v1.0
 */

class AppDrawEvent { 
	private int height, width = 0;

	/**
	 * Erzeugt und liefert das JPanel mit den Buttons.
	 *
	 * @param frame           das JFrame-Objekt
	 * @param view            das JPanel-Objekt
	 * @param image_color     der JLabel für das farbige Bild
	 * @param image_gray      der JLabel für das Graustufenbild
	 * @param image_pattern   der JLabel für das Bild mit Mustern
	 * @return                das JPanel mit den Buttons
	 */
	private JPanel buttons(JFrame frame, JPanel view, JLabel image_color, JLabel image_gray, JLabel image_pattern) {
		// Button : Original
		JButton button_original = new JButton("Original"); 
		button_original.setBounds(50,100,95,30);  
		button_original.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				try {
					view.remove(image_gray);
				} catch (Exception e2) {
					System.out.println(e2);
				}
				try {
					view.remove(image_pattern);
				} catch (Exception e2) {  
					System.out.println(e2);
				}
				view.add(image_color, BorderLayout.CENTER);
				load_frame(frame);
			}  
		});  

		// Button : Gray
		JButton button_gray = new JButton("Grayscale"); 
		button_gray.setBounds(50,100,95,30);  
		button_gray.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				try {
					view.remove(image_color);
				} catch (Exception e2) {  
					System.out.println(e2);
				}
				try {
					view.remove(image_pattern);
				} catch (Exception e2) {  
					System.out.println(e2);
				}
				
				view.add(image_gray, BorderLayout.CENTER);
				load_frame(frame);
			}  
		});  

		// Button : Pattern
		JButton button_pattern = new JButton("Pattern"); 
		button_pattern.setBounds(50,100,95,30);  
		button_pattern.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				try {
					view.remove(image_color);
				} catch (Exception e2) {
					System.out.println(e2);
				}
				try {
					view.remove(image_gray);
				} catch (Exception e2) {  
					System.out.println(e2);
				}
				view.add(image_pattern, BorderLayout.CENTER);
				load_frame(frame);
			}  
		});  

		JPanel buttons = new JPanel();
		buttons.add(button_original);
		buttons.add(button_gray);
		buttons.add(button_pattern);
		
		return buttons;
	}

	/**
	 * Erzeugt und liefert den JLabel für das farbige Bild.
	 *
	 * @param filename    der Dateiname des Bildes
	 * @return            der JLabel für das farbige Bild
	 */
	private JLabel image_color(String filename) {
		try {
			BufferedImage image_old = ImageIO.read(new File(filename));
			BufferedImage image = new BufferedImage(image_old.getWidth()*2, image_old.getHeight()*2, BufferedImage.TYPE_INT_RGB);
			for (int width=0; width<image_old.getWidth()*2; width+=2) {
				for (int height=0; height<image_old.getHeight()*2; height+=2) {
					int color = image_old.getRGB(width/2, height/2);
					image.setRGB(width, height, color);
					image.setRGB(width+1, height, color);
					image.setRGB(width, height+1, color);
					image.setRGB(width+1, height+1, color);
				}
			}
			Icon icon = new ImageIcon(image);
			this.height = image.getHeight();
			this.width = image.getWidth();
			return new JLabel(icon);
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
			return null;
		}
	}

	/**
	 * Erzeugt und liefert den JLabel für das Graustufenbild.
	 *
	 * @param filename    der Dateiname des Bildes
	 * @return            der JLabel für das Graustufenbild
	 */
	private JLabel image_gray(String filename) {
		try {
			BufferedImage image_old = ImageIO.read(new File(filename));
			BufferedImage image = new BufferedImage(image_old.getWidth()*2, image_old.getHeight()*2, BufferedImage.TYPE_INT_RGB);
			for (int width=0; width<image_old.getWidth()*2; width+=2) {
				for (int height=0; height<image_old.getHeight()*2; height+=2) {
					int rgb = image_old.getRGB(width/2, height/2);
					int red = (rgb >> 16) & 0xFF;
					int green = (rgb >> 8) & 0xFF;
					int blue = rgb & 0xFF;
					int color = (red + green + blue)/3;
					color = new Color(color, color, color).getRGB();
					image.setRGB(width, height, color);
					image.setRGB(width+1, height, color);
					image.setRGB(width, height+1, color);
					image.setRGB(width+1, height+1, color);
				}
			}
			Icon icon = new ImageIcon(image);
			return new JLabel(icon);
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
			return null;
		}
	}

	/**
	 * Erzeugt und liefert den JLabel für das Bild mit Mustern.
	 *
	 * @param filename    der Dateiname des Bildes
	 * @return            der JLabel für das Bild mit Mustern
	 */
	private JLabel image_pattern(String filename) {
		try {
			BufferedImage image_old = ImageIO.read(new File(filename));
			BufferedImage image = new BufferedImage(image_old.getWidth()*2, image_old.getHeight()*2, BufferedImage.TYPE_INT_RGB);
			int black = new Color(0,0,0).getRGB();
			int white = new Color(255,255,255).getRGB();
			for (int width=0; width<image_old.getWidth()*2; width+=2) {
				for (int height=0; height<image_old.getHeight()*2; height+=2) {
					int rgb = image_old.getRGB(width/2, height/2);
					int red = (rgb >> 16) & 0xFF;
					int green = (rgb >> 8) & 0xFF;
					int blue = rgb & 0xFF;
					int color = (red + green + blue)/3;
					switch (color/52) {
						case 0: {
							image.setRGB(width, height, black);
							image.setRGB(width+1, height, black);
							image.setRGB(width, height+1, black);
							image.setRGB(width+1, height+1, black);
							break;
						}
						case 1: {
							image.setRGB(width, height, white);
							image.setRGB(width+1, height, black);
							image.setRGB(width, height+1, black);
							image.setRGB(width+1, height+1, black);
							break;
						}
						case 2: {
							image.setRGB(width, height, black);
							image.setRGB(width+1, height, white);
							image.setRGB(width, height+1, white);
							image.setRGB(width+1, height+1, black);
							break;
						}
						case 3: {
							image.setRGB(width, height, black);
							image.setRGB(width+1, height, white);
							image.setRGB(width, height+1, white);
							image.setRGB(width+1, height+1, white);
							break;
						}
						case 4: {
							image.setRGB(width, height, white);
							image.setRGB(width+1, height, white);
							image.setRGB(width, height+1, white);
							image.setRGB(width+1, height+1, white);
							break;
						}
						default: break;
					}
					
				}
			}
			Icon icon = new ImageIcon(image);
			return new JLabel(icon);
		} catch (IOException e) {
			System.out.println(e);
			System.exit(1);
			return null;
		}
	}

	/**
	 * Erzeugt und liefert das JPanel mit dem Exit-Button.
	 *
	 * @param frame    das JFrame der Anwendung
	 * @return         das JPanel mit dem Exit-Button
	 */
	private JPanel exit(JFrame frame) {
		// Button : Original
		JButton button_exit = new JButton("Exit"); 
		button_exit.setBounds(50,100,95,30);  
		button_exit.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				frame.dispose();
				return;
			}  
		});  

		JPanel exit = new JPanel();
		exit.setLayout(new FlowLayout(FlowLayout.RIGHT));
		exit.add(button_exit);
		
		return exit;
	}

	/**
	 * Lädt das JFrame und zeigt es an.
	 *
	 * @param frame    das JFrame der Anwendung
	 */
	private void load_frame(JFrame frame) {
		frame.pack();
		frame.setVisible(true);
		frame.revalidate();
        frame.repaint();
	}

	/**
	 * Erzeugt ein neues AppDrawEvent-Objekt mit dem angegebenen Dateinamen.
	 *
	 * @param filename    der Dateiname des Bildes
	 */
	public AppDrawEvent(String filename) {
		JFrame frame = new AppFrame(filename); 
		JPanel view = new JPanel();
		view.setLayout(new BorderLayout());

		// Image
		JLabel image_color = image_color(filename);
		JLabel image_gray = image_gray(filename);
		JLabel image_pattern = image_pattern(filename);

		// Color Buttons
		JPanel buttons = buttons(frame, view, image_color, image_gray, image_pattern);

		//
		JPanel exit = exit(frame);

		view.add(buttons, BorderLayout.NORTH);
		view.add(image_color, BorderLayout.CENTER);
		view.add(exit, BorderLayout.SOUTH);
		System.out.println(this.height);
		frame.setSize(this.width, this.height);
		frame.add(view);
		
		load_frame(frame);
	}

}

