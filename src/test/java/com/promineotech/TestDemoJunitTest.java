package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJunitTest {
	
	  private TestDemo testDemo;
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {

		if(!expectException) {
			  assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}	
	}
	static Stream<Arguments> argumentsForAddPositive(){
		return Stream.of(
                Arguments.of(6, 3, 3, false),
                Arguments.of(1, 7, 2, false),
                Arguments.of(1, 3, 1, true),
                Arguments.of(0, -2, 3, true),
                Arguments.of(-1, -1, -4, true));
		
	}
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
	    assertThat(testDemo.addPositive(3, 5)).isEqualTo(8);
	    assertThat(testDemo.addPositive(20, 30)).isEqualTo(50);
	    assertThat(testDemo.addPositive(50, 30)).isEqualTo(80);
	    assertThat(testDemo.addPositive(80, 75)).isEqualTo(85);
	    assertThat(testDemo.addPositive(90, 10)).isEqualTo(100);
	    
	}
	 void assertThatFactorialIsCorrect(int n, int expected) {
	        assertThat(testDemo.calculateFactorial(n)).isEqualTo(expected);
	    }

	    static Stream<Arguments> argumentsForCalculateFactorial() {
	        return Stream.of(
	            Arguments.of(0, 1),  // 0! = 1
	            Arguments.of(1, 1),  // 1! = 1
	            Arguments.of(2, 2),  // 2! = 2
	            Arguments.of(5, 120), // 5! = 120
	            Arguments.of(10, 3628800)
	            );
	    }// 10! = 3628800
	        
	        @BeforeEach
	        void setUp() throws Exception {
	            testDemo = new TestDemo();
	        }

	        @Test
	        void assertThatNumberSquaredIsCorrect() {
	        
	            TestDemo mockDemo = spy(testDemo);
	            doReturn(5).when(mockDemo).getRandomInt();
	            int fiveSquared = mockDemo.randomNumberSquared();
	            assertThat(fiveSquared).isEqualTo(25);
	    }
	

}
