package TestNGPratice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CRUDOperation {
	
	private final AtomicInteger idGenerator = new AtomicInteger(100);
	
	private final Map<Integer, String> users = new ConcurrentHashMap<Integer, String>();
	
	public int addUser() {
		int uid = idGenerator.incrementAndGet();
		users.put(uid, "user "+uid);
		return uid;
	}
	
	public String getUser(int uid) {
		return users.get(uid);
	}
	
	public String updateUser(int uid) {
		if(!users.containsKey(uid)) {
			  throw new IllegalArgumentException("User does not exist: " + uid
	            );
		}
		String updateInfo = "updated user " +uid;
		users.put(uid, updateInfo);
		return updateInfo;
	}
	
	public void deleteUser(int uid) {
		if(users.remove(uid)==null) {
			  throw new IllegalArgumentException("User does not exist: " + uid
	            );
		}
	}
	
	
	@Test
	public void addUserTest() {
		int uid = addUser();
		Assert.assertNotNull(getUser(uid), "Created user should exist");
	}
	
	@Test
	public void getUserTest() {
		int uid = addUser();
		String userInfo = getUser(uid);
		Assert.assertEquals(userInfo, "user " +uid);
	}
	
	@Test
	public void updateUserTest() {
		int uid = addUser();
		String result = updateUser(uid);
		Assert.assertEquals(result,  "updated user " +uid);	
		Assert.assertEquals(getUser(uid), "updated user "+uid);
	}
	
	@Test
	public void deleteUserTest() {
		int uid = addUser();
		deleteUser(uid);
		
		Assert.assertNull(getUser(uid), "Deleted user should not exist");
	}

}
