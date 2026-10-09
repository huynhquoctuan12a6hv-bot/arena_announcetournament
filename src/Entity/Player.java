package Entity;
/**
 * Đại diện cho người chơi trong hệ thống ARENA.
 *
 * 
 * Player có thể nhận thông báo về giải đấu
 * và đăng ký tham gia giải đấu.
 * 
 */

public class Player {
	private String name;
	private String email;
	
    /**
     * Khởi tạo một Player.
     *
     * @param name tên người chơi
     * @param email email của người chơi
     */

	public Player(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	  /**
     * Trả về thông tin Player.
     *
     * @return thông tin Player
     */

	@Override
	public String toString() {
		return "Player{" + "name='" + name + '\'' + ", email='" + email + '\'' + '}';
	}
}
