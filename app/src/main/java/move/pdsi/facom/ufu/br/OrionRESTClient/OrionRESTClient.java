/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package move.pdsi.facom.ufu.br.OrionRESTClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.Socket;

/**
 * @author Arthur
 */
public class OrionRESTClient {
    private static String ADDRESS = "batcave1.servehttp.com";
    //private static String ADDRESS = "localhost";
    private static int port = 23333;
    private Socket con;

    public OrionRESTClient() {

    }

    public JSONObject post(JSONObject input) throws IOException, JSONException {
        this.createConnection();
        OutputStream os = null;
        os = con.getOutputStream();
        os.write("POST /v2/entities/ HTTP/1.1\r\n".getBytes("UTF-8"));
        os.write(("Host: " + OrionRESTClient.ADDRESS).getBytes("UTF-8"));
        os.write("Content-Type: application/json\r\nAccept: application/json\r\n\r\n".getBytes("UTF-8"));
        String in = input.toString() + "\r\n\r\n";
        os.write(in.getBytes("UTF-8"));
        os.flush();
        InputStreamReader inp = null;
        inp = new InputStreamReader(con.getInputStream());
        BufferedReader br = new BufferedReader(inp);
        StringBuilder sb = new StringBuilder();
        String aux = null;
        while ((aux = br.readLine()) != null) {
            if (aux.isEmpty())
                break;
            sb.append(aux);
        }
        inp.close();
        con.close();
        System.out.println(sb.toString());
        JSONObject response = new JSONObject();
        response.put("Response", sb.toString());
        return response;
    }

    public JSONObject get(String resource) throws IOException, JSONException {
        this.createConnection();
        OutputStream os = null;
        os = con.getOutputStream();
        os.write(("GET /v2/entities/Teste/attrs/" + resource + "/value HTTP/1.1\r\n").getBytes("UTF-8"));
        os.write(("Host: " + OrionRESTClient.ADDRESS).getBytes("UTF-8"));
        os.write("Content-Type: application/json\r\nAccept: application/json\r\n\r\n".getBytes("UTF-8"));
        os.flush();
        InputStreamReader in = null;
        in = new InputStreamReader(con.getInputStream());
        BufferedReader br = new BufferedReader(in);
        StringBuilder sb = new StringBuilder();
        String aux = null;
        while ((aux = br.readLine()) != null) {
            if (aux.isEmpty())
                break;
            sb.append(aux);
        }
        in.close();
        con.close();
        System.out.println(sb.toString());
        JSONObject response = new JSONObject();
        response.put("Response", sb.toString());
        return response;
    }

    private void createConnection() {
        try {
            this.con = new Socket(OrionRESTClient.ADDRESS, OrionRESTClient.port);
        } catch (MalformedURLException ex) {
            System.out.println("Orion Server Address is Incorrect!");
        } catch (IOException ex) {
            System.out.println("Erro ao Conectar com o Servidor do Orion!");
        }
    }
}
