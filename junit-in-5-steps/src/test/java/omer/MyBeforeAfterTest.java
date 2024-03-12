package omer;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class MyBeforeAfterTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("beforeAll");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("BeforeEach");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void tes2(){
        System.out.println("test2");
    }

    @Test
    public void tes3(){
        System.out.println("test3");
    }

    @AfterEach
    void afterEach(){
        System.out.println("AfterEach");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("afterAll");
    }
}
