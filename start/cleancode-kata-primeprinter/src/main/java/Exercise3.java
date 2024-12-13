public class Exercise3 {
    /**
     *
     * @param amount price
     * @param type Account status (NotRegistered = 1, SimpleCustomer = 2, ValuableCustomer = 3, MostValuableCustomer = 4)
     * @param years Time in years that the client is our customer
     * @return THE PRICE
     */
    public double calculate(double amount, int type, int years)
    {
        double result = 0;
        double disc = (years > 5) ? (double) 5 / 100 : (double)years / 100;
        double resultCase2 = (amount - (0.1 * amount)) - disc * (amount - (0.1 * amount));
        double resultCase3 = (0.7 * amount) - disc * (0.7 * amount);
        double resultCase4 = (amount - (0.5 * amount)) - disc * (amount - (0.5 * amount));

        switch (type) {

            // NotRegistered
            case 1:
                result = amount;
                return result;

            // SimpleCustomer
            case 2:
                result = resultCase2;
                break;

            // ValuableCustomer
            case 3:
                result = resultCase3;
                return result;

            // MostValuableCustomer
            case 4:
                result = resultCase4;
                break;
        }
        return result;
    }
}