import java.util.Date;

/**
 * 
 */

/**
 * @author Shaurya
 *
 */
public class Candle {
	private Date time;
	private double open;
	private double high;
	private double low;
	private double close;
	private double volume;

	public Candle(Date time, double open, double high, double low, double close, double volume) {
		this.time = time;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

}
