public class Solution {
    public int RectCover(int target) {
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        int first = 1;
        int second = 2;
        int result = 0;
        for(int i = 3; i <= target; i++){
            result = first + second;
            first = second;
            second= result;
        }
        return result;

    }
}