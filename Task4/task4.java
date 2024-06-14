
    import java.util.HashMap;
    import java.util.Map;
    import java.util.Scanner;
    
    public class task4 {
    
      
        private static final Map<String, Double> exchangeRates = new HashMap<>();
        
        static {
            exchangeRates.put("USD", 1.0);     
            exchangeRates.put("EUR", 0.85);    
            exchangeRates.put("GBP", 0.75);    
            exchangeRates.put("INR", 74.5);    
            exchangeRates.put("JPY", 110.0);   
           
        }
    
        private static double getExchangeRate(String baseCurrency, String targetCurrency) {
            
            double baseToUsdRate = exchangeRates.getOrDefault(baseCurrency, -1.0);
            double targetToUsdRate = exchangeRates.getOrDefault(targetCurrency, -1.0);
            
            if (baseToUsdRate == -1.0 || targetToUsdRate == -1.0) {
                return -1.0; 
            }
            
            return targetToUsdRate / baseToUsdRate;
        }
    
       
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
    
            
            System.out.print("Enter base currency (e.g., USD): ");
            String baseCurrency = scanner.nextLine().toUpperCase();
            System.out.print("Enter target currency (e.g., EUR): ");
            String targetCurrency = scanner.nextLine().toUpperCase();
    
            
            System.out.print("Enter amount to convert: ");
            double amount = scanner.nextDouble();
    
           
            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
            if (exchangeRate == -1.0) {
                System.out.println("Invalid currency code.");
                return;
            }
    
            
            double convertedAmount = amount * exchangeRate;
    
            
            System.out.printf("Converted amount: %.2f %s%n", convertedAmount, targetCurrency);
        }
    
}
