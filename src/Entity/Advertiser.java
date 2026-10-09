package Entity;

/**
 * Đại diện cho nhà quảng cáo trong hệ thống ARENA.
 * Advertiser có thể quan tâm và tham gia tài trợ độc quyền cho các giải đấu.
 */

public class Advertiser {

	private String name;

	private String email;

	private double balance;

	private boolean interestedInExclusiveSponsorship;

	/**
	 * Khởi tạo Advertiser.
	 *
	 * @param name                             tên nhà quảng cáo
	 * @param email                            email nhà quảng cáo
	 * @param balance                          số dư tài khoản
	 * @param interestedInExclusiveSponsorship trạng thái quan tâm tài trợ
	 */
	public Advertiser(String name, String email, double balance, boolean interestedInExclusiveSponsorship) {

		this.name = name;
		this.email = email;
		this.balance = balance;
		this.interestedInExclusiveSponsorship = interestedInExclusiveSponsorship;
	}

	/**
	 * Lấy tên nhà quảng cáo.
	 *
	 * @return tên nhà quảng cáo
	 */
	public String getName() {
		return name;
	}

	/**
	 * Lấy email nhà quảng cáo.
	 *
	 * @return email nhà quảng cáo
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Lấy số dư tài khoản.
	 *
	 * @return số dư
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Kiểm tra Advertiser có quan tâm tài trợ độc quyền hay không.
	 *
	 * @return true nếu quan tâm
	 */
	public boolean isInterestedInExclusiveSponsorship() {
		return interestedInExclusiveSponsorship;
	}

	/**
	 * Trừ tiền từ tài khoản Advertiser.
	 *
	 * @param amount số tiền cần thanh toán
	 * @return true nếu thanh toán thành công
	 */
	public boolean charge(double amount) {

		if (amount <= 0 || balance < amount) {
			return false;
		}

		balance -= amount;
		return true;
	}

	/**
	 * Trả về thông tin Advertiser.
	 *
	 * @return thông tin Advertiser
	 */
	@Override
	public String toString() {
		return name + " - " + email + " - Balance: " + balance;
	}
}
