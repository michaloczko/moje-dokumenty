import java.io.Serializable;


public class Wypozyczenie implements Serializable {
		
	private static final long serialVersionUID = -3047099880935306056L;
	Ksiazka ksiazka;
	Czytelnik czytelnik;
	/**
	 * @param ksiazka
	 * @param czytelnik
	 */
	public Wypozyczenie(Ksiazka ksiazka, Czytelnik czytelnik) {
		super();
		this.ksiazka = ksiazka;
		this.czytelnik = czytelnik;
	}
	/**
	 * @return the ksiazka
	 */
	public Ksiazka getKsiazka() {
		return ksiazka;
	}
	/**
	 * @param ksiazka the ksiazka to set
	 */
	public void setKsiazka(Ksiazka ksiazka) {
		this.ksiazka = ksiazka;
	}
	/**
	 * @return the czytelnik
	 */
	public Czytelnik getCzytelnik() {
		return czytelnik;
	}
	/**
	 * @param czytelnik the czytelnik to set
	 */
	public void setCzytelnik(Czytelnik czytelnik) {
		this.czytelnik = czytelnik;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ksiazka + " -> " + czytelnik;
	}

}
