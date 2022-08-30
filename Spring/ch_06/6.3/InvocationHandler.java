//InvocationHandler
public class UppercaseHandler implements InvocationHandler {
    Hello target;

    public UppercaseHandler(Hello target) {
        this.target = target;
    }.  //타겟 오브젝트 주입받아두기

    public Object invoke(Object proxy, Method method, Object[] args) throws Thorwable {
        String ret = (String)method.invoke(target, args); //타겟으로 위임 + 인터페이스 메소드 호출
        return ret.toUppderCase(); //부가기능
    }

}
