package LC_Questions.CollectionAll.BinarySearch.LC75.SuccessfulPairsofSpellsandPotions_2300_review;



public class bruteForce {
    public static void main(String[] args) {
        int [] spells = {3,1,2};
        int [] potions = {8,5,8};
        int success = 16;
        bruteForce solution = new bruteForce();
        int [] spell = solution.successfulPairs(spells, potions,success);
        for (int i = 0; i < spells.length; i++) {
            System.out.print(spell[i] + " ");
        }
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int [] remain = new int [spells.length];
        int index = 0;
        for (int i = 0; i < spells.length; i++) {
            for (int j = 0; j < potions.length; j++) {
                if ((long)spells[i] * potions[j] >= success) {
                    remain[index]++;
                }
            }
            index++;
        }
        return remain;
    }
}
