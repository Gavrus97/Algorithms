public class Main {

    public static void main(String[] args) {

        PairwiseProblem pairwiseProblem = new PairwiseProblem();

        pairwiseProblem.solve(new int[] {1,2});//2
        pairwiseProblem.solve(new int[] {1,2,10});//20
        pairwiseProblem.solve(new int[] {100_000,100_000});//10_000_000_000
        pairwiseProblem.solve(new int[] {0,100_000});//0
    }
}
