package net.mohamedsamimejri.depannage_automobile;

import java.io.InputStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

public class ModifierDepanneur extends Activity {
	public static final String strURL1 = "http://10.0.3.2:8080/Tunisie_Telecom/ModifierDepanneur.php";
	public static final String strURL = "http://10.0.3.2:8080/Tunisie_Telecom/SelectDepanneur.php";

	String NumCin, NomPrenom, NumTel, Pss;
	EditText cin, nomprenom, ntel, motdepasse;
	Button Valider;
	InputStream is = null;
	JSONArray ar;
	String nt, result = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modifierdepanneur);
		cin = (EditText) findViewById(R.id.editText1);
		nomprenom = (EditText) findViewById(R.id.editText2);
		ntel = (EditText) findViewById(R.id.editText3);
		motdepasse = (EditText) findViewById(R.id.editText4);
		Valider = (Button) findViewById(R.id.button1);
		Intent data = this.getIntent();
		NumCin = data.getExtras().getString("NumeroCin");

		Toast.makeText(ModifierDepanneur.this, NumCin, Toast.LENGTH_LONG)
				.show();
		new SelectDepanneur().execute();
		Valider.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new ModificationDepanneur().execute();

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

	private class SelectDepanneur extends AsyncTask<Void, Void, JSONArray> {
		ProgressDialog mProgressDialog;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			mProgressDialog = ProgressDialog.show(ModifierDepanneur.this,
					"Progress", "Waiting Please ..", false, false);
		}

		@Override
		protected JSONArray doInBackground(Void... params) {
			JavaScriptOrientedNotation js = new JavaScriptOrientedNotation(
					strURL, NumCin, null, null, null, null, null, null, null,
					null, null);
			js.initialisation(NumCin, null, null, null, null, null, null, null,
					null, null);
			try {
				is = js.Connect(strURL);

			} catch (Exception e) {
				Toast.makeText(ModifierDepanneur.this,
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
				Toast.makeText(ModifierDepanneur.this,
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
				Toast.makeText(ModifierDepanneur.this,
						"Erreur Analyse de donn�e", Toast.LENGTH_LONG).show();
				return;
			}
			try {

				for (int i = 0; i < result.length(); i++) {
					JSONObject json_data = result.getJSONObject(i);
					String c = json_data.getString("Cin");
					String np = json_data.getString("Nom_Prenom");
					String nt = json_data.getString("NTel");
					String mp = json_data.getString("MotDePasse");

					cin.setText(c);
					nomprenom.setText(np);
					ntel.setText(nt);
					motdepasse.setText(mp);
					cin.setEnabled(false);
				}

			} catch (JSONException e) {
				Toast.makeText(ModifierDepanneur.this,
						"Erreur Analyse de donn�e", Toast.LENGTH_LONG).show();
			}
		}

	}

	private class ModificationDepanneur extends AsyncTask<Void, Void, Boolean> {
		ProgressDialog mProgressDialog;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			mProgressDialog = ProgressDialog.show(ModifierDepanneur.this,
					"Progress", "Modification en cours ..", false, false);
		}

		@Override
		protected Boolean doInBackground(Void... params) {
			JavaScriptOrientedNotation js = new JavaScriptOrientedNotation(
					strURL1, NumCin, nomprenom.getText().toString(), ntel
							.getText().toString(), motdepasse.getText()
							.toString(), null, null, null, null, null, null);
			js.initialisation(NumCin, nomprenom.getText().toString(), ntel
					.getText().toString(), motdepasse.getText().toString(),
					null, null, null, null, null, null);
			try {
				js.Connect(strURL1);
				return true;
			} catch (Exception e) {
				Toast.makeText(ModifierDepanneur.this,
						"Error in http connection ", Toast.LENGTH_LONG).show();
				Log.e("log_tag", "Error chttp connection " + e.toString());
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
						ModifierDepanneur.this);
				adb.setTitle("Info");
				adb.setMessage("Modification terminer ");
				adb.setPositiveButton("Ok", null);
				adb.show();
			} else {
				AlertDialog.Builder adb = new AlertDialog.Builder(
						ModifierDepanneur.this);
				adb.setTitle("Info");
				adb.setMessage("Modification Non terminer ");
				adb.setPositiveButton("Ok", null);
				adb.show();
			}
		}

	}
}
