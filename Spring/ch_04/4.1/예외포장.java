//예외 포장
try {
    OrderHome orderHome = EJBHomeFactory.getInstance().getOrderHome();
    Order order = orderHome.findByPrimaryKey(Integer id);
} catch (NamingException ne) {
    throw new EJBException(ne);
} catch (SQLException e) {
    throw new EJBException(e);
} catch (RemoteException re) {
    throw new EJBException(re);
}
