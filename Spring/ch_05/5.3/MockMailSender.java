//목 오브젝트로 만든 메일 전송 확인용 클래스
static class MockMailSender implements MailSender {
	private List<String> requests = new ArrayList<String>();	
		
	public List<String> getRequests() {
		return requests;
	} //메일 주소를 저장해두고 읽을 수 있게

	public void send(SimpleMailMessage mailMessage) throws MailException {
		requests.add(mailMessage.getTo()[0]);  
	} //이메일 주소를 저장

	public void send(SimpleMailMessage[] mailMessage) throws MailException {
	}
}
