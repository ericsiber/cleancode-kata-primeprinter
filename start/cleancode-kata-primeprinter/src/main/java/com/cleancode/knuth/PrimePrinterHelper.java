package com.cleancode.knuth;

public class PrimePrinterHelper {
    private final int[] primes = new int[PrimePrinter.numberOfPrimes + 1];
    private final int linesPerPage = 50;
    private final int columns = 4;
    private final int ordmax = 30;
    private final int[] multiples = new int[ordmax + 1];
    private int pagenumber = 1;
    private int pageoffset = 1;
    private int rowoffset;
    private int column;
    private int candidate = 1;
    private int primeIndex = 1;
    private boolean possiblyPrime;
    private int ord = 2;
    private int square = 9;
    private int n = 0;


    public void printPrimes(int[] numbers, int numberOfNumbers){

        new NumberPrinter(numbers, numberOfNumbers, linesPerPage, columns).invoke();
    }

    public int[] generatePrimes() {
        primes[1] = 2;

        while (primeIndex < PrimePrinter.numberOfPrimes) {
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate)
                        multiples[n] += primes[n] + primes[n];
                    if (multiples[n] == candidate)
                        possiblyPrime = false;
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            primes[primeIndex] = candidate;
        }


        printPrimes(primes, PrimePrinter.numberOfPrimes);
        return primes;
    }

}
