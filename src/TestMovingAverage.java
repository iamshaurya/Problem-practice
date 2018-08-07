import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.joda.time.DateTime;

/**
 * 
 */

/**
 * @author Shaurya
 *
 */
public class TestMovingAverage {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		List<Candle> cList = new ArrayList<>();
		cList.add(new Candle(getDate("2015-12-28T09:15:00+0530"), 48.0, 48.70, 47.79, 48.16, 788.00));
		cList.add(new Candle(getDate("2015-12-28T09:16:00+0530"), 48.72,48.72, 48.14, 48.61, 609));
		cList.add(new Candle(getDate("2015-12-28T09:17:00+0530"), 1385.5, 48.90, 48.39, 48.75, 212));
		cList.add(new Candle(getDate("2015-12-28T09:18:00+0530"), 1387, 48.87, 48.37, 48.63, 1208));
		cList.add(new Candle(getDate("2015-12-28T09:19:00+0530"), 1387, 48.82, 48.24, 48.74, 716));
		cList.add(new Candle(getDate("2015-12-28T09:20:00+0530"), 1386.95, 49.05, 48.64, 49.03, 727));
		cList.add(new Candle(getDate("2015-12-28T09:21:00+0530"), 1389, 1392.95, 1389, 44.6250, 291));
		cList.add(new Candle(getDate("2015-12-28T09:22:00+0530"), 1392.95, 1393, 1392, 45.75, 180));
		cList.add(new Candle(getDate("2015-12-28T09:23:00+0530"), 1392.95, 1393, 1392, 47.8125, 1869));
		cList.add(new Candle(getDate("2015-12-28T09:24:00+0530"), 1386.4, 1388, 1381.05, 47.5625, 788));
		cList.add(new Candle(getDate("2015-12-28T09:25:00+0530"), 1385.1, 1389.1, 1383.85, 47.0000, 613));
		cList.add(new Candle(getDate("2015-12-28T09:26:00+0530"), 1385.5, 1387, 1385.5, 44.5625, 212));
		cList.add(new Candle(getDate("2015-12-28T09:27:00+0530"), 1387, 1387.95, 1385.3, 46.3125, 1208));
		cList.add(new Candle(getDate("2015-12-28T09:28:00+0530"), 1387, 1387.55, 1385.6, 47.6875, 716));
		cList.add(new Candle(getDate("2015-12-28T09:29:00+0530"), 1386.95, 1389.95, 1386.95, 46.6875, 727));
		cList.add(new Candle(getDate("2015-12-28T09:30:00+0530"), 1389, 1392.95, 1389, 45.6875, 291));
		cList.add(new Candle(getDate("2015-12-28T09:31:00+0530"), 1392.95, 1393, 1392, 43.0625, 180));
		cList.add(new Candle(getDate("2015-12-28T09:32:00+0530"), 1392.95, 1393, 1392, 43.5625, 1869));
		cList.add(new Candle(getDate("2015-12-28T09:33:00+0530"), 1392.95, 1393, 1392, 44.8750, 1869));
		cList.add(new Candle(getDate("2015-12-28T09:34:00+0530"), 1392.95, 1393, 1392, 43.6875, 1869));
		cList.add(new Candle(getDate("2015-12-28T09:35:00+0530"), 1392.95, 1393, 1392, 44.00, 1869));
		cList.add(new Candle(getDate("2015-12-28T09:36:00+0530"), 1392.95, 1393, 1392, 44.6875, 1869));
		cList.add(new Candle(getDate("2015-12-28T09:37:00+0530"), 1392.95, 1393, 1392, 44.9875, 1869));
		cList.add(new Candle(getDate("2015-12-28T09:38:00+0530"), 1392.95, 1393, 1392, 45.120, 1869));
		cList.add(new Candle(getDate("2015-12-28T09:39:00+0530"), 1392.95, 1393, 1392, 44.888, 1869));
		cList.add(new Candle(getDate("2015-12-28T09:40:00+0530"), 1392.95, 1393, 1392, 46.001, 1869));
		cList.add(new Candle(getDate("2015-12-28T09:41:00+0530"), 1392.95, 1393, 1392, 46.9905, 1869));

		Map<Date, IndicatorValue> emaMap = calculateEMA(18, cList);
		Map<Date, IndicatorValue> rsiMap = calculateRSI(cList);
		MACD macdMap = calculateMACD(cList, 12, 26);
		Map<Date, IndicatorValue> atrMap = calculateATR(cList);
		int i = 0;
		for (Entry<Date, IndicatorValue> d : atrMap.entrySet()) {
			System.out.println("ATR :: count :: " + (++i) + " :: value :: " + d.getValue());
		}
//		int j = 0;
//		for (Entry<Date, IndicatorValue> d : macdMap.getSignalMap().entrySet()) {
//			System.out.println("MACD-SIGNAL :: count :: " + (++j) + " :: value :: " + d.getValue());
//		}
	}

	private static Map<Date, IndicatorValue> calculateATR(List<Candle> cList) {
		List<IndicatorValue> atrList = new ArrayList<>();
		if (cList.size() > 14) {
			double hlDiff = (double) cList.get(0).getHigh() - cList.get(0).getLow();
			double hcDiff = 0;
			double lcDiff = 0;
			double firstTR = hlDiff;
			for (int i = 1; i < 14; i++) {
				hlDiff = (double) cList.get(i).getHigh() - cList.get(i).getLow();
				hcDiff = (double) cList.get(i).getHigh() - cList.get(i).getClose();
				lcDiff = (double) cList.get(i).getClose() - cList.get(i).getLow();

				firstTR += Math.max(hlDiff, Math.max(hcDiff, lcDiff));
			}
			firstTR = (double) firstTR / 14;

			atrList.add(new IndicatorValue(cList.get(14).getTime(), firstTR, IndicatorType.ATR));

			populateATR(atrList, cList, 14);
		}
		return convertListToMap(atrList);
	}

	private static void populateATR(List<IndicatorValue> atrList, List<Candle> cList, int index) {
		if (index < cList.size()) {
			double hlDiff = (double) cList.get(index).getHigh() - cList.get(index).getLow();
			double hcDiff = (double) cList.get(index).getHigh() - cList.get(index).getClose();
			double lcDiff = (double) cList.get(index).getClose() - cList.get(index).getLow();

			double tr = Math.max(hlDiff, Math.max(hcDiff, lcDiff));

			tr = (double)(atrList.get(atrList.size() - 1).getIndicatorValue() * 13 + tr) / 14;
			
			atrList.add(new IndicatorValue(cList.get(index).getTime(), tr, IndicatorType.ATR));
			
			populateATR(atrList, cList, ++index);
		}
	}

	private static MACD calculateMACD(List<Candle> cList, int fastEMATimePeriod, int slowEMATimePeriod) {
		List<IndicatorValue> macdList = new ArrayList<>();
		Map<Date, IndicatorValue> fastEma = calculateEMA(fastEMATimePeriod, cList);
		Map<Date, IndicatorValue> slowEma = calculateEMA(slowEMATimePeriod, cList);
		for (Entry<Date, IndicatorValue> sEma : slowEma.entrySet()) {
			double macdValue = fastEma.get(sEma.getKey()).getIndicatorValue() - sEma.getValue().getIndicatorValue();
			macdList.add(new IndicatorValue(sEma.getKey(), macdValue, IndicatorType.MACD));
		}
		int signalPeriod = (int) (0.75 * fastEMATimePeriod);
		return new MACD(convertListToMap(macdList),
				calculateEMA(signalPeriod, convertIndiactorValueToCandle(macdList)));
	}

	private static List<Candle> convertIndiactorValueToCandle(List<IndicatorValue> ivlist) {
		List<Candle> cList = new ArrayList<>();
		for (IndicatorValue iv : ivlist) {
			cList.add(new Candle(iv.getDate(), 0, 0, 0, iv.getIndicatorValue(), 0));
		}
		return cList;
	}

	private static Map<Date, IndicatorValue> calculateEMA(int timePeriod, List<Candle> cList) {
		List<IndicatorValue> emaList = new ArrayList<>();
		if (timePeriod <= cList.size() && timePeriod > 0) {
			double initalSMA = 0;
			for (int i = 0; i < timePeriod; i++) {
				initalSMA += cList.get(i).getClose();
			}
			initalSMA = (double) initalSMA / timePeriod;

			double multiplier = (double) 2 / (timePeriod + 1);

			emaList.add(new IndicatorValue(cList.get(timePeriod - 1).getTime(), initalSMA, IndicatorType.EMA));

			populateEMAList(multiplier, emaList, cList, timePeriod, timePeriod);

		}

		return convertListToMap(emaList);
	}

	private static Map<Date, IndicatorValue> convertListToMap(List<IndicatorValue> list) {
		Map<Date, IndicatorValue> map = new LinkedHashMap<>();
		for (IndicatorValue iv : list) {
			map.put(iv.getDate(), iv);
		}
		return map;
	}

	private static void populateEMAList(double multiplier, List<IndicatorValue> emaList, List<Candle> cList,
			int timePeriod, int index) {
		if (index < cList.size()) {
			double ema = (cList.get(index).getClose() - emaList.get(emaList.size() - 1).getIndicatorValue())
					* multiplier + emaList.get(emaList.size() - 1).getIndicatorValue();
			emaList.add(new IndicatorValue(cList.get(index).getTime(), ema, IndicatorType.EMA));
			populateEMAList(multiplier, emaList, cList, timePeriod, ++index);
		}
	}

	private static Map<Date, IndicatorValue> calculateRSI(List<Candle> cList) {
		List<IndicatorValue> rsiList = new ArrayList<>();
		if (cList.size() > 14) {
			double avgGain = 0;
			double avgLoss = 0;
			for (int i = 1; i <= 14; i++) {
				if (cList.get(i - 1).getClose() < cList.get(i).getClose()) {
					avgGain += (cList.get(i).getClose() - cList.get(i - 1).getClose());
				} else {
					avgLoss += (cList.get(i - 1).getClose() - cList.get(i).getClose());
				}
			}
			avgGain = (double) avgGain / 14;
			avgLoss = (double) avgLoss / 14;

			double firstRSI = (double) 100 - (100 / (1 + (avgGain / avgLoss)));

			rsiList.add(new IndicatorValue(cList.get(14).getTime(), firstRSI, IndicatorType.RSI));

			populateRSI(rsiList, cList, avgGain, avgLoss, 14 + 1);
		}
		return convertListToMap(rsiList);
	}

	private static void populateRSI(List<IndicatorValue> rsiList, List<Candle> cList, double avgGain, double avgLoss,
			int index) {
		if (index < cList.size()) {
			double gain = 0;
			double loss = 0;
			if (cList.get(index - 1).getClose() < cList.get(index).getClose()) {
				gain = (cList.get(index).getClose() - cList.get(index - 1).getClose());
			} else {
				loss = (cList.get(index - 1).getClose() - cList.get(index).getClose());
			}
			avgGain = (double) (avgGain * 13 + gain) / 14;
			avgLoss = (double) (avgLoss * 13 + loss) / 14;
			double rsi = (double) 100 - (100 / (1 + (avgGain / avgLoss)));

			rsiList.add(new IndicatorValue(cList.get(index).getTime(), rsi, IndicatorType.RSI));

			populateRSI(rsiList, cList, avgGain, avgLoss, ++index);
		}
	}

	private static Date getDate(String date) {
		return new DateTime(date).toDate();
	}

}
