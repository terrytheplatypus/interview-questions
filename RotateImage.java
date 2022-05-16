public void rotate(int[][] matrix) {
        //oh god i spent way too much time on this one
        /*
        n*n square
        except for odd 1-square center,
        the pattern is x,y -> n-x
        
        examples for length 5 array, 1,1 goes to 3,1 (U-> R)
        2,1 goes to 3,2 (U->R) 
        3,2 goes to 2,3(R-> D)
        1,3 goes to 1,1 (D-> L)
        1,2 goes to 2, 1 (L-> U)
        this is 3x3 subarray so formula is
        
        (i is subarray position by depth)
        U->R x,y-> n-i-1, x
        R->D x,y -> n-i-x+1(?),x (reverse x)
        D -> L x,y ->
        
        for even, there are n/2 rotateable layers
        for odd, there are floor(n/2) rotateable (not counting 1x1 center)
        you can swap only when you're doing each corresponding cell at once
        L -> U (save U), U-> R (save R), R -> D (save D), D -> L
        
        */
        
        int n = matrix.length;
        //for(int i=0;i < n; i++) {
       //     for (int j = 0; j < n; j++) {
        //        matrix[i][j] = 0;
       //     }
       // }
        
        int bound1 = n/2 ;
        System.out.println("bound1 is " + bound1);
        for(int i = 0; i < n/2 ; i++) {
            System.out.println ("i is "+ i);
            for(int j=0; j < n- i*2-1; j++) {
                   //int tmp1 = matrix[j+i][k +i];
                
                   // up [j+i][i]
                   // right   [n-i-1][j+1]
                   // down  [n-j-1][n-i -1]
                   // left [n-i-1][n-j-i-1]
                   
                    //for 3x3, 0,0-> 2,0 ->2,2->0,2
                
                    int up = matrix[i][j+i];
                    int right = matrix[j+i][n-i-1];
                    int down = matrix[n-i -1][n-j -i-1];
                    int left = matrix[n-j-i-1][i];
                    
                
                    System.out.println("n is " + n + " i is " + i + " j is " + j);
                   System.out.println("before:up is " + up + 
                                      " right is " + right +
                                     " down is " + down +
                                     " left is " + left );
                
                   //u->r
                   int tmp1 = matrix[j+i][n-i-1];
                   matrix[j+i][n-i-1] = matrix[i][j+i];
                   //r->d
                   
                   int tmp2 = matrix[n-i -1][n-j -i -1];
                   matrix[n-i -1][n-j -i-1] = tmp1;
                   //d->l
                   tmp1 = matrix[n-j-i-1][i];
                    matrix[n-j-i-1][i] = tmp2;
                   //l->u
                   matrix[i][j+i] = tmp1;
                
                up = matrix[i][j+i];
                    right = matrix[j+i][n-i-1];
                    down = matrix[n-i -1][n-j-1];
                    left = matrix[n-j-i-1][i];
                
                System.out.println("after:up is " + up + 
                                      " right is " + right +
                                     " down is " + down +
                                     " left is " + left );
                   
            }
        }
    }
