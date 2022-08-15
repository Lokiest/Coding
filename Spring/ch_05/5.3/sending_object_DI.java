//메일 전송 기능을 가진 오브젝트를 DI 받도록 수정
public class UserService {
	public static final int MIN_LOGCOUNT_FOR_SILVER = 50;
	public static final int MIN_RECCOMEND_FOR_GOLD = 30;

	private UserDao userDao;
	private MailSender mailSender;
	private PlatformTransactionManager transactionManager;

    public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

    private void sendUpgradeEMail(User user) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setTo(user.getEmail());
        mailMessage.setFrom("useradmin@ksug.org");
        mailMessage.setSubject("Upgrade 안내");
        mailMessage.setText("사용자님의 등급이 " + user.getLevel().name() + "로 업그레이드 되었습니다.");
		
	    this.mailSender.send(mailMessage);
}
