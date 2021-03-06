package tron;

import java.io.Serializable;

public class PartieThread extends Thread implements Serializable{

	Partie m_partie;

	public PartieThread(Partie unePartie){
		m_partie = unePartie;

	}

	public void run(){
/*		if ( m_partie.deplacerSerpents() ) {
			m_partie.getEcran().repaint();
		}
		else {
			m_partie.designerGagnants();
		}*/

		while (m_partie.isPartieEnCours()){
			try {
				if ( m_partie.deplacerSerpents() ) {
					m_partie.getEcran().repaint();
				}
				else {
					m_partie.designerGagnants();
				}
				Thread.sleep( m_partie.getVitesse() );
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
	}
}
