public class Main {

    public static void main(String[] args) {
        BreadthFirstSearch bfs = new BreadthFirstSearch();

        System.out.println("----------Test 1----------");
        bfs.minimum_steps(8, 8, 4, 4, 4, 5);
        System.out.println("Expected: 3 steps" + "\n");
        //output: 3 - PASSES

        System.out.println("----------Test 2----------");
        bfs.minimum_steps(8, 8, 0, 0, 7, 7);
        System.out.println("Expected: 6 steps" + "\n");
        //output: 6 - PASSES

        System.out.println("----------Test 3----------");
        bfs.minimum_steps(8, 8, 0, 0, 0, 7);
        System.out.println("Expected: 5 steps" + "\n");
        //output: 5 - PASSES

        System.out.println("----------Test 4----------");
         bfs.minimum_steps(20, 10, 0, 4, 9, 15);
        System.out.println("Expected: 8 steps" + "\n");
        //output: 8 - PASSES

        System.out.println("----------Test 5----------");
        bfs.minimum_steps(100, 10, 4, 4, 9, 99);
        System.out.println("Expected: 48 steps" + "\n");
        //output: 48 - FAILS!!!!!

        System.out.println("----------Test 6----------");
        bfs.minimum_steps(8, 8, 4, 4, 4, 4);
        System.out.println("Expected: 0 steps" + "\n");
        //output: 0 - PASSES

        System.out.println("----------Test 7----------");
        bfs.minimum_steps(100, 100, 50, 50, 57, 57);
        System.out.println("Expected: 6 steps" + "\n");
        //output: 6 - PASSES

//        System.out.println("----------Testing the limits----------");
//        bfs.minimum_steps(3500, 3500, 1, 1, 3499, 3499);

    }
}
