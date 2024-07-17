class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> spiral = new ArrayList<>();
      int i,  cols, row_start, row_end, col_start, col_end;
      row_start = 0;
      row_end = matrix.length - 1;
      col_start = 0;
      col_end = matrix[0].length - 1;
      cols = matrix[0].length ;
   
     
      while (cols> 0) {
          for (i = col_start; i <= col_end; i++) {
              if(row_start<=row_end){
              spiral.add(matrix[row_start][i]);}
          }
          row_start = row_start + 1;
          for (i = row_start; i <= row_end; i++) {
              if(col_start<=col_end){
              spiral.add(matrix[i][col_end]);}
          }
          col_end = col_end - 1;
          for (i = col_end; i >= col_start; i--) {
              if(row_start<=row_end){
              spiral.add(matrix[row_end][i]);}
          }
          row_end = row_end - 1;
          for (i = row_end; i >= row_start; i--) {
              if(col_start<=col_end){
              spiral.add(matrix[i][col_start]);}
          }
          col_start = col_start + 1;
          cols = cols - 2;
          
      }
      return spiral;
  }
}