package project.back.methods;

public class ReponseTextCovid {
	private  String x = System.getProperty("line.separator");
	  private  String a ="Cas Critique:\n";
	  private  String casa ="D'aprés les informations fournies, vous présentez les symptômes d'une personne atteinte du COVID-19.\n Nous vous exauçons de vous rendre rapprocher directement d'un structure de sante pour avoir plus d'information"
	      + "\n Ou APPELEZ IMMEDIATEMENT AU: 1515 ou 800 00 50 50";
	  private  String b ="Cas suspect mise en quarantaine:";
	  private  String casb = "\n D'aprés les informations fournies, la présence du virus COVID-19 dans votre organisme est trés probable."
	      + "\n Nous vous conseillons de vous mettre en quarantaine afin de protéger vos proches."
	      + "\n Veillez aussi contacter les services médicaux pour faire le test COVID-19 afin de connaître l'etat de votre santé."
	      + "\n APPELEZ AU: 1515 ou 800 00 50 50";
	  private  String c = "Persone normale: \n";
	  private  String casc = "D'aprés les informations fournies, vous ne présentez aucun symptôme en rapport avec la covid-19,\n"
	      + "Cependant, veillez strictement respecter les gestes barriéres s'il vous plait. \n"
	      + "Lavez vous réguliérement les mains. \n"
	      + "Portez un masque. \n"
	      + "Toussez dans votre coude. \n"
	      + "Gardez une distance supérieure ou égale á 1m avec les autres. \n"
	      + "Et respectez les instructions de l'Etat en diminuant vous déplacements et en restant chez vous. \n"
	      + "En cas de doute, veillez appeler au: 1515 ou au 800 00 50 50";
	  public String getCasCritique() {
		  return a+x+casa;
	  }
	  public  String getCasQuantaine() {
		  return b+x+casb;
	  }
	  public  String normal() {
		  return c+x+casc;
	  }
	
}
