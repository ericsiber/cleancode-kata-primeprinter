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

        while (pageoffset <= numberOfNumbers) {
            System.out.print("The First ");
            System.out.print(Integer.toString(numberOfNumbers));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pagenumber));
            System.out.println("\n");
            for (rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage - 1; rowoffset++) {
                for (column = 0; column <= columns - 1; column++)
                    if (rowoffset + column * linesPerPage <= numberOfNumbers)
                        System.out.printf("%10d", numbers[rowoffset + column * linesPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage * columns;
        }
    }
    public int[] invoke() {
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
