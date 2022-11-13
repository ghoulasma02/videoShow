package package1;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LancerApp2 {
	public static void main(String[] args) throws IOException {
		BufferedImage imgVador= ImageIO.read(new File("images/person2.png"));
		BufferedImage imgLeila= ImageIO.read(new File("images/person1.png"));
		
		// création de la fenêtre de l'application
		JFrame laFenetre= new JFrame("Animation Train, etc.");
		laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		laFenetre.setSize(512, 512);
		
		// création de la zône de dessin dans la fenêtre
		Dessin d = new Dessin();
		laFenetre.getContentPane().add(d);
		
		// affiche la fenêtre
		laFenetre.setVisible(true);
		
		
		//mouvement circulaire non aleatoire 
		
		d.ajouterObjet(new AnimationForme(new Etoile(350, 100, 50, 8.f, Color.RED, Color.YELLOW),new MvtCirculaire(250,250,180,0,5)));
		d.ajouterObjet(new AnimationForme(new PolygoneRegulier(5, 240, 40, 40, 4.0f, Color.DARK_GRAY, null),new MvtCirculaire(210,210,180,0,5)));
		
		//objet fixe 
		d.ajouterObjet(new Etoile(470, 100, 50, 8.f, Color.GREEN, Color.GREEN));
		d.ajouterObjet(new Etoile(350, 150, 50, 8.f, Color.YELLOW, Color.RED));
		d.ajouterObjet(new PolygoneRegulier(5, 370, 40, 40, 4.0f, Color.BLACK, Color.BLACK));
         
		// le visage
		Visage v = new Visage(d);
		d.ajouterObjet(v); 
		
		
		// les trains de cercles avec image et en couleur avec mouvement aleatoire
				TrainCercle[] lesTrains= new TrainCercle[7];
				lesTrains[0] = new TrainCercleImage(d, 10, imgVador); d.ajouterObjet(lesTrains[0]);
				lesTrains[1] = new TrainCercleImage(d, 10, imgLeila); d.ajouterObjet(lesTrains[1]);
				for (int i = 2; i < 7; i++) {
					lesTrains[i] = new TrainCercleCouleur(new Color((float) Math.random(), (float) Math.random(),
				(float) Math.random()), d, 10, 10);
				d.ajouterObjet(lesTrains[i]);
				}


	while(true) {
		// la zone de dessin se réaffiche
		d.repaint();
		// un temps de pause pour avoir le temps de voir le nouveau dessin
		d.pause(50);
		//réaliser à tous les trains un déplacement élémentaire
		d.animer();
		
		}
	}
}

