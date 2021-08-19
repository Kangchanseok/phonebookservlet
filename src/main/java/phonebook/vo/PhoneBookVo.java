package phonebook.vo;


public class PhoneBookVo {
		private Long no;
		private String Name;
		private String PhoneNum;
		private String Tel;
		
		
		public PhoneBookVo() {
			
		}
		public PhoneBookVo(String name,String phonenum,String tel) {
			name = name;
			phonenum = phonenum;
			tel=tel;
			
		}
		public Long getNo() {
			return no;
		}
		public void setNo(Long no) {
			this.no = no;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			this.Name = name;
		}
		public String getPhoneNum() {
			return PhoneNum;
		}
		public void setPhoneNum(String phonenum) {
			this.PhoneNum = phonenum;
		}
		public String getTel() {
			return Tel;
		}
		public void setTel(String tel) {
			this.Tel = tel;
		}
		@Override
		public String toString() {
			return "PhoneBookVo [no=" + no + ", Name=" + Name + ", PhoneNum=" + PhoneNum + ", Tel=" + Tel + "]";
		}
		
		
}
