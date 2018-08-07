import java.util.Date;
import java.util.Map;

/**
 * 
 */

/**
 * @author Shaurya
 *
 */
public class MACD {
	private Map<Date, IndicatorValue> macdMap;
	private Map<Date, IndicatorValue> signalMap;

	public MACD(Map<Date, IndicatorValue> macdMap, Map<Date, IndicatorValue> signalMap) {
		super();
		this.macdMap = macdMap;
		this.signalMap = signalMap;
	}

	public Map<Date, IndicatorValue> getMacdMap() {
		return macdMap;
	}

	public void setMacdMap(Map<Date, IndicatorValue> macdMap) {
		this.macdMap = macdMap;
	}

	public Map<Date, IndicatorValue> getSignalMap() {
		return signalMap;
	}

	public void setSignalMap(Map<Date, IndicatorValue> signalMap) {
		this.signalMap = signalMap;
	}

}
