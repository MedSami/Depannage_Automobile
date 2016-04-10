package net.mohamedsamimejri.depannage_automobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class GererDepanneur extends Activity {
	Button Ajouter, Modifier, Supprimer, Appeler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gererdepanneur);
		Ajouter = (Button) findViewById(R.id.button1);
		Modifier = (Button) findViewById(R.id.button2);
		Supprimer = (Button) findViewById(R.id.button3);
		Appeler = (Button) findViewById(R.id.button4);
	
	Ajouter.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(GererDepanneur.this,AjouterDepanneur.class);
			startActivity(i);
		}
	});
	Modifier.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(GererDepanneur.this,ListeDepanneur.class);
			i.putExtra("Action", "Modifier");
			startActivity(i);
		}
	});
	
	Supprimer.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(GererDepanneur.this,ListeDepanneur.class);
			i.putExtra("Action", "Supprimer");
			startActivity(i);
		}
	});

	Appeler.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Intent i=new Intent(GererDepanneur.this,ListeDepanneur.class);
			i.putExtra("Action", "Appeler");
			startActivity(i);
		}
	});
	
	}
}
