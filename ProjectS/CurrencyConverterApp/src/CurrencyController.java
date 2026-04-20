public class CurrencyController {

    public static double convert(double amount, String from, String to) {

        try {
            // Try online first
            double rate = CurrencyModel.getOnlineRate(from, to);
            return amount * rate;

        } catch (Exception e) {
            // Offline fallback
            double rate = CurrencyModel.getOfflineRate(from, to);
            return amount * rate;
        }
    }
}