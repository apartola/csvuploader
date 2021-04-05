package com.partola.csvuploader;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.TestScheduler;

import java.util.concurrent.TimeUnit;

public class DebounceTest {
	
	public static void main(String[] args) {
		final TestScheduler scheduler = new TestScheduler();
		final Observable<Long> longObservable = Observable.intervalRange(0, 20, 0,
				400, TimeUnit.MILLISECONDS, scheduler);
		
		final int timeout = 1000;
		Observable.merge(
				longObservable.throttleFirst(timeout, TimeUnit.MILLISECONDS, scheduler),
				longObservable.debounce(timeout, TimeUnit.MILLISECONDS, scheduler))
				.distinctUntilChanged()
				.subscribe(event -> System.out.println("Merge: " + event));
		
		longObservable
				.debounce(timeout, TimeUnit.MILLISECONDS, scheduler)
				.subscribe(event -> System.out.println("Debounce: " + event));
		
		longObservable
				.throttleFirst(timeout, TimeUnit.MILLISECONDS, scheduler)
				.subscribe(event -> System.out.println("throttleFirst: " + event));
		
		longObservable
				.throttleLast(timeout, TimeUnit.MILLISECONDS, scheduler)
				.subscribe(event -> System.out.println("throttleLast: " + event));
		
		longObservable
				.throttleLatest(timeout, TimeUnit.MILLISECONDS, scheduler)
				.subscribe(event -> System.out.println("throttleLatest: " + event));
		
		longObservable
				.throttleLatest(timeout, TimeUnit.MILLISECONDS, scheduler, true)
				.subscribe(event -> System.out.println("throttleLatest, emit last: " + event));
		
		longObservable
				.throttleWithTimeout(timeout, TimeUnit.MILLISECONDS, scheduler)
				.subscribe(event -> System.out.println("throttleWithTimeout: " + event));
		
		scheduler.advanceTimeBy(40, TimeUnit.SECONDS);
	}
	
}
