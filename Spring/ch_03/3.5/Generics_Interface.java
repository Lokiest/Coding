//제네릭스 적용한 인터페이스
package springbook.learningtest.template;

public interface LineCallback<T> {
	T doSomethingWithLine(String line, T value);
}
