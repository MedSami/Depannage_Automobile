package net.mohamedsamimejri.depannage_automobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Depanneur extends Activity {
	Button consulter, appeler;
	String NumeroCinDepanneur;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.depanneur);
		consulter = (Button) findViewById(R.id.button1);
		appeler = (Button) findViewById(R.id.button3);
		Intent data = this.getIntent();
		NumeroCinDepanneur = data.getExtras().getString("CinDepanneur");
		consulter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(Depanneur.this, ListeDemmande.class);
				i.putExtra("CinDepanneur", NumeroCinDepanneur);
				startActivity(i);
			}
		});
		appeler.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Depanneur.this, ListeAutomobiliste.class);
				i.putExtra("Action", "Appeler");
				startActivity(i);
			}
		});
	

	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK)) {
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}

}
