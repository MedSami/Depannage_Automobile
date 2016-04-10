package net.mohamedsamimejri.depannage_automobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Utilisateur extends Activity {
	Button depanneur, administrateur, automobiliste;
	String Type_utilistaeur;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.utilisateur);
		administrateur = (Button) findViewById(R.id.administrateur);
		depanneur = (Button) findViewById(R.id.depanneur);
		automobiliste = (Button) findViewById(R.id.automobiliste);

		administrateur.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Utilisateur.this, MainActivity.class);
			//	Type_utilistaeur="Administrateur";
				i.putExtra("Type_utilisateur", "Administrateur");
				startActivity(i);
			}
		});

		depanneur.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Utilisateur.this, MainActivity.class);
				// Type_utilistaeur="Depanneur";
					i.putExtra("Type_utilisateur", "Depanneur");

				startActivity(i);
			}
		});

		automobiliste.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Utilisateur.this, MainActivity.class);
//				 Type_utilistaeur="Automobiliste";
				i.putExtra("Type_utilisateur", "Automobiliste");

				startActivity(i);
			}
		});
	}

}
