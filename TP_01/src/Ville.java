import java.io.Serializable;

class Ville implements Serializable
	{
		private int nombreHabitants;
		private String nomPays;
		private String nomVille;
		
		public Ville(int nombreHabitants, String nomPays, String nomVilleString) {
			super();
			this.nombreHabitants = nombreHabitants;
			this.nomPays = nomPays;
			this.nomVille = nomVilleString;
		}
		public Ville() {
			nomVille="inconnu";
			nombreHabitants=0;
			nomPays="inconnu";
		}

		@Override
		public String toString() {
			return "Ville [nombreHabitants=" + nombreHabitants + ", nomPays=" + nomPays + ", nomVille="
					+ nomVille + "]";
		}
		


	}
