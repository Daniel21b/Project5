package application;
/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * 
 * Due: 4/14/2022
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Daniel Berhane
*/
public class HolidayBonus {

	  /**
	   * Calculates the holiday bonus for each store
	   * 
	   * @param data the two dimensional array of store sales
	   * @param high bonus for the highest store in a category
	   * @param low bonus for the lowest store in a category
	   * @param other bonus for all other stores in a category
	   * @return an array of the bonus for each store
	   */
	  public static double[] calculateHolidayBonus(double[][] data, double high, double low,
	      double other) {
	    double[] bonuses = new double[data.length];
	    
	    //find max # of categories
	    int maxCol = 0;
	    for (int i = 0;i < data.length;i++) {
	      if (maxCol < data[i].length) {
	        maxCol = data[i].length;
	      }
	    }
	    
	    for (int j = 0;j < maxCol;j++) {

	      int highBonusIndex = (int) TwoDimRaggedArrayUtility.getHighestInColumn(data, j);
	      int lowBonusIndex = (int) TwoDimRaggedArrayUtility.getHighestInColumn(data, j);
	      
	      // sales must be positive to get high bonus
	      if (TwoDimRaggedArrayUtility.getHighestInColumn(data, j) > 0) {  
	        bonuses[highBonusIndex] += high;
	      }
	      
	      // sales must be positive and different from high to get low bonus
	      if (TwoDimRaggedArrayUtility.getLowestInColumn(data, j) > 0 && highBonusIndex!=lowBonusIndex ) {
	        bonuses[lowBonusIndex] += low;
	      }
	      
	      // add OTHER bonus to the other stores unless not category available if sales are positive 
	      for (int i = 0;i < data.length;i++) {
	        if (j >= data[i].length || i==highBonusIndex || i==lowBonusIndex || data[i][j] <= 0) {
	          continue;
	        } else {
	          bonuses[i] += other;
	        } 
	        System.out.println();
	      }
	    }   
	    return bonuses;
	  }

	  /**
	   * Calculates the total holiday bonuses
	   * 
	   * @param data the two dimensional array of store sales
	   * @param high bonus for the highest store in a category
	   * @param low bonus for the lowest store in a category
	   * @param other bonus for all other stores in a category
	   * @return the total of all holiday bonuses
	   */
	  public static double calculateTotalHolidayBonus(double[][] data, double high, double low,
	      double other) {
	    
	    double[] bonusArray = calculateHolidayBonus(data, high, low, other);
	    double total = 0;
	    
	    for (double bonus:bonusArray) {
	      total+=bonus;
	    }
	    return total;
	  }
	}