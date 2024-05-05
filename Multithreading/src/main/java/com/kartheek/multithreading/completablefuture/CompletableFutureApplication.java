package com.kartheek.multithreading.completablefuture;

import com.kartheek.multithreading.completablefuture.parallel.SupplyAsyncRunParallelExample;
import com.kartheek.multithreading.completablefuture.run.RunAsyncExample;
import com.kartheek.multithreading.completablefuture.callback.SupplyAsyncAcceptExample;
import com.kartheek.multithreading.completablefuture.callback.SupplyAsyncApplyExample;
import com.kartheek.multithreading.completablefuture.supply.SupplyAsyncExample;

public class CompletableFutureApplication {

    public static void main(String[] args) {

        RunAsyncExample runAsync = new RunAsyncExample();
        // runAsync.runAsyncDefault();
       // runAsync.runAsyncOwnThreadPool();

        SupplyAsyncExample supplyAsync = new SupplyAsyncExample();
     //   supplyAsync.supplyAsyncGet();

        SupplyAsyncApplyExample supplyAsyncApply = new SupplyAsyncApplyExample();
       // supplyAsyncApply.supplyAsyncThenApplyAsync();
      //  supplyAsyncApply.supplyAsyncThenApply();

        SupplyAsyncAcceptExample supplyAsyncAccept = new SupplyAsyncAcceptExample();
      //  supplyAsyncAccept.supplyAsyncThenAccept();

        SupplyAsyncRunParallelExample  parallel = new SupplyAsyncRunParallelExample();
        parallel.supplyAsyncParallel();


    }
}
