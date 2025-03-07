import java.util.Arrays;

public class SieveOfEratosthenes {
    public static void sieve(int n) {
        // Step 1: Create a boolean array and assume all numbers are prime
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        // Step 2: 0 and 1 are not prime
        isPrime[0] = false;
        isPrime[1] = false;

        // Step 3: Start marking multiples of each prime
        for (int i = 2; i * i <= n; i++) { 
            if (isPrime[i]) { // If i is prime, mark its multiples as non-prime
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Step 4: Print all prime numbers
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 20; // Change this value as needed
        sieve(n);
    }
}
