package tech.linard.android.estabelecimentosdesaude.util;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import tech.linard.android.estabelecimentosdesaude.model.Estabelecimento;

/**
 * Created by lucas on 26/11/16.
 */

public final class QueryUtils {
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {
    }

    public static <T> T coalesce(T a, T b) {
        return a == null ? b : a;
    }

    public static List<Estabelecimento> fetchEstabelecimentoData (URL requestUrl) {

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(requestUrl);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the HTTP request.", e);
        }
        List<Estabelecimento> estabelecimentos = extractEstabelecimentoFromJson(jsonResponse);
        return estabelecimentos;

    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";
        if (url == null) {
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static List<Estabelecimento> extractEstabelecimentoFromJson(String jsonResponse) {
        if (TextUtils.isEmpty(jsonResponse)) {
            return null;
        }
        List<Estabelecimento> estabelecimentos = new ArrayList<>();

        try {
            JSONArray baseJsonAarray = new JSONArray(jsonResponse);
            for (int i = 0; i <baseJsonAarray.length(); i++) {
                JSONObject currentJson = baseJsonAarray.getJSONObject(i);
                Estabelecimento estabelecimento = new Estabelecimento();
                // String
                estabelecimento.setmCodCnes(currentJson.optString("codCnes"));
                estabelecimento.setmCodUnidade(currentJson.optString("codUnidade"));
                estabelecimento.setmCodIbge(currentJson.optString("codIbge"));
                estabelecimento.setmCnpj(currentJson.optString("cnpj"));
                estabelecimento.setmNomeFantasia(currentJson.optString("nomeFantasia"));
                estabelecimento.setmNatureza(currentJson.optString("natureza"));
                estabelecimento.setmTipoUnidade(currentJson.optString("tipoUnidade"));
                estabelecimento.setmEsferaAdministrativa(currentJson.optString("esferaAdministrativa"));
                estabelecimento.setmRetencao(currentJson.optString("retencao"));
                estabelecimento.setmFluxoClientela(currentJson.optString("fluxoClientela"));
                estabelecimento.setmDescricaoCompleta(currentJson.optString("descricaoCompleta"));
                estabelecimento.setmTipoUnidadeCnes(currentJson.optString("tipoUnidadeCnes"));
                estabelecimento.setmCategoriaUnidade(currentJson.optString("categoriaUnidade"));
                estabelecimento.setmLogradouro(currentJson.optString("logradouro"));
                estabelecimento.setmNumero(currentJson.optString("numero"));
                estabelecimento.setmBairro(currentJson.optString("bairro"));
                estabelecimento.setmCidade(currentJson.optString("cidade"));
                estabelecimento.setmUf(currentJson.optString("uf"));
                estabelecimento.setmCep(currentJson.optString("cep"));
                estabelecimento.setmTurnoAtendimento(currentJson.optString("turnoAtendimento"));
                estabelecimento.setmTelefone(currentJson.optString("telefone"));

                // Double
                estabelecimento.setmLatitude(currentJson.optDouble("lat", 0.0));
                estabelecimento.setmLongitude(currentJson.optDouble("long", 0.0));

                // Boolean
                estabelecimento.setmVinculoSus(currentJson.optString("vinculoSus").equalsIgnoreCase("Sim"));
                estabelecimento.setmTemAtendimentoUrgencia(currentJson.optString("temAtendimentoUrgencia").equalsIgnoreCase("Sim"));
                estabelecimento.setmTemAtendimentoAmbulatorial(currentJson.optString("temAtendimentoAmbulatorial").equalsIgnoreCase("Sim"));
                estabelecimento.setmTemCentroCirurgico(currentJson.optString("temCentroCirurgico").equalsIgnoreCase("Sim"));
                estabelecimento.setmTemObstetra(currentJson.optString("temObstetra").equalsIgnoreCase("Sim"));
                estabelecimento.setmTemNeoNatal(currentJson.optString("temNeoNatal").equalsIgnoreCase("Sim"));
                estabelecimento.setmTemDialise(currentJson.optString("temDialise").equalsIgnoreCase("Sim"));

                // Adiciona na List
                estabelecimentos.add(estabelecimento);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return estabelecimentos;
    }
}
