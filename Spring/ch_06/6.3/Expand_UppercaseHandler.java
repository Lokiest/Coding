//확장된 UppercaseHandler
public class UppercaseHandler implements InvocationHandler {
    Object target;
    private UppercaseHandler(Object target) {
        this.target = target;
    } //어떤 종류의 인터페이스를 구현한 타겟에도 적용 가능하도록 Object 타입으로

    public Object invoke(Object proxy, Method method, Object[] args) throws Thorwable {
        Object ret = method.invoke(target, args);
        if (ret instanceof String) { return ((String)ret).toUpperCase()); }
        else { return ret; }
    }

}
