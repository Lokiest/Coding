//BufferedReader를 전달받는 콜백 인터페이스
package springbook.learningtest.template;

public interface BufferedReaderCallback {
	Integer doSomethingWithReader(BufferedReader br) throws IOException;
}
