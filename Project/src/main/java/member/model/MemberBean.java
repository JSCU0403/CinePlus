package member.model;

public class MemberBean {
	private String member_code;
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_birth;
	private String member_phone;
	private String member_email;
	private String pw_question;
	private String pw_answer;
	private String member_marketing_agree;
	private String member_email_agree;
	private String member_sms_agree;
	private String member_start;
	
	
	public MemberBean() {

	}
	
	public MemberBean(String member_code, String member_id, String member_pw, String member_name, String member_birth,
			String member_phone, String member_email, String pw_question, String pw_answer,
			String member_marketing_agree, String member_email_agree, String member_sms_agree, String member_start) {
		super();
		this.member_code = member_code;
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_birth = member_birth;
		this.member_phone = member_phone;
		this.member_email = member_email;
		this.pw_question = pw_question;
		this.pw_answer = pw_answer;
		this.member_marketing_agree = member_marketing_agree;
		this.member_email_agree = member_email_agree;
		this.member_sms_agree = member_sms_agree;
		this.member_start = member_start;
	}
	
	public String getMember_code() {
		return member_code;
	}
	public void setMember_code(String member_code) {
		this.member_code = member_code;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_birth() {
		return member_birth;
	}
	public void setMember_birth(String member_birth) {
		this.member_birth = member_birth;
	}
	public String getMember_phone() {
		return member_phone;
	}
	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getPw_question() {
		return pw_question;
	}
	public void setPw_question(String pw_question) {
		this.pw_question = pw_question;
	}
	public String getPw_answer() {
		return pw_answer;
	}
	public void setPw_answer(String pw_answer) {
		this.pw_answer = pw_answer;
	}
	public String getMember_marketing_agree() {
		return member_marketing_agree;
	}
	public void setMember_marketing_agree(String member_marketing_agree) {
		this.member_marketing_agree = member_marketing_agree;
	}
	public String getMember_email_agree() {
		return member_email_agree;
	}
	public void setMember_email_agree(String member_email_agree) {
		this.member_email_agree = member_email_agree;
	}
	public String getMember_sms_agree() {
		return member_sms_agree;
	}
	public void setMember_sms_agree(String member_sms_agree) {
		this.member_sms_agree = member_sms_agree;
	}
	public String getMember_start() {
		return member_start;
	}
	public void setMember_start(String member_start) {
		this.member_start = member_start;
	}
	
	
	
}