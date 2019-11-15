package com.cbnu.sjy_;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Test
    public void test() throws Exception {

        /*
         * U : 파라미터1, T : 파라미터2, R : 리턴타입
         *
         * since Java1
         * 0. Runnable : 입력 X, 출력 X
         *
         * since Java5
         * 1. Callable<R> : 입력 X, 출력 1개 : throws Exception
         *
         * since Java8
         * 2. Consumer<U> : 입력 1개 , 출력 X (= void)
         * 3. BiConsumer<U,T> : 입력 2개, 출력 X (= void)
         * 4. Function<U,R> : 입력 1개, 출력 1개
         * 5. BiFunction<U,T,R> : 입력 2개, 출력 1개
         * 6. Predicate<U> : 입력 1개, 출력 boolean 타입 1개
         * 7. BiPredicate<U> : 입력 2개, 출력 boolean 타입 1개
         * 8. Supplier<R> : 입력 X, 출력 1개
         * */
    }
}