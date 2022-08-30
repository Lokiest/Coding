//메소드 선별해서 부가기능 적용하는 invoke()
public Object invoke(Object proxy, Method method, Object[] args) throws Thorwable {
    Object ret = method.invoke(target, args);
    if (ret instanceof String && method.getName().startswith("say"))
        { return ((String)ret).toUpperCase()); }
    else { return ret; }
}
