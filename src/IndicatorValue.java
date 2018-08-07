import java.util.Date;

/**
 * 
 */

/**
 * @author Shaurya
 *
 */
public class IndicatorValue {
	private Date date;
	private double indicatorValue;
	private IndicatorType type;

	public IndicatorValue(Date date, double iv, IndicatorType type){
		this.date = date;
		this.indicatorValue = iv;
		this.type = type;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getIndicatorValue() {
		return indicatorValue;
	}

	public void setIndicatorValue(double indicatorValue) {
		this.indicatorValue = indicatorValue;
	}

	public IndicatorType getType() {
		return type;
	}

	public void setType(IndicatorType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "IndicatorValue [date=" + date + ", indicatorValue=" + indicatorValue + ", type=" + type + "]";
	}
	
	

}
