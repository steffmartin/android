package move.pdsi.facom.ufu.br.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Random;

import move.pdsi.facom.ufu.br.OrionRESTClient.OrionRESTClient;
import move.pdsi.facom.ufu.br.move.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    /**
     * <<<<<<< HEAD
     * Chamada ao clicar no botão de Banco de Dados
     */
    public void orion(View view) {

        try {
            OrionRESTClient cli = new OrionRESTClient();
            Random random = new Random();
            JSONObject test = new JSONObject();
            test.put("id", "Teste");
            JSONObject attr = new JSONObject();
            attr.put("name", "init");
            attr.put("type", "Float");
            attr.put("value", Double.toString(random.nextDouble() * 100)); // Uma coordenada GPS inicial aleatória
            test.put("attribute1", attr);
            JSONObject attr2 = new JSONObject();
            attr2.put("name", "end");
            attr2.put("type", "String");
            attr2.put("value", Double.toString(random.nextDouble() * 1000)); // Uma coordenada GPS final aleatória
            test.put("attribute2", attr2);
            JSONObject attr3 = new JSONObject();
            attr3.put("name", "hor1");
            attr3.put("type", "String");
            attr3.put("value", android.text.format.DateFormat.format("hh:mm:ss", new java.util.Date(new java.util.Date().getTime() - 888888)));
            test.put("attribute3", attr3);
            JSONObject attr4 = new JSONObject();
            attr4.put("name", "hor2");
            attr4.put("type", "String");
            attr4.put("value", android.text.format.DateFormat.format("hh:mm:ss", new java.util.Date()));
            test.put("attribute4", attr4);
            JSONObject attr5 = new JSONObject();
            attr5.put("name", "data");
            attr5.put("type", "String");
            attr5.put("value", android.text.format.DateFormat.format("dd/MM/yyyy", new java.util.Date()));
            test.put("attribute5", attr5);
            JSONObject resp = cli.post(test);
            Toast.makeText(this, "Evento detectado e enviado para o Orion", Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            Toast.makeText(this, "Erro de Comunicação com o Orion! JSON EXCEPTION", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Erro de Comunicação com o Orion! IO EXCEPTION", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Erro de Comunicação com o Orion! EXCEPTION", Toast.LENGTH_SHORT).show();
        }

        OrionRESTClient cli = new OrionRESTClient();
        try {
            double a1 = Double.parseDouble(cli.get("attribute1").getString("Response"));
            double a2 = Double.parseDouble(cli.get("attribute2").getString("Response"));
            String hor1 = cli.get("attribute3").getString("Response");
            String hor2 = cli.get("attribute4").getString("Response");
            String data = cli.get("attribute5").getString("Response");
            double distancia = Math.abs(a2 - a1);

            //Abre tela de add Evento
            Intent intent = new Intent(this, addEventoViagem.class);
            intent.putExtra("distanciaEvento", String.format("%1$,.2f", distancia));
            intent.putExtra("horaInicial", hor1);
            intent.putExtra("horaFinal", hor2);
            intent.putExtra("dataEvento", data);
            startActivity(intent);

        } catch (IOException ex) {
            Log.i("ioexception get", "IOException GET");
            Toast.makeText(this, "Erro de Comunicação com o Orion! JSON EXCEPTION", Toast.LENGTH_SHORT).show();
        } catch (JSONException ex) {
            Log.i("jsonexception get", "JSONException GET");
            Toast.makeText(this, "Erro de Comunicação com o Orion! IO EXCEPTION", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Erro de Comunicação com o Orion! EXCEPTION", Toast.LENGTH_SHORT).show();
        }


    }

    /**
     * =======
     * >>>>>>> master
     * Chamada ao clicar no botão de Meios de Transporte
     */
    public void gerenciarMeios(View view) {
        Intent intent = new Intent(this, MeiosDeTransporteActivity.class);
        startActivity(intent);
    }

    /**
     * Chamada ao clicar no botão de Eventos
     */
    public void gerenciarEventos(View view) {
        Intent intent = new Intent(this, EventosActivity.class);
        startActivity(intent);
    }
}
