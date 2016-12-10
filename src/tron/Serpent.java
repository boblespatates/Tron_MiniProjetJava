package tron;

public class Serpent {

	private String m_couleur;
	private int m_numero;
	private int m_orientation=0;
	private int m_teteX=0;
	private int m_score=0;
	private int m_teteY=0;
	private boolean m_isWin=false;
	private Joueur m_joueur;
	private Partie m_partie;
	
	public void Serpent(int unNumero,String uneCouleur){
		m_numero=unNumero;
		m_couleur=uneCouleur;
	}
	
	public int getTeteX(){
		return m_teteX;
	}
	
	public int getTeteY(){
		return m_teteY;
	}
	
	public boolean changerTete(int x,int y){
		m_teteX=x;
		m_teteY=y;
		int[][] uneGrille=m_partie.getGrille();
		if (uneGrille[x][y]==0)
		{
			m_partie.setGrille(x,y,m_numero);
			return false;
		}else{
			return true;
		}
	}
	
	public boolean deplacerSerpent(){
			if(m_orientation==1){              //gauch
				int x=m_teteX-1;
				int y=m_teteY;
				m_isWin=changerTete(x,y);
			}
			else if(m_orientation==2){              //haut
				int x=m_teteX;
				int y=m_teteY-1;
				m_isWin=changerTete(x,y);
			}
			else if(m_orientation==3){              //droite
				int x=m_teteX+1;
				int y=m_teteY;
				m_isWin=changerTete(x,y);
			}
			else if(m_orientation==4){              //bas
				int x=m_teteX;
				int y=m_teteY+1;
				m_isWin=changerTete(x,y);
		}
		//changerScore();
		return m_isWin;
	}
	
	public void setPartie(Partie unePartie){
		m_partie=unePartie;
	}
	
	public int getOrientation(){
		return m_orientation;
	}
	
	public void changerOrientation(int uneOrientation){
		if (java.lang.Math.abs(m_orientation-uneOrientation)!=2){
			m_orientation=uneOrientation;
		}
	}
	
	public boolean getRes(){
		return m_isWin;
	}
	public String getCouleur(){
		return m_couleur;
	}
	public void setCouleur(String uneCouleur){
		m_couleur=uneCouleur;
	}
	public Joueur getJoueur(){
		return m_joueur;
	}
	public void setJoueur(Joueur uneJoueur){
		m_joueur=uneJoueur;
	}
	/*public void changerScore(){
		if (getRes()==true){
			m_score=m_score+1;
		}
	}*/
}
