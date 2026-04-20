import java.net.*;
import java.io.*;
import org.json.*;

public class CurrencyModel {

    // 🔹 Offline fallback rates (USD base)
    public static double getOfflineRate(String from, String to) {

        double amountInUSD = 1;

        if (from.equals("BDT")) amountInUSD = 0.0091;
        else if (from.equals("EUR")) amountInUSD = 1.08;
        else if (from.equals("INR")) amountInUSD = 0.012;
        else if (from.equals("GBP")) amountInUSD = 1.27;
        else if (from.equals("JPY")) amountInUSD = 0.0068;

        if (to.equals("BDT")) return amountInUSD * 109.5;
        if (to.equals("EUR")) return amountInUSD * 0.93;
        if (to.equals("INR")) return amountInUSD * 83;
        if (to.equals("GBP")) return amountInUSD * 0.79;
        if (to.equals("JPY")) return amountInUSD * 147;

        return amountInUSD;
    }

    // 🔹 Online API (ExchangeRate API – free)
    public static double getOnlineRate(String from, String to) throws Exception {

        String urlStr =
            "https://api.exchangerate.host/convert?from=" + from + "&to=" + to;

        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader br =
            new BufferedReader(new InputStreamReader(con.getInputStream()));

        StringBuilder json = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) json.append(line);
        br.close();

        JSONObject obj = new JSONObject(json.toString());
        return obj.getDouble("result");
    }
}