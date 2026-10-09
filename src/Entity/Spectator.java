package Entity;

/**
 * Đại diện cho khán giả trong hệ thống ARENA.
 *
 * 
 * Spectator có thể nhận thông báo về các giải đấu mà họ quan tâm.
 * 
 */
public class Spectator {

	private String name;

	private String email;

	/**
	 * Khởi tạo một Spectator.
	 *
	 * @param name  tên khán giả
	 * @param email email của khán giả
	 */

	public Spectator(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	/**
	 * Trả về thông tin Spectator.
	 *
	 * @return thông tin Spectator
	 */

	@Override
	public String toString() {
		return name + " - " + email;
	}
}
