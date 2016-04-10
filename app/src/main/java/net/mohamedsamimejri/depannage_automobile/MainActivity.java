package net.mohamedsamimejri.depannage_automobile;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;

public class MainActivity extends Activity {
	EditText cin, pss;
	Button Valider;
	TextView t_util;
	String Ncin, Mpss, Type_utilisateur, result = "";
	InputStream is = null;
	JSONArray ar;
	public static final String strURL = "http://10.0.3.2:8080/Tunisie_Telecom/IdentificationAdmin.php";
	public static final String strURL1 = "http://10.0.3.2:8080/Tunisie_Telecom/IdentificationAutomobiliste.php";
	public static final String strURL2 = "http://10.0.3.2:8080/Tunisie_Telecom/IdentificationDepanneur.php";

	JavaScriptOrientedNotation js = new JavaScriptOrientedNotation();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		cin = (EditText) findViewById(R.id.cin);
		pss = (EditText) findViewById(R.id.motdepasse);
		Valider = (Button) findViewById(R.id.button1);
		t_util = (TextView) findViewById(R.id.textView1);
		Intent data = this.getIntent();
		Type_utilisateur = data.getExtras().getString("Type_utilisateur");
		t_util.setText(Type_utilisateur);
		Valider.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (Type_utilisateur.equals("Administrateur")) {

					Ncin = cin.getText().toString();
					Mpss = pss.getText().toString();
					if (Ncin.equals("")) {// hna yverify 7at cin
						// walla l�
						AlertDialog.Builder adb = new AlertDialog.Builder(// si
																			// ma
								// 7atte8
								// yatla3
								// message
								// alert
								// Saisir
								// votre
								// cin
								MainActivity.this);
						adb.setTitle("V�rifier");
						adb.setMessage("Saisir Votre CIN");
						adb.setPositiveButton("Ok", null);
						adb.show();
						cin.requestFocus();// yraja3 cursor lel zone text cin
					} else if (Ncin.length() != 8) {// hna ken
						// cin
						// deferent
						// to 8
						// yatla3
						// message
						// CIN doit
						// etre de 8
						// chiffre
						AlertDialog.Builder adb = new AlertDialog.Builder(
								MainActivity.this);
						adb.setTitle("V�rifier");
						adb.setMessage("CIN doit etre de 8 chiffre");
						adb.setPositiveButton("Ok", null);
						adb.show();
						cin.requestFocus();
					} else if (Mpss.equals("")) {// hna yverify 7at cin
						// walla l�
						AlertDialog.Builder adb = new AlertDialog.Builder(// si
																			// ma
								// 7atte8
								// yatla3
								// message
								// alert
								// Saisir
								// votre
								// cin
								MainActivity.this);
						adb.setTitle("V�rifier");
						adb.setMessage("Saisir Votre Mot De Passe");
						adb.setPositiveButton("Ok", null);
						adb.show();
						cin.requestFocus();// yraja3 cursor lel zone text cin
					} else
						try {
							int NC = Integer.parseInt(Ncin);// convert
							// cin
							// elli
							// 7atha
							// el
							// entier
							// bech
							// ken
							// raj3et
							// erreur
							// na3rfou
							// elli
							// houa
							// 7at
							// ra9m
							// cin
							// 4alet
							new LoginAdmin().execute();
						} catch (Exception e) {// lenna el message mta3 cin law
												// ken
							// 7atha chaine de caractere mech
							// entier
							AlertDialog.Builder adb = new AlertDialog.Builder(
									MainActivity.this);
							adb.setTitle("V�rifier");
							adb.setMessage("CIN doit etre Numerique");
							adb.setPositiveButton("Ok", null);
							adb.show();
							cin.requestFocus();
						}

				}
				if (Type_utilisateur.equals("Automobiliste")) {

					Ncin = cin.getText().toString();
					Mpss = pss.getText().toString();
					if (Ncin.equals("")) {// hna yverify 7at cin
						// walla l�
						AlertDialog.Builder adb = new AlertDialog.Builder(// si
																			// ma
								// 7atte8
								// yatla3
								// message
								// alert
								// Saisir
								// votre
								// cin
								MainActivity.this);
						adb.setTitle("V�rifier");
						adb.setMessage("Saisir Votre CIN");
						adb.setPositiveButton("Ok", null);
						adb.show();
						cin.requestFocus();// yraja3 cursor lel zone text cin
					} else if (Ncin.length() != 8) {// hna ken
						// cin
						// deferent
						// to 8
						// yatla3
						// message
						// CIN doit
						// etre de 8
						// chiffre
						AlertDialog.Builder adb = new AlertDialog.Builder(
								MainActivity.this);
						adb.setTitle("V�rifier");
						adb.setMessage("CIN doit etre de 8 chiffre");
						adb.setPositiveButton("Ok", null);
						adb.show();
						cin.requestFocus();
					} else if (Mpss.equals("")) {// hna yverify 7at cin
						// walla l�
						AlertDialog.Builder adb = new AlertDialog.Builder(// si
																			// ma
								// 7atte8
								// yatla3
								// message
								// alert
								// Saisir
								// votre
								// cin
								MainActivity.this);
						adb.setTitle("V�rifier");
						adb.setMessage("Saisir Votre Mot De Passe");
						adb.setPositiveButton("Ok", null);
						adb.show();
						cin.requestFocus();// yraja3 cursor lel zone text cin
					} else
						try {
							int NC = Integer.parseInt(Ncin);// convert
							// cin
							// elli
							// 7atha
							// el
							// entier
							// bech
							// ken
							// raj3et
							// erreur
							// na3rfou
							// elli
							// houa
							// 7at
							// ra9m
							// cin
							// 4alet
							/**********************************************************************************************/
							new LoginAutomobiliste().execute();

						} catch (Exception e) {// lenna el message mta3 cin law
												// ken
							// 7atha chaine de caractere mech
							// entier
							AlertDialog.Builder adb = new AlertDialog.Builder(
									MainActivity.this);
							adb.setTitle("V�rifier");
							adb.setMessage("CIN doit etre Numerique");
							adb.setPositiveButton("Ok", null);
							adb.show();
							cin.requestFocus();
						}

				}
				if (Type_utilisateur.equals("Depanneur")) {

					Ncin = cin.getText().toString();
					Mpss = pss.getText().toString();
					if (Ncin.equals("")) {// hna yverify 7at cin
						// walla l�
						AlertDialog.Builder adb = new AlertDialog.Builder(// si
																			// ma
								// 7atte8
								// yatla3
								// message
								// alert
								// Saisir
								// votre
								// cin
								MainActivity.this);
						adb.setTitle("V�rifier");
						adb.setMessage("Saisir Votre CIN");
						adb.setPositiveButton("Ok", null);
						adb.show();
						cin.requestFocus();// yraja3 cursor lel zone text cin
					} else if (Ncin.length() != 8) {// hna ken
						// cin
						// deferent
						// to 8
						// yatla3
						// message
						// CIN doit
						// etre de 8
						// chiffre
						AlertDialog.Builder adb = new AlertDialog.Builder(
								MainActivity.this);
						adb.setTitle("V�rifier");
						adb.setMessage("CIN doit etre de 8 chiffre");
						adb.setPositiveButton("Ok", null);
						adb.show();
						cin.requestFocus();
					} else if (Mpss.equals("")) {// hna yverify 7at cin
						// walla l�
						AlertDialog.Builder adb = new AlertDialog.Builder(// si
																			// ma
								// 7atte8
								// yatla3
								// message
								// alert
								// Saisir
								// votre
								// cin
								MainActivity.this);
						adb.setTitle("V�rifier");
						adb.setMessage("Saisir Votre Mot De Passe");
						adb.setPositiveButton("Ok", null);
						adb.show();
						cin.requestFocus();// yraja3 cursor lel zone text cin
					} else
						try {
							int NC = Integer.parseInt(Ncin);// convert
							// cin
							// elli
							// 7atha
							// el
							// entier
							// bech
							// ken
							// raj3et
							// erreur
							// na3rfou
							// elli
							// houa
							// 7at
							// ra9m
							// cin
							// 4alet
							/***********************************************************************************************/
							new LoginDepanneur().execute();

						} catch (Exception e) {// lenna el message mta3 cin law
												// ken
							// 7atha chaine de caractere mech
							// entier
							AlertDialog.Builder adb = new AlertDialog.Builder(
									MainActivity.this);
							adb.setTitle("V�rifier");
							adb.setMessage("CIN doit etre Numerique");
							adb.setPositiveButton("Ok", null);
							adb.show();
							cin.requestFocus();
						}

				}

			}
		});
	}

	private class LoginAdmin extends AsyncTask<Void, Void, JSONArray> {
		private ProgressDialog mProgressDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgressDialog = ProgressDialog.show(MainActivity.this,
					"Processing...", "Check Cin", false, false);
		}

		@Override
		protected JSONArray doInBackground(Void... arg0) {
			JavaScriptOrientedNotation js = new JavaScriptOrientedNotation(
					strURL, Ncin, null, null, null, null, null, null, null,
					null, null);
			js.initialisation(Ncin, null, null, null, null, null, null, null,
					null, null);
			try {
				is = js.Connect(strURL);
			} catch (Exception e) {
				Toast.makeText(MainActivity.this, "Error in http connection ",
						Toast.LENGTH_LONG).show();
			}

			try {
				result = js.ConvertToString(is);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				AlertDialog.Builder adb = new AlertDialog.Builder(
						MainActivity.this);
				adb.setTitle("V�rifier");
				adb.setMessage("CIN Incorrect");
				adb.setPositiveButton("Ok", null);
				adb.show();
				cin.requestFocus();
			}

			try {
				ar = js.Analyse(result);

			} catch (Exception e) {

				AlertDialog.Builder adb = new AlertDialog.Builder(
						MainActivity.this);
				adb.setTitle("V�rifier");
				adb.setMessage("CIN Incorrect");
				adb.setPositiveButton("Ok", null);
				adb.show();
				cin.requestFocus();
			}

			return ar;
		}

		@Override
		protected void onPostExecute(JSONArray result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			mProgressDialog.dismiss();
			if (result == null) {
				AlertDialog.Builder adb = new AlertDialog.Builder(
						MainActivity.this);
				adb.setTitle("V�rifier");
				adb.setMessage("CIN Incorrect");
				adb.setPositiveButton("Ok", null);
				adb.show();
				cin.requestFocus();
				return;
			}
			try {
				for (int i = 0; i < result.length(); i++) {
					JSONObject json_data;

					json_data = result.getJSONObject(i);

					String ncin = json_data.getString("Cin");

					String MotDePasse = json_data.getString("MotDePasse");

					if (ncin.equals(Ncin) && MotDePasse.equals(Mpss)) {

						Intent E = new Intent(MainActivity.this,
								Administrateur.class);

						startActivity(E);
						finish();
					} else if (ncin.equals(Ncin) && !MotDePasse.equals(Mpss)) {

						AlertDialog.Builder adb = new AlertDialog.Builder(
								MainActivity.this);
						adb.setTitle("V�rifier");
						adb.setMessage("Mot De Passe Incorrect");
						adb.setPositiveButton("Ok", null);
						adb.show();

					}
				}
			} catch (Exception e) {
				AlertDialog.Builder adb = new AlertDialog.Builder(
						MainActivity.this);
				adb.setTitle("V�rifier");
				adb.setMessage("Mot De Passe Incorrect!!!");
				adb.setPositiveButton("Ok", null);
				adb.show();
			}

		}
	}

	private class LoginAutomobiliste extends AsyncTask<Void, Void, JSONArray>

	{
		private ProgressDialog mProgressDialog;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			mProgressDialog = ProgressDialog.show(MainActivity.this,
					"Processing...", "Check Cin", false, false);
		}

		@Override
		protected JSONArray doInBackground(Void... arg0) {

			JavaScriptOrientedNotation js = new JavaScriptOrientedNotation(
					strURL1, Ncin, null, null, null, null, null, null, null,
					null, null);
			js.initialisation(Ncin, null, null, null, null, null, null, null,
					null, null);
			try {
				is = js.Connect(strURL1);
			} catch (Exception e) {
				Toast.makeText(MainActivity.this, "Error in http connection ",
						Toast.LENGTH_LONG).show();
				Log.e("log_tag", "Error chttp connection " + e.toString());
			}

			try {

				result = js.ConvertToString(is);

			} catch (Exception e) {

				AlertDialog.Builder adb = new AlertDialog.Builder(
						MainActivity.this);
				adb.setTitle("V�rifier");
				adb.setMessage("CIN Incorrect");
				adb.setPositiveButton("Ok", null);
				adb.show();
				cin.requestFocus();
			}

			try {
				ar = js.Analyse(result);
			} catch (Exception e) {
				AlertDialog.Builder adb = new AlertDialog.Builder(
						MainActivity.this);
				adb.setTitle("V�rifier2");
				adb.setMessage("CIN Incorrect");
				adb.setPositiveButton("Ok", null);
				adb.show();
				cin.requestFocus();
			}

			return ar;
		}

		@Override
		protected void onPostExecute(JSONArray result) {
			super.onPostExecute(result);
			mProgressDialog.dismiss();
			if (result == null) {
				AlertDialog.Builder adb = new AlertDialog.Builder(
						MainActivity.this);
				adb.setTitle("V�rifier");
				adb.setMessage("CIN Incorrect");
				adb.setPositiveButton("Ok", null);
				adb.show();
				cin.requestFocus();
				return;
			}
			try {
				for (int i = 0; i < result.length(); i++) {
					JSONObject json_data = result.getJSONObject(i);
					String ncin = json_data.getString("Cin");

					String MotDePasse = json_data.getString("MotDePasse");

					if (ncin.equals(Ncin) && MotDePasse.equals(Mpss)) {

						Intent E = new Intent(MainActivity.this,
								Automobiliste.class);
						E.putExtra("CinAutomobiliste", ncin);
						startActivity(E);
						finish();
					} else if (ncin.equals(Ncin) && !MotDePasse.equals(Mpss)) {

						AlertDialog.Builder adb = new AlertDialog.Builder(
								MainActivity.this);
						adb.setTitle("V�rifier");
						adb.setMessage("Mot De Passe Incorrect");
						adb.setPositiveButton("Ok", null);
						adb.show();
						return;

					}
				}
			} catch (Exception e) {

			}
		}

	}

	private class LoginDepanneur extends AsyncTask<Void, Void, JSONArray> {
		private ProgressDialog mProgressDialog;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			mProgressDialog = ProgressDialog.show(MainActivity.this,
					"Progress ..", "Check Identification ", false, false);
		}

		@Override
		protected JSONArray doInBackground(Void... arg0) {
			JavaScriptOrientedNotation js = new JavaScriptOrientedNotation(
					strURL2, Ncin, null, null, null, null, null, null, null,
					null, null);
			js.initialisation(Ncin, null, null, null, null, null, null, null,
					null, null);

			try {

				is = js.Connect(strURL2);

			} catch (Exception e) {
				Toast.makeText(MainActivity.this, "Error in http connection",
						Toast.LENGTH_LONG).show();
				Log.e("log_tag", "Error chttp connection " + e.toString());
			}

			try {

				result = js.ConvertToString(is);

			} catch (Exception e) {

				AlertDialog.Builder adb = new AlertDialog.Builder(
						MainActivity.this);
				adb.setTitle("V�rifier");
				adb.setMessage("CIN Incorrect");
				adb.setPositiveButton("Ok", null);
				adb.show();
				cin.requestFocus();
			}

			try {
				ar = js.Analyse(result);
			} catch (Exception e) {
				AlertDialog.Builder adb = new AlertDialog.Builder(
						MainActivity.this);
				adb.setTitle("V�rifier");
				adb.setMessage("CIN Incorrect");
				adb.setPositiveButton("Ok", null);
				adb.show();
				cin.requestFocus();
			}
			return ar;

		}

		@Override
		protected void onPostExecute(JSONArray result) {
			super.onPostExecute(result);
			mProgressDialog.dismiss();
			if (result == null) {
				AlertDialog.Builder adb = new AlertDialog.Builder(
						MainActivity.this);
				adb.setTitle("V�rifier");
				adb.setMessage("CIN Incorrect");
				adb.setPositiveButton("Ok", null);
				adb.show();
				cin.requestFocus();
				return;
			}
			try {
				for (int i = 0; i < result.length(); i++) {
					JSONObject json_data = result.getJSONObject(i);
					String ncin = json_data.getString("Cin");
					
					String MotDePasse = json_data.getString("MotDePasse");

					if (ncin.equals(Ncin) && MotDePasse.equals(Mpss)) {

						Intent E = new Intent(MainActivity.this,
								Depanneur.class);
						E.putExtra("CinDepanneur", ncin);
						startActivity(E);
						finish();
					} else if (ncin.equals(Ncin) && !MotDePasse.equals(Mpss)) {

						AlertDialog.Builder adb = new AlertDialog.Builder(
								MainActivity.this);
						adb.setTitle("V�rifier");
						adb.setMessage("Mot De Passe Incorrect");
						adb.setPositiveButton("Ok", null);
						adb.show();
						return;

					}
				}
			} catch (Exception e) {
				AlertDialog.Builder adb = new AlertDialog.Builder(
						MainActivity.this);
				adb.setTitle("V�rifier");
				adb.setMessage("CIN Incorrect");
				adb.setPositiveButton("Ok", null);
				adb.show();
				cin.requestFocus();
			}

		}

	}
}
