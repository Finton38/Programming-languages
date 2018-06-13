package hw5;

public class selections {

	public static void main(String[] args) {
		int first = 10, second = 20, third = 30;
		int max, mid, min;
		
		System.out.println("Nested Version");
		// Nested version-------------------------------
		if (first > second) {
			if (first > third) {
				max = first;
				if (second > third) {
					min = third;
					mid = second;
				} else {
					min = second;
					mid = third;
				}
			} else {
				max = third;
				mid = first;
				min = second;
			}
		}else if(second>first) {
			if(second>third) {
				max = second;
				if(first>third) {
					min = third;
					mid=first;
				}else {
					min = first;
					mid = third;
				}
			}else {
				max = third;
				min = first;
				mid = second;
			}
		}else {
			max = third;
			min = second;
			mid = first;
			
		}
		System.out.println("Max: " + max + " Mid: " + mid + " Min: " + min);
		System.out.println();
		
		
		
		// Non Nested version---------------
		System.out.println("Non Nested Version");
		if (first>second && first>third && second>third) {
			max = first;
			min = third;
			mid = second;
		}
		if(first > second && first>third && second < third) {
			max = first;
			min = second;
			mid = third;
		}
		if(second>first && second>third && first>third) {
			max = second;
			min = third;
			mid= first;
		}
		if(second>first && second>third && first<third) {
			max = second;
			min = first;
			mid= third;
		}
		if(third>first && third>second && first>second) {
			max = third;
			min = second;
			mid = first;
		}
		if(third>first && third>second && first<second) {
			max = third;
			min = first;
			mid = second;
		}
		System.out.println("Max: " + max + " Mid: " + mid + " Min: " + min);

	}


}
