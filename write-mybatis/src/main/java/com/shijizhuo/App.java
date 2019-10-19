package com.shijizhuo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ReentrantLock reentrantLock = new ReentrantLock(false);
        System.out.println( "Hello World!" );
    }
}
