public class MineSweeper {

    public static int check(boolean[][] field, int i, int j){
        int mines = 0;
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        if(i-1 < 0){
            up = 0;
        }
        else{
            up = i - 1;
        }

        if(i+1 > field.length - 1){
            down = field.length - 1;
        }
        else{
            down = i+1;
        }

        if(j-1 < 0){
            left = 0;
        }
        else{
            left = j - 1;
        }

        if(j+1 > field[i].length - 1){
            right = field[i].length - 1;
        }
        else{
            right = j+1;
        }

        for(int r = up; r <= down; r++){
            for(int c = left; c <= right; c++){
                if(field[r][c] && (!(r == i && c == j))){
                    mines++;
                }
            }
        }
        return mines;
    }

    public static int[][] mineSweeper(boolean[][] field){
        int[][] result = new int[field.length][field[0].length];

        for(int i = 0; i < field.length; i++){
            for(int j = 0; j < field[i].length; j++){
                result[i][j] = check(field, i, j);
            }
        }

        return result;
    }

    public static void main(String[] args){
        boolean[][] field = new boolean[][]{{true, false, false}, {false, true, false}, {false, false, false}};
        int[][] result = mineSweeper(field);
        for(int i = 0; i < result.length; i++){
            System.out.print("[ ");
            for(int j = 0; j < result[0].length; j++){
                System.out.print(result[i][j] + ", ");
            }
            System.out.print("]");
            System.out.println();
        }
        System.out.println(result);
    }
}
