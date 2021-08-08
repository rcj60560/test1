package qqservice.test;

import qqservice.Car;
import qqservice.qqservice.QQServer;

import java.lang.reflect.Field;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
//        new QQServer();
//        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);

//        SynchronousQueue<Runnable> queue = new SynchronousQueue<Runnable>();
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue);
//        executor.execute(() -> {
//            System.out.println("任务1 :" + Thread.currentThread().getName() + ",quene :" + queue.size());
//            while (true) {
//            }
//        });
//        executor.execute(() -> {
//            System.out.println("任务2 :" + Thread.currentThread().getName() + ",quene :" + queue.size());
//        });
//        executor.execute(() -> {
//            System.out.println("任务3 :" + Thread.currentThread().getName() + ",quene :" + queue.size());
//        });
//        executor.execute(() -> {
//            System.out.println("任务4 :" + Thread.currentThread().getName() + ",quene :" + queue.size());
//        });
//        executor.execute(() -> {
//            System.out.println("任务5 :" + Thread.currentThread().getName() + ",quene :" + queue.size());
//        });

//        Car car = new Car();
//        System.out.println(car.getClass());

        Class<?> clz = Class.forName("qqservice.Car");
        Car car = (Car) clz.newInstance();

        Field name = clz.getField("name");
        name.set(car, "思域");

        System.out.println(car.getName());
    }
}
