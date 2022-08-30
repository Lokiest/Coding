//reflection 학습 테스트
package springbook.learning.jdk;
...
public class Reflection Test {
    @Test
    public void invokeMethod() throws Exception {
        String name = "Spring";

        assertThat(name.lenght(), is(6));

        Method lengthMethod = String.class.getMethod("length");
        assertThat((Integer)lengthMethod.invoke(name), is(6));

        assertThat(name.charAt(0), is('S'));

        Method charAtMethod = String.class.getMethod("charAt", int.class);
        assertThat((Character)charAtMethod.invoke(name, 0), is('S'));
    }
}
