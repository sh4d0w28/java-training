package day6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// FJP - executor service
//
// RecursiveTask - return value
// RecursiveAction - not
// when want execute, use :
// ... invoke (return int, block current thread, guarantee execution ASAP) or
// ... submit (not guarantee execution now)

// do not forget shut it down

class MyAction extends RecursiveAction {

    @Override
    protected void compute() {
        System.out.println("MyAction::compute");
    }
}

class MyTask extends RecursiveTask<Integer> {

    @Override
    protected Integer compute() {
        System.out.println("MyTask::compute with return -1");
        return -1;
    }
}

public class Day6Parallels {

    public static void main(String[] args) {

        ForkJoinPool fjp = ForkJoinPool.commonPool(); // common pool of threads that available for all app (Executor service)
        //ForkJoinPool fjp = new ForkJoinPool(2); // using 2 cores

        fjp.invoke(new MyAction()); // execute ASAP, blocks
        fjp.invoke(new MyTask()); // execute ASAP, blocks

        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(()->{ System.out.println("Task 1 running"); return 1; });
        tasks.add(()->{ System.out.println("Task 2 running"); return 2; });
        tasks.add(()->{ System.out.println("Task 3 running"); return 3; });
        tasks.add(()->{ System.out.println("Task 4 running"); return 4; });

        int sum = 0;
        List<Future<Integer>> futureSums = fjp.invokeAll(tasks);
        fjp.shutdown();

        try {
            for (Future<Integer> futureSum : futureSums) {
                sum += futureSum.get();
            }
        } catch (InterruptedException | ExecutionException ex ) {
            ex.printStackTrace();
        }
        System.out.println("The sum is " + sum);

        System.out.format("%d cores executing\n", fjp.getParallelism()); // amount of cores can be used

    }
}
