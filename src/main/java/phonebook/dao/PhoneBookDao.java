package phonebook.dao;

import java.util.List;
import phonebook.vo.PhoneBookVo;

public interface PhoneBookDao {
		public List<PhoneBookVo> getList();
		public int insert(PhoneBookVo vo);
		public int delete(Long pk);
		
}
