//라인별 작업을 정의한 콜백 인터페이스
package springbook.learningtest.template;

public interface LineCallback {
	Integer doSomethingWithLine(String line, Integer value);
}
