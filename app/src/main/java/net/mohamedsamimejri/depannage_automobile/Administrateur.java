package net.mohamedsamimejri.depannage_automobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Administrateur extends Activity {
	Button gererDepanneur, gererAutomobiliste;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.administrateur);
		gererDepanneur = (Button) findViewById(R.id.button1);
		gererAutomobiliste = (Button) findViewById(R.id.button2);
		
		gererDepanneur.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent i=new Intent(Administrateur.this,GererDepanneur.class);
			startActivity(i);
			}
		});
		
		gererAutomobiliste.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Administrateur.this,GererAutomobiliste.class);
				startActivity(i);
			}
		});

	}

}
