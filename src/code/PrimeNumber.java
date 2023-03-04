package code;

/**
 * k진수에서 소수 개수 구하기
 */
public class PrimeNumber {
	public int solution(int n, int k) {
        int answer = 0;
		
        String nStr = Integer.toString(n, k);	// 진수 변환
        int nStrLength = nStr.length();	// 진수
        
        int unit = 1;
        
        while(unit <= nStrLength) {	// 자르는 단위가 문자열 길이 만큼과 같을 때까지 반복
        	for(int i = 0 ; i < nStrLength ; i++) {
        		int scope = i+unit;	// 문자열 자르는 범위, 인덱스
        		
        		if(scope <= nStrLength) {	// 범위가 문자열 길이보다 작거나 같은 경우
        			String subStr = nStr.substring(i, scope);
        			
        			if(subStr.contains("0")) {	// 0을 포함한 숫자인 경우
        				continue;
        			}
        			
        			boolean flag = isStrPrime(subStr);	// 소수 확인하는 함수 호출
        			
        			if(flag) {	// 소수인 경우
        				int lIdx = i-1;
        				int rIdx = i+unit;
        				
        				if(lIdx > 0 && rIdx < nStrLength && "0".equals(nStr.substring(lIdx, i)) && "0".equals(nStr.substring(rIdx, rIdx+1))) {	// 소수 양쪽에 0이 있는 경우
        					answer++;
        				} else if(lIdx < 0 && rIdx < nStrLength && "0".equals(nStr.substring(rIdx, rIdx+1))) {	// 오른쪽에만 0이 있고 왼쪽에 아무것도 없는 경우
        					answer++;
        				} else if(rIdx >= nStrLength && lIdx > 0 && "0".equals(nStr.substring(lIdx, i))) {	// 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
        					answer++;
        				} else if(lIdx < 0 && rIdx >= nStrLength) {	// 소수 양쪽에 아무것도 없는 경우
        					answer++;
        				}
        			}
        		}
        	}
        	
        	unit++;	// 문자열 자르는 단위 증가
        }
        
        return answer;
    }
    
    public boolean isStrPrime(String s) {	// 소수 확인하는 함수, 소수면 true, 소수 아니면 false 반환
		long n = Long.parseLong(s);
		
		if(n < 2) {
			return false;
		}
		
		Double d = new Double(String.valueOf(Math.sqrt(n)));
		
		for (int i = 2; i <= d.intValue() ; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
