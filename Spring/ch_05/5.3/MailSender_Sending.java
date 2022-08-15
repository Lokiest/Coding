//스프링의 MailSender을 이용한 메일 발송 메소드

private void sendUpgradeEMail(User user) {
	JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("mail.server.com");

    SimpleMailMessage mailMessage = new SimpleMailMessage();
	mailMessage.setTo(user.getEmail());
    mailMessage.setFrom("useradmin@ksug.org");
    mailMessage.setSubject("Upgrade 안내");
    mailMessage.setText("사용자님의 등급이 " + user.getLevel().name() + "로 업그레이드 되었습니다.");
		
	mailSender.send(mailMessage);
}
