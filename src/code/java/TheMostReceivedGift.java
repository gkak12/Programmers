package code.java;

/**
 *  가장 많이 받은 선물
 *  https://school.programmers.co.kr/learn/courses/30/lessons/258712
 *
 *  @author hyunjun
 */

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class TheMostReceivedGift {

    public static void main(String[] args) {
//        String[] friends = {"muzi", "ryan", "frodo", "neo"};
//        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

//        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
//        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};

        String[] friends = {"a", "b", "c"};
        String[] gifts = {"a b", "b a", "c a", "a c", "a c", "c a"};

        int result = solution(friends, gifts);
        System.out.println("result: " + result);
    }

    public static int solution(String[] friends, String[] gifts) {
        int[][] giftArr = new int[friends.length][friends.length];
        Map<Integer, String> indexMap = Arrays.stream(friends)
            .collect(
                Collectors.toMap(friend -> Arrays.asList(friends).indexOf(friend), friend -> friend )
            );
        Map<String, GiftInfo> giftMap = Arrays.stream(friends)
            .collect(
                Collectors.toMap(friend -> friend, friend -> new GiftInfo(0, Arrays.asList(friends).indexOf(friend), 0))
            );

        Arrays.stream(gifts).forEach(item -> {
            String[] tmp = item.split(" ");
            String from  = tmp[0];
            String to = tmp[1];

            // 선물지수 계산
            GiftInfo fromGift = giftMap.get(from);

            int fromPoint = fromGift.getPoint() + 1;
            fromGift.setPoint(fromPoint);

            GiftInfo toGift = giftMap.get(to);

            int toPoint = toGift.getPoint() - 1;
            toGift.setPoint(toPoint);

            // 선물거래 로그 테이블
            giftArr[fromGift.getIdx()][toGift.getIdx()] += 1;
        });

        giftMap.keySet().stream()
            .forEach(item -> {
                GiftInfo giftInfo = giftMap.get(item);
                int idx = giftInfo.getIdx();

                for(int j = 0; j < giftArr[idx].length; j++) {
                    if(idx == j){   // 자기자신인 경우 생략
                        continue;
                    }

                    GiftInfo otherGiftInfo = giftMap.get(indexMap.get(j));

                    if(giftArr[idx][j] > 0 || giftArr[j][idx] > 0) {    // 두 사람 사이에 선물 주고받은 기록이 있는 경우
                        if(giftArr[idx][j] > giftArr[j][idx]){          // 자기자신이 선물 더 많이 준 경우
                            giftInfo.setExpCount(giftInfo.getExpCount()+1);
                        } else if(giftArr[idx][j] == giftArr[j][idx] && giftInfo.getPoint() > otherGiftInfo.getPoint()){     // 두 사람이 선물을 주고받은 수가 같고 자기자신이 선물지수가 더 높은 경우
                            giftInfo.setExpCount(giftInfo.getExpCount()+1);
                        }
                    } else if((giftArr[idx][j] < 1 && giftArr[j][idx] < 1) || (giftArr[idx][j] == giftArr[j][idx])) {   // 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같은 경우
                        if(giftInfo.getPoint() > otherGiftInfo.getPoint()){     // 자기자신이 선물지수가 더 높은 경우
                            giftInfo.setExpCount(giftInfo.getExpCount()+1);
                        }
                    }
                }
            });

        int answer = giftMap.values().stream()
            .mapToInt(GiftInfo::getExpCount).max()
            .orElseThrow(RuntimeException::new);

        return answer;
    }

    public static class GiftInfo {
        private int point;
        private int idx;
        private int expCount;

        public GiftInfo(int point, int idx, int expCount) {
            this.point = point;
            this.idx = idx;
            this.expCount = expCount;
        }

        public int getPoint(){
            return this.point;
        }

        public void setPoint(int point){
            this.point = point;
        }

        public int getIdx(){
            return this.idx;
        }

        public void setIdx(int idx){
            this.idx = idx;
        }

        public int getExpCount(){
            return this.expCount;
        }

        public void setExpCount(int expCount){
            this.expCount = expCount;
        }
    }
}
