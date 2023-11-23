package com.gluhov.proselyte.module14;


import java.util.concurrent.Semaphore;

/*
Дан класс:
public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}

Один и тот же экземпляр данного класса будет вызван 3мя разными потоками. Поток А - будет вызывать метод first(). Поток B - second(). Поток С - third().
Необходимо реализовать механизм и изменить программу таким образом, что методы класса Semaphore будут вызваны в правильном порядке.

Пример:
Вывод: "firstsecondthird"
Мы не знаем, в каком порядке будут вызваны методы, но должны гарантировать порядок.
*/
public class UsingSemaphore {
    public static void main(String[] args) {
        Foo foo = new Foo();
        new ThreadA(foo);
        new ThreadB(foo);
        new ThreadC(foo);
    }
}

class ThreadA implements Runnable {
    Foo foo;

    public ThreadA(Foo foo) {
        this.foo = foo;
        new Thread(this).start();
    }

    @Override
    public void run() {
        foo.first();
    }
}

class ThreadB implements Runnable {
    Foo foo;

    public ThreadB(Foo foo) {
        this.foo = foo;
        new Thread(this).start();
    }

    @Override
    public void run() {
        foo.second();
    }
}

class ThreadC implements Runnable {
    Foo foo;

    public ThreadC(Foo foo) {
        this.foo = foo;
        new Thread(this).start();
    }

    @Override
    public void run() {
        foo.third();
    }
}


class Foo {
    static Semaphore firstSemaphore = new Semaphore(1);
    static Semaphore secondSemaphore = new Semaphore(0);
    static Semaphore thirdSemaphore = new Semaphore(0);

    public void first() {
        try {
            firstSemaphore.acquire();
        } catch ( InterruptedException е ) {
            System.out.println("Перехвачено исключение типа InterruptedException");
        }
        System.out.print("first");
        secondSemaphore.release();
    }
    public void second() {
        try {
            secondSemaphore.acquire();
        } catch ( InterruptedException е ) {
            System.out.println("Перехвачено исключение типа InterruptedException");
        }
        System.out.print("second");
        thirdSemaphore.release();
    }
    public void third() {
        try {
            thirdSemaphore.acquire();
        } catch ( InterruptedException е ) {
            System.out.println("Перехвачено исключение типа InterruptedException");
        }
        System.out.print("third"); }
}
