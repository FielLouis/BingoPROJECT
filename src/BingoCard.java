import java.util.ArrayList;
public class BingoCard {
    int[][] nums;
    int id;

    public BingoCard(int id) {
        this.id = id;
        // TODO randomize the nums
        // Col 1: 1-15
        // Col 2: 16-30
        // Col 3: 31-45 (middle is 0)
        // Col 4: 46-60
        // Col 5: 61-75
        nums = new int[5][5];
        ArrayList<Integer> existingNumber = new ArrayList<Integer>();

        int temp = 0;
        boolean alreadyUsed = false;

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(i == 2 && j == 2) {
                    nums[i][j] = 0;
                    continue;
                }

                while(!alreadyUsed){
                    temp = (int) (Math.random() * 15) + 1 + 15 * j;
                    if(!existingNumber.contains(temp)) {
                        alreadyUsed = true;
                        existingNumber.add(temp);
                    }
                }
                nums[i][j] = temp;
                alreadyUsed = false;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                sb.append(nums[row][col]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
