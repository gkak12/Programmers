package code;

public class Main {
	public static void main(String[] args) {
		BrushSale b = new BrushSale();
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		int[] res = b.solution(enroll, referral, seller, amount);
		
		for(int i : res) {
			System.out.println(i);
		}
	}
}
