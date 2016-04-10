package net.mohamedsamimejri.depannage_automobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

public class EnvoyerDemmande extends Activity {
	public static final String strURL = "http://10.0.3.2:8080/Tunisie_Telecom/SelectDepanneur.php";
	public static final String strURL1 = "http://10.0.3.2:8080/Tunisie_Telecom/AjoutDemmande.php";

	int s = 0;
	int a = 0;
	EditText nomprenom, demmande;
	Button Valider;
	InputStream is = null;
	JSONArray ar;
	String Demmande,NumeroCinDepanneur, NumeroCinAutomobiliste, np, c, nt, result = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.envoyerdemmande);
		nomprenom = (EditText) findViewById(R.id.editText1);
		demmande = (EditText) findViewById(R.id.editText2);
		Valider = (Button) findViewById(R.id.button1);
		Intent data = this.getIntent();
		NumeroCinDepanneur = data.getExtras().getString("NumeroCinDepanneur");
		NumeroCinAutomobiliste = data.getExtras().getString(
				"NumeroCinAutomobiliste");

		new SelectDEpanneur().execute();

		Valider.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (demmande.getText().toString().equals("")) {
					AlertDialog.Builder adb = new AlertDialog.Builder(
							EnvoyerDemmande.this);
					adb.setTitle("V�rifier");
					adb.setMessage("saisir Demmande");
					adb.setPositiveButton("Ok", null);
					adb.show();
					demmande.requestFocus();
					return;
				}
				Demmande=demmande.getText().toString();
				new DemmandeEnvoyer().execute();

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

	private class SelectDEpanneur extends AsyncTask<Void, Void, JSONArray> {
		ProgressDialog mProgressDialog;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			mProgressDialog = ProgressDialog.show(EnvoyerDemmande.this,
					"Progress", "Waiting Please ..", false, false);
		}

		@Override
		protected JSONArray doInBackground(Void... params) {
			JavaScriptOrientedNotation js = new JavaScriptOrientedNotation(
					strURL, NumeroCinDepanneur, null, null, null, null, null,
					null, null, null, null);
			js.initialisation(NumeroCinDepanneur, null, null, null, null, null,
					null, null, null, null);
			try {
				is = js.Connect(strURL);
			} catch (Exception e) {
				Toast.makeText(EnvoyerDemmande.this,
						"Error in http connection ", Toast.LENGTH_LONG).show();
				Log.e("log_tag", "Error chttp connection " + e.toString());
			}

			try {
				result = js.ConvertToString(is);
			} catch (Exception e) {
				Log.e("log_tag", "Error converting result " + e.toString());
			}

			try {
				ar = js.Analyse(result);
			} catch (Exception e) {
				Toast.makeText(EnvoyerDemmande.this,
						"Erreur Analyse de donn�e", Toast.LENGTH_LONG).show();
			}

			return ar;
		}

		@Override
		protected void onPostExecute(JSONArray result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			mProgressDialog.dismiss();

			if (result == null) {
				Toast.makeText(EnvoyerDemmande.this,
						"Erreur Analyse de donn�e", Toast.LENGTH_LONG).show();
				return;
			}
			try {
				for (int i = 0; i < result.length(); i++) {
					JSONObject json_data = result.getJSONObject(i);
					c = json_data.getString("Cin");
					np = json_data.getString("Nom_Prenom");

					nomprenom.setText(np);
					nomprenom.setEnabled(false);
				}

			} catch (Exception e) {
				Toast.makeText(EnvoyerDemmande.this,
						"Erreur Analyse de donn�e", Toast.LENGTH_LONG).show();
			}
		}

	}

	private class DemmandeEnvoyer extends AsyncTask<Void, Void, Boolean> {
		ProgressDialog mProgressDialog;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			mProgressDialog = ProgressDialog.show(EnvoyerDemmande.this,
					"Progress", "En cours d'envoyer", false, false);
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			JavaScriptOrientedNotation js = new JavaScriptOrientedNotation(
					strURL1, NumeroCinDepanneur, NumeroCinAutomobiliste,
					Demmande, null, null, null, null,
					null, null, null);
			js.initialisation(NumeroCinDepanneur, NumeroCinAutomobiliste,
					Demmande, null, null, null, null,
					null, null, null);

		
			
			try {
				js.Connect(strURL1);
				return true;

			} catch (Exception e) {
				Log.e("log_tag", "Error in http connection " + e.toString());
				Toast.makeText(getApplicationContext(),
						"Error in http connection", Toast.LENGTH_SHORT).show();

			}
			return false;
		}

		@Override
		protected void onPostExecute(Boolean result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			mProgressDialog.dismiss();
			if (result) {
				AlertDialog.Builder adb = new AlertDialog.Builder(
						EnvoyerDemmande.this);
				adb.setTitle("Demmande");
				adb.setMessage("Demmande Envoyer");
				adb.setPositiveButton("Ok", null);
				adb.show();
			} else {
				AlertDialog.Builder adb = new AlertDialog.Builder(
						EnvoyerDemmande.this);
				adb.setTitle("Demmande");
				adb.setMessage("Demmande Non Envoyer");
				adb.setPositiveButton("Ok", null);
				adb.show();
			}
		}

	}
}
