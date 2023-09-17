import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CodingTask {

	public static void main(String[] args) {
		List<String> mainList = new ArrayList<String>();

//*******************Examples 1********************
		mainList.add("5 3");
		mainList.add("1 2 100");
		mainList.add("2 5 100");
		mainList.add("3 4 100");

//*******************Examples 2********************
//		mainList.add("7 5");
//		mainList.add("2 3 901");
//		mainList.add("1 6 443");
//		mainList.add("3 7 212");
//		mainList.add("2 5 982");
//		mainList.add("1 2 890");

		List<Integer> processedList;
		try {
			processedList = processList(mainList);

			if (!processedList.isEmpty()) {

				/*
				 * Iterate every row in the information list to get the correct indexes and the
				 * value to add
				 */
				int iIndex;
				int jIndex;
				int kValue;
				String[] rowValues;

				for (int i = 1; i < mainList.size(); i++) {
					rowValues = mainList.get(i).split(" ");
					iIndex = Integer.parseInt(rowValues[0]) - 1;
					jIndex = Integer.parseInt(rowValues[1]) - 1;
					kValue = Integer.parseInt(rowValues[2]);

					for (int j = iIndex; j <= jIndex; j++) {
						processedList.set(j, processedList.get(j) + kValue);
					}

				}

				System.out.println("Final list: " + processedList);
				System.out.println("Maximum value: " + getMaxValue(processedList));
			} else {
				System.out.println("The calculation could not be completed, verify the entry data.");
			}

		} catch (Exception e) {
			System.out.println("The process could not be completed: " + e);
		}

	}

	public static List<Integer> processList(List<String> list) throws Exception {

		List<Integer> response = new ArrayList<Integer>();

		/*
		 * I use the information in the first line to build the final list
		 */

		try {
			String[] informationFirstLine = list.get(0).split(" ");
			int listSize = Integer.parseInt(informationFirstLine[0]);

			for (int i = 0; i < listSize; i++) {
				response.add(0);
			}

		} catch (Exception e) {

			System.out.println("There was an error when processing the raw information: " + e);
			throw new Exception("There was an error when processing the raw information: " + e);
		}

		return response;

	}

	public static int getMaxValue(List<Integer> list) throws Exception {

		try {
			int response = 0;

			/*
			 * We can obtain the maximun value iterating throw the complete list using for
			 * each, using the function max from the stream or the Collection*****
			 */

//			for (int value : list) {
//				if (value > response) {
//					response = value;
//				}
//			}
//			response = Collections.min(list);

			response = list.stream().mapToInt(x -> x).max().orElse(0);

			return response;
		} catch (Exception e) {
			System.out.println("There was an error when calculating the maximum value: " + e);
			throw new Exception("There was an error when calculating the maximum value: " + e);
		}

	}

}
